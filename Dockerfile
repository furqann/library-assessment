FROM eclipse-temurin:21-alpine

WORKDIR /opt

COPY target/library-assessment-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]