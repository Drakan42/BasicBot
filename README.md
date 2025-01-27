# BasicBot
A Robot controller program to move and in a 2d gridded plain.

I used Spring boot to create a simple Rest Api.
Spring boot was used as it is a lightweight easy to use Java Rest Framework that has a lot of features and I believe that it was the best technology for the job.
I specifically chose spring for the fact that it has an option to create shell commands to interact with the Rest API.

**Dependency:**
Maven

**Run**
Clone the project
In the root directory of the project run

`mvn spring-boot:run`

This will start-up the application and running on port 8080

**Docker**
I have also supplied and Dockerfile to create a Docker image of the packaged code
To do so run :
`mvn package`
`docker build -t basicbot .`
`docker run -it -p 8080:8080 basicbot`

