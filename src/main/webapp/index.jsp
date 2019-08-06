<html>
<body>
    <h2>Resource Planner REST API</h2>
    <hr />
    <p><a href="webapi/workers">Workers</a>
    <p>./workers - Get all workers</p>
    <p>./workers/{id} - Get worker by id
    
    <p><a href="webapi/teams">Teams</a>
    <p>./teams - Get all teams</p>
    <p>./teams/{id} - Get team by id</p>
    
    <p><a href="webapi/works">Works</a>
    <p>./works - Get all works</p>
    <p>./works/worker/{id} - Get works by worker id</p>
    <p>./works/project/{id} - Get works by project id</p>
    <p>./works/team/{id}/year/{year} - Get works for specific team and year</p>
    <p>./works - Put work into database (Consumes JSON object)</p>
    
    <p><a href="webapi/availabilities">Availabilities</a>
    <p>./availabilities - Get all availabilities</p>
    <p>./availabilities/team/{id}/year/{year} - Get all availabilities fro specific team and year</p>
    <p>./availabilities - Put availability into database (Consumes JSON object)</p>
</body>
</html>
