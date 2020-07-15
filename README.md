# Springboot Live Reload Example

1. Basically add this configuration in the `docker-compose.yml`
```
version: '3'
services:
  live-reload:
    image: openjdk:8-jdk-alpine
    ports:
      - "8080:8080"
      - "8000:8000"
    volumes:
      - .:/app
      - ~/.m2:/root/.m2
    working_dir: /app
    command: './mvnw spring-boot:run'
```
2. Configuration at `pom.xml`

Add these plugins:
```
<plugins>
  <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
      <excludeDevtools>false</excludeDevtools>
    </configuration>
  </plugin>
  <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
  </plugin>
</plugins>
```

Add this dependency:
```
<!-- LiveReload -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <optional>true</optional>
</dependency>
```

3. To make it faster to reload, configure `application.properties`:
```
spring.devtools.restart.poll-interval=2s
spring.devtools.restart.quiet-period=1s
```

## Additional
In order to test how `lombok` lib works, I have also added the simplest test ever to it. 
- [documentation](https://www.baeldung.com/lombok-ide)


Helpful references:
- https://github.com/mstickel/docker-spring-boot-quickdev
- https://mariobuonomo.dev/blog/spring-boot-live-reload-docker
- https://github.com/ntsim/hot-spring-docker
