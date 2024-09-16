plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
	id("com.google.devtools.ksp")
	id("dagger.hilt.android.plugin")
	id("androidx.navigation.safeargs.kotlin")
}

android {
	namespace = "com.fran.users"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.fran.users"
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

	viewBinding {
		enable = true
	}
}

dependencies {
	// Kotlin
	implementation("androidx.activity:activity-ktx:1.9.1")
	implementation("androidx.appcompat:appcompat:1.7.0")
	implementation("androidx.constraintlayout:constraintlayout:2.1.4")
	implementation("androidx.core:core-ktx:1.13.1")
	implementation("androidx.fragment:fragment-ktx:1.8.2")

	// Coroutines
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

	// Dagger
	implementation("com.google.dagger:hilt-android:2.51.1")
	implementation("androidx.recyclerview:recyclerview:1.3.2")
	ksp("com.google.dagger:hilt-android-compiler:2.51.1")

	// Glide
	implementation("com.github.bumptech.glide:glide:4.16.0")

	// Live Data
	implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")

	// Material
	implementation("com.google.android.material:material:1.12.0")

	//Navigation
	implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
	implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

	// Retrofit
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")

	// Unit Test
	testImplementation("junit:junit:4.13.2")
	testImplementation("com.google.dagger:hilt-android-testing:2.51.1")

	// Android Test
	androidTestImplementation("androidx.test.ext:junit:1.2.1")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
	androidTestImplementation("androidx.navigation:navigation-testing:2.7.7")
	androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")

	// KSP Test
	kspTest("com.google.dagger:hilt-compiler:2.51.1")
	kspAndroidTest("com.google.dagger:hilt-compiler:2.51.1")

}