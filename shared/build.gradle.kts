import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.vanniktech.mavenPublish)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_17
        }
    }

//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//            isStatic = true
//        }
//    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.materialIconsExtended)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.skyd.settings"
    compileSdk = 36
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates("io.github.skyd666", "settings", "1.0-beta05")

    pom {
        name.set("Settings")
        description.set("A Compose Multiplatform Settings UI Component.")
        inceptionYear.set("2025")
        url.set("https://github.com/SkyD666/Settings")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("SkyD666")
                name.set("SkyD666")
                url.set("https://github.com/SkyD666")
            }
        }
        scm {
            url.set("https://github.com/SkyD666/Settings")
            connection.set("scm:git:git://github.com/SkyD666/Settings.git")
            developerConnection.set("scm:git:ssh://git@github.com/SkyD666/Settings.git")
        }
    }
}
