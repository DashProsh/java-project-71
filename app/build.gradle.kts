plugins {
    id("application")
    id("checkstyle")
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6") // Для генерации кода
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
}

application {
    mainClass.set("hexlet.code.App")
}

checkstyle {
    toolVersion = "10.12.3"
    configFile = file("${rootProject.projectDir}/config/checkstyle/checkstyle.xml")
}
