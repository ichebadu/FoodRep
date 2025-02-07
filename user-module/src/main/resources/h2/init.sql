create table users(
    id bigint auto_increment,
    name varchar(50),
    balance int,
    primary key(id)
);

create table transaction(
    id bigint auto_increment,
    user_id bigint,
    amount int,
    transaction_date timestamp,
    foreign key (user_id) references users(id) on delete cascade
);

insert into users(name, balance) values ('iche', 3000 ),('mike', 100 ),('jim', 600), ('john', 7800 )