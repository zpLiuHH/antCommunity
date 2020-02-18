alter table USER
	add avatar_url varchar(100);

comment on column USER .avatar_url is '发起人地址';