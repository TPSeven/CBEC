-- cbce1.2

-- Role 角色表
create table ROLE(
  role_id number(10),
  role_name varchar2(20),
  constraint pk_role_id primary key(role_id)
);
insert into ROLE values(1,'manufacturer');
insert into ROLE values(2,'seller');
insert into ROLE values(3,'admin');
select * from ROLE;

-- waller 钱包
create table WALLET(
  wallet_id number(10) ,
  balance number(20,2), --余额
  bankcards number(10), --银行卡，应该还要一个银行卡信息表
  constraint pk_wallet_id primary key(wallet_id)
);

insert into WALLET values(1,10000,null);
insert into WALLET values(2,10000,null);
insert into WALLET values(3,10000,null);
create sequence WALLET_NEXTID_SQ start with 4 increment by 1;
select * from WALLET;

-- user 用户表
create table UUSER(
  user_id number(10),
  user_name varchar2(20),
  user_password varchar2(10),
  user_sex varchar2(4),
  user_age number(2),
  user_portrait BLOB,
	portraitFileName varchar2(100),
  portraitContentType varchar2(100),

  user_email varchar2(50),
  user_phone varchar2(15),
  user_birthday date,
  user_joindate date,
  user_desc varchar(200),

  wallet_id number(5),
  man_id number(10),
  seller_id number(10),
  constraint pk_user_id primary key(user_id)
);
ALTER TABLE UUSER ADD constraint uuser_wallet_FK FOREIGN KEY(wallet_id) REFERENCES WALLET(wallet_id); --钱包外键
insert into UUSER values(1,'manufacturer','1234','男',20,null,null,null,'manu@qq.com','1008611','01-12月-1998','8-1月-2015','一个制造商账号',1,0,0);
insert into UUSER values(2,'seller','1234','女',20,null,null,null,'seller@qq.com','1008611','01-12月-1998','8-1月-2015','一个借卖家账号',2,0,0);
insert into UUSER values(3,'admin','1234','男',20,null,null,null,'admin@qq.com','10086','1-12月-1998','8-1月-2015','管理员账号',3,0,0);
select * from UUSER;
create sequence USER_NEXTID_SQ start with 4 increment by 1;
-- ALTER TABLE UUSER ADD CONSTRAINT UUSER_MANU_FK FOREIGN KEY(man_id) REFERENCES MANUFACTURER(man_id); -- 添加制造商外键

-- 用户角色关联表
create table UUser_Role_Relate(
  user_id number(10),
  role_id number(10),
  constraint UUSER_ROLE_RPK primary key(user_id,role_id),
  foreign key (user_id) references UUSER(user_id),
  foreign key (role_id) references ROLE(role_id)
);
insert into UUser_Role_Relate values(1,1);
insert into UUser_Role_Relate values(1,2);
insert into UUser_Role_Relate values(1,3);
insert into UUser_Role_Relate values(2,2);
insert into UUser_Role_Relate values(3,3);
select * from UUser_Role_Relate;

-- SystemModule 系统模块表
create table SystemModule(
  module_no number(10) primary key,
  module_name varchar(50)
);
insert into SystemModule values(1,'品牌商');
insert into SystemModule values(2,'借卖商');
insert into SystemModule values(3,'管理员');
select * from SystemModule;

--SystemFunction 系统功能表
create table SystemFunction(
  fun_no number(10) primary key,
  module_no number(10) references SystemModule(module_no),
  fun_name varchar(100),
  fun_url varchar(100)
);
insert into SystemFunction values (1,1,'我的信息','manufacturer/view.html');
insert into SystemFunction values (2,1,'品牌管理','brand/brand.html');
insert into SystemFunction values (3,1,'商品录入','product/main.html');
insert into SystemFunction values (4,1,'商品主图',null);
insert into SystemFunction values (5,1,'订单管理',null);
insert into SystemFunction values (6,1,'我的钱包',null);

insert into SystemFunction values (7,2,'商品管理',null);
insert into SystemFunction values (8,2,'店铺管理',null);
insert into SystemFunction values (9,2,'商品浏览',null);
insert into SystemFunction values (10,2,'心愿单',null);
insert into SystemFunction values (11,2,'订单管理',null);
insert into SystemFunction values (12,2,'我的钱包',null);

insert into SystemFunction values (13,3,'用户管理','user/main.html');
insert into SystemFunction values (14,3,'品牌商管理','manufacturer/main.html');
insert into SystemFunction values (15,3,'订单管理','orderitem/orderitem.html');
insert into SystemFunction values (16,3,'权限管理','role/main.html');
insert into SystemFunction values (17,3,'系统模块管理','module/main.html');
select * from SystemFunction;

-- 模块角色关联表
create table Role_Module_Relate(
  role_id number(10),
  module_no number(10),
  constraint Role_Module_RPK primary key(role_id,module_no),
  foreign key (role_id) references ROLE(role_id),
  foreign key (module_no) references SystemModule(module_no)
);
insert into Role_Module_Relate values (1,1);
insert into Role_Module_Relate values (2,2);
insert into Role_Module_Relate values (3,1);
insert into Role_Module_Relate values (3,2);
insert into Role_Module_Relate values (3,3);
select * from Role_Module_Relate;

--manufacturer 制造商
create table MANUFACTURER(
  man_id number(10) constraint pk_man_id primary key, 
  man_no number(10),
  man_name  varchar2(20), 
  man_log BLOB,
  man_phone varchar2(20),
  man_address varchar2(100), 
  man_desc varchar2(200)  
);
create sequence MANUFACTURER_NEXTID_SQ;
insert into MANUFACTURER values(MANUFACTURER_NEXTID_SQ.NEXTVAL,1111,'小米公司',null,'10086','北京','为发烧而生');
insert into MANUFACTURER values(MANUFACTURER_NEXTID_SQ.NEXTVAL,1000,'苹果公司',null,'1008611','美国','Switch');
insert into MANUFACTURER values(MANUFACTURER_NEXTID_SQ.NEXTVAL,1000,'华为公司',null,'13800','中国','万物互联网');
select * from MANUFACTURER;


--brand 品牌表
create table BRAND(
  brand_id number(20) constraint pk_brand_id primary key,  
  brand_name  varchar2(50),  
  man_id number(20),  
  brand_desc varchar2(200)  
);
create sequence BRAND_NEXTNO_SQ;
-- ALTER TABLE BRAND ADD CONSTRAINT BRAND_MANU_FK FOREIGN KEY(man_id) REFERENCES BRAND(man_id); 

--ORDER_ITEM
create table ORDER_ITEM(
  order_id number(20) constraint pk_order_id primary key,       
  pro_id number(20),
  pro_id_count number(20),  
  man_id number(20),   
  seller_id number(20), 
  state varchar2(20) 
);



create table PRODUCT(
  pro_id number(20) constraint pk_pro_id primary key,
  pro_name  varchar2(50), 
  pro_price number(20,2), 
  pro_weight number(20,2),
  pro_count number(20),
  pro_kinds_id  number(20),
  pro_state_id  number(20),
  brand_id  number(20),
  pro_photos_id  number(20),
  pro_desc  varchar2(200)
);

insert into PRODUCT(pro_id,pro_name,pro_price,pro_weight)
values(2,'a',1,20)
