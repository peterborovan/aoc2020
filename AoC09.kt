import java.io.File

fun main() {
    val input = //"AoC09.test"
        "AoC09.txt"
    val lines = File(input)
        .readLines()
        .map{ it.toLong()
        }
    val N = 25
    var resA = 0L
    lab@
    for (k in N until lines.count()) {
        val x = lines[k]
        for (i in k-N until k) {
            for (j in i + 1 until k) {
                if (x == lines[i] + lines[j])
                    continue@lab
            }
        }
        resA = x
        break
    }
    println("A: $resA")

    for (i in 0 until lines.count()) {
        for (j in i + 1 until lines.count()) {
            if (lines.subList(i,j+1).sum() == resA) {
                println("B: ${lines.subList(i,j+1).min()!!+lines.subList(i,j+1).max()!!}")
                break
            }
        }
    }
}
