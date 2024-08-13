create table if not exists Shavarma_Order
(
    id identity,
    delivery_name   varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city   varchar(50) not null,
    cc_number       varchar(16) not null,
    cc_expiration   varchar(5)  not null,
    cc_cvv          varchar(3)  not null,
    place_at       timestamp   not null
);

create table if not exists Shavarma
(
    id identity,
    name               varchar(50) not null,
    shawarma_order     bigint      not null,
    shawarma_order_key bigint      not null,
    create_at          timestamp   not null
);

create table if not exists Ingredient_ref
(
    ingredient   varchar(4) not null,
    shawarma     bigint     not null,
    shawarma_key bigint     not null
);

create table if not exists Ingredient
(
    id   varchar(4)  not null unique,
    name varchar(25) not null,
    type varchar(10) not null
);

alter table Shavarma
    add foreign key (shawarma_order) references Shavarma_order (id);
alter table Ingredient_ref
    add foreign key (ingredient) references Ingredient (id);