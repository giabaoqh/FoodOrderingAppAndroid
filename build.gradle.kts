plugins {
    id("com.android.application") version "8.10.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.10.0") // Cập nhật phiên bản Gradle Plugin Android
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24") // Cập nhật plugin Kotlin
    }
}
