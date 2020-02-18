create table question
(
	id int auto_increment,
	title varchar(50) not null,
	description text,
	tag varchar(256),
	gmt_creat bigint,
	gmt_modified bigint,
	view_count int default 0,
	comment_count int default 0,
	like_count int default 0,
	creator varchar(50),
	constraint question_pk
		primary key (id)
);

comment on table question is '问题';

comment on column question.title is '标题';

comment on column question.description is '描述';

comment on column question.tag is '标签';

comment on column question.gmt_creat is '创建时间';

comment on column question.gmt_modified is '修改时间';

comment on column question.view_count is '阅读量';

comment on column question.comment_count is '评论数';

comment on column question.like_count is '点赞数';

comment on column question.creator is '发起人';

