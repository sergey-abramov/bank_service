create table account_number
(
    id serial primary key,
    number int,
    balance int
);

create table bank_account
(
    id serial primary key,
    name varchar not null,
    pin int not null,
    account_number_id int references account_number(id) not null
)