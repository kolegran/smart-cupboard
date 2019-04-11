FROM openjdk:11-jre

RUN mkdir /app
COPY build/libs/smart-cupboard-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "/app/smart-cupboard-0.0.1-SNAPSHOT.jar"]