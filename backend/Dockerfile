# Verwende ein Basis-Image mit Java
FROM openjdk:17-jdk-slim

# Setze das Arbeitsverzeichnis
WORKDIR /app

# Kopiere das Maven Build-File und installiere Abhängigkeiten
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# Installiere Maven Wrapper und gehe offline
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Kopiere den restlichen Code
COPY src ./src

# Baue das Projekt
RUN ./mvnw package -DskipTests

# Setze das Arbeitsverzeichnis für die JAR-Ausführung
WORKDIR /app/target

# Exponiere den Port
EXPOSE 8080

# Startpunkt des Containers
CMD ["java", "-jar", "nachrichtenapp-0.0.1-SNAPSHOT.jar"]
