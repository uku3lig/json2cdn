plugins {
    java
    id("com.gradleup.shadow") version "8.3.5"
}

group = "net.uku3lig"
version = "0.1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.panda-lang.org/releases")
    }
}

dependencies {
    implementation("net.dzikoysk:cdn:1.14.5")
}