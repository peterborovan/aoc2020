import java.io.File

fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val lines = File("AoC21"+sf)
        .readLines()
        //.map { it.replace(" ", "")}
//        .toTypedArray()
    var allings = setOf<String>().toMutableSet()
    var allalls = setOf<String>().toMutableSet()
    var mapa = mutableMapOf<String, MutableSet<String>>()
    for (l in lines) {
        val lpar = l.indexOf("(")
        if (lpar>= 0) {
            val ings = l.substring(0,lpar-1).split(" ").map{it.trim()}
            //println(ings)
            allings.addAll(ings)
            val ags = l.substring(lpar+9,l.length-1).split(",").map{it.trim()}
            //println(ags)
            allalls.addAll(ags)
            for (a in ags) {
                if (mapa[a] == null) {
                    mapa[a] = ings.toMutableSet()
                } else {
                    //println("alergen $a - before ${mapa[a]} intersect $ings")
                    var res = mutableSetOf<String>()
                    for (y in mapa[a]!!)
                        if (ings.contains(y))
                            res.add(y)
                    mapa[a] = res
                    //println("alergen $a - after ${mapa[a]}")
                }
            }
        } else {
            println("neexistuje(")
        }
    }
    //println(allings.count())
    val listAlgs = allalls.map{"X"+it}
    println("solve($listAlgs):-")
    for((k,v) in mapa) {
        println("\tmember(X$k,${v}),")
    }
    println("\talldiff($listAlgs),")
    println("\twrite($listAlgs),nl,fail.")

    println("alldiff([]).")
    println("alldiff([X|Xs]):- not(member(X,Xs)),alldiff(Xs).")

    // from prolog
    //?- solve(X).
    // [xrmxxvn,gnrpml,vmhqr,qxfzc,rfmvh,jxh,khpdjv,rdfr]
    //Xpeanuts, Xnuts, Xdairy, Xeggs, Xsesame, Xwheat, Xfish, Xsoy
    //[xrmxxvn,gnrpml,vmhqr,qxfzc,rfmvh,jxh,khpdjv,rdfr]
    val ingrealergens = listOf(
        "xrmxxvn","gnrpml","vmhqr","qxfzc","rfmvh",
        "jxh","khpdjv","rdfr")

    ///?- solve(Xdairy, Xfish, Xsoy).
    //val ingrealergens = listOf("mxmxvkd","sqjhc","fvjkl")

    var safeings = mutableSetOf<String>()
    for (l in lines) {
        val lpar = l.indexOf("(")
        if (lpar>= 0) {
            val ings = l.substring(0, lpar - 1).split(" ").map { it.trim() }
            safeings.addAll(ings.filter { it !in ingrealergens})
        }
    }
    //println(safeings)
    var countA = 0
    for (l in lines) {
        val lpar = l.indexOf("(")
        if (lpar>= 0) {
            val ings = l.substring(0, lpar - 1).split(" ").map { it.trim() }
            countA += ings.filter {it in safeings}.count()
        }
    }
    println("A: ${countA}")
    //  4        3      0     1      5      7      2     6
    //peanuts, nuts,  dairy, eggs, sesame, wheat, fish,  soy
    //[xrmxxvn,gnrpml,vmhqr, qxfzc,rfmvh,  jxh,   khpdjv,rdfr]
    println("B: ")
    //rucne... vmhqr,qxfzc,khpdjv,gnrpml,xrmxxvn,rfmvh,rdfr,jxh
}
/*
test:
solve(Xdairy, Xfish, Xsoy):-
    member(Xdairy,[mxmxvkd]),
    member(Xfish,[mxmxvkd, sqjhc]),
    member(Xsoy,[sqjhc, fvjkl]),
    alldiff([Xdairy, Xfish, Xsoy]),
    write([Xdairy, Xfish, Xsoy]),nl,fail.

%?- solve(Xdairy, Xfish, Xsoy).
%[mxmxvkd,sqjhc,fvjkl]

%- vsetky rozne
alldiff([]).
alldiff([X|Xs]):- not(member(X,Xs)),alldiff(Xs).



solve(Xpeanuts, Xnuts, Xdairy, Xeggs, Xsesame, Xwheat, Xfish, Xsoy):-
    member(Xpeanuts,[gnrpml, xrmxxvn]),
    member(Xnuts,[gnrpml]),
    member(Xdairy,[rdfr, gnrpml, vmhqr]),
    member(Xeggs,[rdfr, qxfzc]),
    member(Xsesame,[rdfr, rfmvh, qxfzc]),
    member(Xwheat,[gnrpml, jxh]),
    member(Xfish,[rfmvh, gnrpml, qxfzc, khpdjv]),
    member(Xsoy,[gnrpml, rdfr]),
    alldiff([Xpeanuts, Xnuts, Xdairy, Xeggs, Xsesame, Xwheat, Xfish, Xsoy]),
    write([Xpeanuts, Xnuts, Xdairy, Xeggs, Xsesame, Xwheat, Xfish, Xsoy]),nl,fail.


--test
    member(Xpeanuts,[xrmxxvn]),
    member(Xnuts,[gnrpml]),
    member(Xdairy,[ vmhqr]),
    member(Xeggs,[ qxfzc]),
    member(Xsesame,[rfmvh ]),
    member(Xwheat,[ jxh]),
    member(Xfish,[ khpdjv]),
    member(Xsoy,[ rdfr]),

%- vsetky rozne
alldiff([]).
alldiff([X|Xs]):- not(member(X,Xs)),alldiff(Xs).

 */