import java.io.File
import java.util.*

fun main() {
    val input = //"AoC08.test"
                  "AoC08.txt"
    val lines = File(input)
        .readLines()
        .map { it.replace("+","")}
        .map { it.split(" ").toMutableList() }
    println("A: ${Inter(lines).run(true)}")
    for (i in 0 until lines.count()) {
        //println("menim instrukciu $i ")
        val tmp = lines[i][0]
        if (lines[i][0] == "nop")
            lines[i][0] = "jmp"
        else if (lines[i][0] == "jmp")
            lines[i][0] = "nop"
        var res = Inter(lines).run(false)
        if (res != null) {
            println("B: $res")
            break
        }
        lines[i][0] = tmp
    }
}
data class Inter(val lines : List<MutableList<String>>) {

    fun run(repeated : Boolean) : Long? {
        var pc = 0
        var acc = 0L
        var pcs = mutableSetOf<Int>()
        while (pc < lines.count() && !pcs.contains(pc)) {
            pcs.add(pc)
            val ins = lines[pc]
            val code = ins[0]
            val arg = Integer.parseInt(ins[1])
            //println("$pc:\t$code $arg \t$acc")
            if (code == "nop") {
                pc++
            } else if (code == "acc") {
                acc += arg
                pc++
            } else if (code == "jmp") {
                pc += arg
            }
        }
        if (pc >= lines.count()) {
            return acc
        } else if (repeated && pcs.contains(pc)) {
            return acc
        }
        return null
    }
}
