create table FOO_Foo (
	uuid_ VARCHAR2(75 CHAR) null,
	fooId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	field1 VARCHAR2(75 CHAR) null,
	field2 number(1, 0),
	field3 number(30,0),
	field4 timestamp null,
	field5 VARCHAR2(75 CHAR) null
);
