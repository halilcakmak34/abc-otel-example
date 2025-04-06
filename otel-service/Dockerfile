# Use an official Java runtime as a parent image
FROM amazoncorretto:21.0.4-alpine3.18

# Set the working directory in the container
WORKDIR /app

ENV SPRING_PROFILES_ACTIVE docker
ENV EUREKA_FULL_URL http://10.10.1.4:8761/eureka/
ENV POSTGRES_URL jdbc:postgresql://10.10.1.4:4900/otel-db

# Copy the JAR file into the container
COPY target/otel-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 4002

# Run the JAR file
ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar", "app.jar"]

