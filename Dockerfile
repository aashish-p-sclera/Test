FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/demo1-0.0.1-SNAPSHOT.jar /app/demo1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/demo1.jar"]