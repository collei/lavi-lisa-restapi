
create database lavi character set utf8 collate utf8_general_ci;

create table entries (
	id int not null auto_increment primary key,
	entry varchar(30) not null,
	part_of_speech int not null,
	meaning varchar(50) not null
) character set utf8 collate utf8_general_ci engine=innoDB;

create table parts_of_speech (
	id int not null primary key,
	part_of_speech varchar(16) not null,
	abbreviated_form varchar(8) not null
) character set utf8 collate utf8_general_ci engine=innoDB;