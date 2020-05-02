FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
ADD src/ /app/src/
ADD pom.xml /app/
RUN mvn install -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine
WORKDIR /opt
COPY --from=build /app/target/app.jar /opt/
CMD ["/usr/bin/java", "-jar","app.jar"]