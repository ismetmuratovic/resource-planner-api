\set ON_ERROR_STOP on

\c postgres

DROP DATABASE IF EXISTS resource_planner;
DROP ROLE IF EXISTS resource_planner_api;

\ir 'db.sql'
\ir 'insert_data.sql'
