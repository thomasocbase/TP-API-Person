FROM openjdk:21-bookworm

LABEL authors="Thomas"

RUN apt-get update && apt-get install -y netcat-openbsd

WORKDIR /app

COPY target/*.jar app.jar
COPY wait-for-db.sh /wait-for-db.sh

RUN chmod +x /wait-for-db.sh

EXPOSE 8080

ENTRYPOINT ["/wait-for-db.sh", "db", "3306", "--", "java", "-jar", "app.jar"]