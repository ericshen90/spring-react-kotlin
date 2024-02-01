# Getting Started

A CRUD program that uses React + Node + Yarn for the frontend, Kotlin + Spring Boot for the backend, and Gradle for the build tool.

### Reference Documentation

- [backend][backend-readme]
- [frontend][frontend-readme]

### Requirements

- A [Gradle Wrapper][gradle-wrapper] configured in this directory.

### Description

The frontend sub-project builds an `index.html` file in its `build` directory. A custom task named
`processFrontendResources`, and defined in the backend sub-project copies the previous file in the
`build/resources/main/public` directory of the backend sub-project. The `processResources` task of the backend
sub-project depends on this `processFrontendResources` task, to ensure frontend artifacts are included when building
the WAR artifact: the `bootWar` task in the backend project automatically packages files in the
`${project.buildDir}/resources/static` directory into the WAR artifact so as they are publicly accessible.

Finally:

- Enter `gradlew bootRun` on a command line.
- Open a browser, connect to URL `http://localhost:8080`, and see the following page.

[backend-readme]: <backend/README.md> (Backend README)
[frontend-readme]: <frontend/README.md> (Frontend README)

[gradle-wrapper]: <https://docs.gradle.org/current/userguide/gradle_wrapper.html> (Gradle Wrapper)
[spring-boot]: <https://spring.io/projects/spring-boot> (Spring Boot)

### Reference

- [CRUD Application With React and Spring Boot](https://www.baeldung.com/spring-boot-react-crud)
- [frontend-gradle-plugin](https://siouan.github.io/frontend-gradle-plugin/getting-started)
