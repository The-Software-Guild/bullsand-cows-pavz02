DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel;
USE hotel;

DROP TABLE IF EXISTS roomTypes;
CREATE TABLE roomTypes (
    type VARCHAR(10) PRIMARY KEY,
    minimum INT,
    maximum INT,
    price FLOAT,
    extra FLOAT
);

DROP TABLE IF EXISTS rooms;
CREATE TABLE rooms (
    roomNumber INT PRIMARY KEY,
    type VARCHAR(10),
    FOREIGN KEY (type) REFERENCES roomTypes(type)
);

DROP TABLE IF EXISTS amenities;
CREATE TABLE amenities (
    amenity VARCHAR(50) PRIMARY KEY,
    price FLOAT
);

DROP TABLE IF EXISTS roomAmenities;
CREATE TABLE roomAmenities (
    roomNumber INT,
    amenity VARCHAR(50),
    PRIMARY KEY (roomNumber, amenity),
    FOREIGN KEY (roomNumber) REFERENCES rooms(roomNumber),
    FOREIGN KEY (amenity) REFERENCES amenities(amenity)
);

DROP TABLE IF EXISTS guests;
CREATE TABLE guests (
    name VARCHAR(50) PRIMARY KEY,
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zip INT,
    phone VARCHAR(15)
);

DROP TABLE IF EXISTS reservations;
CREATE TABLE reservations (
    roomNumber INT,
    name VARCHAR(50),
    adults INT,
    children INT,
    startDate DATE,
    endDate DATE,
    total FLOAT,
    PRIMARY KEY (name, roomNumber, startDate, endDate),
    FOREIGN KEY (name) REFERENCES guests(name),
    FOREIGN KEY (roomNumber) REFERENCES rooms(roomNumber)
);

