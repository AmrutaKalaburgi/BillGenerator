

# Stage 1: Build with Java 24 + Maven manually installed
FROM openjdk:24-jdk-slim AS build
WORKDIR /app
RUN apt-get update && apt-get install -y maven
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:24-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
#FROM openjdk:24-jdk-slim
#
## 2️⃣ Set working directory inside the container
#WORKDIR /app
#
## 3️⃣ Copy the JAR file into the container
#COPY target/BillGenerator-0.0.1-SNAPSHOT.jar /app/BillGenerator-0.0.1-SNAPSHOT.jar
#
## 4️⃣ Expose port 8080
#EXPOSE 8080
#
## 5️⃣ Command to run the JAR
#ENTRYPOINT ["java", "-jar", "BillGenerator-0.0.1-SNAPSHOT.jar"]