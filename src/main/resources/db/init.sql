--liquibase formatted sql
--changeset sbochkov:1
CREATE TABLE "director"
(
    "id"  serial       NOT NULL,
    "fio" varchar(255) NOT NULL,
    CONSTRAINT "director_pk" PRIMARY KEY ("id")
);
 CREATE TABLE "actor" (
        "id" serial NOT NULL,
    	"fio" varchar(255) NOT NULL,
    	CONSTRAINT "actor_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );

    CREATE TABLE "country" (
    	"id" serial NOT NULL,
    	"name" varchar(128) NOT NULL UNIQUE,
    	CONSTRAINT "country_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "genre" (
    	"id" serial NOT NULL,
    	"type" varchar(128) NOT NULL UNIQUE,
    	CONSTRAINT "genre_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "company" (
    	"id" serial NOT NULL,
    	"name" varchar(128) NOT NULL UNIQUE,
    	"foundation" int NOT NULL,
    	CONSTRAINT "company_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
create table "room"
(
    id           serial
        primary key,
    number       integer not null,
    projector    varchar(255),
    total_places integer not null,
    type         varchar(255)
);
create table "row"
(
    id serial primary key,
    number  integer not null,
    places  integer not null,
    ticket_cost_mp real not null,
    room_id integer not null
);
ALTER TABLE IF EXISTS public."row"
    ADD CONSTRAINT room_id FOREIGN KEY (room_id)
    REFERENCES public.room (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

    CREATE TABLE "film" (
    	"id" serial NOT NULL,
    	"title" varchar(128) NOT NULL,
    	"duration" int NOT NULL,
    	"licence_cost" float4 NOT NULL,
    	"rating" float4 NOT NULL,
    	"start_date" DATE NOT NULL,
    	"age_restrictions" int NOT NULL,
    	CONSTRAINT "film_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "session" (
    	"id" serial NOT NULL,
    	"film_id" int NOT NULL,
    	"date" DATE NOT NULL,
    	"cost" float4 NOT NULL,
    	"room_id" int NOT NULL,
    	CONSTRAINT "session_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
      CREATE TABLE "ticket" (
    	"id" serial NOT NULL,
    	"booking_id" int NOT NULL,
    	CONSTRAINT "ticket_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "booking" (
    	"id" serial NOT NULL,
    	"price" float4 NOT NULL,
    	"session_id" int NOT NULL,
    	"row_id" int NOT NULL,
    	"place" int NOT NULL,
    	"type" BOOLEAN NOT NULL,
    	CONSTRAINT "booking_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
     CREATE TABLE "ad_type" (
        	"id" serial NOT NULL,
        	"type" varchar(128) NOT NULL UNIQUE,
        	CONSTRAINT "ad_type_pk" PRIMARY KEY ("id")
        ) WITH (
          OIDS=FALSE
        );
     CREATE TABLE "client" (
        	"id" serial NOT NULL,
        	"type" BOOLEAN NOT NULL DEFAULT 'true',
        	"e-mail" varchar(256) NOT NULL UNIQUE,
        	"phone" varchar(32) NOT NULL UNIQUE,
        	"inn" int NOT NULL UNIQUE,
        	"ogrnip" varchar(255) NOT NULL UNIQUE,
        	"kpp" varchar(255) NOT NULL UNIQUE,
        	"title" varchar(255) NOT NULL UNIQUE,
        	"address" varchar(255) NOT NULL,
        	CONSTRAINT "client_pk" PRIMARY KEY ("id")
        ) WITH (
          OIDS=FALSE
        );
    CREATE TABLE "advertising" (
    	"id" serial NOT NULL,
    	"duration" int NOT NULL,
    	"ad_type" int NOT NULL,
    	"client_id" int NOT NULL,
    	CONSTRAINT "advertising_pk" PRIMARY KEY ("id")
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "session_ad" (
    	"session_id" int NOT NULL,
    	"advertising_id" int NOT NULL
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "film_director" (
    	"director_id" int NOT NULL,
    	"film_id" int NOT NULL
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "film_genre" (
    	"genre_id" int NOT NULL,
    	"film_id" int NOT NULL
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "film_company" (
    	"company_id" int NOT NULL,
    	"film_id" int NOT NULL
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "film_country" (
    	"country_id" int NOT NULL,
    	"film_id" int NOT NULL
    ) WITH (
      OIDS=FALSE
    );
    CREATE TABLE "film_actor" (
    	"actor_id" int NOT NULL,
    	"film_id" int NOT NULL
    ) WITH (
      OIDS=FALSE
    );
    ALTER TABLE "session" ADD CONSTRAINT "session_fk0" FOREIGN KEY ("film_id") REFERENCES "film"("id");
    ALTER TABLE "session" ADD CONSTRAINT "session_fk1" FOREIGN KEY ("room_id") REFERENCES "room"("id");
    ALTER TABLE "row" ADD CONSTRAINT "row_fk0" FOREIGN KEY ("room_id") REFERENCES "room"("id");
    ALTER TABLE "ticket" ADD CONSTRAINT "ticket_fk0" FOREIGN KEY ("booking_id") REFERENCES "booking"("id");
    ALTER TABLE "booking" ADD CONSTRAINT "booking_fk0" FOREIGN KEY ("session_id") REFERENCES "session"("id");
    ALTER TABLE "booking" ADD CONSTRAINT "booking_fk1" FOREIGN KEY ("row_id") REFERENCES "row"("id");
    ALTER TABLE "advertising" ADD CONSTRAINT "advertising_fk0" FOREIGN KEY ("ad_type") REFERENCES "ad_type"("id");
    ALTER TABLE "advertising" ADD CONSTRAINT "advertising_fk1" FOREIGN KEY ("client_id") REFERENCES "client"("id");
    ALTER TABLE "session_ad" ADD CONSTRAINT "session_ad_fk0" FOREIGN KEY ("session_id") REFERENCES "session"("id");
    ALTER TABLE "session_ad" ADD CONSTRAINT "session_ad_fk1" FOREIGN KEY ("advertising_id") REFERENCES "advertising"("id");
    ALTER TABLE "film_director" ADD CONSTRAINT "film_director_fk0" FOREIGN KEY ("director_id") REFERENCES "director"("id");
    ALTER TABLE "film_director" ADD CONSTRAINT "film_director_fk1" FOREIGN KEY ("film_id") REFERENCES "film"("id");
    ALTER TABLE "film_genre" ADD CONSTRAINT "film_genre_fk0" FOREIGN KEY ("genre_id") REFERENCES "genre"("id");
    ALTER TABLE "film_genre" ADD CONSTRAINT "film_genre_fk1" FOREIGN KEY ("film_id") REFERENCES "film"("id");
    ALTER TABLE "film_company" ADD CONSTRAINT "film_company_fk0" FOREIGN KEY ("company_id") REFERENCES "company"("id");
    ALTER TABLE "film_company" ADD CONSTRAINT "film_company_fk1" FOREIGN KEY ("film_id") REFERENCES "film"("id");
    ALTER TABLE "film_country" ADD CONSTRAINT "film_country_fk0" FOREIGN KEY ("country_id") REFERENCES "country"("id");
    ALTER TABLE "film_country" ADD CONSTRAINT "film_country_fk1" FOREIGN KEY ("film_id") REFERENCES "film"("id");
    ALTER TABLE "film_actor" ADD CONSTRAINT "film_actor_fk0" FOREIGN KEY ("actor_id") REFERENCES "actor"("id");
    ALTER TABLE "film_actor" ADD CONSTRAINT "film_actor_fk1" FOREIGN KEY ("film_id") REFERENCES "film"("id");






















