# Step 1: Use an official Java runtime as a base image
FROM eclipse-temurin:17-jdk-alpine as build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Maven build artifact (JAR) into the container
# Adjust the source path to the JAR as needed
COPY target/*.jar app.jar

# Step 4: Expose the application port (default Spring Boot is 8080)
EXPOSE 8080

# Step 5: Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
