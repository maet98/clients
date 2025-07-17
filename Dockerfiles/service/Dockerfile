# Stage 1: Build the jar
FROM gradle:8.12-jdk21 AS build
# Copy source code into the container and set the ownership to 'gradle' user
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build -x test --no-daemon

# Stage 2: Production image
FROM openjdk:21-slim AS production
EXPOSE 8080

# Create a non-root user and group (using 'appuser' as an example)
RUN groupadd -r appgroup && useradd -r -g appgroup -m appuser

# Create the /app directory and set permissions
RUN mkdir /app && chown appuser:appgroup /app

# Copy the jar file from the build stage into the production image
COPY --from=build /home/gradle/src/build/libs/*.jar /app/clients-*.jar

# Change to non-root user
USER appuser

# Set the entrypoint to run the Java application
ENTRYPOINT ["java", "-jar", "/app/clients-*.jar"]
