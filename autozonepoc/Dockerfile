# Stage 1: Build
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Set working directory to /app
WORKDIR /app

# Copy the Maven project files to /app directory (pom.xml and src/)
COPY pom.xml .  # Make sure the pom.xml is copied here
COPY src ./src  # Ensure source code is copied into /app/src

# Download dependencies and build the application
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk

# Set the working directory to /app
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optional: Add health check to monitor container status
# HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1
