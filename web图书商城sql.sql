create table user_table(
	 userId int(11) auto_increment primary key,
	 userName varchar(30) not null,
	 accountId int (11) not null
);

create table trade_table(
	tradeId int(11) auto_increment primary key,
	tradeTime datetime,
	userId int(11) not null
);

create table account_table(
	accountId int (11) auto_increment primary key,
	balance int(11) 

);

create table book_table(
	bookId  int(11) auto_increment primary key,
	author varchar(255),
	title varchar(255) not null,
	price float,
	publicShingDate date,
	salesAmount int(11),
	storeNumber int(11),
	remark varchar(255)
);

create table  trade_item_table(
	itemId int(11) auto_increment primary key,
	quantity int(11),
	bookId int(11),
	tradeId int(11)
);