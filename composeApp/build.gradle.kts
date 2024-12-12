import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.buildKonfig.plugin)
    alias(libs.plugins.baselineprofile)
}

val appVersionName = "1.0.0"
val appVersionCode = 1

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            api(projects.core.data)
            api(projects.core.domain)
            api(projects.core.local)
            api(projects.core.ui)
            api(projects.core.util)

            api(projects.features.splash)
            api(projects.features.auth)
            api(projects.features.home)
            api(projects.features.profile)
            api(projects.features.subject)
        }
    }
}

val prop = gradleLocalProperties(rootDir, providers)

android {
    namespace = "com.volsu.unijournal"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.volsu.unijournal"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            keyAlias = prop.getProperty("keystore.release.alias")
            keyPassword = prop.getProperty("keystore.release.password")
            storeFile = file(prop.getProperty("keystore.release.file"))
            storePassword = prop.getProperty("keystore.release.store.password")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    applicationVariants.all variant@{
        this.outputs
            .map { it as com.android.build.gradle.internal.api.ApkVariantOutputImpl }
            .forEach { output ->
                output.outputFileName = "(${this@variant.buildType.name})$appVersionName.apk"
            }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
dependencies {
    implementation(libs.androidx.profileinstaller)
    "baselineProfile"(project(":baseline"))
}

buildkonfig {
    packageName = "com.volsu.unijournal.konfig"

    defaultConfigs {
        buildConfigField(FieldSpec.Type.STRING, "appVersionName", appVersionName)
        buildConfigField(FieldSpec.Type.INT, "appVersionCode", appVersionCode.toString())
    }
}

