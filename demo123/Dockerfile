# Stage 1: Build the Maven project
FROM maven:3.9.9-amazoncorretto-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Download dependencies without running the tests
RUN mvn dependency:go-offline -B


# Copy the rest of the application source code
COPY src ./src

# Package the application (skip tests if desired)
RUN mvn clean package -DskipTests

# Stage 2: Deploy to Tomcat
FROM tomcat:11.0.0-jdk21

# Set the environment variable for the location of the WAR file

# Set the working directory inside the container
WORKDIR /usr/local/tomcat/webapps/

# Copy the WAR file from the build stage
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war



# Expose port 8080
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
