FROM openjdk:11

WORKDIR /app

COPY build/libs/user-details-service-0.0.1-SNAPSHOT.jar user-details-service.jar

ENTRYPOINT ["java", "-jar", "user-details-service.jar"]