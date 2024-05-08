plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.userapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.userapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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

    buildFeatures{
        viewBinding = true
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

    //livedata
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    //viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.0")
    //fragment
    implementation("androidx.fragment:fragment-ktx:1.7.0")

    //Gson
    implementation("com.google.code.gson:gson:2.10.0")
    //Retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")
    //okhttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //Material Design
    implementation("com.google.android.material:material:1.12.0")

//    //Koin
//    implementation("io.insert-koin:koin-android:3.1.2")
//    implementation("io.insert-koin:koin-androidx-viewmodel:3.1.2")

    val koin_version = "3.5.0"
    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("io.insert-koin:koin-core:$koin_version")
    testImplementation("io.insert-koin:koin-androidx-viewmodel:$koin_version")
    testImplementation("io.insert-koin:koin-androidx-scope:$koin_version")
    implementation("io.insert-koin:koin-android:$koin_version")

}