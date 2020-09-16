create table animal_category (name varchar(255) not null, primary key (name))
create table gallery_url (id  bigserial not null, url varchar(255), product_id int8 not null, primary key (id))
create table order_product (product_id int8 not null, order_id int8 not null)
create table orders (id  bigserial not null, total_price numeric(19, 2), user_id int8 not null, primary key (id))
create table product (id  bigserial not null, description varchar(255), name varchar(255), price numeric(19, 2), animal_category varchar(255) not null, primary key (id))
create table user_info (id  bigserial not null, email varchar(255), name varchar(255), primary key (id))
alter table gallery_url add constraint FKpf9v7ukfv5f9yws6hfabj43q0 foreign key (product_id) references product
alter table order_product add constraint FKl5mnj9n0di7k1v90yxnthkc73 foreign key (order_id) references orders
alter table order_product add constraint FKhnfgqyjx3i80qoymrssls3kno foreign key (product_id) references product
alter table orders add constraint FKq0ny5rek18pjqb8a86pnnyt9d foreign key (user_id) references user_info
alter table product add constraint FKk3l4i5yfe94crv4jkcn1vfebk foreign key (animal_category) references animal_category
