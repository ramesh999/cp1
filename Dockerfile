FROM eclipse-temurin:21-jre
WORKDIR /app

RUN useradd -m appuser
USER appuser

# Avoid copying *.original jar; copy only the Spring Boot fat jar
COPY /target/cp1-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "/app/app.jar"]

