CREATE DATABASE resource_planner;

\c resource_planner

CREATE USER resource_planner_api WITH PASSWORD 'testpass1';

GRANT ALL PRIVILEGES ON DATABASE resource_planner TO resource_planner_api;

CREATE TABLE worker (
  id BIGSERIAL NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,

  CONSTRAINT worker_pk PRIMARY KEY (id)
);

CREATE TABLE team (
  id BIGSERIAL NOT NULL,
  name VARCHAR(50) NOT NULL,
  
  CONSTRAINT team_pk PRIMARY KEY(id)
);

CREATE TABLE belongs (
  worker_id BIGINT NOT NULL,
  team_id BIGINT NOT NULL,
  
  CONSTRAINT belongs_pk PRIMARY KEY(worker_id,team_id),
  CONSTRAINT worker_id_fk FOREIGN KEY (worker_id) REFERENCES worker(id) ON DELETE CASCADE,
  CONSTRAINT team_id_fk FOREIGN KEY (team_id) REFERENCES team(id) ON DELETE CASCADE
);

CREATE TABLE project (
  id BIGSERIAL NOT NULL,
  name VARCHAR(100) NOT NULL,

  CONSTRAINT project_pk PRIMARY KEY(id)
);

CREATE TABLE works (
  worker_id BIGINT NOT NULL,
  project_id BIGINT NOT NULL,
  date_start DATE NOT NULL,
  date_end DATE,

  CONSTRAINT works_pk PRIMARY KEY(worker_id,project_id,date_start),
  CONSTRAINT worker_id_fk FOREIGN KEY (worker_id) REFERENCES worker(id) ON DELETE CASCADE,
  CONSTRAINT project_id_fk FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE
);

CREATE TABLE availability (
  worker_id BIGINT NOT NULL,
  week DATE NOT NULL,
  available_days INT,

  CONSTRAINT availability_pk PRIMARY KEY (worker_id,week),
  CONSTRAINT worker_id_fk FOREIGN KEY (worker_id) REFERENCES worker(id) ON DELETE CASCADE
); 

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO resource_planner_api;
