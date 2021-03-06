CREATE TABLE ROLE (
    ID          NUMERIC PRIMARY KEY,
    NAME        VARCHAR(256)  NOT NULL
);

CREATE TABLE USERS (
    ID          NUMERIC PRIMARY KEY,
    SURNAME     VARCHAR(256) NOT NULL,
    NAME        VARCHAR(256) NOT NULL,
    PATRONYMIC  VARCHAR(256),
    EMAIL       VARCHAR(48),
    PHOTO_PATH  VARCHAR(256),
    PHONE       VARCHAR(48),
    LOGIN       VARCHAR(48),
    ROLE_ID     NUMERIC NOT NULL,
    PASSWORD    VARCHAR(256) NOT NULL,
    FOREIGN KEY (ROLE_ID)    REFERENCES ROLE(ID)
);

CREATE TABLE PHOTO (
    ID           NUMERIC PRIMARY KEY,
    IMAGE_PATH   VARCHAR(256),
    DESCRIPTION  TEXT
);

CREATE TABLE MUSIC (
    ID             NUMERIC PRIMARY KEY,
    NAME           VARCHAR(256),
    IMAGE_PATH     VARCHAR(256),
    LINK           VARCHAR(256),
    DESCRIPTION    TEXT
);

CREATE TABLE TEXTS (
    ID          NUMERIC PRIMARY KEY,
    TEXT        TEXT
);

CREATE SEQUENCE USERS_SEQUENCE
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START WITH 400
  INCREMENT BY 1;

CREATE SEQUENCE PHOTO_SEQUENCE
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START WITH 400
  INCREMENT BY 1;

CREATE SEQUENCE MUSIC_SEQUENCE
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START WITH 400
  INCREMENT BY 1;