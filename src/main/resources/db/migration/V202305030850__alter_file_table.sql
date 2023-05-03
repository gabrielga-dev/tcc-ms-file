ALTER TABLE file
    ADD COLUMN origin varchar(300) not null;
ALTER TABLE file
    ADD COLUMN origin_uuid varchar(36) not null;
