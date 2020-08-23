/*
-- c_cafe Table Create SQL
CREATE TABLE c_cafe
(
    c_idx      INT, 
    c_name     VARCHAR2(100) NOT NULL, 
    c_addr     VARCHAR2(300) NOT NULL, 
    c_tel      VARCHAR2(100) NOT NULL, 
    c_price    VARCHAR2(100) NOT NULL, 
    c_park     VARCHAR2(100) NOT NULL, 
    c_time     VARCHAR2(100) NOT NULL, 
    c_hday     VARCHAR2(100) NOT NULL, 
    c_uri      VARCHAR2(100), 
    c_map      VARCHAR2(100) NOT NULL, 
    c_photo    VARCHAR2(100) NOT NULL, 
    c_menu1    VARCHAR2(100) NOT NULL, 
    c_menu2    VARCHAR2(100), 
    c_menu3    VARCHAR2(100), 
    c_menu4    VARCHAR2(100), 
    c_tag        VARCHAR2(100) NOT NULL, 
    CONSTRAINT C_CAFE_PK PRIMARY KEY (c_idx)
);

CREATE SEQUENCE c_cafe_seq;

-- c_cafe Table Create SQL
CREATE TABLE c_member
(
    m_idx        INT              , 
    m_id         VARCHAR2(100)    NOT NULL, 
    m_pwd        VARCHAR2(100)    NOT NULL, 
    m_name       VARCHAR2(100)    NOT NULL, 
    m_gender     VARCHAR2(100)    NOT NULL, 
    m_tel        VARCHAR2(100)    NOT NULL, 
    m_email      VARCHAR2(100)    NOT NULL, 
    m_photo      VARCHAR2(100)    , 
    m_grade      VARCHAR2(100)    NOT NULL, 
    m_ip         VARCHAR2(100)    NOT NULL, 
    m_regdate    DATE             , 
    CONSTRAINT C_MEMBER_PK PRIMARY KEY (m_idx)
);

CREATE SEQUENCE c_member_seq;

CREATE TABLE c_review
(
    r_idx        INT              , 
    r_cot        VARCHAR2(1000)    NOT NULL, 
    m_idx        INT               NOT NULL, 
    c_idx        INT               NOT NULL, 
    r_grade      INT               NOT NULL, 
    r_pwd        VARCHAR2(100)     NOT NULL, 
    r_ip         VARCHAR2(100)     NOT NULL, 
    r_regdate    DATE             , 
    CONSTRAINT C_REVIEW_PK PRIMARY KEY (r_idx)
);

insert into c_member values(c_review_SEQ.nextval,'�� ī�� �ʹ� ���پƾƾƾ�','admin1','������','����','010-111-1111','admin@gamil.com', 'no_file.jpg','������','127.0.0.1',sysdate);

CREATE SEQUENCE c_review_seq;

ALTER TABLE c_review
    ADD CONSTRAINT FK_cafe_c_idx FOREIGN KEY (c_idx)
        REFERENCES c_cafe (c_idx) ON DELETE CASCADE;

ALTER TABLE c_review
    ADD CONSTRAINT FK_member_m_idx FOREIGN KEY (m_idx)
        REFERENCES c_member (m_idx) ON DELETE CASCADE;

-- c_cafe Table Create SQL
CREATE TABLE c_hits
(
    s_idx    INT    , 
    s_num    INT    NOT NULL, 
    c_idx    INT    NOT NULL, 
    CONSTRAINT C_HITS_PK PRIMARY KEY (s_idx)
);

CREATE SEQUENCE c_hits_seq;

ALTER TABLE c_hits
    ADD CONSTRAINT FK_h_cafe_c_idx FOREIGN KEY (c_idx)
        REFERENCES c_cafe (c_idx) ON DELETE CASCADE;
 
insert into c_member values(c_member_SEQ.nextval,'admin1','admin1','������','����','010-111-1111','admin@gamil.com', 'no_file.jpg','������','127.0.0.1',sysdate);

update c_member set m_pwd = 'admin12' where m_id = 'admin12';



alter table c_review
 drop constraint FK_cafe_c_idx
alter table c_review
 drop constraint FK_member_m_idx
alter table c_hits
 drop constraint FK_h_cafe_c_idx
 
--�������� �˻�
select * from information_schema.table_constraints where table_name = '���̺��';


alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx) 
                               references product(p_idx)
                               on delete cascade
alter table cart
  add constraint fk_cart_m_idx foreign key(m_idx) 
                               references member(m_idx)
                               on delete cascade
		
delete  from c_member where m_idx =1 ;
			
select * from c_member where m_id = 'admin1'			
			
select * from c_member;
select * from c_cafe;
select * from c_review;
select * from c_hits;
select * from detail_review_view;

insert into c_cafe values(c_cafe_SEQ.nextval,'�м�1','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�2','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�3','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�4','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�6','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�7','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�8','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�9','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�10','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�11','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');
insert into c_cafe values(c_cafe_SEQ.nextval,'�м�12','12345��� ���������¿���272','02-2071-9505','10000','����','10:00~12:00', '14:30~10:00','www.cafe.com','123123','123.jpg','�Ƹ޸�ī��,5000��',null,null,null,'������,������');


select * from detail_review_view where c_idx = 1

commit

-- ���� + ȸ�� ����
create or replace view detail_review_view as
select m.m_idx m_idx, m.m_id m_id, m.m_pwd m_pwd, m.m_name m_name, m.m_gender m_gender, m.m_tel m_tel, m.m_email m_email, m.m_photo m_photom, m.m_grade m_grade, m.m_ip m_ip, m.m_regdate m_regdate, r.r_idx r_idx, r.r_cot r_cot, r.c_idx c_idx, r.r_grade r_grade, r.r_pwd r_pwd, r.r_regdate r_regdate
from c_review r left outer join c_member m on r.m_idx = m.m_idx
order by r.r_idx desc

-- ���� ���
select r.*,
round((select avg(r_grade) from c_review where c_idx = 1),1) avg
from 
   (select * from c_review where c_idx=1 order by r_grade desc) r
where rownum = 1

select r.r_idx r_idx, r.r_cot r_cot, r.c_idx c_idx, r.r_grade r_grade, r.r_pwd r_pwd, r.r_regdate r_regdate,
(select sum(c_idx) from c_review where c_idx = 1) sum,
(
	select sum(r_grade) 
	from c_review 
	where c_idx = 
	(
		select c_idx
		from c_reivew
		where r_grade = 5
	)
) r
from c_review

create or replace view hits_view
as
select r_idx,r.c_idx,h.s_num

from c_review r inner join c_hits h on r.c_idx = h.c_idx

select * from hits_view where c_idx =35
select * from c_hits where c_idx = 35

*/

/*
--alter table [�߰������̺��] add constraint [�������Ǹ�] foreign key(�÷���) references [�θ����̺��] (PK�÷���) [ON DELETE CASCADE / ON UPDATE CASECADE];

--�� ����� 
create or replace view cart_view
as
	select
	   p.p_idx,c_idx, p_num,p_name,p_price,p_saleprice,
	   c_cnt, c_cnt* p_saleprice amount, m.m_idx
	from product p inner join  cart c on p.p_idx = c.p_idx
		inner join member m on m.m_idx = c.m_idx  

select * from cart_view;
 
-- drop sequence c_hits_seq;

-- DROP VIEW detail_review_view

-- �ϳ��� ��ȸ
select *
from (select *
from c_review
where c_idx = 1
order by r_grade desc) 
where rownum = 1

select avg(r_grade) avg, COUNT(*) count  from c_review where c_idx = 1 

select r.*,avg(r_grade)
from (select r_grade, COUNT(*) count
from c_review
where c_idx = 1 
GROUP BY r_grade) r


select r.r_cot r_cot,
(select avg(r_grade) from c_review where c_idx = 1) avg
from 
   (select * from c_review where c_idx=1) r
where rownum = 1


select r.*, 
(select s_num from hits_view where c_idx =1) s_nu
from 
(select * from hits_view where c_idx =5) r

select * from c_hits where c_idx = 33

��ȸ�� selectone
--
select s_num, nvl(count(r_idx),0) count from hits_view where c_idx =36 group by s_num


insert into c_hits values(c_hits_seq.nextval,1,36);
--��ȸ�� ����
UPDATE
    c_hits
SET
    s_num = (
                       SELECT nvl(s_num,0)+1
                     from c_hits
                      WHERE c_idx = c_idx
    ) 
WHERE
     c_idx = c_idx




select sum(r_idx) sum, count(*) count
from 
(select * from c_review where c_idx=1) r
group by r_grade

SELECT  COUNT(*) FROM c_review GROUP BY r_grade


select r.r_cot r_cot,
(select avg(r_grade) from c_review where c_idx = 1) avg
from 
   (select * from c_review where c_idx=1) r
where rownum = 1


SELECT c_idx
       
       count(CASE r_grade  WHEN 1 THEN 1 end) r_grade_1,
       count(CASE r_grade  WHEN 2 THEN 2 end) r_grade_2,
       count(CASE r_grade  WHEN 3 THEN 3 end) r_grade_3,
       count(CASE r_grade  WHEN 3 THEN 3 end) r_grade_4,
       count(CASE r_grade  WHEN 3 THEN 3 end) r_grade_5
 
  FROM 
  (
  
  
  
  select 
  
          'r_grade' || r_grade as r_grade 
          
          ,
 		  count(*)
 		  FROM c_review where c_idx = 2
 
   group by r_grade
  	
select 
    r.*, 
   (bad+notBad+soso+likes+god) as total
from  	
(
	select
	      nvl(avg(case r_grade when 1 then count(*) end), 0) bad,
	      nvl(avg(case r_grade when 2 then count(*) end), 0) notBad,
	      nvl(avg(case r_grade when 3 then count(*) end), 0) soso,
	      nvl(avg(case r_grade when 4 then count(*) end), 0) likes,
	      nvl(avg(case r_grade when 5 then count(*) end), 0) god
	from c_review
	where c_idx=22
	group by r_grade
) r
  			


select * from c_cafe where c_addr like '_____����%' order by c_idx desc
               	  
        
select * from c_review where c_idx = 2


--10�� ��ȸ�ϱ�
<![CDATA[
      select *
      from (select rownum c_idx,c_name,c_addr,c_tel,c_price,c_park,c_time,c_hday,c_uri,c_map,c_photo,c_menu1,c_menu2,c_menu3,c_menu4,c_tag  from c_cafe)
      where rownum <10
      ]]>
      
--10�Ǿ� �˻�
   select a.* from (select ROWNUM as RNUM, b.* from
( select * from c_cafe where  c_tag like '%' || '����ž' || '%' order by c_idx desc) b )
 a where a.RNUM>=(0*5)+1 and a.RNUM<=0*5+5;
select * from c_cafe where  c_addr like '%' || '����' || '%' order by c_idx desc



select a.* from 
(
   select ROWNUM as RNUM, b.* 
   from
   ( 
       select * from c_cafe
             where c_addr like '%����%' 
       order by c_idx desc
    ) b 
) a
where  a.RNUM >= (0*5)+1 and a.RNUM <= (0*5)+5 




insert into c_cafe values(c_cafe_seq.nextval, '����', '28721 ���� ������ â�ط�14���� 16�����߼ҵ�', '033-651-4007', 4000, 
								'����', '���� 08:00 - 24:00', '���߹���', null, '37.772914,128.9446399', 
								'cafe1.jpg', '������,5300', '�Ƹ޸�ī��,4200', null, null, 
								'����ž,�ٴٺ�');
								
insert into c_cafe values(c_cafe_seq.nextval, '�ٴ�����', '24770 ������ ���� �伺�� ���̸� 75-36', '033-636-1096', 6000, 
								'����', '���� 10:00 - 22:00', '���߹���', 'http://www.seasidegarden.co.kr/', '38.230962,128.5798764', 
								'cafe2.jpg', '�Ƹ޸�ī��,5000', '�ݵ�η� �Ƹ޸�ī��,6000', null, null, 
								'����ž,Ű����,���θ�,�׶�');
								
insert into c_cafe values(c_cafe_seq.nextval, '�򸶷�', '24770 ������ ������ �ʴ絿 266-3', '033-922-7175', 4000, 
								'�Ұ�', '���� 11:00 - 21:00', 'ȭ���� �޹�', 'http://www.instagram.com/cafe_toenmaru', '37.7877828,128.9113856', 
								'cafe3.jpg', '�Ƹ޸�ī��,3500', '�򸶷�Ŀ��,5500', null, null, 
								'�����,�ʴ�κ�,������');
								
insert into c_cafe values(c_cafe_seq.nextval, '�׶�λ� Ŀ�ǰ���', '25623 ������ ������ ������ ��ܸ� 973-1', '033-648-2760', 6000, 
								'����', '���� 09:00 - 21:00', '���߹���', 'http://www.terarosa.com/', '37.6960542,128.8896992', 
								'cafe4.jpg', '�Ƹ޸�ī��,4500', 'ī�����,5000', null, null, 
								'�ڵ�帳,�׶�');	
																							
insert into c_cafe values(c_cafe_seq.nextval, '�ø������', '25053 ������ ��籺 ������ �α��� 636-5', '1577-8647', 8000, 
								'����', '���� 11:00 - 22:00', '���߹���', 'http://www.yyroad.co.kr', '37.9686013,128.7596703', 
								'cafe5.jpg', '�Ƹ޸�ī��,4500', '���̽��ٶ�,7500', null, null, 
								'��ü��,�ݷ����� ����,��,���ڼ�');	
								
insert into c_cafe values(c_cafe_seq.nextval, '���κ�', '12768 ��⵵ ���ֽ� �ߴ뵿 160-2', '031-761-1295', 8000, 
								'����', '���� 09:00 - 22:00', '���߹���', 'http://www.9block.co.kr/', '37.4032755,127.2211737', 
								'cafe6.jpg', '�Ƹ޸�ī��,7000', null, null, null, 
								'��ü��');								
								
insert into c_cafe values(c_cafe_seq.nextval, '�ܱ�', '11518 ��⵵ ���ֽ� �鼮�� ��긮 182-2', '031-871-3700', 10000, 
								'����', '���� 12:00 - 20:00', '���߹���', 'http://www.dangung.com/', '37.7759844,126.9567382', 
								'cafe7.jpg', '�Ƹ޸�ī��,10000', null, null, null, 
								'��ü��');
								
insert into c_cafe values(c_cafe_seq.nextval, '�������� �ȴ�', '12277 ��⵵ �����ֽ� �ͺ��� �ȴ縮 774', '031-577-2505', 6000, 
								'����', '���� 10:00 - 02:00', '���߹���', null, '37.5563997,127.2341516', 
								'cafe8.jpg', '�Ƹ޸�ī��,6000', null, null, null, 
								'��ü��,�ݷ����� ����');								
								
insert into c_cafe values(c_cafe_seq.nextval, '��ƼƮ��ũ', '10880 ��⵵ ���ֽ� ���ߵ� 75-6', '031-871-3700', 6000, 
								'����', '���� 09:00 - 22:00', '���߹���', 'http://www.instagram.com/dirty_trunk_korea', '37.7275583,126.700827', 
								'cafe9.jpg', '�Ƹ޸�ī��,4500', null, null, null, 
								'��ü��');		
								
insert into c_cafe values(c_cafe_seq.nextval, '���', '12282 ��⵵ �����ֽ� ���ȸ� ���ȸ� 192-11', '031-576-8090', 10000, 
								'����', '���� 11:00 - 22:00', '���߹���', 'http://www.godangcnb.com', '37.5360706,127.3003635', 
								'cafe10.jpg', '��Ƽ���Ǿ�,9000', null, null, null, 
								'��ü��,�ѿ�');																					
													
insert into c_cafe values(c_cafe_seq.nextval, '�̻��', '21393 ��õ������ ���� ���� 211-179', '032-511-2359', 4000, 
								'�Ұ�', '���� 10:00 ~ 23:00', '�Ŵ� ù°�� ȭ���� �޹�', 'https://www.instagram.com/23r.cafe/', '37.4943627,126.7226238', 
								'cafe11.jpg', '�Ƹ޸�ī��,5000', '�̻�� ���ν����,4000', null, null, 
								'��ü��');		
								
insert into c_cafe values(c_cafe_seq.nextval, '��ȭ����', '23049 ��õ������ ��ȭ�� ���� ������ 428-1', '070-4193-4889', 6000, 
								'����', '���� 10:00 ~ 19:00', '���߹���', 'https://www.instagram.com/maehwamareum123/', '37.6362311,126.5175486', 
								'cafe12.jpg', '�ڵ�帳��,5000', '������,6000', null, null, 
								'��ü��,������');																										

insert into c_cafe values(c_cafe_seq.nextval, '���ٹ�', '23123 ��õ������ ������ ����� ���縮 148-2', '032-889-8300', 6000, 
								'����', '���� 10:00 ~ 20:30', '���� ȭ���� �޹�', 'https://www.instagram.com/ppeoldabang', '37.234127,126.529162', 
								'cafe13.jpg', '�Ƹ޸�ī��,6500', '������,15000', null, null, 
								'��ü��,�ٴٺ�');		
								
insert into c_cafe values(c_cafe_seq.nextval, '����ξ�Ŀ��x���˰���ī��', '22186 ��õ������ ����Ȧ�� ������ 622-17', '010-8887-6223', 4000, 
								'����', '���� 12:00 ~ 21:00', '���� �Ͽ��� �޹�', 'http://instagram.com/leon_and_macaron', '37.4513501,126.633087', 
								'cafe14.jpg', '�Ƹ޸�ī��,3500', null, null, null, 
								'����Ʈ');	
								
insert into c_cafe values(c_cafe_seq.nextval, '���', '22190 ��õ������ ����Ȧ�� ������ 627-506', '032-887-3561', 4000, 
								'�Ұ�', '���� 10:00 ~ 22:00', '�Ŵ� ù°�� ������ �޹�', 'https://www.instagram.com/cafe_birang/', '37.4509778,126.6346871', 
								'cafe15.jpg', '�Ƹ޸�ī��,4000', 'ī���,5000', null, null, 
								'��ü��');																																																																																																																																																																																																																																									
																						insert into c_cafe values
(c_cafe_seq.nextval, '5to7', '04768 ���� ������ ���｣2�� 44-13', '070-4127-7616', 10000, 
                        '�Ұ�', '���� 11:30 - 21:00', '���� ��,ȭ', 'http://www.instagram.com/5to7__seongsuvintage', '36.6105628,131.1765599', 
                        'cafe16.jpg', '���ں���,6000', '5to7�����,8000', null, null, 
                        '�ְߵ��ݰ���,��ü��');   

insert into c_cafe values
(c_cafe_seq.nextval, '&other', '04768 ���� ������ ���｣2�� 40-10' , '070-8777-9724', 8000, 
                        '�Ұ�', '���� 10:30 - 23:00', '���߹���',
 'https://cafenother.modoo.at', '37.5462542,127.0406077', 
                        'cafe17.jpg', '�Ƹ޸�ī��,7000 ', '���̽��ص�,7500', null, null, 
                        '�����,����,����ġ');   

insert into c_cafe values
(c_cafe_seq.nextval, '�׸���', '04768 ���� ������ ���｣2�� 18-11' , '02-499-5833', 6000, 
                        '�Ұ�', '���� 12:00 - 19:00', '���� ��,ȭ',
 'https://www.instagram.com/greenlab_seoulforest/', '37.5469743,127.0385196', 
                        'cafe18.jpg', '�ڸ���ϰ�,6000 ', '������ú�ϰ�,6000', '�м��ĸ�����ϰ�,6000', 
		null, '����ž');   

insert into c_cafe values
(c_cafe_seq.nextval, '�Ҿƹ�������', '04781 ���� ������ �����̷�7���� 9' , '02-499-5833', 8000, 
                        '�Ұ�', '���� 12:00 - 19:00', '���߹���',
 'https://www.instagram.com/grandpa.factory/', '37.5410878,127.0527159', 
                        'cafe19.jpg', 'Ŀ��,5000 ', '�Ľ�Ÿ,19000', '�����ؿ��̵�,8000', 
		null, 'Dining');   

insert into c_cafe values
(c_cafe_seq.nextval, 'KANTO', '04781 ���� ������ ������� 20' , '010-8386-3657', 6000, 
                        '�Ұ�', '���� 11:00 ~ 21:00', '���߹���',
 'http://instagram.com/kanto_cafe', '37.5434087,127.0493122', 
                        'cafe20.jpg', '����Ʈ,17500', '��ũ��,6500', '���Ŀ��,5000',  
		null, '����'); 
		
insert into c_cafe values(c_cafe_seq.nextval, '���Ŀ��', '46311 �λ걤���� ������ �ΰ 873-98', '051-512-7034', 5000, 
								'�Ұ�', '���� 10:00 - 21:30', '���߹���', null, '35.2192686,129.0842482', 
								'cafe21.jpg', '������ �ڵ�帳 ��,5000', '���������� ��,4800', null, null, 
								'�ѿ�,���� �ٸ���Ÿ è�Ǿ� �����');
								
insert into c_cafe values(c_cafe_seq.nextval, '�ű���', '49084 �λ걤���� ������ û�е� 148-203 ', '070-8230-1116', 6000, 
								'����', '���� 11:00-23:00', '���߹���', 'http://sinki.co.kr/', '35.0904646,129.0612129', 
								'cafe22.jpg', '�ű��,7000', 'ī���,6000', null, null, 
								'�λ��״뱳,����ž,�λ���,�׶�');
								
insert into c_cafe values(c_cafe_seq.nextval, '����993', '48098 �λ걤���� �ؿ�뱸 �ߵ� 993-3', '033-922-7175', 7000, 
								'����', '���� 11:00~22:00', '���߹���', 'http://edge993.co.kr/', '35.1564176,129.1730262', 
								'cafe23.jpg', '������,7500', '���� �����Ƴ�,7000', null, null, 
								'�ؿ��,�ٴ尡,���');
								
insert into c_cafe values(c_cafe_seq.nextval, '���̵�', '25623 �λ� ���屺 �ϱ��� ���鸮 449', '051-727-4717', 6000, 
								'����', '���� 10:30~22:00', '���߹���', null, '35.2829065,129.2543218', 
								'cafe24.jpg', '�Ƹ޸�ī��,5500', '���̵縻��Ŀ��,7500', null, null, 
								'�ҳ��������ηΰ�,�ڿ�ģȭ��');	
																							
insert into c_cafe values(c_cafe_seq.nextval, '���̺��', '46037 �λ� ���屺 ����� �ظ��̷� 286', '051-727-1660', 7000, 
								'����', '���� 11:00 - 24:00', '���߹���', 'http://www.waveoncoffee.com/', '35.3222464,129.2673818', 
								'cafe25.jpg', 'ī�� ��,6000', '����� Ŀ��,7000', null, null, 
								'���Ǻ�,�ĵ�,�ٴ�');	
		
*/



