plugins {
    id("org.jetbrains.kotlin.android")
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.network_data"
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


    implementation("androidx.core:core-ktx:1.13.1")

    // networking with retrofit
    implementation(networkDependencies["retrofit"]!!)
    implementation(networkDependencies["retrofitGsonConverter"]!!)
    implementation(networkDependencies["retrofitRxJavaAdapter"]!!)
    implementation(networkDependencies["okHttp3"]!!)
    implementation(networkDependencies["okHttp3Logging"]!!)

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")


}