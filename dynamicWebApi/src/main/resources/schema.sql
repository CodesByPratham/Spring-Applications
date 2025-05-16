DROP TABLE employee; -- Comment the line because at first there is no table to drop
DROP TABLE department; -- Comment the line because at first there is no table to drop
DROP SEQUENCE dept_seq; -- Comment the line because at first there is no sequence to drop
DROP SEQUENCE emp_seq; -- Comment the line because at first there is no sequence to drop

CREATE TABLE department (
   deptid   NUMBER PRIMARY KEY,
   deptname VARCHAR2(30) NOT NULL
);

CREATE TABLE employee (
   id     NUMBER PRIMARY KEY,
   name   VARCHAR2(30) NOT NULL,
   deptid NUMBER NOT NULL,
   mail   VARCHAR2(60) NOT NULL,
   age    NUMBER NOT NULL,
   gender VARCHAR2(10) NOT NULL,
   salary NUMBER NOT NULL,
   CONSTRAINT fk_employee_department FOREIGN KEY(deptid) REFERENCES department(deptid)
);

CREATE SEQUENCE dept_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE emp_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;