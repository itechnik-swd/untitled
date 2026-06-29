plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

ext {
    set("junitVersion", "5.10.0")
    set("mockitoVersion", "5.7.0")
}

dependencies {
    testImplementation("org.mockito:mockito-core:${property("mockitoVersion")}")
    testImplementation("org.mockito:mockito-junit-jupiter:${property("mockitoVersion")}")
    testImplementation(platform("org.junit:junit-bom:${property("junitVersion")}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}