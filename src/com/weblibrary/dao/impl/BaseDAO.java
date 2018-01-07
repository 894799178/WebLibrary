package com.weblibrary.dao.impl;


import com.mysql.jdbc.Statement;
import com.weblibrary.daoport.DAO;
import com.weblibrary.db.DBUtil;
import com.weblibrary.db.ReflectionUtils;
import com.weblibrary.domain.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class BaseDAO<T> implements DAO <T> {

   private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;
   public BaseDAO(){
      // Class.class.getSuperclass().getSuperClassGenricType(clazz, 0);
        clazz = ReflectionUtils.getSuperGenericType(getClass());
   }

    /**
     * 执行 insert操作,完成后返回插入的id.
     *
     * @param sql
     * @param args
     * @return
     */
    @Override
    public long insert(String sql, Object... args) {
        long id = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSer = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if(args != null){
                for (int i=0;i < args.length;i++){
                    preparedStatement.setObject(i+1 ,args[i]);
                }
            }
            preparedStatement.executeUpdate();
            resultSer = preparedStatement.getGeneratedKeys();
            if(resultSer.next()){
                id = resultSer.getLong(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.release(resultSer,preparedStatement);
            DBUtil.releaseConnection(connection);
        }
        return id;
    }

    /**
     * 执行update操作.包括insert,update,delete (但是无返回值)
     *
     * @param sql
     * @param args
     */
    @Override
    public void update(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            queryRunner.update(connection,sql,args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.releaseConnection(connection);
        }
    }

    /**
     * 执行单条查询操作,返回与纪录对应的类的一个对象
     *
     * @param sql
     * @param args
     * @return
     */
    @Override
    public T query(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();

            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 执行查询,返回多个对象,对象使用list存储.
     *
     * @param sql
     * @param args
     * @return
     */
    @Override
    public List<T> queryForList(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 获取某个单一数据,比如 最大值,查询的数据的数量....
     *
     * @param sql
     * @param args
     * @return
     */
    @Override
    public <V> V getSingleVal(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            return (V)queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.releaseConnection(connection);
        }

        return null;
    }

    /**
     * 批量处理sql
     *
     * @param sql
     * @param params
     */
    @Override
    public void batch(String sql, Object[]... params) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            queryRunner.batch(connection,sql,params);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.releaseConnection(connection);
        }
    }

}
