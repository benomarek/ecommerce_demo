create table animal_category (name varchar(255) not null, primary key (name))
create table gallery_url (id  bigserial not null, url varchar(255), product_id int8 not null, primary key (id))
create table order (id  bigserial not null, total_price numeric(19, 2), user_id int8 not null, primary key (id))
create table order_product (product_id int8 not null, order_id int8 not null)
create table product (id  bigserial not null, description varchar(255), name varchar(255), price numeric(19, 2), animal_category varchar(255) not null, primary key (id))
create table user (id  bigserial not null, email varchar(255), name varchar(255), primary key (id))
alter table gallery_url add constraint FKpf9v7ukfv5f9yws6hfabj43q0 foreign key (product_id) references product
alter table order add constraint FKt7abetueht6dd1gs9jyl3o4t7 foreign key (user_id) references user
alter table order_product add constraint FKb3sm2umdh0yd7jwrnda0qixd0 foreign key (order_id) references order
alter table order_product add constraint FKhnfgqyjx3i80qoymrssls3kno foreign key (product_id) references product
alter table product add constraint FKk3l4i5yfe94crv4jkcn1vfebk foreign key (animal_category) references animal_category
create table animal_category (name varchar(255) not null, primary key (name))
create table gallery_url (id  bigserial not null, url varchar(255), product_id int8 not null, primary key (id))
create table order (id  bigserial not null, total_price numeric(19, 2), user_id int8 not null, primary key (id))
create table order_product (product_id int8 not null, order_id int8 not null)
create table product (id  bigserial not null, description varchar(255), name varchar(255), price numeric(19, 2), animal_category varchar(255) not null, primary key (id))
create table user (id  bigserial not null, email varchar(255), name varchar(255), primary key (id))
alter table gallery_url add constraint FKpf9v7ukfv5f9yws6hfabj43q0 foreign key (product_id) references product
alter table order add constraint FKt7abetueht6dd1gs9jyl3o4t7 foreign key (user_id) references user
alter table order_product add constraint FKb3sm2umdh0yd7jwrnda0qixd0 foreign key (order_id) references order
alter table order_product add constraint FKhnfgqyjx3i80qoymrssls3kno foreign key (product_id) references product
alter table product add constraint FKk3l4i5yfe94crv4jkcn1vfebk foreign key (animal_category) references animal_category
create table animal_category (name varchar(255) not null, primary key (name))
create table gallery_url (id  bigserial not null, url varchar(255), product_id int8 not null, primary key (id))
create table order (id  bigserial not null, total_price numeric(19, 2), user_id int8 not null, primary key (id))
create table order_product (product_id int8 not null, order_id int8 not null)
create table product (id  bigserial not null, description varchar(255), name varchar(255), price numeric(19, 2), animal_category varchar(255) not null, primary key (id))
create table user (id  bigserial not null, email varchar(255), name varchar(255), primary key (id))
alter table gallery_url add constraint FKpf9v7ukfv5f9yws6hfabj43q0 foreign key (product_id) references product
alter table order add constraint FKt7abetueht6dd1gs9jyl3o4t7 foreign key (user_id) references user
alter table order_product add constraint FKb3sm2umdh0yd7jwrnda0qixd0 foreign key (order_id) references order
alter table order_product add constraint FKhnfgqyjx3i80qoymrssls3kno foreign key (product_id) references product
alter table product add constraint FKk3l4i5yfe94crv4jkcn1vfebk foreign key (animal_category) references animal_category
create table animal_category (name varchar(255) not null, primary key (name))
create table gallery_url (id  bigserial not null, url varchar(255), product_id int8 not null, primary key (id))
create table order (id  bigserial not null, total_price numeric(19, 2), user_id int8 not null, primary key (id))
create table order_product (product_id int8 not null, order_id int8 not null)
create table product (id  bigserial not null, description varchar(255), name varchar(255), price numeric(19, 2), animal_category varchar(255) not null, primary key (id))
create table user (id  bigserial not null, email varchar(255), name varchar(255), primary key (id))
alter table gallery_url add constraint FKpf9v7ukfv5f9yws6hfabj43q0 foreign key (product_id) references product
alter table order add constraint FKt7abetueht6dd1gs9jyl3o4t7 foreign key (user_id) references user
alter table order_product add constraint FKb3sm2umdh0yd7jwrnda0qixd0 foreign key (order_id) references order
alter table order_product add constraint FKhnfgqyjx3i80qoymrssls3kno foreign key (product_id) references product
alter table product add constraint FKk3l4i5yfe94crv4jkcn1vfebk foreign key (animal_category) references animal_category
