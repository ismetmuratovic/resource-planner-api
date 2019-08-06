--Insert workers

INSERT INTO worker(first_name,last_name) VALUES('Ismet','Muratović');
INSERT INTO worker(first_name,last_name) VALUES('Mirza','Halilčević');
INSERT INTO worker(first_name,last_name) VALUES('Sead','Delić');
INSERT INTO worker(first_name,last_name) VALUES('Suad','Halilović');
INSERT INTO worker(first_name,last_name) VALUES('Jasmin','Hadžić');

--Insert teams

INSERT INTO team(name) VALUES('Team FET');
INSERT INTO team(name) VALUES('Team A');
INSERT INTO team(name) VALUES('Team B');

--Insert relations belongs

INSERT INTO belongs(worker_id,team_id) VALUES (1,1);
INSERT INTO belongs(worker_id,team_id) VALUES (2,1);
INSERT INTO belongs(worker_id,team_id) VALUES (3,1);
INSERT INTO belongs(worker_id,team_id) VALUES (4,1);
INSERT INTO belongs(worker_id,team_id) VALUES (5,1);
INSERT INTO belongs(worker_id,team_id) VALUES (1,2);

--Insert projects

INSERT INTO project(name) VALUES ('ALPHA');
INSERT INTO project(name) VALUES ('ZETA');
INSERT INTO project(name) VALUES ('GAMA');

--Isert relations works

INSERT INTO works(worker_id,project_id,date_start,date_end) VALUES(1,1,'2019-07-15','2019-07-17');
INSERT INTO works(worker_id,project_id,date_start,date_end) VALUES(2,1,'2019-07-15','2019-07-18');
INSERT INTO works(worker_id,project_id,date_start,date_end) VALUES(3,1,'2019-07-22','2019-07-25');

INSERT INTO works(worker_id,project_id,date_start) VALUES(4,1,'2019-07-22');
INSERT INTO works(worker_id,project_id,date_start) VALUES(1,2,'2019-07-22');
INSERT INTO works(worker_id,project_id,date_start) VALUES(2,2,'2019-07-22');

--Insert aavailability

INSERT INTO availability(worker_id,week,available_days) VALUES (1,'2019-07-15',5);
INSERT INTO availability(worker_id,week,available_days) VALUES (1,'2019-07-22',5);
INSERT INTO availability(worker_id,week,available_days) VALUES (2,'2019-07-15',3);
INSERT INTO availability(worker_id,week,available_days) VALUES (3,'2019-07-15',4);
