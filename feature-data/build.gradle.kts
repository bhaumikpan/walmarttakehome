
plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.feature_data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }
}

val networkDependencies = mapOf(
    "retrofit" to "com.squareup.retrofit2:retrofit:${rootProject.ext.get("retrofitVersion")}",
    "retrofitGsonConverter" to "com.squareup.retrofit2:converter-gson:${rootProject.ext.get("retrofitVersion")}",
    "retrofitRxJavaAdapter" to "com.squareup.retrofit2:adapter-rxjava2:${rootProject.ext.get("retrofitVersion")}",
    "okHttp3" to "com.squareup.okhttp3:okhttp:${rootProject.ext.get("okHttpVersion")}",
    "okHttp3Logging" to "com.squareup.okhttp3:logging-interceptor:${rootProject.ext.get("okHttpVersion")}"
)

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation("javax.inject:javax.inject:1")

    implementation(project(":feature-domain"))
    implementation(project(":network-data"))
    implementation(project(":analytics"))


    // todo this should get from network-data module
    // networking with retrofit
    implementation(networkDependencies["retrofit"]!!)
    implementation(networkDependencies["retrofitGsonConverter"]!!)
    implementation(networkDependencies["retrofitRxJavaAdapter"]!!)
    implementation(networkDependencies["okHttp3"]!!)
    implementation(networkDependencies["okHttp3Logging"]!!)

    // Hilt
    implementation("com.google.dagger:hilt-android:${rootProject.ext.get("hilt_version")}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.ext.get("hilt_version")}")
    testImplementation ("com.google.dagger:hilt-android-testing:${rootProject.ext.get("hilt_version")}")
    kaptTest ("com.google.dagger:hilt-compiler:${rootProject.ext.get("hilt_version")}")


    // test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.2.1")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")


    // mocking framework
    testImplementation("io.mockk:mockk:1.12.0")

}

apply(plugin = "dagger.hilt.android.plugin")