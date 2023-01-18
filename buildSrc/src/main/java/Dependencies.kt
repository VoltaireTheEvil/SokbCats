object Config {
    const val applicationId = "ru.niisokb.makulin.sokbcats"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    //Design
    const val appcompat = "1.6.0"
    const val material = "1.7.0"

    //Kotlin
    const val core = "1.9.0"
    const val stdlib = "1.8.0"
    const val coroutinesCore = "1.6.4"
    const val coroutinesAndroid = "1.6.4"

    //Dagger2
    const val dagger = "2.44.2"

    //Coil
    const val coil = "2.2.2"

    //Room
    const val roomKtx = "2.5.0"
    const val runtime = "2.5.0"
    const val roomCompiler = "2.5.0"

    //ViewBinding
    const val viewBinding = "1.5.6"

    //Test
    const val jUnit = "4.13.2"
    const val runner = "1.5.2"
    const val espressoCore = "3.5.1"
    const val testExt = "1.1.5"

    //Navigation
    const val navigation = "2.5.3"

    //Fragment
    const val fragmentKtx = "1.5.5"

    //Paging3
    const val paging3 = "3.1.1"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "4.10.0"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.stdlib}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object Coil {
    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object ViewBinding {
    const val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate:${
        Versions.viewBinding
    }"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
}

object NavigationComponent {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Fragment {
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
}

object Paging {
    const val paging3 = "androidx.paging:paging-runtime:${Versions.paging3}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}