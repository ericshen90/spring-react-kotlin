import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("war")

    kotlin("jvm") version "1.9.21"
    kotlin("plugin.allopen") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
    kotlin("plugin.jpa") version "1.9.21"
}

group = "com.eric"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    maven { url = uri("https://repo.mail.netease.com/artifactory/repo") }
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("com.h2database:h2")
    implementation("io.github.serpro69:kotlin-faker:1.15.0")
    implementation(kotlin("stdlib"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.register<Copy>("processFrontendResources") {
    // Directory containing the artifacts produced by the frontend project
    val frontendProjectBuildDir = project(":frontend").buildDir
    val frontendBuildDir = file("${frontendProjectBuildDir}")
    // Directory where the frontend artifacts must be copied to be packaged alltogether with the backend by the 'war'
    // plugin.
    val frontendResourcesDir = file("${project.buildDir}/resources/main/static")

    group = "Frontend"
    description = "Process frontend resources"
    dependsOn(":frontend:assembleFrontend")

    from(frontendBuildDir)
    into(frontendResourcesDir)
}

tasks.named<Task>("processResources") {
    dependsOn("processFrontendResources")
}
