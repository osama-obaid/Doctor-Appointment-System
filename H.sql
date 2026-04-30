

CREATE DATABASE H;

USE H;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(256) NOT NULL,
    ROLE VARCHAR(10) 
);

INSERT INTO users (username, password,ROLE) VALUES ('osama',SHA2("123456",256), 'Admin'),('osamaa',SHA2("123456",256), 'User');

create table booking( id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(50) NOT NULL ,
  phone VARCHAR(25) NOT NULL,
  email VARCHAR(50) NOT NULL,
   age int NOT NULL,
    date VARCHAR(50) ,
     time VARCHAR(50) ,
      status VARCHAR(50) NOT NULL,
       description VARCHAR(255) ,
       doctorname varchar(50)  
   );
    
    CREATE TABLE Doctor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    specialty VARCHAR(255)
);

CREATE TABLE Patient (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Appointment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    status VARCHAR(255) NOT NULL,
    doctor_id BIGINT,
    patient_id BIGINT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);