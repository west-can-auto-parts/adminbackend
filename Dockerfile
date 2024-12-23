# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /usr/src/myapp

# Copy the current directory contents into the container at /usr/src/myapp
COPY . .

# Compile the Java application
RUN ./mvnw package

# Expose port 8081
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "target/admin-0.0.1-SNAPSHOT.jar"]
