--Get all worker names from some team

SELECT worker.first_name,worker.last_name FROM worker 
INNER JOIN belongs ON worker.id=belongs.worker_id 
INNER JOIN team ON belongs.team_id=team.id WHERE team.name='Team A';

--Get all project that some worker works on

SELECT project.name FROM project 
INNER JOIN works ON project.id=works.project_id 
INNER JOIN worker ON worker.id=works.worker_id WHERE worker.first_name='Ismet';


--Get how many days worker worked on some project in some week

SELECT DATE_PART('day',age(works.date_end,works.date_start)) FROM works
INNER JOIN worker ON worker.id=works.worker_id
INNER JOIN project ON works.project_id=project.id
WHERE worker.first_name='Ismet' AND project.name='ALPHA' AND works.date_end<'2019-07-20';

--Get days avilable in some week for some worker

SELECT availability.available_days FROM availability
INNER JOIN worker ON availability.worker_id=worker.id
WHERE worker.first_name='Ismet' AND availability.week='2019-07-15';
