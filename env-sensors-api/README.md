### Environmental Sensors API
This API exposes an endpoint to receive and store measurements sent by Disruptive Studios environmental sensors.

Technical information can be consulted on http://localhost:3128/api/swagger.html.


### Pre requisites
Before running the app, you need to install Docker on the host machine. You may also install OpenJDK 19 with Maven for building it. 

### Installation Instructions
- Create a copy of `.env.example` as `.env` and fill its values.
- Create a copy of `flyway.conf.example` as `.flyway.conf` and fill its values.
- If you installed Maven locally, run `mvn clean verify`.
- If Maven is not installed, run `docker run -it --rm --name my-maven-project -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3.8.6-openjdk-18 mvn clean verify`.
- For skipping tests, run the `verify` command with the `-DskipTests` flag.
- Once finished, run `docker-compose up -d` to spin up all containers.
- The API application will be running inside its container on port 8080.

Note: Nginx will not work until a valid domain is pointing to the server with a valid SSL certificate.
