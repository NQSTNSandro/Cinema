--liquibase formatted sql
--changeset sgolovko:1
CREATE TABLE "director"
(
    "id"  serial       NOT NULL,
    "fio" varchar(255) NOT NULL,
    CONSTRAINT "director_pk" PRIMARY KEY ("id")
)
