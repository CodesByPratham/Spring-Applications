DROP TABLE students CASCADE CONSTRAINTS; -- Comment the line because at first there is no table to drop

CREATE TABLE students (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER
);
