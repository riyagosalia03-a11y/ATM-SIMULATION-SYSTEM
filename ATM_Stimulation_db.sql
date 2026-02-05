create database atm_db;
use atm_db;
drop table account;
create table account
(accno int primary key,
pin int,
name text,
op_bal double
);

insert into account values(101,1234,"Riya Goslaia",23000);
insert into account values(102,1254,"Annie Ghelani",56000);
insert into account values(103,9658,"Yashvi Desai",86000);
insert into account values(104,1460,"Palak Pardeshi",63000);
insert into account values(105,5632,"Keyur Shah",12000);

select*from account;