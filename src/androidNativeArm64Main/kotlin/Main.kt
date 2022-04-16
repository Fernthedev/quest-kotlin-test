// Entrypoint for quest mod
import platform.android.__android_log_print

const val DBG_LEVEL = 3
const val INF_LEVEL = 4

// Makes this extern "C" void setup()
@CName("setup")
fun setup() {
    println("Hello, Kotlin/Native!")
    __android_log_print(INF_LEVEL, "KotlinQuest", "Look mom Kotlin works on Quest!")
}

@CName("load")
fun load() {
    CommonMain.createTestFile("/sdcard/Android/data/com.beatgames.beatsaber/files/logs")
}