FROM openjdk:17
EXPOSE 8080
ADD target/backend-0.0.1.jar appdubleu-backend.jar
ADD .env .env
ENTRYPOINT ["java", "-jar", "appdubleu-backend.jar"]
