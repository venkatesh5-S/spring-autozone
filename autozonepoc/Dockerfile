# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the local code to the container
COPY . /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the Spring Boot application (skip tests if needed)
RUN mvn clean package -DskipTests

# Create the final image with a smaller base image for production
FROM openjdk:17-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /app/target/springbackend.jar /app/springbackend.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/springbackend.jar"]

