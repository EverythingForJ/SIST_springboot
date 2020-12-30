CREATE TABLE Member
(
userid VARCHAR2(20),
passwd VARCHAR2(20) CONSTRAINT member_passwd_nn NOT NULL,
name VARCHAR2(20) CONSTRAINT member_name_nn NOT NULL,
age NUMBER(2) CONSTRAINT member_age_nn NOT NULL,
gender CHAR(1) CONSTRAINT member_gender_nn NOT NULL,
city VARCHAR2(30) CONSTRAINT member_city_nn NOT NULL,
CONSTRAINT member_userid_pk PRIMARY KEY(userid),
CONSTRAINT member_age_ck CHECK(age BETWEEN 20 AND 65),
CONSTRAINT member_gender_ck CHECK(gender IN ('1', '0')),
CONSTRAINT member_city_ck CHECK(city IN('서울', '부산', '대전', '광주', '대구', '인천', '울산'))
)

CREATE OR REPLACE PROCEDURE sp_member_insert
(
    t_userid IN member.userid%TYPE,
    t_passwd IN member.passwd%TYPE,
    t_name IN member.name%TYPE,
    t_age IN member.age%TYPE,
    t_gender IN member.gender%TYPE,
    t_city IN member.city%TYPE
)
IS
BEGIN
INSERT INTO Member(userid, passwd, name, age, gender, city)
VALUES(t_userid, t_passwd, t_name, t_age, t_gender, t_city);
COMMIT;
END;

CREATE OR REPLACE PROCEDURE sp_member_select_all
(
member_record OUT SYS_REFCURSOR
)
AS
BEGIN
OPEN member_record FOR
SELECT * FROM Member
ORDER BY userid ASC;
END;

CREATE OR REPLACE PROCEDURE sp_member_select
(
t_userid IN member.userid%TYPE,
member_record OUT SYS_REFCURSOR
)
AS
BEGIN
OPEN member_record FOR
SELECT * FROM Member
WHERE userid = t_userid;
END;


CREATE OR REPLACE PROCEDURE sp_member_update
(
t_age IN member.age%TYPE,
t_gender IN member.gender%TYPE,
t_city IN member.city%TYPE,
t_userid IN member.userid%TYPE
)
IS
BEGIN
UPDATE Member SET age = t_age, gender = t_gender, city = t_city
WHERE userid = t_userid;
COMMIT;
END;