import kotlinx.cinterop.memScoped
import platform.posix.EOF
import platform.posix.fclose
import platform.posix.fopen
import platform.posix.fputs

object CommonMain {

    fun createTestFile(folder: String) {
        writeAllLines("${folder}/kotlin_quest.log", listOf("look it's kotlin!", "oh my that's so cool!"))
    }

    private fun writeAllLines(filePath: String, lines: List<String>, lineEnding: String = "\n") {
        val file = fopen(filePath, "wb+") ?: throw IllegalArgumentException("Cannot open output file $filePath")
        try {
            memScoped {
                lines.forEach {
                    if (fputs(it + lineEnding, file) == EOF) {
                        throw Error("File write error")
                    }
                }
            }
        } finally {
            fclose(file)
        }
    }
}