import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
    jacoco
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":module-core"))
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.3.3")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    implementation("org.jetbrains.kotlinx", "kotlinx-io-jvm", "0.1.5")
    implementation("org.apache.commons", "commons-pool2", "2.8.0")
    implementation("com.ufoscout.properlty", "properlty-kotlin", "1.9.0")
}

tasks {
    withType<Test> {
        testLogging.showExceptions = true
        testLogging.exceptionFormat = TestExceptionFormat.FULL
        testLogging.showStandardStreams = true
        testLogging.showCauses = true
        testLogging.showStackTraces = true
        testLogging.events = setOf(
            TestLogEvent.STARTED,
            TestLogEvent.FAILED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.STANDARD_ERROR
        )
        outputs.upToDateWhen {false}
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
