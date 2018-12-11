create table FOO_Foo (
	uuid_ varchar(75) null,
	fooId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate datetime(6) null,
	modifiedDate datetime(6) null,
	field1 varchar(75) null,
	field2 tinyint,
	field3 integer,
	field4 datetime(6) null,
	field5 varchar(75) null
) engine InnoDB;
