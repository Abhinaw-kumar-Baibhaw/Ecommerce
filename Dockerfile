FROM openjdk:17-jdk-slim AS base
WORKDIR /app
COPY target/FullFledgedEcommerce-0.0.1-SNAPSHOT.jar /app/FullFledgedEcommerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/FullFledgedEcommerce-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
