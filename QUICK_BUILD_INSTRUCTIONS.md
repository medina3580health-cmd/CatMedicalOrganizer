// Build release APK using:
// ./gradlew assembleRelease
//
// Output location:
// app/build/outputs/apk/release/app-release.apk
//
// Then download and install on your phone!

android {
    // ... existing config ...
    
    signingConfigs {
        release {
            storeFile file("release-key.jks")
            storePassword "password"
            keyAlias "cat-organizer"
            keyPassword "password"
        }
    }

    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
