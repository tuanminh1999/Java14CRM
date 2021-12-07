create database if not exists crm;

use crm;

create table crm_role(
	id 				int auto_increment,
    name 			varchar(255) not null,
    description 	varchar(255),
    primary key (id)
);

create table crm_status(
	id 				int auto_increment,
    name 			varchar(255) not null,
    description 	varchar(255),
    primary key (id)
);

create table crm_user(
	id 				int auto_increment,
    name 			varchar(255) not null,
    email 			varchar(100) not null,
    password 		varchar(255) not null,
    phone 			varchar(36),
    address 		varchar(255),
    role_id 			int,
    primary key (id)
);

create table crm_project(
	id				int auto_increment,
    name 			varchar(255) not null,
    description 	varchar(255),
    start_date		date,
    end_date		date,
    create_by		int,
    primary key (id)
);

create table crm_task(
	id 				int auto_increment,
    assignee 		int,
    name 			varchar(255) not null,
    description 	varchar(255),
    start_date		date,
    end_date		date,
    project_id			int,
    status_id			int,
    primary key (id)
);

alter table crm_user add constraint fk_user_role foreign key (role_id) references crm_role (id);
alter table crm_project add constraint fk_project_create_user foreign key (create_by) references crm_user (id);
alter table crm_task add constraint fk_task_assignee_user foreign key (assignee) references crm_user (id);
alter table crm_task add constraint fk_task_status foreign key (status_id) references crm_status (id);
alter table crm_task add constraint fk_task_project foreign key (project_id) references crm_project (id);

-- Insert Role --
insert into crm_role(name, description) values ('ADMIN', 'Quản trị');
insert into crm_role(name, description) values ('LEADER', 'Lãnh đạo');
insert into crm_role(name, description) values ('MEMBER', 'Nhân viên');

-- Insert User --
insert into crm_user(name, email, password, phone, address, role_id) values('Admin','admin@gmail.com', '1234', '0123456789', '123 Trần Hưng Đạo', 1);
insert into crm_user(name, email, password, phone, address, role_id) values('Anh','nguyenvana@gmail.com', '1234', '0123456789', '123 Nguyễn Trãi', 2);
insert into crm_user(name, email, password, phone, address, role_id) values('Bình','nguyenvanb@gmail.com', '1234', '0123456789', '123 An Dương Vương', 3);

-- Insert Status --
insert into crm_status(name, description) values ('CHƯA THỰC HIỆN', 'Chưa thực hiện');
insert into crm_status(name, description) values ('ĐANG THỰC HIỆN', 'Đang thực hiện');
insert into crm_status(name, description) values ('HOÀN THÀNH', 'Hoàn thành');
