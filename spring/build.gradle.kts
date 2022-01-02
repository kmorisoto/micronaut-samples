plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    id("org.jetbrains.kotlin.kapt") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("io.micronaut.application") version "3.0.2"
}

version = "0.1"
group = "com.example"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.spring:micronaut-spring-annotation")
    kapt("io.micronaut.spring:micronaut-spring-boot")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.spring:micronaut-spring-boot")
    kaptTest("io.micronaut.spring:micronaut-spring-annotation")
    kaptTest("io.micronaut.spring:micronaut-spring-boot")
    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")


}


application {
    mainClass.set("com.example.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

allOpen {
    annotation("org.springframework.web.bind.annotation.RestController")
}
