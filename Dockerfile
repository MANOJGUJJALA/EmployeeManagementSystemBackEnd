FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar springboot-backend.jar
ENTRYPOINT ["java","-jar","/springboot-backend.jar"]
EXPOSE 8080