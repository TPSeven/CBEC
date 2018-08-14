-- cbce1.2
-- user �û���
create table UUSER(
  user_id number(10) primary key,
  user_name varchar2(20),
  user_password varchar2(10),
  sex varchar2(4),
  user_email varchar2(20),
  user_phone varchar2(15),
  role_id int
);

create sequence USER_NEXTID_SQ;
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'admin','123','��','test@qq.com','10086',1);
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'manufacturer','1234','��','test1@qq.com','1008611',2);
insert into UUSER values(USER_NEXTID_SQ.NEXTVAL,'seller','12345','��','tes1t@qq.com','13800138',3);
select * from UUSER;

-- Role ��ɫ��
create table ROLE(
  role_id number(10) primary key,
  role_name varchar2(20)
);
insert into ROLE values(1,'admin');
insert into ROLE values(2,'manufacturer');
insert into ROLE values(3,'seller');

-- waller Ǯ����
create table WALLET(
  wallet_id number(10) primary key,
  balance number(20) --Ǯ�����
);

-- �û���Ǯ��������
create table USER_LIEN_WALLET(
  uid number(10) references UUSER(user_id),
  wid number(10) references WALLET(wallet_id),
  primary key(USERID,FUNNO)
);

--manufacturer �����̱�
create table MANUFACTURER(
  man_id number(10) constraint pk_man_id primary key, 
  man_no number(10),
  man_name  varchar2(20), 
  man_address varchar2(50), 
  man_scope varchar2(100),  --������Ӫ����Χ��Χ
  man_desc varchar2(200)  
);
create sequence MANUFACTURER_NEXTID_SQ;

insert into MANUFACTURER(man_id,man_name,man_address,man_scope,man_desc)
values(MANUFACTURER_NEXTNO_SQ.NEXTVAL,'xxx','yyy','zzz','kkk');
select man_id id,man_address address,man_scope scope,man_desc mdesc
from MANUFACTURER 
where man_id=22;

select * from MANUFACTURER;

--brand
create table "BRAND"
(
  brand_id number(20,0) constraint pk_brand_id primary key,  --Ʒ��ID
  brand_name  varchar2(50),  --Ʒ������
  man_id number(20,0),  --������ID
  brand_desc varchar2(200)  --Ʒ�Ƽ��
);

create sequence BRAND_NEXTNO_SQ;


--ORDER_ITEM
create table "ORDER_ITEM"
(
  order_id number(20,0) constraint pk_order_id primary key,       --����ID
  pro_id number(20,0),   --��ƷID
  pro_id_count number(20,0),  --��Ʒ����
  man_id number(20,0),    --������ID
  seller_id number(20,0), --������ID
  state varchar2(20  byte)    --����״̬
)



create table "PRODUCT"
(
  pro_id number(20,0) constraint pk_pro_id primary key,
  pro_name  varchar2(50 byte), 
  pro_price number(20,2), 
  pro_weight number(20,2),
  pro_count number(20,0),
  pro_kinds_id  number(20,0),
  pro_state_id  number(20,0),
  brand_id  number(20,0),
  pro_photos_id  number(20,0),
  pro_desc  varchar2(200 byte)
)

insert into PRODUCT(pro_id,pro_name,pro_price,pro_weight)
values(2,'a',1,20)
