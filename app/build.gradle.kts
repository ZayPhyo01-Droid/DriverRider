plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.sci.buildtype"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sci.buildtype"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false

        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    flavorDimensions.apply {
        add(0, "taxi")
    }
    productFlavors {

        create("driver") {
            //url
            dimension = "taxi"
            resValue(type = "string", name = "appType", value = "driver")
            applicationIdSuffix = ".driver"
            resValue(type = "string", name = "appName", "Driver")
            manifestPlaceholders["appRoundIcon"] = "@drawable/driver"
            buildConfigField("Boolean", "showDriverProfile", "false")
        }

        create("rider") {
            //url
            dimension = "taxi"
            resValue(type = "string", name = "appType", value = "rider")
            applicationIdSuffix = ".rider"
            resValue(type = "string", name = "appName", "Rider")
            manifestPlaceholders["appRoundIcon"] = "@drawable/rider"
            buildConfigField("Boolean", "showDriverProfile", "true")

        }

        buildFeatures {
            buildConfig = true
        }


    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}