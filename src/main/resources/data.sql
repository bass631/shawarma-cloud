delete
from Ingredient_ref;
delete
from Shavarma;
delete
from Shavarma_order;
delete
from Ingredient;

insert into Ingredient (id, name, type) values ('RGLV', 'Обычный лаваш', 'WRAP');
insert into Ingredient (id, name, type) values ('CELV', 'Сырный лаваш', 'WRAP');
insert into Ingredient (id, name, type) values ('CHFL', 'Куриное филе', 'PROTEIN');
insert into Ingredient (id, name, type) values ('GRBF', 'Говяжья котлета', 'PROTEIN');
insert into Ingredient (id, name, type) values ('JLPN', 'Халапеньо', 'VEGGIES');
insert into Ingredient (id, name, type) values ('PTTO', 'Картофель', 'VEGGIES');
insert into Ingredient (id, name, type) values ('CHED', 'Чеддер', 'CHEESE');
insert into Ingredient (id, name, type) values ('PARM', 'Пармезан', 'CHEESE');
insert into Ingredient (id, name, type) values ('SISA', 'Фирменный соус', 'SAUCE');
insert into Ingredient (id, name, type) values ('SRCA', 'Сметана', 'SAUCE');