# Build Stage
FROM maven:3.9.9-eclipse-temurin-17-focal AS build
WORKDIR /app

# Copy Maven wrapper files first
COPY .mvn/ .mvn/
COPY mvnw mvnw.cmd ./

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Run Stage
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/student-survey-0.0.1-SNAPSHOT.jar app.jar

# Add wait-for-it script to handle database connection delays
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

EXPOSE 8080
ENTRYPOINT ["./wait-for-it.sh", "surveydb.cgo2ah0kc7n2.us-east-1.rds.amazonaws.com:3306", "--", "java", "-jar", "app.jar"]
