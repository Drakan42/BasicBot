# BasicBot
A Robot controller program to move and in a 2d gridded plain.

I used Spring boot to create a simple Rest Api.
Spring boot was used as it is a lightweight easy to use Java Rest Framework that has a lot of features and I believe that it was the best technology for the job.
I specifically chose spring for the fact that it has an option to create shell commands to interact with the Rest API.

**Dependency:**
Maven

## Run
### Native
Clone the project
In the root directory of the project run

`mvn spring-boot:run` This will start-up the application and running on port 8080

Once the app is running you can interact with it via you favorite HTTP request client
OR by the spring shell

### Docker
I have also supplied and Dockerfile to create a Docker image of the packaged code
To do so run :
```
mvn package
docker build -t basicbot .
docker run -it -p 8080:8080 basicbot
```

## Usage 
### Shell 

The shell commands to interact with the application are:

| Command    | Description                          | Default | Examples          |
|------------|--------------------------------------|---------|-------------------|
| `setBoard` | sets the board size                  | 5,5     | setBoard 8,8      | 
| `setBot`   | sets the starting position of the bot| N,1,1   | setBot S,6,6      |
| `command`  | Runs the movment instructions        |         | command FRLFLFRF  |

### Rest Examples
POST http://localhost:8080/setBoard
Content-Type: application/json 
{"lat": 4,"lng": 4 }

POST http://localhost:8080/setBot
Content-Type: application/json
{"Direction": "N","lng": 1,"lat": 1 }

GET http://localhost:8080/command? command=FFF