FROM openjdk:19-alpine
EXPOSE 8102
COPY /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]