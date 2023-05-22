FROM openjdk:19-alpine
ENV PORT 8102
EXPOSE 8102
COPY /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]