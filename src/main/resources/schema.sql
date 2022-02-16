create table users(
	username varchar_ignorecase(60) not null primary key,
	password varchar_ignorecase(60) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(60) not null,
	authority varchar_ignorecase(60) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);



INSERT INTO users (username, password, enabled)
values('user','password', true);

INSERT INTO users (username, password, enabled)
values('admin','$2a$04$DXPFu6LLBNGbmMIroNa91eMeLGinaD6Wv/jx6j2ou6/v6AsP4F1HK', true);

INSERT INTO authorities(username, authority)
values('user','ROLE_USER');

INSERT INTO authorities(username, authority)
values('admin','ROLE_ADMIN');