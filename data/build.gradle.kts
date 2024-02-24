plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("app.cash.sqldelight")
}

android {
    namespace = "io.genry.template.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:1.12.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")


    //SqlDelight
    implementation("app.cash.sqldelight:android-driver:2.0.1")
    implementation("app.cash.sqldelight:coroutines-extensions:2.0.1")

    //datastorePrefs
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

sqldelight {
    databases {
        create("TemplateDB") {
            packageName.set("io.genry.template.db")
        }
    }
}

