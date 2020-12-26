import java.io.File
import java.util.*

fun main() {
    val input = //"AoC03.test"
                 "AoC03.txt"
    val lines = File(input)
        .readLines()
    .toTypedArray()
    var x = 0
    var y = 0
    var c = 0
    while (x < lines.count() ) {
            if (lines[x][y % (lines[x].count())] == '#')
                c++
            x+=1
            y+=3
    }
    println("A: $c")

    var prod =1L
    var posx = listOf<Int>(1,3,5,7,1)
    var posy = listOf<Int>(1,1,1,1,2)
    for(i in 0 until posx.count()) {
        var x = 0
        var y = 0
        var c = 0
        while (x < lines.count()) {
            if (lines[x][y % (lines[x].count())] == '#')
                c++
            x += posy[i]
            y += posx[i]
        }
        prod *= c
    }
    println("B: $prod")
}