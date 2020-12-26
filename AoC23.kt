import java.io.File
fun main() {
    val inp = listOf(3,6,2,9,8,1,7,5,4).toMutableList()
    //val inp = listOf(3,8,9,1,2,5,4,6,7).toMutableList()
    val sf = ".txt"

    var index = 0
    repeat(100) {
        val len = inp.count()
        val curr = inp[index%len]
        val picked = listOf(
            inp[(index+1)%len],
            inp[(index+2)%len],
            inp[(index+3)%len])
        var dest = curr-1
        if (dest < inp.min()!!)
            dest = inp.max()!!
        while (picked.contains(dest)) {
            dest--
            if (dest < inp.min()!!)
                dest = inp.max()!!
        }
        inp.remove(picked[0])
        inp.remove(picked[1])
        inp.remove(picked[2])
        val destindex = inp.indexOf(dest)
        inp.addAll(destindex+1, picked)
        index = inp.indexOf(curr)
        index ++
    }
    val in1 = inp.indexOf(1)
    var s = ""
    for(i in 1..inp.count()-1) {
        s += inp[(i+in1)%inp.count()]
    }
    println("A: $s")
}
