# AGENTS

## Project overview
- Repo layout: backend in `be/`, frontend in `fe/`, infra in `infra/`, DB in `docker-compose.yml`.
- Backend is a Maven multi-module build (`be/pom.xml`) with modules: `app`, `identity`, `common`.
- Spring Boot entry point is `be/app/src/main/java/com/flix/app/FlixPlaftformApplication.java` (scans `com.flix` for entities/repos).

## Backend structure and conventions
- Shared JPA/validation/web utilities live in `be/common` (`be/common/pom.xml`).
- Identity/security lives in `be/identity` and is pulled into the app module (`be/identity/pom.xml`).
- The `app` module depends on both `common` and `identity` (`be/app/pom.xml`).
- Configuration is split: `application.yml` imports `identity.yml` and `common.yml` via `spring.config.import`.
- Local DB settings are in `be/app/src/main/resources/application-local.yml` (MySQL + JPA validate).

## Data and migrations
- MySQL is provisioned by `docker-compose.yml` (db name `flix-db`, root password `rootpassword`).
- Flyway is enabled in `be/app/src/main/resources/application.yml` with migrations in `be/app/src/main/resources/db/migration`.

## Frontend structure and workflows
- Frontend is Vue 3 + Vite + TypeScript; scripts are in `fe/package.json` (`dev`, `build`, `preview`).
- Entry point is `fe/src/main.ts`, root component `fe/src/App.vue`.

## Integration points
- JWT settings live in `be/identity/src/main/resources/identity.yml` (secret + expiration).
- Backend expects MySQL and Flyway; keep migrations in sync with JPA `ddl-auto: validate`.

## Build/test notes
- Java is set to 25 and Spring Boot 4.0.6 in `be/pom.xml`; Lombok + MapStruct processors are configured there.
- Run Maven goals from `be/` to build all modules; run Vite scripts from `fe/`.

