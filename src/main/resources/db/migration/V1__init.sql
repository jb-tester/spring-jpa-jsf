create table tab1
(
    id int auto_increment,
    title varchar(255) not null,
    price int(1) not null,
    amount int(5) not null,
    constraint demo_pk primary key (id)  ,
    available BOOLEAN default true
);

insert into tab1 (id, title, price, amount,available) values
(1, 'oranges', 20, 1000, true),
(2, 'apples', 15, 2000, true),
(3, 'strawberries', 100, 50, false),
(4, 'grapes', 60, 500, true),
(5, 'mango', 1000, 20, false);
