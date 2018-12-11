drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_CFFD06FF on FOO_Foo (field2);
create index IX_B2FCA947 on FOO_Foo (uuid_, companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_, groupId);


