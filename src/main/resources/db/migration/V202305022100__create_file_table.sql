CREATE TABLE file
(
    uuid          varchar(36) primary key not null,
    name          varchar(300)            not null,
    type          varchar(500)            not null,
    creation_date timestamp               not null
);
