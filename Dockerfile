FROM openjdk:11
EXPOSE 8082
ADD target/my-events-ms-file-docker.jar my-events-ms-file-docker.jar
ENTRYPOINT ["java", "-jar", "/my-events-ms-file-docker.jar"]
