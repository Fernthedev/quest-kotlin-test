plugins {
    kotlin("multiplatform") version "1.6.20"
}

group = "com.github.fernthedev"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    androidNativeArm64().apply {
        binaries {
            sharedLib {
//                optimized = true
            }
        }
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
        val androidNativeArm64Main by getting
        val androidNativeArm64Test by getting
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
