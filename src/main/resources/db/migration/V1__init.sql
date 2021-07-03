create table tab1
(
    id int auto_increment,
    title varchar(255) not null,
    price int(1) not null,
    amount int(5) not null,
    constraint demo_pk primary key (id)
);

insert into tab1 (id, title, price, amount) values
(1, 'oranges', 20, 1000),
(2, 'apples', 15, 2000),
(3, 'strawberries', 100, 50),
(4, 'grapes', 60, 500),
(5, 'mango', 1000, 20);
