
FROM maven:3.9.6-eclipse-temurin-24 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:24-jdk-slim

# 2️⃣ Set working directory inside the container
WORKDIR /app

# 3️⃣ Copy the JAR file into the container
COPY target/*.jar app.jar

# 4️⃣ Expose port 8080
EXPOSE 8080

# 5️⃣ Command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]