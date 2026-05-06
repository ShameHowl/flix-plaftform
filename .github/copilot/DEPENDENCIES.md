# POM Dependencies Summary

This file summarizes Maven dependencies by module folder.

## be/

### be/pom.xml (parent)
- org.projectlombok:lombok:${lombok.version} (scope: provided)
- org.springframework.boot:spring-boot-starter-test:${spring-boot.version}
- org.springframework.boot:spring-boot-devtools:${spring-boot.version}

Dependency management (import/BOM):
- org.springframework.boot:spring-boot-dependencies:${spring-boot.version} (type: pom, scope: import)

Managed versions:
- org.mapstruct:mapstruct:${mapstruct.version}
- com.mysql:mysql-connector-j:${mysql-connector-j.version}

### be/app/pom.xml
- org.springframework.boot:spring-boot-starter-web
- com.mysql:mysql-connector-j
- org.springframework.boot:spring-boot-jpa
- com.flix:identity:${project.version}
- com.flix:common:${project.version}
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-flyway
- org.flywaydb:flyway-mysql

### be/common/pom.xml
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation
- com.fasterxml.jackson.core:jackson-annotations
- org.springframework:spring-web

### be/identity/pom.xml
- org.springframework.boot:spring-boot-security-oauth2-resource-server
- org.springframework.boot:spring-boot-security
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation
- org.mapstruct:mapstruct
- com.flix:common:${project.version}
- org.apache.tomcat.embed:tomcat-embed-core
- tools.jackson.core:jackson-databind

