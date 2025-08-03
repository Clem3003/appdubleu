FROM openjdk:17-alpine
EXPOSE 8080
ADD backend/target/backend-0.0.1.jar appdubleu-backend.jar
ENTRYPOINT ["java", "-jar", "appdubleu-backend.jar"]