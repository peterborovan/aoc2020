import java.io.File

var ass = mutableMapOf<Int, Int>()
lateinit var fields : List<List<String>>
val bord = mutableListOf<MutableList<Int>>()
var nbsval = mutableListOf<MutableList<Int>>()

fun verifyS(seati : Int, len: Int) : List<Int> {
    val res = mutableListOf<Int>()
    for (c in 0 until len) {
        var isOK = true
        sss@
        for (nb in nbsval) {
            //println(nb)
            var all = true
//        for (seati in 0 until nb.count()) {
//        for (seati in 0..pocet) {
            val s = nb[seati]
            val bi = c
            val b = bord[bi]
            if (!(b[0] <= s && s <= b[1] || b[2] <= s && s <= b[3])) {
                isOK = false
                break@sss
            }
        }
        if (isOK) {
            res.add(c)
        }
    }
    return res
}


fun verify(pocet : Int) : Boolean {
    var isOK = true
    for (nb in nbsval) {
        //println(nb)
        var all = true
//        for (seati in 0 until nb.count()) {
//        for (seati in 0..pocet) {
        val seati = pocet
        val s = nb[seati]
        val bi = ass[seati]!!
        val b = bord[bi]
        if (!(b[0] <= s && s <= b[1] || b[2] <= s && s <= b[3])) {
            return false
        }
    }
    return true
}
var max = 0
fun rek(n : Int, len : Int) {
    if (n > max) {
        max = n
        println("max = $max, $len")
    }
    if ( n < len) {
        ccc@
        for (x in 0 until len) {
            for (j in 0 until n)
                if (ass[j] == x)
                    continue@ccc
            ass[n] = x
            if (verify(n))
                rek(n + 1, len)
        }
    } else {
        println("VALID $ass")
//        for((k,v) in ass) {
//            println("$k")
        //}
    }
}

fun main() {
    val sf = ".txt"
    //val sf = ".test"
    fields = File("AoC16f"+sf)
        .readLines()
        .map { it.split(":") }

    for (f in fields) {
        val parts = f[1].trim().split(" or ")
        //println(parts)
        val ml = mutableListOf<Int>()
        for (p in parts) {
            val x = p.split("-")
            ml.add(x[0].toInt())
            ml.add(x[1].toInt())
        }
        //println(ml)
        bord.add(ml)
    }
    var nbs = File("AoC16nb"+sf)
        .readLines()
        .map { it.split(",") }
        .map { it.map { it.toInt()}}
    var count = 0
    for (nb in nbs) {
        //println(nb)
        var all = true
        for (s in nb) {
            var g = 0
            for (b in bord) {
                if (b[0] <= s && s <= b[1] || b[2] <= s && s <= b[3]) {
                    g++
                }
            }
            if (g == 0) {
                all = false
                count += s
                //println("$s je zle, count $count")
            }
        }
        if (all) {
            //println("$nb valid")
            nbsval.add(nb.toMutableList())
        } else {
            //println("invalid")
        }
    }
    println("A: $count")

    //println(nbsval.count())
    var len = nbs[0].count()
    //len = 3
    println("solve(S):-")
    print("\tS=[S0")
    for(s in 1 until len) {
        print(",S$s")
    }
    println("]),")
    println("\tS :: [0..${len-1}],")
    println("\talldifferent(S),")
    for(s in 0 until len) {
        println("\tmember(S$s,${verifyS(s, len)}),")
    }
    println("\tlabeling(S).")

    val solution = listOf(17, 0, 2, 7, 3, 10, 5, 16, 14, 19, 8, 15, 18, 9, 4, 6, 12, 13, 11, 1)

    //your ticket:
    //109,101,79,127,71,59,67,61,173,157,163,103,83,97,73,167,53,107,89,131
    val input = listOf(109,101,79,127,71,59,67,61,173,157,163,103,83,97,73,167,53,107,89,131)
    var prod = 1L
    for(i in 0 until len) {
        if (solution[i] < 6) {
            //println(input[i])
            prod *= input[i]
        }
    }
    println("B: $prod")
    //rek(0, len)
//    for (nb in nbsval) {
//        println(nb.count())
//    }
    /*
    for (nb in nbsval) {
        //println(nb)
        var all = true
        for (seati in 0 until nb.count()) {
            val s = nb[seati]
            var g = 0
            for (bi in 0 until bord.count()) {
                val b = bord[bi]
                if (b[0] <= s && s <= b[1] || b[2] <= s && s <= b[3]) {
                    g++
                    println("$seati - $bi")
                }
            }
            if (g == 0) {
                all = false
                count += s
                println("$s je zle, count $count")
            }
        }
        if (all) {
            println("$nb valid")
            nbsval.add(nb.toMutableList())
        } else {
            //println("invalid")
        }
    }
    */
}

/*
eclipseCLP
:- lib(ic).

solve(S):-
            S=[S0,S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19],
            S :: [0..19],
            alldifferent(S),member(S0,[9, 10, 11, 14, 17]),
            member(S13,[9]),
            member(S8,[9, 14]),
            member(S18,[9, 11, 14]),
            member(S5,[9, 10, 11, 14]),
            member(S15,[6, 9, 10, 11, 14, 17]),
            member(S10,[6, 8, 9, 10, 11, 14, 17]),
            member(S16,[6, 8, 9, 10, 11, 12, 14, 17]),
            member(S3,[6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S1,[0, 6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S14,[0, 4, 6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S6,[0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S19,[0, 1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S2,[0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S4,[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 17]),
            member(S7,[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16, 17, 18]),
            member(S9,[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19]),
            member(S11,[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]),
            member(S12,[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 17, 18]),
            member(S17,[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18]),
            labeling(S).



[17, 0, 2, 7, 3, 10, 5, 16, 14, 19, 8, 15, 18, 9, 4, 6, 12, 13, 11, 1]


:- lib(ic).

solve(S):-
    S = [S0,S1,S2],
    S :: [0..2],
    alldifferent(S),
    member(S0,[0, 1]),
    member(S1,[0]),
    member(S2,[2]),
    labeling(S).
 */