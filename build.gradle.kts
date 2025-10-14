plugins {
    `java-library`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    // Paper API snapshots & artifacts
    maven("https://repo.papermc.io/repository/maven-public/")
}

// PaperMc version from plugin-path/META-INF/MAINFEST.MF
dependencies {
    // Your plugin compiles against the Paper API only (provided by the server at runtime)
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")

    // --- Testing ---
    testImplementation(platform("org.junit:junit-bom:5.11.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Engine + launcher at runtime (needed especially when running via IDE/Gradle Test Executor)
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly ("org.junit.platform:junit-platform-launcher")

    // MockBukkit for unit tests (targeting Paper/Bukkit 1.21)
    testImplementation("org.mockbukkit.mockbukkit:mockbukkit-v1.21:4.83.0")

    // Paper API also on test classpath so tests see the API types
    testImplementation("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}
