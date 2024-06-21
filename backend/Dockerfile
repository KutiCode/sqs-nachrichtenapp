# Dockerfile für das Backend

FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
