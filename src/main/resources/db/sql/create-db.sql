--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  bdate  DATE
);

CREATE TABLE auditoriums (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  countseats  INTEGER
);

CREATE TABLE events (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(100),
  dateevent  DATETIME,
  idauditorium INTEGER
);

CREATE TABLE vipseats (
  id         INTEGER PRIMARY KEY,
  idauditorium INTEGER
);

CREATE TABLE tickets (
    id INTEGER PRIMARY KEY,
    name VARCHAR(30),
    seat INTEGER,
    price FLOAT,
    idevent INTEGER,
    iduser INTEGER
);  

ALTER TABLE vipseats 
    ADD CONSTRAINT auditoriums_vipseats
    FOREIGN KEY(idauditorium)
    REFERENCES auditoriums(id);

ALTER TABLE events 
    ADD CONSTRAINT auditoriums_events
    FOREIGN KEY(idauditorium)
    REFERENCES auditoriums(id);

ALTER TABLE tickets 
    ADD CONSTRAINT events_tickets
    FOREIGN KEY(idevent)
    REFERENCES events(id);

ALTER TABLE tickets 
    ADD CONSTRAINT users_tickets
    FOREIGN KEY(iduser)
    REFERENCES users(id);

