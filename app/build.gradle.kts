plugins {
    id("application")
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
}

application {
    mainClass.set("hexlet.code.App")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

configure<CheckstyleExtension> {
    toolVersion = "10.12.3"
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
}
