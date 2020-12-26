import java.io.File

fun ln(inp : Long) : Int {
    var subn = 7L
    var v = 1L
    var l = 0
    while (v!=inp) {
        v *= subn
        v = v % 20201227
        l++
    }
    return l
}


fun main() {
    val a = 12090988L
    val b = 240583L
    val aln = ln(a)
    //println(aln)
    val bln = ln(b)
    //println(bln)

    var subn = a
    var v = 1L
    for (l in 1..bln) {
        v *= subn
        v = v % 20201227
    }
    println("A: $v")
}


