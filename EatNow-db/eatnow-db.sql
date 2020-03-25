/*
 Alejandro Cerrato Espejo
 EatNow-db
 Version 1.1
 */
-- Creating and using eatnow database --
CREATE DATABASE EATNOW;

USE DATABASE EATNOW;

-- Creating users for server usage -- 
CREATE USER 'eatnow-server' @'%' IDENTIFIED BY 'EatNowBest';

GRANT INSERT, UPDATE, DELETE, SELECT ON EATNOW.* TO 'eatnow-server' @'%';

-- Creating users for maintenance usage --
CREATE USER 'eatnow-maintenance' @'%' IDENTIFIED BY 'EatNowSoftware';

GRANT all privileges ON EATNOW.* TO 'eatnow-maintenance' @'%';

-- Updating privileges -- 
FLUSH PRIVILEGES;

-- Creating tables for use -- 
CREATE TABLE COMPANIES (
    ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(20),
    EMAIL VARCHAR(60),
    PASSWORD VARCHAR(64),
    PASSWORD_SALT VARCHAR(16)
);

CREATE TABLE SHOPS (
    ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(20),
    COMPANY_ID INT,
    COUNTRY VARCHAR(20),
    PROVINCE VARCHAR(20),
    CITY VARCHAR(20),
    ADDRESS VARCHAR(40),
    ZIPCODE INT(6),
    CONSTRAINT FOREIGN KEY (COMPANY_ID) REFERENCES COMPANIES(ID)
);

CREATE TABLE CLIENTS (
    ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(20),
    EMAIL VARCHAR(60),
    PASSWORD VARCHAR(64),
    PASSWORD_SALT VARCHAR(16)
);

CREATE TABLE CATEGORIES (
    ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(25) unique,
    DESCRIPCTION VARCHAR(200),
    CONSTRAINT FOREIGN KEY (SHOP_ID) REFERENCES SHOPS(ID)
);

CREATE TABLE PRODUCTS (
    ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(20),
    PRICE FLOAT(7, 2),
    DESCRIPTION VARCHAR(200),
    CATEGORY INT,
    CONSTRAINT FOREIGN KEY (CATEGORY) REFERENCES CATEGORIES(ID)
);

CREATE TABLE ORDER_STATUS(
    ID SMALLINT PRIMARY KEY,
    NAME VARCHAR(20)
);

CREATE TABLE CLIENT_ORDER (
    ID INT PRIMARY KEY auto_increment,
    CLIENT_ID INT,
    SHOP_ID INT,
    STATUS SMALLINT,
    CONSTRAINT FOREIGN KEY (SHOP_ID) REFERENCES SHOPS(ID),
    CONSTRAINT FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(ID),
    CONSTRAINT FOREIGN KEY (STATUS) REFERENCES ORDER_STATUS(ID)
);

CREATE TABLE ORDER_PRODUCTS (
    ORDER_ID INT,
    PRODUCT_ID INT,
    AMOUNT SMALLINT,
    PRODUCT_PRICE FLOAT(7, 2),
    CONSTRAINT FOREIGN KEY (ORDER_ID) REFERENCES SHOP_ORDER(ID),
    CONSTRAINT FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID)
);

-- Creating logs tables -- 
CREATE TABLE CLIENT_LOGS (
    ID INT PRIMARY KEY auto_increment,
    CLIENT_ID INT,
    RECORD_DATE DATE,
    TYPE VARCHAR(20),
    CLIENT_IP VARCHAR(15),
    CONSTRAINT FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(ID)
);

CREATE TABLE COMPANY_LOGS (
    ID INT PRIMARY KEY auto_increment,
    COMPANY_ID INT,
    RECORD_DATE DATE,
    TYPE VARCHAR(20),
    COMPANY_IP VARCHAR(15),
    CONSTRAINT FOREIGN KEY (COMPANY_ID) REFERENCES COMPANIES(ID)
);

-- Creating tokens tables --
CREATE TABLE CLIENT_TOKENS (
    CLIENT_ID INT,
    CLIENT_IP VARCHAR(15),
    EXPEDITION_DATE DATE,
    EXPIRATION_DATE DATE,
    PRIMARY KEY (CLIENT_ID, CLIENT_IP),
    CONSTRAINT FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(ID)
);

CREATE TABLE COMPANY_TOKENS (
    COMPANY_ID INT,
    COMPANY_IP VARCHAR(15),
    EXPEDITION_DATE DATE,
    EXPIRATION_DATE DATE,
    PRIMARY KEY (COMPANY_ID, COMPANY_IP),
    CONSTRAINT FOREIGN KEY (COMPANY_ID) REFERENCES COMPANIES(ID)
);