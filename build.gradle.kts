plugins {
    kotlin("jvm") version "2.2.21"
    application
}

group = "com.group7"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    /* Stuff for the ELK layout algorithm */
    implementation("org.eclipse.xtext:org.eclipse.xtext.xbase.lib:2.35.0")
    implementation("org.eclipse.elk:org.eclipse.elk.core:0.11.0")
    implementation("org.eclipse.elk:org.eclipse.elk.graph:0.11.0")
    implementation("org.eclipse.elk:org.eclipse.elk.alg.layered:0.11.0")
    implementation("org.eclipse.elk:org.eclipse.elk.alg.mrtree:0.11.0")
    implementation("org.eclipse.elk:org.eclipse.elk.alg.force:0.11.0")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "MainKt"
}

tasks.test {
    useJUnitPlatform()
}