FROM maven:3.9.11-ibm-semeru-17-noble as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "app.jar" ]