FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container at /app
COPY target/clustered-data-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
