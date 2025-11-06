plugins {
    java
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Selenium + WebDriverManager
    testImplementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")

    // Cucumber (one consistent version)
    testImplementation("io.cucumber:cucumber-java:7.20.1")
    testImplementation("io.cucumber:cucumber-junit:7.20.1")
    testImplementation("io.cucumber:cucumber-spring:7.20.1") // ✅ this is critical

    // JUnit 4
    testImplementation("junit:junit:4.13.2")

    // Spring (optional)
    implementation("org.springframework:spring-context:6.1.3")
    testImplementation("org.springframework:spring-test:6.1.3")

    testImplementation("io.rest-assured:rest-assured:5.4.0")

    // JSON handling (useful for parsing or logging responses)
    testImplementation("org.json:json:20240303")

    // For assertions
    testImplementation("org.hamcrest:hamcrest:2.2")

    // Optional: JSONPath and schema validation
    testImplementation("io.rest-assured:json-path:5.4.0")
    testImplementation("io.rest-assured:json-schema-validator:5.4.0")

}

tasks.test {
    // Use JUnit 4 so Cucumber JUnit runner is picked up
    useJUnit()
}
