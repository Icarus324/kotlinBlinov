plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "ru.netology"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("task2.Task2Kt")
}

tasks.test {
    useJUnitPlatform()
}
