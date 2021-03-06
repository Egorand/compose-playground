plugins {
  alias(libs.plugins.android)
  alias(libs.plugins.kotlin)
}

android {
  namespace = "dev.egorand.composeplayground"
  compileSdk = 32

  defaultConfig {
    applicationId = "dev.egorand.composeplayground"
    minSdk = 24
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"

    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.get()
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.tooling.preview)
  implementation(libs.accompanist.pager)
  implementation(libs.accompanist.pager.indicators)
  implementation(libs.accompanist.systemuicontroller)
  implementation(libs.coil.compose)
}
