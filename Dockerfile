FROM openjdk:11-jdk-slim as build
WORKDIR /app
COPY target/springboot-finance-0.0.1-SNAPSHOT.jar docker.jar

ENTRYPOINT ["java","-jar","/app/docker.jar"]

