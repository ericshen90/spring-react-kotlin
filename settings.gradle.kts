pluginManagement {
    plugins {
        id("war")
        id("org.siouan.frontend-jdk17") version "8.0.0"
    }
}

include("backend", "frontend")

rootProject.name = "spring-react-kotlin"
