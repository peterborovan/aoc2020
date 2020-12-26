data class Node(var prev : Node?=null, var next: Node?=null, val value:Int)

var first : Node? = null
var mapa:MutableMap<Int,Node> = emptyMap<Int,Node>().toMutableMap()

fun insert(c : Int) {
    //println("insert $c")
    val n = Node(value = c)
    if (first == null) {
        first = n
        n.next = first
        n.prev = first
    } else {
        n.prev = first?.prev
        n.next = first
        first?.prev?.next = n
        first?.prev = n
    }
    mapa[c] = n
}
fun insertAfter(n1 : Node, n2 : Node) {
    n1.next?.prev = n2
    n2.next = n1.next
    n1.next = n2
    n2.prev = n1
}
fun delete(n:Node) {
    n.prev?.next = n.next
    n.next?.prev = n.prev
}

fun main() {
    val inp = listOf(3,6,2,9,8,1,7,5,4).toMutableList()
    for(i in inp)
        insert(i)
    for(n in (inp.max()!!+1)..1000000)
        insert(n)

    var actual = first
    for(lev in 1..10000000) {
        val p1 = actual?.next!!
        delete(p1)
        val p2 = actual?.next!!
        delete(p2)
        val p3 = actual?.next!!
        delete(p3)
        val picked = listOf(p1.value, p2.value, p3.value)
        var destination = actual!!.value
        do {
            destination = destination - 1
            if (destination == 0)
                destination = 1000000
        } while (picked.contains(destination))
        val destNode = mapa[destination]!!
        insertAfter(destNode, p3)
        insertAfter(destNode, p2)
        insertAfter(destNode, p1)
        actual = actual.next
    }

    var node1 = mapa[1]!!

    var prod=1L
    node1 = node1.next!!
    prod *= node1.value.toLong()
    node1 = node1.next!!
    prod *= node1.value.toLong()
    println("B: $prod")
}



//fun main() {
//    val inp = listOf(3,6,2,9,8,1,7,5,4).toMutableList()
//    for(n in 10..1000000)
//        inp.add(n)
//    //println(inp)
//    //exitProcess(1)
//    //val inp = listOf(3,8,9,1,2,5,4,6,7).toMutableList()
//    //val sf = ".txt"
//    //val sf = ".test"
////    val lines = File("AoC23"+sf)
////        .readLines()
////        //.map { it.replace(" ", "")}
//////        .toTypedArray()
//
//    var index = 0
//    println(inp)
//    for(lev in 1..10000000) {
//        val len = inp.count()
//        val curr = inp[index%len]
//        val picked = listOf(
//            inp[(index+1)%len],
//            inp[(index+2)%len],
//            inp[(index+3)%len])
//        var dest = curr-1
//        if (dest < inp.min()!!)
//            dest = inp.max()!!
//        while (picked.contains(dest)) {
//            dest--
//            if (dest < inp.min()!!)
//                dest = inp.max()!!
//        }
//        inp.remove(picked[0])
//        inp.remove(picked[1])
//        inp.remove(picked[2])
//        val destindex = inp.indexOf(dest)
////        println(destindex)
////        println(inp)
//        inp.addAll(destindex+1, picked)
//        val in1 = inp.indexOf(1)
//
//        //println("$lev:: curr=$curr, dest=$dest, piked=$picked $inp")
//        println("$lev:: ${inp[(in1)%len]}, ${inp[(in1+1)%len]}, ${inp[(in1+2)%len]}")
//        index = inp.indexOf(curr)
//        index ++
//    }
//    val in1 = inp.indexOf(1)
//    println("A: ")
//    println("B: ")
//}

