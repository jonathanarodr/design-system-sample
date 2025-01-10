Gradle 8.2.1
AGP 8.2.2
Kotlin 1.9.25
Compose Compiler 1.5.15

composeOptions {
    kotlinCompilerExtensionVersion = "1.5.15"
//        enableStrongSkippingMode = true
}

// Material Design 3
api 'androidx.compose.material3:material3:1.3.0'

// Fundation
api 'androidx.compose.foundation:foundation-android:1.7.1'

// Android Studio Preview support
api 'androidx.compose.ui:ui-tooling-preview:1.7.1'
api 'androidx.compose.ui:ui-tooling:1.7.1'

// ui
api 'androidx.compose.ui:ui:1.7.1'
api "androidx.compose.ui:ui-graphics:1.7.1"
api "androidx.compose.ui:ui-tooling-preview:1.7.1"

// Optional - Integration with activities
api 'androidx.activity:activity-compose:1.9.2'
// Optional - Integration with ViewModels
api 'androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5'
// Optional - Integration with LiveData
api 'androidx.compose.runtime:runtime-livedata:1.7.1'

// test compose
testImplementation 'androidx.compose.ui:ui-test-junit4-android:1.7.1'
testImplementation "androidx.compose.ui:ui-test-junit4:1.7.1"
debugImplementation 'androidx.compose.ui:ui-test-manifest:1.7.1'
