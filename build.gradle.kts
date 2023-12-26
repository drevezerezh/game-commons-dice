/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.5/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    alias(libs.plugins.jvm)

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
}

group = "io.drevezerezh.gamecommons"


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation(libs.junit.jupiter.engine)
    testImplementation(libs.assertj)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


publishing {
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
            artifactId="game-commons-dice"
        }
    }
    repositories {
        mavenLocal()
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion="8.5"
}
