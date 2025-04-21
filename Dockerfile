FROM maven:3.8.6-eclipse-temurin-17 AS final

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src

CMD ["mvn", "spring-boot:run"]
