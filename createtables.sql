CREATE SCHEMA IF NOT EXISTS `test` ;

USE test;

CREATE TABLE Address (
    addressId int NOT NULL AUTO_INCREMENT,
    postcode varchar(255),
    PRIMARY KEY (addressId)
);

CREATE TABLE Person(
    personId int NOT NULL AUTO_INCREMENT,
    addressId int,
    name varchar(255),
    PRIMARY KEY (personId),
    FOREIGN KEY (addressId) REFERENCES Address(addressId)
);

INSERT INTO Address (postcode) values ('EC8U 3CC');

INSERT INTO Person (addressid,name) values ((select addressid from address),'vikrant');
