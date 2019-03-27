FROM openjdk:11-jre

RUN mkdir /app
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]