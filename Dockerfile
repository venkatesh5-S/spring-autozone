# Stage 1: Build
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Download dependencies and build the application
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optional: Add health check to monitor container status
HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1
