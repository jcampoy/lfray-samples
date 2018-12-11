drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;



create index IX_CFFD06FF on FOO_Foo (field2);
create index IX_B2FCA947 on FOO_Foo (uuid_, companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_, groupId);



quit