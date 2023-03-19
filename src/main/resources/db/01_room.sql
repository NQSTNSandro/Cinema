--liquibase formatted sql
--changeset sbochkov:2
INSERT INTO room values(0,1,'standard',20, '3d');
INSERT INTO row values(0,1,5,15.0, 0);
