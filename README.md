### Context

Project provides backend and frontend for labseq sequence generate.

### Features

- Labseq sequence generate

### Run project in the local environment

To run the project on your local machine, you need to have some tools installed:

- [Node greater than 18.10](https://nodejs.org/en/download)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.htmll)
- [Angular CLI](https://angular.io/cli)
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/downloads)
- [Maven](https://maven.apache.org/download.cgi)

#### Run the commands below:

1. Clone the project
`$ git clone https://github.com/pierrepgr/test-labseq.git`
2. Navigate to the back-end directory in the project folder
`$ cd test-labseq/labseq-api/` and run `$ mvn clean install` and `$ mvn clean package`
3. Navigate to the front-end directory in the project folder
`$ cd test-labseq/labseq-ui/` and run `$ npm install`
4. To run the tests
    ##### Back-end
    In the backend directory run the command `$ mvn verify`

5. Build projects
In the root folder of the **test-labseq** project run the command `$ docker-compose build`
6. Run projects
In the root folder of the **test-labseq** project run the command `$ docker-compose up`

    #### The application will be available at the link [http://localhost:4200](http://localhost:4200).

<br />

### API Documentation
The API documentation will be available when starting the project and you can access it through the link [http://localhost:8080/api/swagger-ui/index.html](http://localhost:8080/api/swagger-ui/index.html).
<br />


### Available APIs

#### - Labseq Sequence Generate

**Method:** GET
**URL:** http://localhost:8080/api/labseq/100


**Return: (Example)**
**Status:** 200 OK
<pre>
  182376579
</pre>
