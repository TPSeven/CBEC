-- cbce1.2

-- Role 角色表
create table ROLE(
  role_id number(10),
  role_name varchar2(20),
  constraint pk_role_id primary key(role_id)
);
insert into ROLE values(1,'admin');
insert into ROLE values(2,'manufacturer');
insert into ROLE values(3,'seller');
select * from ROLE;

-- waller 钱包
create table WALLET(
  wallet_id number(10) ,
  balance number(20), --余额
  bankcard number(20), --银行卡
  constraint pk_wallet_id primary key(wallet_id)
);
create sequence WALLET_NEXTID_SQ;
insert into WALLET values(WALLET_NEXTID_SQ.Nextval,10000,null);
insert into WALLET values(WALLET_NEXTID_SQ.Nextval,10000,null);
insert into WALLET values(WALLET_NEXTID_SQ.Nextval,10000,null);
insert into WALLET values(WALLET_NEXTID_SQ.Nextval,10000,null);
select * from WALLET;

-- user 用户表
create table UUSER(
  user_id number(10),
  user_name varchar2(20),
  user_password varchar2(10),
  user_sex varchar2(4),
  user_age number(2),
  user_email varchar2(20),
  user_phone varchar2(15),
  role_id int,
  wallet_id number(10),
  man_id number(10),
  seller_id number(10),
  constraint pk_user_id primary key(user_id),
  constraint uuser_wallet_FK FOREIGN KEY(wallet_id) REFERENCES WALLET(wallet_id), --钱包外键
  constraint UUSER_ROLE_FK FOREIGN KEY(role_id) REFERENCES ROLE(role_id) --角色外键
);
create sequence USER_NEXTID_SQ;
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'admin','123','男',20,'test@qq.com','10086',1,2);
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'manufacturer','1234','男',20,'test1@qq.com','1008611',2,3);
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'seller','12345','女',22,'tes1t@qq.com','13800138',3,4);
select * from UUSER;
ALTER TABLE UUSER ADD CONSTRAINT UUSER_MANU_FK FOREIGN KEY(man_id) REFERENCES MANUFACTURER(man_id); -- 添加制造商外键
ALTER TABLE UUSER ADD (user_birthday date default null); -- 添加生日
ALTER TABLE UUSER ADD (user_joindate date default null); -- 添加日期

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
insert into MANUFACTURER values(MANUFACTURER_NEXTID_SQ.NEXTVAL,1111,'小米',null,'10086','北京','为发烧而生');
insert into MANUFACTURER values(MANUFACTURER_NEXTID_SQ.NEXTVAL,1000,'苹果',null,'1008611','美国','Switch');
insert into MANUFACTURER values(MANUFACTURER_NEXTID_SQ.NEXTVAL,1000,'华为',null,'13800','中国','万物互联网');
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
