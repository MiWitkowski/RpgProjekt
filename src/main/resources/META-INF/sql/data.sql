use rpg_projekt;
create table if not exists monster
(
    id         int auto_increment
        primary key,
    experience int          not null,
    hp         int          not null,
    name       varchar(255) not null
);

create table if not exists role
(
    role_id int auto_increment
        primary key,
    role    varchar(255) null
);

create table if not exists users
(
    username   varchar(50)     null,
    password   varchar(256)    null,
    enabled    tinyint(1)      null,
    id         int auto_increment
        primary key,
    experience int default 0   not null,
    hp         int default 100 not null,
    lvl        int default 1   not null,
    constraint username
        unique (username)
);

create table if not exists authorities
(
    username  varchar(256) null,
    authority varchar(256) null,
    id        int auto_increment
        primary key,
    users     int          null,
    constraint FKnmbunvecup7ec3v7qofbmkq2b
        foreign key (users) references users (id)
);

create table if not exists user_role
(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint FKa68196081fvovjhkek5m97n3y
        foreign key (role_id) references role (role_id),
    constraint FKj345gk1bovqvfame88rcx7yyx
        foreign key (user_id) references users (id)
);


insert into monster (hp, name, experience) VALUE (5, "Goblin", 5);
insert into monster (hp, name, experience) VALUE (10, "Troll", 10);
insert into monster (hp, name, experience) VALUE (30, "Smok", 30);

insert into users (username, password, enabled) VALUES ('testo', '$2a$10$rg2EQF1c5uunzFC1L.z2oub.va3ca2rTuBWmmwHcSi36qRYaaAg2a', true);
insert into users (username, password, enabled) VALUES ('admin', '$2a$10$Wvj1EaJW6f9dbzBYMSyLkeb8hNq0TcKnsBPyGkBox9SopvMx0CKKG', true);



insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('testo', 'ROLE_USER');

