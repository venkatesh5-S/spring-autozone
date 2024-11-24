# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory in the container
WORKDIR /app

# Copy only the necessary files (like pom.xml) before building the JAR
COPY pom.xml ./

# Copy the src folder to the container
COPY src ./src

# Build the JAR file (make sure 'mvn clean package' is done or use a multi-stage build)
RUN mvn clean package -DskipTests

# Copy the JAR file from the target directory to the container
COPY target/*.jar app.jar

# Expose the port the app will run on
EXPOSE 8080

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
