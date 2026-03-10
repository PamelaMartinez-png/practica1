# Etapa 1: Compilación (Maven)
FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR /app
# Copiamos el archivo pom y el código fuente
COPY pom.xml .
COPY src ./src
# Compilamos el proyecto y generamos el .jar
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime)
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
# Copiamos el .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]