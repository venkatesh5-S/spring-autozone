# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file from the Maven build
COPY target/*.jar app.jar


# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
