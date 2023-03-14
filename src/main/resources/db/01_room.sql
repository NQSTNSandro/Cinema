--liquibase formatted sql
--changeset sbochkov:2
INSERT INTO room values(1,1,'standard',20, '3d');
INSERT INTO row values(1,1,5,15.0, 1);
