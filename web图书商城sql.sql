create table user_table(
	 User_id int(11) auto_increment primary key,
	 User_Name varchar(30) not null,
	 account_id int (11) not null
);

create table trade_table(
	trade_id int(11) auto_increment primary key,
	trade_time datetime,
	User_id int(11) not null
);

create table account_table(
	account_id int (11) auto_increment primary key,
	balance int(11) 

);

create table book_table(
	book_id  int(11) auto_increment primary key,
	author varchar(255),
	title varchar(255) not null,
	price float,
	publishing_date date,
	sales_amount int(11),
	store_number int(11),
	remark varchar(255)
);

create table  trade_item_table(
	item_id int(11) auto_increment primary key,
	quantity int(11),
	book_id int(11),
	trade_id int(11)
);