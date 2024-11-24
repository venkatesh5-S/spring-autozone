# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory in the container
WORKDIR /app

# Copy the JAR file from the Maven build stage to the container
COPY target/*.jar app.jar

EXPOSE 8080


# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
