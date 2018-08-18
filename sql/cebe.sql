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
  user_portrait BLOB,
	portraitFileName varchar2(100),
  portraitContentType varchar2(100),

  user_email varchar2(50),
  user_phone varchar2(15),
  user_birthday date,
  user_joindate date,
  user_desc varchar(200),

  role_id number(2),
  wallet_id number(5),
  man_id number(10),
  seller_id number(10),
  constraint pk_user_id primary key(user_id)
);
create sequence USER_NEXTID_SQ;
--ALTER TABLE UUSER ADD constraint uuser_wallet_FK FOREIGN KEY(wallet_id) REFERENCES WALLET(wallet_id), --钱包外键
ALTER TABLE UUSER ADD constraint UUSER_ROLE_FK FOREIGN KEY(role_id) REFERENCES ROLE(role_id); --角色外键
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'admin','admin','男',20,null,null,null,'test@qq.com','10086','1-12月-1998','8-1月-2015','管理员账号',1,0,0,0);
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'manufacturer','1234','男',20,null,null,null,'test@qq.com','1008611','01-12月-1998','8-1月-2015','一个制造商账号',2,0,0,0);
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'seller','12345','女',20,null,null,null,'test@qq.com','1008611','01-12月-1998','8-1月-2015','一个借卖家账号',3,0,0,0);
select * from UUSER;
ALTER TABLE UUSER ADD CONSTRAINT UUSER_MANU_FK FOREIGN KEY(man_id) REFERENCES MANUFACTURER(man_id); -- 添加制造商外键

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
