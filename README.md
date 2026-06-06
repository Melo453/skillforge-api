# SkillForge API

Backend monolítico para crear y seguir rutas de aprendizaje.

## Stack inicial

- Java 21
- Spring Boot 3
- Maven
- PostgreSQL
- Docker Compose
- Spring Web
- Spring Data JPA
- Spring Security

## Estado actual

Versión `v0.1.0`:

- Proyecto Spring Boot creado
- Endpoint health funcionando
- PostgreSQL levantado con Docker Compose
- Configuración inicial de datasource
- Estructura base de paquetes
- Git Flow configurado

## Cómo levantar la base de datos

```bash
docker compose up -d
Cómo ejecutar la app
./mvnw spring-boot:run

En Windows:

mvnw.cmd spring-boot:run
Health check
GET http://localhost:8080/api/v1/health

Respuesta esperada:

SkillForge API is running