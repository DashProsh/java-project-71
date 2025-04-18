import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("application")
    id("checkstyle")
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("jacoco")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
     testImplementation(platform("org.junit:junit-bom:5.10.3"))
     testImplementation("org.junit.jupiter:junit-jupiter")
     implementation("org.apache.commons:commons-lang3:3.13.0")
     implementation("info.picocli:picocli:4.7.6")
     annotationProcessor("info.picocli:picocli-codegen:4.7.6")
     implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
     testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
     implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

checkstyle {
    toolVersion = "10.12.4"
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(true)
    }
}
