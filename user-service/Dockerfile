FROM openjdk:11

WORKDIR /app

COPY build/libs/user-service-0.0.1-SNAPSHOT.jar user-service.jar

ENTRYPOINT ["java", "-jar", "user-service.jar"]