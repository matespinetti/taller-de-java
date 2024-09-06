# Stage 1: Build the Maven project
FROM jelastic/maven:3.9.4-openjdk-22.ea-b17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code into the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn install

# Stage 2: Create the final image with Tomcat
FROM tomcat

# Remove the default web apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file from the previous stage
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
