FROM openjdk:17
LABEL description="Book Management System API server"

ENV APP_HOME="/usr/app/"

WORKDIR $APP_HOME
COPY build/libs/*.jar app.jar

EXPOSE 80

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -Dspring.profiles.active=prod -jar app.jar"]
