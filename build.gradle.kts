plugins {
    // Support for Kotlin.
    alias(libs.plugins.jvm)
}

group = "myapp"
version = "1.0-SNAPSHOT"
val kotestVersion = "5.8.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertions)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}