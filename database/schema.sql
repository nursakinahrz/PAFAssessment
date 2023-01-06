CREATE TABLE customers
(
    id int auto_increment not null,
    name varchar(32) not null,
    address varchar(128) not null,
    email varchar(128),
    primary key(id)
);

-- LOAD DATA INFILE 'data.csv'
-- INTO TABLE customers
-- FIELDS TERMINATED BY ':';
-- INSERT INTO customers (name, address, email)
-- VALUES ('?', '?', '?');

CREATE TABLE railway.order
(  order_id varchar(8) not null,
	delivery_id varchar(8) not null,
    name varchar(32) not null,
    address varchar(128) not null,
    email varchar(128)  not null,
    status varchar(128) not null,
    date DateTime,
    primary key(order_id)
);

CREATE TABLE railway.lineItem
(  item text not null,
	quantity int default '1'
);

CREATE TABLE railway.order_status
(	order_id varchar(8) not null,
delivery_id varchar(8) not null,
status enum ('pending', 'dispatched') not null,
status_update DateTime not null
);





