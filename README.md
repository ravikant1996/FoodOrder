# FoodOrder
FoodOrderUI


    //dagger
    implementation("com.google.dagger:hilt-android:2.40")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    //coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-RC'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-RC'

    def latestVersion = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$latestVersion"
    implementation "com.squareup.retrofit2:converter-gson:$latestVersion"

    def lifecycle_version = "2.4.0"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    implementation 'com.google.code.gson:gson:2.8.8'
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    def activity_version = "1.4.0"
    // Kotlin
    implementation("androidx.activity:activity-ktx:$activity_version")

    def nav_version = "2.3.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")


    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    /////////////room/////////
    def roomVersion = "2.4.0"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")
