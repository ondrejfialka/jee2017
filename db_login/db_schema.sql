create schema login;

CREATE TABLE Users(username VARCHAR(255) PRIMARY KEY, passwd VARCHAR(255))
CREATE TABLE UserRoles(username VARCHAR(255), role VARCHAR(32)) 