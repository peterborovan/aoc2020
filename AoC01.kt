import java.io.File

fun main() {
    val input = //"AoC01.test"
                 "AoC01.txt"
    val lines = File(input)
        .readLines()
        .map { it.toInt() }
    loop@
    for (a in lines)
        for (b in lines)
            if (a+ b == 2020) {
                println("A: ${a * b}")
                break@loop
            }
    loop1@
    for (a in lines)
        for (b in lines)
            for (c in lines)
            if (a+b+c == 2020) {
                println("B: ${a*b*c}")
                break@loop1
            }
}