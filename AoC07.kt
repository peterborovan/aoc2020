import java.io.File
import java.util.*

val NO = "no other"
var visited = mutableSetOf<String>()
fun rek(wanted: String, lines: List<List<String>>) {
    //println("rek $wanted")
    lines.forEach { line ->
        val lhs = line[0]
        for (i in 1..line.count() - 1) {
            val rhs = line[i]
            if (rhs.contains(NO)) {
                //println("$lhs -> no other")
            } else {
                val m = rhs.indexOf(" ")
                val c = rhs.substring(0, m)
                val x = Integer.parseInt(c)
                val rest = rhs.substring(m + 1)
                if (rest == wanted) {
                    // println("$lhs -> $c $rest")
                    visited.add(lhs)
                    rek(lhs, lines)
                }
            }
        }
    }
}

fun rek2(wanted: String, lines: List<List<String>>): Int {
    var cnt = 1
    lines.forEach { line ->
        val lhs = line[0].trim()
        if (lhs == wanted) {
            for (i in 1..line.count() - 1) {
                val rhs = line[i]
                if (rhs.contains(NO)) {
                    //println("$lhs -> no other")
                } else {
                    val m = rhs.indexOf(" ")
                    val c = rhs.substring(0, m)
                    val rest = rhs.substring(m + 1)
                    cnt = cnt +rek2(rest, lines) * Integer.parseInt(c)
                }
            }
        }
    }
    return cnt
}

fun main() {
    val SG = "shiny gold"
    val input = //"AoC07.test"
        "AoC07.txt"
    val lines = File(input)
        .readLines()
        .map { it.split(",") }
    var set = mutableSetOf(SG)
    var newset = mutableSetOf<String>()
    lines.forEach { line ->
        val lhs = line[0]
        for (i in 1..line.count() - 1) {
            val rhs = line[i]
            if (rhs.contains(NO)) {
                //println("$lhs -> no other")
            } else {
                val m = rhs.indexOf(" ")
                val c = rhs.substring(0, m)
                val x = Integer.parseInt(c)
                val rest = rhs.substring(m + 1)
                if (set.contains(rest)) {
                    //println("$lhs -> $c $rest")
                    newset.add(lhs)

                }
            }
        }
    }
    //println("${newset.count()}, $newset")
    set.addAll(newset)
    //set = newset
    //println("${set.count()}, $set")
    rek(SG, lines)
    println("A: ${visited.count()}")
    val countB = rek2(SG, lines)
    println("B: ${countB - 1}")
}
