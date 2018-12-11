create table FOO_Foo (
	uuid_ varchar(75) null,
	fooId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	field1 varchar(75) null,
	field2 bool,
	field3 integer,
	field4 timestamp null,
	field5 varchar(75) null
);
