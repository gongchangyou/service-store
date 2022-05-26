create table `store`
(
id    int auto_increment comment '主键'
primary key,
count int default 0 not null comment '商品库存'
);