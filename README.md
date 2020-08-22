# RecyclerViewTutorial
A Basic RecyclerView Tutorial to help anyone get started with android development.

![A small screenshot showcasing how the app looks](https://github.com/kevingermainbusiness/RecyclerViewTutorial/blob/master/app/src/main/res/drawable-v24/Screen_Shot_2020_08_21_at_15_23_56.png)

## Built with

* [Google Material Design](https://github.com/material-components/material-components-android/releases)
* [Maven](https://maven.apache.org/) - Dependency Management

### Quick Start

Add the following to ``` build.gradle```:

```gradle
repositories {
    jcenter()
}

dependencies {
    // Material Design Dependency
    implementation 'com.google.android.material:material:1.2.0'
    
    // RecyclerView dependency
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
}
```

Inside the ``` android{ } ```tag add:
```gradle
android {

    defaultConfig {
        vectorDrawables.useSupportLibrary true
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

