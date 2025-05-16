INSERT INTO department(deptid, deptname) VALUES (dept_seq.NEXTVAL, 'Information Technology');
INSERT INTO department(deptid, deptname) VALUES (dept_seq.NEXTVAL, 'Human resources');
INSERT INTO department(deptid, deptname) VALUES (dept_seq.NEXTVAL, 'Finance');
INSERT INTO department(deptid, deptname) VALUES (dept_seq.NEXTVAL, 'Marketing');

COMMIT;

INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Pratham Rathod', 1, 'pratham@gmail.com', 21, 'male', 800000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Kritika Lohani', 1, 'kritika@gmail.com', 22, 'female', 600000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Dev Patel', 3, 'dev@gmail.com', 19, 'male', 300000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Vivek Surati', 3, 'vivek@gmail.com', 21, 'male', 200000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Dev Palasanwala', 4, 'dev.palasan@gmail.com', 22, 'male', 700000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Kishan Yadav', 2, 'kishan@gmail.com', 21, 'male', 500000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Mansi Padia', 4, 'mansi@gmail.com', 23, 'female', 400000);
INSERT INTO employee(id, name, deptid, mail, age, gender, salary) VALUES(emp_seq.NEXTVAL, 'Shraddha Jadav', 2, 'shraddha@gmail.com', 20, 'female', 350000);

COMMIT;