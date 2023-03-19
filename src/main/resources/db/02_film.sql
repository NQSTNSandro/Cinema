--liquibase formatted sql
--changeset sbochkov:3
INSERT INTO film values(0,'Test title',10000,20,16,'2023-03-19',5);
