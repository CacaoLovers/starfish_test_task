FROM gradle:7.6-jdk17-alpine AS build
COPY --chown=gradle:gradle docker /home/gradle/src
WORKDIR /home/gradle/src

FROM openjdk:17
RUN mkdir /app

COPY build/libs/starfish_test_task-0.0.1.jar /app/starfish_test_task.jar
ENTRYPOINT ["java", "-jar", "/app/starfish_test_task.jar"]
