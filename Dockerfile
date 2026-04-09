FROM maven:3.9-eclipse-temurin-21-alpine
# Usa una imagen base que ya incluye Maven

LABEL authors="yuliette"

WORKDIR /app
# Define el directorio de trabajo dentro del contenedor como /app

COPY pom.xml .
# Copia el archivo pom.xml desde tu máquina al contenedor (ruta actual)

COPY src ./src
# Copia el codigo fuente (carpeta src) al contenedor dentro de /app

RUN mvn clean package -DskipTests
# clean descarga todas las dependencias que aún no tenga

ENTRYPOINT ["java", "-jar", "target/WalmartApi-0.0.1-SNAPSHOT.jar"]
# Define el comando que se ejecutará al iniciar el contenedor (ejecutado)