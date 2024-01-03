#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:1.8-jdk-slim
COPY --from=build /target/Advertise-0.0.1-SNAPSHOT.jar Advertise.jar
# ENV PORT=8080
EXPOSE 8081
ENTRYPOINT ["java","-jar","Advertise.jar"]
