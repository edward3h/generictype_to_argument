plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")

    testImplementation("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")
    testImplementation("io.micronaut:micronaut-core:4.3.5")
    testImplementation("io.micronaut:micronaut-jackson-databind:4.3.5")


}

tasks.withType<Test>() {
    useJUnitPlatform()
}