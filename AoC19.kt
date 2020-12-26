import java.io.File

//var rs = mutableMapOf<Int, List<String>>()
//fun par(w : String, state : Int) : Pair(String, ) {
//    println("$w, $state")
//    println("${rs[state]}")
//    var atleastone = false
//    for(posib in rs[state]!!) {
//        println("$posib")
//        val xx = posib.split(" ").map{ it.trim().toInt() }
//        for (x in xx) {
//            par(w, x)
//        }
//    }
//
//}
fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val rules =
        //File("AoC19"+sf)
        File("AoC19B"+sf)
        .readLines()
    //println(rules)
    for (r in rules) {
        val rparts = r.split(":")
        val rid = rparts[0].trim().toInt()
        val lparts = rparts[1].trim().split("|").map{it.trim()}
        //rs[rid] = lparts
        for (lp in lparts) {
            val xx = lp.trim().split(" ")
            var ind = 0
            print("q$rid(W$ind,W${xx.count()}) :- ")
            for(x in xx) {
                if (x.contains("a")) {
                    print("W${ind} = [a | W${ind+1}],")
                } else if (x.contains("b")) {
                    print("W${ind} = [b | W${ind+1}],")
                } else
                    print("q$x(W$ind,W${ind+1}),")
                ind++
            }
            println("true.")
        }
    }

    val words = File("AoC19w"+sf)
        .readLines()

    println("goals([")
    var ciarka2 = ""
    for(w in words) {
        print("\t${ciarka2}q0([")
        var ciarka = ""
        for (ch in w) {
            print(ciarka+ch)
            ciarka = ","
        }
        println("],[])")
        ciarka2 = ","
    }
    println("\t]).")

    println("count([],0). ")
    println("count([G|GS],N) :- G -> (count(GS,N1), N is N1+1) ; count(GS,N).")

    println("?-goals(Gs), count(Gs, Result).")

        //.map { it.replace(" ", "")}
//        .toTypedArray()
    //println(words)


//    for (w in words) {
//        par(w, 0)
//        break
//    }

    println("A: ")
    println("B: ")
}


/*
q50(W0,W2) :- q5(W0,W1),q18(W1,W2),true.
q50(W0,W2) :- q61(W0,W1),q39(W1,W2),true.
q79(W0,W2) :- q118(W0,W1),q18(W1,W2),true.
q79(W0,W2) :- q125(W0,W1),q39(W1,W2),true.
q102(W0,W2) :- q38(W0,W1),q39(W1,W2),true.
q102(W0,W2) :- q19(W0,W1),q18(W1,W2),true.
q114(W0,W2) :- q39(W0,W1),q38(W1,W2),true.
q114(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q119(W0,W2) :- q39(W0,W1),q103(W1,W2),true.
q40(W0,W2) :- q39(W0,W1),q72(W1,W2),true.
q40(W0,W2) :- q18(W0,W1),q38(W1,W2),true.
q10(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q10(W0,W2) :- q39(W0,W1),q132(W1,W2),true.
q44(W0,W2) :- q51(W0,W1),q39(W1,W2),true.
q44(W0,W2) :- q118(W0,W1),q18(W1,W2),true.
q18(W0,W1) :- W0 = [a | W1],true.
q55(W0,W2) :- q18(W0,W1),q33(W1,W2),true.
q55(W0,W2) :- q39(W0,W1),q4(W1,W2),true.
q101(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q101(W0,W2) :- q39(W0,W1),q100(W1,W2),true.
q28(W0,W2) :- q110(W0,W1),q39(W1,W2),true.
q28(W0,W2) :- q96(W0,W1),q18(W1,W2),true.
q11(W0,W2) :- q42(W0,W1),q31(W1,W2),true.
q92(W0,W2) :- q26(W0,W1),q39(W1,W2),true.
q92(W0,W2) :- q110(W0,W1),q18(W1,W2),true.
q2(W0,W2) :- q18(W0,W1),q93(W1,W2),true.
q2(W0,W2) :- q39(W0,W1),q44(W1,W2),true.
q27(W0,W2) :- q73(W0,W1),q18(W1,W2),true.
q27(W0,W2) :- q135(W0,W1),q39(W1,W2),true.
q0(W0,W2) :- q8(W0,W1),q11(W1,W2),true.
q8(W0,W1) :- q42(W0,W1),true.
q14(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q41(W0,W2) :- q109(W0,W1),q39(W1,W2),true.
q41(W0,W2) :- q58(W0,W1),q18(W1,W2),true.
q4(W0,W2) :- q64(W0,W1),q39(W1,W2),true.
q4(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q85(W0,W2) :- q65(W0,W1),q18(W1,W2),true.
q85(W0,W2) :- q27(W0,W1),q39(W1,W2),true.
q122(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q122(W0,W2) :- q18(W0,W1),q66(W1,W2),true.
q123(W0,W2) :- q103(W0,W1),q39(W1,W2),true.
q123(W0,W2) :- q72(W0,W1),q18(W1,W2),true.
q72(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q72(W0,W2) :- q66(W0,W1),q18(W1,W2),true.
q130(W0,W2) :- q18(W0,W1),q132(W1,W2),true.
q130(W0,W2) :- q39(W0,W1),q125(W1,W2),true.
q135(W0,W2) :- q39(W0,W1),q74(W1,W2),true.
q135(W0,W2) :- q18(W0,W1),q32(W1,W2),true.
q67(W0,W2) :- q18(W0,W1),q54(W1,W2),true.
q67(W0,W2) :- q39(W0,W1),q20(W1,W2),true.
q133(W0,W2) :- q39(W0,W1),q105(W1,W2),true.
q133(W0,W2) :- q18(W0,W1),q128(W1,W2),true.
q116(W0,W2) :- q71(W0,W1),q18(W1,W2),true.
q116(W0,W2) :- q14(W0,W1),q39(W1,W2),true.
q88(W0,W2) :- q18(W0,W1),q84(W1,W2),true.
q88(W0,W2) :- q39(W0,W1),q124(W1,W2),true.
q111(W0,W2) :- q100(W0,W1),q39(W1,W2),true.
q111(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q1(W0,W2) :- q38(W0,W1),q18(W1,W2),true.
q1(W0,W2) :- q122(W0,W1),q39(W1,W2),true.
q51(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q51(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q109(W0,W2) :- q16(W0,W1),q39(W1,W2),true.
q109(W0,W2) :- q87(W0,W1),q18(W1,W2),true.
q25(W0,W2) :- q18(W0,W1),q56(W1,W2),true.
q25(W0,W2) :- q39(W0,W1),q97(W1,W2),true.
q78(W0,W2) :- q18(W0,W1),q35(W1,W2),true.
q78(W0,W2) :- q39(W0,W1),q41(W1,W2),true.
q12(W0,W2) :- q18(W0,W1),q43(W1,W2),true.
q12(W0,W2) :- q39(W0,W1),q101(W1,W2),true.
q29(W0,W2) :- q39(W0,W1),q37(W1,W2),true.
q29(W0,W2) :- q18(W0,W1),q10(W1,W2),true.
q134(W0,W2) :- q18(W0,W1),q122(W1,W2),true.
q134(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q5(W0,W2) :- q39(W0,W1),q72(W1,W2),true.
q5(W0,W2) :- q18(W0,W1),q14(W1,W2),true.
q96(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q96(W0,W2) :- q39(W0,W1),q14(W1,W2),true.
q47(W0,W2) :- q39(W0,W1),q121(W1,W2),true.
q47(W0,W2) :- q18(W0,W1),q15(W1,W2),true.
q63(W0,W2) :- q13(W0,W1),q18(W1,W2),true.
q63(W0,W2) :- q1(W0,W1),q39(W1,W2),true.
q16(W0,W2) :- q14(W0,W1),q18(W1,W2),true.
q16(W0,W2) :- q72(W0,W1),q39(W1,W2),true.
q43(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q43(W0,W2) :- q38(W0,W1),q39(W1,W2),true.
q115(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q54(W0,W2) :- q51(W0,W1),q66(W1,W2),true.
q105(W0,W2) :- q39(W0,W1),q51(W1,W2),true.
q105(W0,W2) :- q18(W0,W1),q132(W1,W2),true.
q107(W0,W2) :- q82(W0,W1),q39(W1,W2),true.
q107(W0,W2) :- q50(W0,W1),q18(W1,W2),true.
q87(W0,W2) :- q122(W0,W1),q39(W1,W2),true.
q76(W0,W2) :- q14(W0,W1),q18(W1,W2),true.
q76(W0,W2) :- q48(W0,W1),q39(W1,W2),true.
q30(W0,W2) :- q39(W0,W1),q64(W1,W2),true.
q30(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q17(W0,W2) :- q104(W0,W1),q39(W1,W2),true.
q17(W0,W2) :- q107(W0,W1),q18(W1,W2),true.
q95(W0,W2) :- q39(W0,W1),q47(W1,W2),true.
q95(W0,W2) :- q18(W0,W1),q63(W1,W2),true.
q34(W0,W2) :- q134(W0,W1),q39(W1,W2),true.
q34(W0,W2) :- q130(W0,W1),q18(W1,W2),true.
q24(W0,W2) :- q19(W0,W1),q18(W1,W2),true.
q24(W0,W2) :- q122(W0,W1),q39(W1,W2),true.
q106(W0,W2) :- q39(W0,W1),q100(W1,W2),true.
q121(W0,W2) :- q38(W0,W1),q18(W1,W2),true.
q121(W0,W2) :- q71(W0,W1),q39(W1,W2),true.
q126(W0,W2) :- q75(W0,W1),q39(W1,W2),true.
q126(W0,W2) :- q43(W0,W1),q18(W1,W2),true.
q23(W0,W2) :- q18(W0,W1),q48(W1,W2),true.
q23(W0,W2) :- q39(W0,W1),q125(W1,W2),true.
q90(W0,W2) :- q18(W0,W1),q127(W1,W2),true.
q90(W0,W2) :- q39(W0,W1),q20(W1,W2),true.
q56(W0,W2) :- q62(W0,W1),q39(W1,W2),true.
q56(W0,W2) :- q30(W0,W1),q18(W1,W2),true.
q89(W0,W2) :- q49(W0,W1),q18(W1,W2),true.
q89(W0,W2) :- q22(W0,W1),q39(W1,W2),true.
q113(W0,W2) :- q87(W0,W1),q39(W1,W2),true.
q113(W0,W2) :- q59(W0,W1),q18(W1,W2),true.
q48(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q48(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q49(W0,W2) :- q72(W0,W1),q39(W1,W2),true.
q49(W0,W2) :- q125(W0,W1),q18(W1,W2),true.
q68(W0,W2) :- q18(W0,W1),q3(W1,W2),true.
q68(W0,W2) :- q39(W0,W1),q80(W1,W2),true.
q112(W0,W2) :- q69(W0,W1),q18(W1,W2),true.
q112(W0,W2) :- q17(W0,W1),q39(W1,W2),true.
q71(W0,W2) :- q66(W0,W1),q66(W1,W2),true.
q58(W0,W2) :- q114(W0,W1),q39(W1,W2),true.
q58(W0,W2) :- q111(W0,W1),q18(W1,W2),true.
q104(W0,W2) :- q18(W0,W1),q90(W1,W2),true.
q104(W0,W2) :- q39(W0,W1),q2(W1,W2),true.
q86(W0,W2) :- q39(W0,W1),q91(W1,W2),true.
q86(W0,W2) :- q18(W0,W1),q9(W1,W2),true.
q99(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q99(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q19(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q19(W0,W2) :- q39(W0,W1),q66(W1,W2),true.
q42(W0,W2) :- q18(W0,W1),q83(W1,W2),true.
q42(W0,W2) :- q39(W0,W1),q112(W1,W2),true.
q31(W0,W2) :- q85(W0,W1),q18(W1,W2),true.
q31(W0,W2) :- q94(W0,W1),q39(W1,W2),true.
q7(W0,W2) :- q4(W0,W1),q39(W1,W2),true.
q7(W0,W2) :- q24(W0,W1),q18(W1,W2),true.
q97(W0,W2) :- q57(W0,W1),q39(W1,W2),true.
q97(W0,W2) :- q117(W0,W1),q18(W1,W2),true.
q75(W0,W2) :- q100(W0,W1),q39(W1,W2),true.
q75(W0,W2) :- q122(W0,W1),q18(W1,W2),true.
q37(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q37(W0,W2) :- q103(W0,W1),q39(W1,W2),true.
q117(W0,W2) :- q39(W0,W1),q14(W1,W2),true.
q117(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q129(W0,W2) :- q103(W0,W1),q18(W1,W2),true.
q129(W0,W2) :- q125(W0,W1),q39(W1,W2),true.
q32(W0,W2) :- q36(W0,W1),q18(W1,W2),true.
q32(W0,W2) :- q40(W0,W1),q39(W1,W2),true.
q60(W0,W2) :- q48(W0,W1),q39(W1,W2),true.
q128(W0,W2) :- q18(W0,W1),q14(W1,W2),true.
q128(W0,W2) :- q39(W0,W1),q19(W1,W2),true.
q61(W0,W2) :- q100(W0,W1),q39(W1,W2),true.
q84(W0,W2) :- q98(W0,W1),q39(W1,W2),true.
q84(W0,W2) :- q76(W0,W1),q18(W1,W2),true.
q93(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q93(W0,W2) :- q18(W0,W1),q51(W1,W2),true.
q26(W0,W2) :- q18(W0,W1),q72(W1,W2),true.
q83(W0,W2) :- q18(W0,W1),q131(W1,W2),true.
q83(W0,W2) :- q39(W0,W1),q78(W1,W2),true.
q59(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q59(W0,W2) :- q39(W0,W1),q48(W1,W2),true.
q33(W0,W2) :- q18(W0,W1),q71(W1,W2),true.
q33(W0,W2) :- q39(W0,W1),q48(W1,W2),true.
q3(W0,W2) :- q18(W0,W1),q99(W1,W2),true.
q3(W0,W2) :- q39(W0,W1),q23(W1,W2),true.
q20(W0,W2) :- q39(W0,W1),q122(W1,W2),true.
q20(W0,W2) :- q18(W0,W1),q72(W1,W2),true.
q9(W0,W2) :- q39(W0,W1),q133(W1,W2),true.
q9(W0,W2) :- q18(W0,W1),q108(W1,W2),true.
q6(W0,W2) :- q75(W0,W1),q18(W1,W2),true.
q6(W0,W2) :- q123(W0,W1),q39(W1,W2),true.
q52(W0,W2) :- q39(W0,W1),q81(W1,W2),true.
q52(W0,W2) :- q18(W0,W1),q67(W1,W2),true.
q62(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q62(W0,W2) :- q39(W0,W1),q72(W1,W2),true.
q108(W0,W2) :- q18(W0,W1),q13(W1,W2),true.
q108(W0,W2) :- q39(W0,W1),q120(W1,W2),true.
q81(W0,W2) :- q18(W0,W1),q79(W1,W2),true.
q81(W0,W2) :- q39(W0,W1),q129(W1,W2),true.
q77(W0,W2) :- q92(W0,W1),q18(W1,W2),true.
q77(W0,W2) :- q6(W0,W1),q39(W1,W2),true.
q124(W0,W2) :- q119(W0,W1),q18(W1,W2),true.
q124(W0,W2) :- q60(W0,W1),q39(W1,W2),true.
q82(W0,W2) :- q116(W0,W1),q18(W1,W2),true.
q82(W0,W2) :- q10(W0,W1),q39(W1,W2),true.
q110(W0,W2) :- q71(W0,W1),q39(W1,W2),true.
q110(W0,W2) :- q48(W0,W1),q18(W1,W2),true.
q98(W0,W2) :- q132(W0,W1),q18(W1,W2),true.
q98(W0,W2) :- q14(W0,W1),q39(W1,W2),true.
q74(W0,W2) :- q18(W0,W1),q70(W1,W2),true.
q74(W0,W2) :- q39(W0,W1),q115(W1,W2),true.
q91(W0,W2) :- q39(W0,W1),q21(W1,W2),true.
q91(W0,W2) :- q18(W0,W1),q12(W1,W2),true.
q132(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q132(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q100(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q53(W0,W2) :- q18(W0,W1),q29(W1,W2),true.
q53(W0,W2) :- q39(W0,W1),q34(W1,W2),true.
q125(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q125(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q131(W0,W2) :- q39(W0,W1),q77(W1,W2),true.
q131(W0,W2) :- q18(W0,W1),q46(W1,W2),true.
q103(W0,W2) :- q66(W0,W1),q39(W1,W2),true.
q103(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q65(W0,W2) :- q53(W0,W1),q18(W1,W2),true.
q65(W0,W2) :- q52(W0,W1),q39(W1,W2),true.
q38(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q38(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q39(W0,W1) :- W0 = [b | W1],true.
q21(W0,W2) :- q99(W0,W1),q18(W1,W2),true.
q21(W0,W2) :- q102(W0,W1),q39(W1,W2),true.
q36(W0,W2) :- q103(W0,W1),q39(W1,W2),true.
q36(W0,W2) :- q125(W0,W1),q18(W1,W2),true.
q73(W0,W2) :- q18(W0,W1),q7(W1,W2),true.
q73(W0,W2) :- q39(W0,W1),q89(W1,W2),true.
q118(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q57(W0,W2) :- q14(W0,W1),q18(W1,W2),true.
q57(W0,W2) :- q64(W0,W1),q39(W1,W2),true.
q35(W0,W2) :- q39(W0,W1),q55(W1,W2),true.
q35(W0,W2) :- q18(W0,W1),q28(W1,W2),true.
q66(W0,W1) :- q18(W0,W1),true.
q66(W0,W1) :- q39(W0,W1),true.
q94(W0,W2) :- q39(W0,W1),q86(W1,W2),true.
q94(W0,W2) :- q18(W0,W1),q45(W1,W2),true.
q80(W0,W2) :- q106(W0,W1),q39(W1,W2),true.
q80(W0,W2) :- q134(W0,W1),q18(W1,W2),true.
q127(W0,W2) :- q39(W0,W1),q14(W1,W2),true.
q127(W0,W2) :- q18(W0,W1),q48(W1,W2),true.
q64(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q64(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q69(W0,W2) :- q95(W0,W1),q39(W1,W2),true.
q69(W0,W2) :- q25(W0,W1),q18(W1,W2),true.
q45(W0,W2) :- q88(W0,W1),q39(W1,W2),true.
q45(W0,W2) :- q68(W0,W1),q18(W1,W2),true.
q15(W0,W2) :- q39(W0,W1),q38(W1,W2),true.
q15(W0,W2) :- q18(W0,W1),q71(W1,W2),true.
q70(W0,W2) :- q18(W0,W1),q132(W1,W2),true.
q70(W0,W2) :- q39(W0,W1),q118(W1,W2),true.
q13(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q13(W0,W2) :- q132(W0,W1),q39(W1,W2),true.
q46(W0,W2) :- q18(W0,W1),q126(W1,W2),true.
q46(W0,W2) :- q39(W0,W1),q113(W1,W2),true.
q120(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q120(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q22(W0,W2) :- q39(W0,W1),q100(W1,W2),true.
q22(W0,W2) :- q18(W0,W1),q48(W1,W2),true.


goals([
    q0([a,b,b,b,b,a,b,b,b,a,a,b,a,b,a,b,a,a,a,b,b,a,a,b,b,b,b,b,b,b,b,a],[]),
    q0([b,b,b,a,b,b,b,b,a,b,b,a,b,b,b,b,a,b,b,b,a,b,a,b],[]),
    q0([a,a,b,b,a,b,a,b,b,b,b,a,b,a,b,b,a,a,a,b,b,a,b,b],[]),
    q0([a,a,b,a,b,b,a,a,a,a,b,b,b,a,a,a,a,a,b,a,a,b,b,b],[]),
    q0([a,a,a,a,b,a,a,a,b,a,b,b,b,b,b,b,b,b,b,b,a,b,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,b,b,a,b,b,b,a,b,b,a,a,b,b,a],[]),
    q0([a,b,a,a,a,a,b,b,b,a,b,a,a,b,a,a,a,b,a,b,b,b,b,b],[]),
    q0([b,b,a,b,a,b,b,b,a,a,a,a,a,a,a,b,b,b,a,b,a,b,b,a],[]),
    q0([b,b,b,a,a,a,a,a,b,b,a,b,b,a,a,b,b,b,b,b,a,b,a,a],[]),
    q0([a,a,a,a,b,b,a,b,a,b,b,b,a,b,b,b,b,b,a,b,a,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([a,a,a,a,b,a,a,a,a,a,b,b,b,b,b,b,b,a,a,a,a,b,b,a],[]),
    q0([a,a,b,a,a,a,a,b,a,a,b,a,b,b,b,a,b,a,b,a,b,b,b,b,b,b,b,b,a,b,a,b],[]),
    q0([b,b,a,a,b,b,a,b,a,b,a,a,a,b,a,b,b,a,b,a,b,b,b,a],[]),
    q0([b,b,a,b,b,b,a,a,b,b,a,b,b,b,b,a,a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,a,a,b,b,a,a,b,b,a,b,a,a,a,a,a,a,a,a,b,a,a,b,a,b,a],[]),
    q0([b,b,b,b,b,a,b,a,b,b,a,a,b,b,a,b,b,a,a,a,a,a,b,a],[]),
    q0([b,a,b,a,a,b,b,b,b,b,a,a,b,b,b,a,a,a,b,a,b,b,a,a,a,a,a,b,b,b,a,b,a,b,a,b,b,a,a,a],[]),
    q0([b,a,a,a,a,a,a,b,a,a,a,a,b,a,b,b,b,b,b,b,a,a,b,b,b,a,a,a,b,a,a,a],[]),
    q0([a,b,a,b,b,b,a,b,a,b,a,b,a,b,a,b,b,b,b,a,b,a,a,b],[]),
    q0([b,b,a,a,a,a,b,b,a,b,a,b,a,a,a,b,a,a,a,a,b,a,b,b,b,a,b,a,b,a,a,a,b,b,a,a,a,a,a,b,b,b,b,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,b,a,b,a,a,b,b,b,b,a,a,a,b,a,b,b,b,b,a,a,b,b],[]),
    q0([b,b,a,a,a,b,a,a,a,a,a,a,b,a,a,a,b,b,b,a,b,a,a,a],[]),
    q0([a,a,a,a,a,a,a,b,b,b,a,a,b,a,b,a,a,a,a,a,a,b,a,a],[]),
    q0([b,a,a,b,a,a,a,a,b,b,b,a,b,b,a,a,b,b,a,a,b,a,a,a],[]),
    q0([a,a,b,b,b,b,b,b,b,b,a,a,a,b,b,b,a,a,b,b,a,a,a,b],[]),
    q0([b,b,b,a,a,b,b,a,b,a,a,b,b,b,b,a,b,b,a,a,b,b,a,a],[]),
    q0([a,a,b,a,b,a,a,b,a,b,a,b,a,b,a,a,b,a,b,b,b,b,a,a],[]),
    q0([a,a,a,a,a,b,b,a,a,b,a,a,b,a,b,b,b,b,b,a,b,b,b,a,a,b,a,a,a,b,a,a,a,a,b,b,a,a,a,a,a,b,b,b,a,b,a,b,b,a,a,b,a,a,b,a,a,b,b,a,a,b,a,b,b,b,a,a,a,b,b,b,b,b,b,a,a,b,a,a],[]),
    q0([a,b,b,b,b,a,b,a,a,a,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,a,b,b,b,b,b,a],[]),
    q0([a,a,b,a,a,a,a,b,b,a,a,b,a,a,b,b,b,b,b,a,b,b,b,a,a,b,b,b,b,a,a,a,a,a,a,a,b,b,a,a],[]),
    q0([a,b,a,b,b,b,a,a,a,a,b,a,b,a,b,a,a,b,a,b,a,a,b,a,a,b,b,a,b,b,b,b,b,a,a,a,a,b,b,b,b,b,a,a,a,a,b,b,a,a,b,a,a,a,a,a,b,b,b,b,b,b,a,b,b,a,a,b,b,a,b,a,b,b,a,b,a,a,b,a],[]),
    q0([b,b,b,a,b,b,a,b,b,a,a,b,a,a,a,a,a,a,b,b,a,b,a,a,a,b,b,a,b,b,a,a,b,b,b,b,b,a,a,a],[]),
    q0([b,b,b,b,b,b,b,b,b,a,b,a,b,b,a,b,a,b,b,b,b,a,a,a,b,a,a,a,b,a,a,a],[]),
    q0([b,a,a,a,b,b,b,a,b,a,b,a,b,a,a,a,a,a,b,b,a,a,b,a],[]),
    q0([b,b,a,b,a,a,a,b,b,b,a,b,b,b,b,a,b,a,a,b,a,b,b,b],[]),
    q0([b,a,b,a,a,b,b,b,a,a,a,b,a,a,b,b,b,a,a,b,a,b,a,b,b,b,b,a,b,b,b,b,a,b,b,a,a,a,a,a,b,b,b,b,b,a,a,b],[]),
    q0([a,a,a,b,a,a,b,b,a,b,b,b,b,b,b,a,b,b,b,b,b,b,b,b],[]),
    q0([a,b,b,a,b,a,b,a,b,a,b,b,b,b,b,a,b,a,a,a,b,b,a,a],[]),
    q0([a,a,a,a,a,b,a,b,a,b,a,b,a,a,b,b,b,a,a,b,b,b,b,b],[]),
    q0([a,a,b,b,a,b,b,b,a,a,b,a,b,b,b,b,b,b,a,a,a,a,b,b,b,b,a,a,a,a,b,a,a,a,b,b,b,a,b,a,b,a,a,b,b,b,b,b,a,a,a,b,b,a,b,b],[]),
    q0([a,a,b,b,b,b,b,b,a,b,b,b,a,b,a,a,a,a,a,a,b,b,a,a],[]),
    q0([a,a,b,a,a,a,b,b,b,b,b,b,b,a,b,a,b,b,b,b,a,a,a,b],[]),
    q0([a,a,b,b,b,b,b,b,b,a,b,a,a,b,a,b,b,a,a,a,a,b,a,a,a,b,a,a,b,b,a,a],[]),
    q0([b,b,a,b,a,b,b,b,b,b,b,a,b,b,a,a,a,a,b,a,b,b,b,a],[]),
    q0([a,a,a,b,a,a,a,a,a,b,a,a,a,b,a,b,b,a,a,b,b,a,a,b],[]),
    q0([b,a,b,b,a,b,b,b,b,a,b,a,a,b,b,a,a,b,a,a,b,b,b,b,b,a,b,a,a,a,a,a],[]),
    q0([a,b,b,b,b,b,b,a,b,b,a,a,a,a,b,b,b,a,a,a,a,a,b,a],[]),
    q0([a,a,b,b,b,b,b,b,a,b,a,b,a,a,a,b,a,b,b,a,a,b,b,b,a,b,b,a,b,a,b,b],[]),
    q0([a,a,a,a,b,a,b,b,a,a,a,a,a,b,a,b,b,b,a,a,b,a,a,b],[]),
    q0([b,a,a,a,a,b,a,b,b,a,a,a,b,b,a,b,b,b,a,b,b,a,a,b],[]),
    q0([a,a,b,b,b,b,a,a,a,b,a,b,b,b,a,a,a,b,a,a,b,a,b,b,b,b,b,b,a,b,a,b],[]),
    q0([b,b,b,a,b,b,b,b,b,b,b,a,b,b,a,b,b,b,a,b,b,a,a,a,a,b,a,a,b,b,b,a],[]),
    q0([b,a,b,a,a,b,a,a,a,a,b,a,b,a,a,a,a,a,a,a,a,a,b,a],[]),
    q0([b,a,b,b,b,b,b,b,b,b,a,b,b,b,b,a,b,a,a,a,b,a,a,b],[]),
    q0([b,a,a,a,b,a,b,a,a,a,a,b,a,a,b,b,b,b,b,a,a,a,b,a],[]),
    q0([b,b,b,b,a,a,b,a,a,a,a,a,b,a,a,a,b,b,a,a,a,a,b,b,b,a,b,a,a,b,b,b,a,b,b,b,a,a,a,a],[]),
    q0([b,b,a,b,a,b,b,b,b,b,a,a,a,a,a,b,b,b,a,a,a,a,a,b,a,a,a,a,b,b,b,a,b,b,a,b,b,b,a,b],[]),
    q0([b,a,a,a,a,a,a,b,a,a,a,b,b,b,b,a,a,a,b,a,b,a,b,a,a,b,b,a,b,a,b,b],[]),
    q0([b,a,b,b,a,b,b,a,b,b,a,b,b,b,a,a,a,b,a,a,a,a,b,a],[]),
    q0([b,b,b,a,a,a,a,b,b,b,b,a,b,b,a,a,a,b,b,a,a,b,a,b,a,b,b,b,b,a,b,a,a,b,a,a,b,a,a,b,a,b,b,b,b,a,b,b],[]),
    q0([b,a,b,b,b,b,b,a,b,b,a,b,a,a,b,b,b,a,a,a,a,b,b,a],[]),
    q0([a,a,a,b,b,b,b,b,b,b,a,b,a,a,a,b,a,b,b,a,a,a,a,a],[]),
    q0([b,a,a,a,b,b,b,b,a,b,a,a,b,b,a,b,a,b,a,b,b,b,b,a],[]),
    q0([a,b,b,b,b,b,b,a,a,a,b,a,a,b,a,a,a,a,b,b,a,a,b,b,b,a,a,b,b,b,b,a,a,b,b,b,a,b,b,b,b,a,b,b,a,b,b,a,b,b,b,b,b,a,b,b],[]),
    q0([b,b,a,a,b,a,b,a,b,b,a,a,a,b,a,a,a,a,a,a,a,a,b,a],[]),
    q0([b,a,b,a,a,b,a,b,b,b,a,a,b,b,a,b,b,b,a,b,a,a,a,a,b,a,b,a,a,b,b,a,b,b,a,b,b,a,b,a,a,a,b,b,b,a,b,b],[]),
    q0([b,a,a,b,a,a,a,a,b,b,b,a,a,b,b,b,b,a,b,a,b,b,a,b],[]),
    q0([a,a,a,a,b,a,a,a,a,a,b,a,b,b,a,a,a,b,a,a,a,a,b,b,a,a,a,b,b,a,a,b],[]),
    q0([a,b,a,a,a,a,b,b,b,a,a,b,a,b,a,b,a,a,b,b,a,b,b,a],[]),
    q0([a,a,b,a,b,a,a,a,b,b,b,b,b,b,b,a,a,a,b,b,a,a,b,a],[]),
    q0([a,b,a,b,b,a,b,b,b,a,a,a,a,a,b,a,b,a,b,b,a,a,b,a,a,a,b,b,b,b,a,a,a,b,b,a,b,b,a,b,a,a,a,a,a,a,b,b,b,a,a,b,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,b,a,b,b,b,a,b,b,a,b,a,a,b],[]),
    q0([a,b,a,b,a,a,a,a,b,b,a,a,a,a,a,b,a,a,a,a,a,a,a,a,a,b,a,a,a,b,a,a,a,b,a,a,a,a,b,a],[]),
    q0([b,a,b,b,b,a,a,b,a,b,a,b,a,b,a,b,b,a,b,a,a,a,a,a,b,b,b,a,b,b,b,a,b,a,a,a,b,a,b,b,a,b,b,a,b,a,a,b,a,b,b,a,a,a,b,b],[]),
    q0([a,a,a,a,a,a,a,b,b,b,a,a,a,b,b,b,b,b,a,b,a,b,a,a],[]),
    q0([a,a,a,b,a,a,a,a,b,a,a,a,b,b,b,b,b,a,a,a,a,b,a,b,b,a,a,a,a,b,a,b,a,b,b,b,a,a,b,a,a,a,a,a,a,a,b,a],[]),
    q0([a,b,b,b,a,b,a,a,b,a,b,a,a,b,b,a,b,a,a,b,a,b,b,b,a,a,a,a,b,b,a,a,b,a,a,b,b,a,a,a],[]),
    q0([a,b,a,a,b,b,b,b,a,b,b,a,a,b,a,b,a,b,a,b,a,a,b,b,a,a,b,b,a,b,b,a],[]),
    q0([a,a,a,b,a,b,a,b,a,a,a,a,a,b,b,b,b,a,b,b,b,a,a,b],[]),
    q0([a,a,b,a,a,a,b,b,a,b,b,b,b,b,b,a,b,b,b,b,a,b,b,b,a,a,a,b,b,b,a,b,b,b,b,b,b,b,a,a,b,a,a,b,b,b,b,b,a,b,b,b,a,a,b,a,a,a,b,b,b,b,a,b,b,b,a,a,b,b,a,b],[]),
    q0([b,b,a,a,a,a,b,a,b,b,a,a,a,b,a,a,b,b,b,b,a,b,b,a,a,a,a,a,b,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([b,b,a,a,a,b,a,a,a,a,b,b,b,b,a,a,a,a,a,b,a,a,a,b],[]),
    q0([b,a,a,b,a,a,a,a,a,b,b,b,a,a,a,a,b,b,b,b,a,b,a,a],[]),
    q0([a,b,a,b,b,a,b,a,a,b,b,b,b,b,a,b,b,a,a,a,a,a,b,b,b,b,b,a,b,a,b,a,a,a,a,b,a,b,b,a,b,a,b,b,a,a,b,b],[]),
    q0([b,b,a,a,b,b,b,a,b,b,a,a,b,b,a,b,a,a,b,b,a,a,a,a],[]),
    q0([a,b,b,a,a,b,b,b,b,b,b,a,a,b,b,b,b,a,a,a,a,a,a,a],[]),
    q0([a,b,a,b,a,b,a,b,b,b,a,b,a,a,a,a,a,b,a,b,a,b,b,a],[]),
    q0([a,b,b,b,b,b,b,a,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,a],[]),
    q0([b,a,a,b,b,b,b,a,b,a,a,b,b,b,b,a,a,b,b,a,b,a,a,a],[]),
    q0([a,a,b,a,b,b,b,b,a,a,b,a,a,b,b,a,a,a,b,b,b,a,b,a],[]),
    q0([b,b,b,b,b,a,b,a,a,b,a,b,b,b,a,b,a,b,a,b,b,a,a,b],[]),
    q0([a,b,b,b,b,b,a,b,a,b,b,b,a,a,a,a,b,a,a,b,b,a,a,b],[]),
    q0([b,b,a,a,b,b,a,b,a,a,b,a,b,a,a,b,a,b,b,a,b,b,a,a],[]),
    q0([a,a,b,a,a,a,b,a,a,a,a,b,b,b,b,b,a,b,b,b,b,b,a,b,a,a,b,b,a,b,a,a,b,b,a,a,a,b,b,a,b,a,a,b,b,a,b,b,b,a,b,b,a,a,a,b,b,a,a,b,b,a,a,b],[]),
    q0([b,b,b,b,b,a,a,a,b,b,b,a,b,a,a,a,a,a,a,b,b,a,a,b,a,b,a,b,b,a,a,a,a,b,b,b,b,a,b,b],[]),
    q0([a,a,b,b,b,a,a,a,b,a,b,b,a,a,a,a,b,a,b,a,b,a,b,a,a,b,b,a,b,b,b,b,b,a,b,a,b,a,b,a,b,b,b,b,b,b,a,a],[]),
    q0([b,a,b,b,a,b,b,b,a,b,a,b,a,a,b,a,a,b,b,b,b,b,a,b,a,b,b,b,b,b,b,a,a,a,a,a,a,b,b,a],[]),
    q0([a,b,a,a,a,a,b,b,b,b,b,a,a,b,b,a,a,b,a,a,a,b,a,b,a,a,a,a,b,b,b,a,b,a,a,b,a,b,a,a,a,a,b,b,a,a,a,b,a,b,b,b,b,a,a,b],[]),
    q0([a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,b,a,a,b,b,a,b,a,b,b,b,b,a],[]),
    q0([b,a,b,b,a,a,b,b,a,a,a,a,b,a,b,b,a,b,a,a,a,a,a,b],[]),
    q0([b,b,b,a,a,a,a,b,b,a,b,a,a,a,b,a,a,b,b,a,a,b,a,a],[]),
    q0([b,a,a,b,a,b,a,b,b,b,b,b,b,a,b,a,b,a,b,b,b,b,a,a,a,b,a,a,a,a,b,a],[]),
    q0([b,a,b,b,a,b,b,a,b,a,b,b,a,a,a,a,b,b,b,b,b,b,b,a,b,b,a,b,a,a,a,a,a,a,b,a,b,a,b,a,a,a,a,b,a,b,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,a,b,b],[]),
    q0([b,b,a,a,b,b,a,b,b,a,b,b,a,a,b,b,a,a,b,a,b,b,a,a,a,b,b,b,b,a,b,b,b,a,a,b,b,a,b,b],[]),
    q0([a,b,b,a,a,a,b,b,a,a,a,a,b,a,b,a,a,a,a,b,a,b,b,b,b,a,a,a,a,b,b,a,a,b,b,a,a,b,a,a],[]),
    q0([b,a,a,b,a,b,b,a,a,b,a,b,a,b,b,b,b,b,b,a,b,b,a,a,b,a,a,a,a,a,a,b],[]),
    q0([b,a,b,a,b,a,b,a,b,b,a,b,b,b,a,a,b,a,b,b,a,a,b,a],[]),
    q0([b,b,b,a,a,b,b,a,b,a,a,a,b,b,b,b,b,b,b,b,a,a,b,a,a,b,a,a,b,a,b,b,a,a,b,a,b,a,a,a,a,b,b,a,a,a,b,a,b,a,b,b,b,a,b,b,b,a,a,a,b,b,a,a],[]),
    q0([b,b,b,b,a,b,b,a,b,b,a,a,a,a,b,b,b,b,b,b,a,a,a,a],[]),
    q0([a,b,a,b,a,a,a,b,a,b,a,a,b,b,a,b,a,a,a,a,b,b,b,a,b,a,a,b,b,a,a,b,b,b,a,b,b,a,a,a,a,b,b,a,b,a,a,b,a,b,b,a,a,a,b,b,b,a,a,a,a,b,b,a,b,a,b,b,a,b,a,a,b,b,a,a,a,b,b,a,b,a,a,a,b,b,a,a,a,a,a,b,a,b,a,b],[]),
    q0([a,b,b,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,b,b,b,a,b,b],[]),
    q0([b,a,b,b,a,b,a,a,a,b,a,a,a,b,a,b,a,a,b,a,b,b,b,a],[]),
    q0([b,a,a,b,b,a,b,a,b,b,a,a,a,b,b,b,a,a,a,a,b,a,b,b,b,b,b,a,b,a,b,b,a,b,b,a,a,b,a,a,a,a,a,b,a,a,a,b,b,b,b,a,a,b,a,a,a,a,a,a,a,b,b,a,a,a,a,b,b,b,b,b,a,a,a,b,a,a,b,a],[]),
    q0([b,b,a,a,a,a,b,b,b,a,b,b,a,a,a,b,a,a,a,a,a,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([b,a,a,a,b,b,a,b,a,a,b,a,b,b,b,b,b,a,a,a,b,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,a,b,a,a,b,b,b,b,b,a,b,b,a,a,b,b,a,b,a,b,b,a,b,b,a,a,b,b,a,a,b,b,a,b,b,a,b,a,a,b,b,b,b,b,b,a,a,b],[]),
    q0([b,b,b,a,b,b,b,b,b,a,b,a,a,b,b,a,a,a,b,b,a,b,a,a,a,a,a,b,a,b,a,a],[]),
    q0([a,b,a,b,a,a,a,b,b,b,a,a,b,a,b,a,a,a,b,b,b,b,b,b,a,a,b,a,b,a,a,a,a,a,a,b,a,b,a,a,b,a,a,a,a,a,b,b,b,a,b,b,b,a,b,b],[]),
    q0([a,a,b,b,a,b,a,b,a,a,a,b,b,b,b,a,a,a,a,a,a,a,b,a],[]),
    q0([b,b,a,b,a,b,b,b,b,a,b,b,b,b,a,b,b,b,b,b,b,a,a,b],[]),
    q0([b,a,b,a,a,b,a,b,a,a,a,b,a,b,b,a,b,a,b,b,a,a,a,b],[]),
    q0([b,b,a,a,a,b,b,b,b,b,a,a,a,b,b,a,a,a,a,a,a,a,a,a],[]),
    q0([a,a,b,a,a,a,b,a,a,b,b,b,a,b,a,a,a,a,a,a,b,a,b,b,a,a,a,b,b,b,b,b,a,a,a,b,a,a,a,b,a,b,a,a,a,a,a,b],[]),
    q0([b,a,b,a,a,a,b,b,b,b,a,a,b,b,a,b,b,a,b,b,a,a,a,a,b,b,a,b,b,b,b,a,a,b,b,a,b,b,b,b,b,b,b,a,b,a,b,a],[]),
    q0([a,b,b,b,b,b,a,b,b,a,b,b,a,b,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,b,a,b,b,a,b,b,a,a,b,b,b,a,b,b,a,a,a,a,a,a,a,a,b,a,a,b],[]),
    q0([a,a,a,a,b,b,b,a,a,b,a,a,a,b,b,a,a,b,b,a,a,b,a,a],[]),
    q0([a,a,a,a,b,a,b,b,b,b,a,a,b,b,b,a,b,b,a,b,a,a,b,a],[]),
    q0([a,b,b,b,a,a,a,a,b,b,a,a,a,a,b,b,b,b,a,b,b,b,a,a,b,a,b,a,b,a,a,a,a,b,a,a,b,b,b,b,b,b,b,b,b,b,a,a,a,a,a,b,b,a,b,b],[]),
    q0([a,a,a,a,a,a,a,b,a,a,b,a,a,a,a,b,b,a,a,a,a,b,b,a],[]),
    q0([b,b,b,a,a,b,b,a,b,b,b,a,a,a,a,b,a,a,b,b,a,b,b,b,b,a,a,b,b,a,b,b],[]),
    q0([a,b,b,a,a,b,a,b,a,a,b,a,a,b,a,a,b,b,b,a,b,a,a,b],[]),
    q0([b,b,a,b,a,a,a,b,b,a,b,b,b,b,b,a,a,a,b,b,a,a,b,a],[]),
    q0([b,b,a,a,a,b,b,b,a,b,a,b,a,a,b,b,a,b,a,b,b,a,b,b,b,b,a,b,a,a,a,b,a,b,b,a,a,a,b,a,a,b,a,b,b,b,b,b,b,b,a,b,a,b,b,a],[]),
    q0([b,a,b,a,a,b,a,b,b,a,b,a,b,a,b,b,b,b,a,b,a,b,a,a],[]),
    q0([a,a,a,b,b,b,b,b,b,b,a,a,a,b,a,a,a,b,b,b,b,a,a,b],[]),
    q0([a,b,b,b,a,a,a,a,b,b,a,a,a,a,b,b,b,a,b,a,b,a,a,b],[]),
    q0([b,b,a,b,b,a,a,b,b,a,b,b,a,a,b,b,b,a,a,a,b,a,a,b],[]),
    q0([a,a,a,b,a,a,a,a,a,a,b,b,b,b,b,b,a,a,b,a,b,a,b,a,a,b,b,b,b,a,b,a,a,a,a,b,a,a,b,a],[]),
    q0([a,a,b,b,b,b,a,a,a,a,a,b,b,b,b,a,a,b,a,b,a,b,b,a],[]),
    q0([a,a,a,a,a,a,a,b,b,a,b,a,a,b,a,b,a,b,b,a,b,a,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,b,a,b,a,a,a,a,a,a,b,b,a,b,b,b,a,b,a,b,a,a,b,a,a,a,a,a,b,b,b,b],[]),
    q0([b,a,a,a,b,b,b,a,a,a,a,b,b,b,a,a,b,b,b,b,a,a,a,a,a,a,a,b,a,a,b,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,b,a,a,a,b,a,a,a,b,a,a,b,a,a,a,b,b,a,a,a,b,a,b,a,a,a,b,a,a,a],[]),
    q0([a,a,b,b,b,a,a,b,a,a,b,a,a,b,a,a,b,a,b,b,a,a,a,b,a,b,b,b,a,b,b,b,a,b,a,a,a,a,b,a,b,b,a,b,b,b,a,a,a,a,a,a,a,a,b,a,b,b,a,a,a,a,b,a],[]),
    q0([b,a,b,a,b,a,b,a,a,a,b,b,a,b,b,b,b,a,b,b,a,b,b,a,a,b,b,a,a,a,b,b,b,b,a,b,a,a,b,a,b,a,b,b,a,b,a,b],[]),
    q0([a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,a,b,a,b,b,b,b,b,a,b,b,b,b,a,b,b,b],[]),
    q0([b,b,a,a,a,b,a,a,b,a,b,b,a,b,a,a,b,b,b,a,b,a,b,a],[]),
    q0([b,b,b,b,b,a,a,a,b,a,b,b,b,b,b,a,a,a,a,b,b,a,a,b,b,a,a,b,b,a,a,b,b,b,b,a,b,a,a,a],[]),
    q0([b,b,a,b,b,b,b,b,a,a,a,b,b,a,b,a,b,b,a,a,a,a,b,a,b,b,a,a,b,b,a,a,b,b,b,b,b,b,a,a],[]),
    q0([a,a,b,a,b,b,a,a,a,a,a,a,b,b,b,a,a,b,b,a,b,b,b,a],[]),
    q0([a,b,a,b,a,a,a,b,b,a,a,a,b,b,b,b,a,a,b,b,b,b,a,b],[]),
    q0([b,b,a,a,a,a,b,a,a,a,a,a,a,a,a,b,b,a,b,b,b,a,b,b],[]),
    q0([a,b,b,a,a,a,a,a,a,a,a,a,a,b,b,a,a,b,b,b,b,a,b,a],[]),
    q0([b,b,b,a,b,b,a,b,b,b,b,a,a,a,a,b,b,a,a,a,a,a,a,a],[]),
    q0([b,a,a,a,b,b,b,b,b,b,b,a,b,a,a,b,a,b,b,a,a,a,a,a,b,a,a,b,a,b,b,b,a,a,a,a,a,b,a,b,a,b,a,a,a,b,a,a,a,a,a,b,b,a,a,a,b,a,a,b,a,b,b,a],[]),
    q0([a,a,b,a,b,b,a,a,a,a,b,b,b,b,b,b,a,b,a,b,b,a,b,b,b,b,b,a,b,a,a,a],[]),
    q0([a,b,a,b,a,a,a,a,a,a,b,b,b,a,a,b,a,b,a,a,a,b,b,b,b,b,b,a,a,a,b,b],[]),
    q0([a,b,a,a,a,a,b,b,a,b,a,a,a,b,a,b,b,b,a,b,a,b,b,a],[]),
    q0([b,a,b,b,a,a,a,a,b,a,b,a,a,b,b,a,a,a,b,a,a,b,b,a,b,b,a,a,b,a,a,a,a,b,a,b,b,a,a,b],[]),
    q0([b,b,b,a,b,b,a,b,b,a,b,b,a,b,b,a,a,a,a,b,a,b,a,a],[]),
    q0([b,b,a,b,b,b,a,a,a,b,a,b,a,a,b,a,b,a,b,b,b,a,a,a],[]),
    q0([a,a,b,b,a,b,a,b,b,b,b,a,b,b,b,a,a,a,b,b,a,b,b,b,b,b,a,b,b,a,a,a,b,b,b,a,a,a,b,b,a,a,a,b,a,a,b,a],[]),
    q0([b,a,b,b,a,b,b,a,a,a,a,b,b,b,b,a,b,a,b,b,b,a,a,a],[]),
    q0([b,a,b,b,a,a,a,a,b,b,b,a,b,b,b,b,b,a,a,a,b,a,a,b],[]),
    q0([a,b,b,a,a,a,b,b,b,b,b,a,a,b,b,a,b,a,a,b,b,b,b,a,b,a,a,a,b,b,a,a],[]),
    q0([b,b,a,b,a,b,b,b,a,a,b,b,a,a,b,b,a,b,b,b,b,b,a,b],[]),
    q0([a,a,a,b,b,b,b,b,a,a,b,b,a,a,b,b,a,a,b,b,b,b,b,a],[]),
    q0([b,a,a,b,b,b,a,a,b,b,b,b,b,a,b,a,a,b,b,a,b,a,a,b],[]),
    q0([b,b,a,a,a,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,a,b,a],[]),
    q0([b,b,a,b,b,a,a,b,a,b,a,b,a,a,b,b,b,b,b,b,a,a,b,b],[]),
    q0([a,a,a,a,a,b,a,b,b,b,a,b,a,a,a,a,b,b,a,b,a,a,a,a,a,a,a,a,b,b,b,a,a,b,b,b,b,b,b,b],[]),
    q0([a,b,a,a,b,a,b,b,b,b,b,a,b,a,a,b,a,b,b,b,a,a,b,a,a,a,a,b,b,b,a,b,a,a,a,a,b,b,b,b,b,b,a,a,b,b,a,a,a,b,a,b,b,a,a,a],[]),
    q0([a,a,b,a,a,b,b,a,a,b,a,a,b,a,b,b,a,b,a,b,b,b,b,a],[]),
    q0([b,a,a,b,b,b,b,a,b,a,b,b,b,b,a,b,b,a,b,b,b,a,a,a],[]),
    q0([b,b,b,a,a,a,a,b,a,b,a,a,a,a,b,b,b,b,b,b,b,a,b,b],[]),
    q0([b,b,b,b,a,b,b,a,b,a,a,a,a,b,a,a,a,b,b,a,a,b,b,b,a,a,b,a,b,b,b,b,a,a,a,a,a,b,b,a],[]),
    q0([b,b,b,b,a,b,b,a,a,a,b,b,a,a,a,b,b,a,b,a,b,b,a,b,b,a,a,b,a,b,b,a],[]),
    q0([b,a,b,a,a,a,b,a,b,a,a,a,a,a,a,b,b,b,a,b,a,a,b,b,b,a,b,a,a,a,b,a,b,a,b,a,a,b,b,b,b,b,b,a,b,a,a,b],[]),
    q0([b,a,b,b,a,a,a,a,b,b,a,a,a,b,a,a,b,a,a,b,a,a,b,a],[]),
    q0([a,a,b,b,a,a,b,b,a,a,a,b,a,b,b,b,b,b,a,b,a,a,b,a],[]),
    q0([a,b,a,a,a,a,b,b,a,a,a,a,a,a,a,b,a,a,a,b,b,b,b,a,a,b,a,b,a,b,a,a],[]),
    q0([a,b,b,b,b,b,a,b,b,a,b,a,a,a,b,a,a,a,b,b,a,a,a,a],[]),
    q0([a,a,b,b,b,a,a,a,b,a,a,b,a,a,a,a,a,b,a,a,b,b,b,a],[]),
    q0([b,a,a,b,a,a,b,b,b,a,b,b,a,a,a,a,b,b,a,b,a,b,a,b],[]),
    q0([a,b,b,a,a,b,a,b,b,b,a,a,b,a,a,b,b,a,a,a,b,a,a,a,b,a,a,a,a,b,b,a,a,a,b,a,a,a,b,b,b,a,a,b,a,b,a,b,a,a,b,b,b,a,b,b],[]),
    q0([b,a,b,b,b,b,b,a,a,a,b,b,a,b,b,b,a,b,b,b,b,b,b,a,b,a,b,b,a,b,b,a,a,a,a,a,b,b,a,a],[]),
    q0([b,a,a,b,a,a,a,a,a,b,b,a,a,b,b,b,b,a,b,b,b,b,b,b,b,b,a,a,a,a,b,b,b,a,a,a,b,b,b,a,a,b,b,a,a,b,a,a],[]),
    q0([b,b,b,a,b,b,b,b,b,b,a,a,a,a,b,a,b,b,b,b,b,b,b,a,a,b,b,b,a,b,b,b,a,a,b,b,b,a,b,a],[]),
    q0([b,b,a,b,a,b,b,b,a,b,a,a,b,b,a,b,b,b,a,b,a,b,b,a],[]),
    q0([a,a,b,b,b,a,a,b,b,b,b,a,b,b,a,a,b,b,b,a,b,a,a,b],[]),
    q0([a,b,a,a,b,a,b,b,a,b,a,b,a,a,a,b,b,b,b,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,a,a,b,b,a,a,b,a,b,a,b,b,a,b,a,b,a,a],[]),
    q0([a,b,a,a,b,b,b,b,b,b,b,b,b,b,b,a,b,a,a,a,b,a,a,b],[]),
    q0([a,a,a,b,a,a,b,b,a,a,b,a,b,b,a,a,a,a,b,b,b,a,b,b],[]),
    q0([a,b,a,b,b,b,a,b,b,a,b,a,a,b,b,b,a,b,a,b,a,b,a,a],[]),
    q0([a,b,a,a,a,b,a,a,a,a,b,b,a,b,b,a,b,b,b,b,a,b,a,b],[]),
    q0([a,a,a,a,b,b,b,a,b,b,b,a,a,a,a,b,a,a,a,a,a,a,b,a],[]),
    q0([a,a,b,a,b,b,b,b,b,b,a,a,b,a,b,a,a,a,b,a,b,b,b,a],[]),
    q0([b,b,a,a,a,b,a,b,b,a,a,b,b,b,b,a,b,a,a,b,b,a,a,a],[]),
    q0([b,b,a,b,a,a,a,b,b,b,a,a,a,b,b,b,a,b,a,b,a,a,a,b,a,a,a,a,a,a,a,b,a,b,a,a,b,a,a,a,a,a,b,b,a,a,b,a],[]),
    q0([a,a,b,b,a,b,b,b,b,a,b,a,a,b,a,a,a,b,b,b,b,b,a,b,b,b,a,b,b,b,b,b,b,a,b,a,a,b,b,a,b,a,a,b,a,b,b,a],[]),
    q0([b,b,a,b,b,a,a,b,a,b,a,a,b,b,b,b,b,a,a,b,b,b,b,a,b,a,b,a,a,a,b,a,b,b,a,a,b,b,b,b,b,b,b,a,a,a,b,a],[]),
    q0([b,b,b,b,a,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,a,a],[]),
    q0([a,a,a,a,b,b,b,a,b,b,a,b,b,b,b,b,a,a,b,b,a,b,b,a],[]),
    q0([a,b,b,a,b,a,b,a,a,a,a,a,b,b,a,b,b,b,a,a,a,b,b,a,a,a,a,a,a,b,a,b,b,b,a,b,a,a,b,b,a,a,b,a,a,b,b,b],[]),
    q0([b,b,a,a,b,b,b,a,b,a,b,a,a,b,b,a,b,a,a,b,a,a,b,b,a,a,b,b,b,b,a,b,b,a,a,b,b,b,b,b],[]),
    q0([a,b,a,b,a,a,a,b,b,b,a,b,b,b,a,a,a,a,b,a,a,a,b,b,b,b,b,b,a,a,a,b,a,b,b,b,a,a,a,b],[]),
    q0([a,a,a,a,b,b,a,b,b,a,a,b,a,a,b,b,a,b,a,b,a,b,a,a],[]),
    q0([a,b,a,a,a,a,b,b,a,a,b,a,b,b,b,b,b,a,b,a,b,b,b,b],[]),
    q0([b,a,b,a,b,a,b,a,a,b,b,a,a,b,b,b,a,a,b,a,a,b,a,b],[]),
    q0([b,b,a,a,a,a,b,b,a,a,b,b,a,b,b,b,a,b,a,a,a,a,b,b,a,a,a,b,b,a,a,b,a,b,b,a,a,b,b,a],[]),
    q0([b,a,b,a,a,a,b,b,a,a,b,a,b,b,b,b,a,a,a,a,b,a,a,a,b,b,a,b,a,a,b,a],[]),
    q0([a,b,a,b,a,b,b,b,b,b,b,a,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,a,b,b,b,a,b,a,b,a,b,a,a,a,a,b,b,b,a,b],[]),
    q0([a,a,a,b,b,b,b,b,a,a,a,b,a,b,b,a,b,a,a,a,a,a,a,b,a,a,b,b,b,a,b,a,a,b,b,b,a,a,a,b],[]),
    q0([a,a,b,a,b,a,a,b,a,a,a,a,b,a,a,a,b,b,b,b,a,a,a,a],[]),
    q0([b,b,a,a,a,a,b,a,a,b,a,b,a,a,a,b,a,b,a,b,b,a,b,b,b,b,a,b,b,a,a,b,b,a,b,a,b,a,a,b,a,a,b,a,b,b,b,a,a,b,b,a,a,b,b,a],[]),
    q0([a,a,b,a,a,b,b,b,b,a,a,a,b,b,b,b,a,a,a,a,a,b,a,b,a,a,b,b,a,b,b,a,b,a,b,a,b,a,a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a,a,b,a,a,a,a,a,b,a,a,b,b,b,b,a,a,b,b,a,a,a,b,b,a,a,a],[]),
    q0([a,b,b,a,b,a,b,b,b,b,a,a,b,b,b,a,b,b,a,b,a,a,b,a,b,b,a,b,b,b,a,a,a,b,b,b,a,b,b,b,a,a,a,b,a,a,b,a],[]),
    q0([b,b,a,a,a,a,b,a,a,b,a,b,a,a,b,b,b,b,b,b,b,b,b,a,a,a,b,b,a,a,a,a],[]),
    q0([a,b,b,a,b,b,a,b,b,a,b,a,b,a,b,b,a,a,b,b,b,a,b,b],[]),
    q0([b,b,a,b,b,a,a,b,b,b,b,b,a,a,b,a,a,b,a,b,a,a,a,a,b,a,b,b,a,b,a,b],[]),
    q0([a,a,a,a,a,a,a,b,a,a,b,a,b,a,a,b,a,b,b,a,a,b,a,a],[]),
    q0([a,b,a,a,a,b,a,a,a,b,b,a,a,a,b,a,a,a,b,a,a,a,a,a],[]),
    q0([b,a,b,a,a,a,b,a,b,a,a,a,b,b,b,a,b,a,a,b,b,b,b,a,a,b,a,a,b,b,a,b,a,b,a,b,b,b,a,a,b,b,b,b,a,a,a,a],[]),
    q0([a,b,a,a,a,b,b,b,a,b,a,b,b,b,a,b,b,a,b,a,a,b,a,a,a,b,a,a,a,b,a,a],[]),
    q0([b,b,b,a,a,a,a,b,a,a,a,a,a,b,a,b,a,b,b,b,b,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,b,a,a,a,a,b,b,b,b,b,a,b,a,b,a,b],[]),
    q0([a,a,a,b,b,b,b,a,a,a,a,a,a,b,a,b,b,a,b,b,b,b,b,a,a,b,b,a,b,a,a,a,a,a,b,b,b,a,a,b,b,b,a,b,a,a,b,b],[]),
    q0([b,b,a,b,b,a,b,a,a,a,a,a,b,b,b,a,b,a,a,a,b,b,b,a,a,b,a,a,b,b,b,a],[]),
    q0([b,b,b,a,b,b,b,b,a,b,a,b,a,b,b,b,b,a,a,a,a,b,b,b,b,a,a,b,a,b,b,b],[]),
    q0([a,b,a,a,b,b,b,b,b,a,a,b,a,a,a,a,a,b,b,b,a,a,b,b],[]),
    q0([a,a,b,a,b,b,b,b,b,a,b,b,a,b,b,a,a,b,a,b,b,b,b,a],[]),
    q0([a,a,b,b,b,b,a,a,a,a,a,b,b,b,b,a,a,b,b,b,a,a,b,b],[]),
    q0([b,b,b,a,b,b,b,b,b,b,a,b,b,b,b,b,a,a,a,b,a,b,b,b,b,a,b,a,a,b,b,a],[]),
    q0([b,a,a,a,a,b,b,a,b,b,a,b,b,a,a,a,b,b,a,a,b,a,a,a,a,a,b,a,a,b,b,b],[]),
    q0([a,b,a,b,b,b,a,a,b,a,a,b,a,a,a,a,b,b,a,b,a,b,a,b],[]),
    q0([a,b,a,a,b,a,a,a,a,a,b,a,b,b,b,a,a,b,b,b,a,a,b,a,a,b,b,a,b,a,b,b],[]),
    q0([a,b,b,a,b,b,b,b,a,a,b,b,a,b,b,b,b,b,b,b,a,b,b,a,b,a,a,b,b,b,b,a,a,b,b,a,b,a,a,b],[]),
    q0([b,a,a,b,b,a,a,a,b,a,b,b,b,b,a,a,a,a,a,b,b,b,a,b,a,a,a,a,a,b,b,a],[]),
    q0([b,a,b,a,a,b,b,b,a,a,a,a,b,b,b,a,a,a,b,b,a,b,a,a,b,b,a,b,b,a,b,a,a,b,a,b,a,a,a,b,b,b,a,a,b,a,a,a],[]),
    q0([a,b,a,a,a,a,b,b,a,a,b,a,a,b,a,a,b,b,a,a,a,b,a,b,a,b,a,b,b,a,b,a],[]),
    q0([b,b,a,b,b,b,b,b,a,b,a,a,b,a,b,b,b,a,a,b,a,b,a,a],[]),
    q0([a,a,b,a,b,a,a,b,a,b,a,b,a,a,b,b,b,b,a,b,b,b,b,b,a,b,b,a,b,b,a,b,a,b,b,a,b,b,a,a,b,b,a,a,a,a,a,a,a,a,a,b,b,a,a,a],[]),
    q0([b,b,b,a,a,b,b,a,b,a,b,b,a,a,b,b,b,b,b,b,b,b,b,b],[]),
    q0([a,a,a,b,a,a,b,b,a,b,b,b,b,b,a,b,a,b,b,a,b,a,a,b],[]),
    q0([a,a,a,b,b,b,b,b,b,b,b,a,a,b,b,b,a,a,b,a,a,b,b,a,a,b,b,a,a,b,b,b,a,a,a,b,a,b,a,b,a,b,b,a,a,b,b,a],[]),
    q0([b,a,a,a,a,b,a,a,b,b,b,a,a,b,b,a,a,a,a,b,b,a,b,b],[]),
    q0([b,a,b,b,a,a,a,a,a,a,b,a,b,a,b,b,a,a,a,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,a,a,a,b,a,a,a,b,a,b,b,b,b,b,a,a,a,b],[]),
    q0([a,b,a,b,b,a,b,b,b,a,a,b,b,b,b,a,b,a,b,b,a,b,a,a,a,b,a,b,a,b,a,b,b,b,b,b,a,a,a,b],[]),
    q0([b,b,a,a,a,a,b,b,a,a,b,b,a,b,a,a,b,a,a,a,b,b,a,b,b,a,b,b,b,b,a,b,b,a,a,a,b,b,a,b,b,a,b,a,b,a,a,b],[]),
    q0([a,a,a,b,a,b,b,a,a,a,b,a,a,a,a,b,b,a,b,a,a,a,a,a],[]),
    q0([b,a,b,a,a,a,b,b,b,a,b,a,b,a,b,b,b,b,b,b,a,a,b,b],[]),
    q0([a,a,a,b,a,b,b,b,a,b,b,b,a,b,b,b,a,a,a,b,a,a,b,a],[]),
    q0([a,b,a,a,a,b,b,a,a,b,b,a,b,b,b,b,b,b,a,a,b,a,b,a,b,b,a,b,a,b,b,b,a,a,b,b,b,a,a,b,b,b,a,b,a,b,a,b,b,b,a,a,b,b,a,a],[]),
    q0([b,b,a,b,b,b,b,a,b,a,a,b,b,b,a,a,a,b,b,a,a,a,b,a],[]),
    q0([a,a,b,a,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,b,a,a,b],[]),
    q0([b,b,b,b,a,a,b,a,a,a,a,a,a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,b,b,b,b,b],[]),
    q0([a,a,a,a,b,a,a,a,b,b,b,a,a,b,a,b,b,a,b,a,b,b,b,a],[]),
    q0([b,b,a,b,b,a,b,a,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,b,b,a,b,b,b,b,b,a,b,a,a,a,a,a,b,a,a,a,b,b,b,a,a,a,b],[]),
    q0([b,a,b,b,b,b,b,b,b,b,a,a,a,b,a,a,b,b,b,b,a,a,a,b],[]),
    q0([a,b,a,b,a,a,a,a,b,a,a,b,a,a,b,b,a,b,a,b,a,b,a,a],[]),
    q0([a,a,b,a,b,a,b,b,b,b,a,a,b,b,a,b,a,a,b,a,a,b,b,a,a,b,b,b,a,a,b,b,a,b,b,a,a,b,a,a,a,b,a,b,b,b,b,a],[]),
    q0([a,b,a,a,b,b,b,b,b,a,b,a,b,b,a,a,a,b,b,b,b,a,b,b],[]),
    q0([a,b,b,a,a,b,a,b,a,a,b,b,b,b,a,b,b,b,b,b,a,a,a,b,a,a,b,b,b,a,b,a,b,a,a,a,b,b,b,a,b,a,a,b,b,a,a,b],[]),
    q0([b,b,a,b,b,a,b,a,b,b,b,a,b,b,a,b,b,a,b,a,b,a,a,a,b,b,a,a,b,a,b,a,a,a,b,a,a,b,b,b],[]),
    q0([b,b,a,a,a,a,a,b,a,b,b,a,a,b,a,b,b,b,b,a,a,b,a,a],[]),
    q0([a,a,a,b,a,b,b,b,b,b,a,b,a,b,b,b,b,b,a,a,b,b,a,a],[]),
    q0([a,a,a,a,a,b,a,b,b,a,b,b,a,b,b,a,a,a,b,b,a,a,a,b],[]),
    q0([a,b,a,a,b,b,b,b,b,a,b,b,a,a,b,b,b,a,b,a,b,a,a,b],[]),
    q0([a,a,b,b,b,a,a,a,b,b,b,a,a,a,a,b,a,b,b,a,b,a,a,b],[]),
    q0([a,b,b,a,b,a,a,b,a,b,a,b,a,b,b,a,b,b,a,b,b,b,a,a,b,b,b,b,b,a,a,a],[]),
    q0([b,a,b,b,a,b,a,a,a,b,a,a,a,b,a,b,b,b,b,b,a,b,b,b],[]),
    q0([a,a,b,b,b,b,a,a,a,a,b,a,b,b,b,b,a,b,a,a,a,b,a,a],[]),
    q0([b,a,a,b,a,a,a,a,a,a,a,b,b,a,a,b,b,a,b,a,a,b,b,b,b,a,a,b,a,b,b,a,a,a,a,b,b,b,b,a,b,a,b,b,a,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,b,a,b,a,a,a,b,a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,b,b],[]),
    q0([a,b,b,a,a,b,a,b,b,b,a,b,b,b,a,a,a,b,a,b,b,a,a,b],[]),
    q0([b,b,a,b,a,a,a,a,a,a,b,b,a,b,a,a,b,a,a,b,a,a,b,a],[]),
    q0([b,a,a,b,a,a,b,b,a,a,b,a,a,a,a,b,a,b,b,b,a,b,a,a,a,a,b,a,a,b,b,b],[]),
    q0([b,a,b,a,a,b,a,a,b,b,b,b,a,b,b,a,a,b,b,a,b,b,b,b,a,b,b,b,a,a,b,a],[]),
    q0([b,b,a,b,a,a,a,b,a,a,b,a,a,a,b,b,a,a,a,a,b,a,a,b],[]),
    q0([a,b,b,a,a,a,b,b,b,b,a,b,b,b,b,a,a,b,b,b,b,b,a,b,b,a,a,a,a,a,a,b,b,a,b,a,b,b,b,b],[]),
    q0([a,a,a,b,b,a,b,a,b,b,a,b,a,b,a,a,a,a,b,b,b,a,b,a],[]),
    q0([a,a,a,a,b,a,b,b,a,a,b,b,b,a,a,a,b,a,b,b,a,b,a,a,b,b,b,b,a,a,b,b],[]),
    q0([a,a,b,a,a,b,a,a,b,b,b,b,b,a,b,a,a,a,a,a,b,b,a,b,b,a,a,b,a,b,b,a],[]),
    q0([a,a,a,b,b,b,b,b,b,a,a,b,a,b,b,b,a,b,b,b,b,a,a,a,b,a,a,b,b,b,b,a,b,b,a,b,a,a,b,b],[]),
    q0([b,b,a,a,b,b,b,a,b,b,b,b,b,b,a,a,a,b,a,a,b,b,a,a,b,a,b,a,a,b,a,b,b,a,b,a,b,b,b,a,b,a,a,a,a,a,a,a,b,b,a,a,a,a,a,b,b,a,a,b,b,a,a,b,a,b,b,b,b,b,b,a],[]),
    q0([a,a,a,b,a,a,b,b,b,a,a,b,a,a,a,a,b,b,b,b,a,b,a,a],[]),
    q0([b,a,b,a,a,b,b,b,a,a,b,b,b,b,a,a,a,a,b,a,a,b,a,b],[]),
    q0([a,a,b,a,a,a,a,b,b,a,b,a,a,b,a,b,b,a,a,b,a,b,a,b,b,b,a,b,b,b,b,b,a,b,b,b,a,a,b,a],[]),
    q0([a,a,b,b,a,b,b,b,a,b,a,b,a,a,b,b,b,b,a,a,b,b,b,a,b,a,b,b,a,a,b,a,b,a,a,b,b,a,b,b,a,b,b,b,b,b,b,b],[]),
    q0([a,b,b,a,a,b,b,b,a,a,a,b,a,b,b,b,a,b,a,a,a,b,a,a],[]),
    q0([b,b,b,a,a,b,b,b,a,b,a,a,b,a,b,b,a,b,b,b,a,a,b,b],[]),
    q0([b,a,a,a,b,b,b,b,a,a,b,a,b,a,a,b,a,b,a,a,b,a,b,b,b,a,a,b,a,a,a,a,a,b,b,a,a,b,b,b,b,b,a,b,a,b,b,a],[]),
    q0([a,a,b,a,a,a,a,b,a,b,a,b,b,b,a,a,a,a,a,b,b,b,a,b],[]),
    q0([b,b,a,a,a,b,a,a,b,a,a,a,a,b,b,b,a,b,a,b,b,a,a,b],[]),
    q0([a,a,b,a,a,a,b,a,a,b,b,b,a,b,b,b,b,a,b,a,b,a,a,a,b,b,a,a,a,b,b,b,b,b,a,a,a,a,a,a,b,b,a,b,b,b,a,b],[]),
    q0([b,b,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,b,b,a,b,a,b,b],[]),
    q0([b,a,b,a,b,a,a,a,b,a,b,a,b,a,b,b,b,a,a,a,b,b,a,b,b,b,b,b,b,b,a,b,a,a,a,b,a,b,a,a,a,a,a,b,b,a,a,a],[]),
    q0([b,b,b,a,b,b,b,a,b,b,b,a,a,b,b,a,b,b,b,a,b,b,b,b,a,a,b,a,a,a,a,b],[]),
    q0([a,a,b,b,a,b,a,b,a,a,b,a,b,a,b,a,b,b,a,a,b,b,b,a,b,b,a,b,a,b,b,b,b,a,a,a,a,b,b,b,b,a,b,b,b,b,a,a],[]),
    q0([b,b,a,a,b,b,a,b,a,a,a,b,a,a,a,a,b,b,b,b,b,a,a,b],[]),
    q0([b,b,b,b,b,b,b,a,b,a,a,a,a,b,a,b,a,a,b,a,a,a,b,b,b,a,b,a,a,a,b,b,a,b,a,a,a,a,b,a],[]),
    q0([a,a,a,b,a,b,b,b,a,a,b,b,a,b,b,b,a,b,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,b,a,a,b,a,b,a,a,a,b,a,b,a,b],[]),
    q0([a,a,a,a,b,b,a,b,b,b,b,a,a,a,a,a,a,a,b,b,b,b,b,b,b,b,a,a,b,a,b,a,a,a,a,b,a,a,a,a,a,b,a,a,a,b,a,b,b,a,a,a,a,b,b,a,a,b,a,b,b,b,b,b,b,b,b,a,b,a,b,a],[]),
    q0([a,a,a,b,b,b,b,a,a,b,a,b,b,a,b,b,a,b,b,a,b,a,a,b],[]),
    q0([b,b,a,a,b,a,b,b,a,a,b,b,b,b,a,b,b,b,a,b,a,b,b,a,b,b,a,b,b,a,a,a,b,a,a,b,a,b,a,a,a,a,b,a,b,b,a,b,a,a,a,b,b,b,b,a],[]),
    q0([b,a,a,b,a,a,a,a,b,b,a,a,b,b,b,a,a,a,a,a,a,b,b,b],[]),
    q0([a,b,b,a,b,a,b,a,b,b,a,b,a,a,a,a,b,b,a,a,b,a,b,b],[]),
    q0([b,b,b,b,a,b,b,a,b,a,b,b,a,a,b,b,b,a,a,a,b,b,b,a,a,b,a,b,a,a,a,a,b,a,a,b,b,a,b,b],[]),
    q0([b,a,a,b,b,b,b,b,b,a,b,b,b,b,a,a,b,a,a,b,b,b,a,b],[]),
    q0([b,b,a,b,a,a,b,b,a,a,b,b,b,a,a,a,a,a,a,b,a,a,a,b],[]),
    q0([b,a,b,a,b,b,b,b,a,b,b,a,a,b,a,b,b,a,a,a,b,b,a,a,b,b,a,b,a,a,b,b,b,a,a,a,b,a,b,a,b,a,b,b,a,b,a,b,b,b,b,b,b,b,b,a,a,b,b,b,a,b,b,b,a,a,a,a,b,a,b,b],[]),
    q0([a,b,a,b,a,b,a,b,b,b,b,a,a,b,b,a,a,a,b,a,a,a,b,b,a,b,a,b,a,a,b,b,b,a,a,b,a,b,a,a],[]),
    q0([a,b,a,a,b,a,b,b,b,a,b,b,a,b,b,a,b,a,b,b,b,a,b,b],[]),
    q0([b,b,b,a,b,a,a,b,b,b,b,a,a,a,b,a,b,a,b,a,b,b,a,a,a,a,b,b,b,a,b,b,b,a,b,a,a,b,b,b,b,a,a,a,a,b,a,a,a,b,b,a,a,b,b,b,b,a,a,b,b,b,b,a],[]),
    q0([a,b,b,a,b,b,a,b,a,b,a,a,a,a,b,b,a,b,a,b,a,a,b,b,a,a,b,b,b,b,b,a,b,a,a,b,a,b,b,b],[]),
    q0([a,b,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a,a,b,a,b,a,b,b,a,a,b,b,a,b,b,a],[]),
    q0([a,b,a,a,b,a,a,a,b,a,b,b,a,a,a,a,a,a,b,b,a,a,a,a],[]),
    q0([b,b,b,b,a,a,b,a,b,a,a,b,b,a,a,a,a,b,b,b,b,a,a,b,b,b,a,b,b,b,b,a,b,a,b,a,a,a,a,a,a,a,b,b,a,b,b,a,b,a,a,a,a,a,a,a,a,b,b,b,b,b,a,b],[]),
    q0([a,a,b,b,b,b,b,b,b,a,b,a,b,a,b,b,a,b,a,a,a,a,b,a],[]),
    q0([b,a,a,a,a,a,a,b,b,b,b,a,b,b,b,b,a,a,a,a,a,b,a,a],[]),
    q0([b,b,a,a,b,a,b,a,a,a,a,a,b,b,b,a,a,a,b,a,b,a,b,b,a,a,a,b,b,b,b,b,b,b,a,a,b,a,a,a],[]),
    q0([a,a,b,a,b,a,a,a,b,a,b,a,b,a,b,a,a,a,a,a,b,b,a,b,b,b,b,a,a,a,a,a,b,a,a,b,b,a,b,b],[]),
    q0([a,b,a,a,a,b,b,a,a,b,a,a,b,a,a,a,a,b,b,b,a,b,a,b],[]),
    q0([a,b,a,a,a,b,b,b,a,b,a,a,b,a,b,b,b,b,a,a,b,a,a,a],[]),
    q0([a,b,a,b,b,b,a,b,a,a,b,a,a,a,a,b,a,a,b,a,b,b,a,b],[]),
    q0([a,a,a,a,b,a,b,a,a,b,a,a,a,a,b,b,a,b,b,a,a,a,a,b],[]),
    q0([b,b,a,a,a,a,b,a,b,b,b,b,b,a,b,a,a,b,b,b,b,a,a,a],[]),
    q0([b,b,b,a,b,a,b,b,a,b,a,b,a,a,b,b,a,a,a,a,b,a,a,b],[]),
    q0([b,a,b,a,b,a,a,a,a,b,b,a,b,b,b,b,a,b,b,a,b,b,b,b,a,b,a,a,a,b,a,b,a,a,a,b,b,b,b,b,a,a,b,a,b,a,a,b,b,b,a,a,b,b,b,b],[]),
    q0([a,b,b,b,b,a,b,b,b,b,a,b,b,a,a,a,a,a,b,a,b,a,b,b,b,b,a,b,a,a,b,b],[]),
    q0([a,b,a,b,b,a,a,b,b,b,a,b,a,a,b,b,b,b,a,a,b,a,b,b,b,b,a,a,b,b,b,b,a,b,a,a,b,a,a,a],[]),
    q0([a,a,a,b,a,b,b,a,b,b,a,b,b,a,a,b,b,b,a,a,b,b,a,a],[]),
    q0([b,a,b,a,b,a,b,b,a,b,a,a,a,a,b,b,b,b,b,b,b,b,a,a],[]),
    q0([b,b,a,a,b,b,a,b,b,b,a,b,b,b,b,a,b,b,b,a,b,b,a,a,b,a,a,a,a,a,a,a,a,b,a,a,b,a,b,a],[]),
    q0([a,a,a,a,b,a,b,b,a,a,b,a,a,a,b,a,a,a,a,b,a,a,b,a],[]),
    q0([b,a,a,a,a,a,a,b,b,a,a,a,b,b,b,a,a,a,a,a,b,a,b,b,a,a,a,b,b,b,b,b,a,b,b,a,b,a,a,a],[]),
    q0([a,a,b,b,a,b,b,b,b,b,a,a,a,b,a,a,b,a,a,b,b,b,b,a],[]),
    q0([a,a,a,a,b,b,b,a,b,b,a,a,a,a,b,b,b,a,a,b,b,a,a,a],[]),
    q0([a,b,b,a,b,b,b,b,a,b,a,a,a,a,b,a,a,b,b,b,b,a,b,b,a,b,b,b,b,a,a,a,a,a,b,a,a,a,b,b,b,b,b,a,b,b,b,b,b,a,b,b,b,b,a,a,b,b,a,a,b,b,b,a],[]),
    q0([b,b,a,b,a,b,b,b,a,a,b,a,a,b,a,a,b,b,b,a,a,a,a,b,b,b,b,a,a,a,b,b],[]),
    q0([a,b,a,b,a,a,b,a,a,a,b,b,a,b,a,b,a,b,b,b,b,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,a,b,a,a,a,b,a,b,a,b,b,a,b,a,a,a],[]),
    q0([b,a,b,a,a,b,a,a,a,b,a,a,b,a,b,b,b,b,b,a,b,a,a,a],[]),
    q0([b,a,b,b,b,b,b,b,b,a,b,b,b,b,b,a,b,b,b,b,a,a,b,b],[]),
    q0([b,b,b,b,a,b,b,a,a,b,b,a,b,b,b,b,a,a,a,b,a,a,b,b],[]),
    q0([b,b,b,a,a,b,b,b,b,b,a,a,a,a,b,a,b,b,a,b,a,b,b,b,b,b,b,a,a,a,a,a,b,b,a,b,a,b,a,b],[]),
    q0([b,a,a,b,b,a,b,a,a,b,b,b,b,a,b,b,a,a,a,a,a,b,b,a],[]),
    q0([b,b,b,a,a,a,a,b,b,b,a,a,b,b,a,b,b,a,a,a,b,b,a,a,b,a,b,a,b,b,b,b,a,b,b,b,a,b,a,b,a,a,b,b,a,b,b,a,a,a,b,a,a,b,a,b],[]),
    q0([b,b,b,a,b,b,a,a,b,a,b,a,a,a,b,b,a,a,b,a,b,b,a,a,b,a,a,b,a,a,b,a],[]),
    q0([b,b,b,a,a,b,a,b,b,a,b,b,b,b,b,b,a,b,a,b,a,a,b,a,a,a,b,a,b,a,a,b,a,a,b,b,a,b,b,a],[]),
    q0([a,b,b,a,a,b,a,b,b,a,a,b,b,b,a,a,b,b,a,a,b,b,a,a],[]),
    q0([b,a,b,b,a,a,b,b,b,a,b,b,a,b,a,a,b,b,b,b,a,a,b,b],[]),
    q0([a,a,a,a,b,a,a,a,a,b,a,b,a,a,a,b,b,b,b,b,a,a,a,b],[]),
    q0([a,b,b,b,a,a,a,a,a,a,b,a,a,b,a,a,b,a,a,b,a,b,b,a],[]),
    q0([a,a,b,a,a,a,b,a,a,a,a,a,b,a,b,b,a,a,a,a,b,a,b,b,b,a,b,a,b,b,b,a,a,a,a,b,a,b,a,a],[]),
    q0([a,a,a,b,b,b,b,a,b,b,b,a,b,b,b,a,b,a,a,a,a,a,b,b],[]),
    q0([a,a,b,b,a,b,a,b,a,b,a,a,a,b,b,b,a,b,b,a,a,a,a,a],[]),
    q0([b,a,b,a,a,b,a,a,b,a,a,b,a,a,a,a,b,b,a,a,a,a,a,b,b,a,b,b,b,b,a,a],[]),
    q0([b,b,a,b,b,b,b,a,b,a,b,a,b,b,b,b,a,b,a,b,a,b,a,a,a,b,a,a,a,a,a,b,b,b,b,b,a,a,a,b],[]),
    q0([b,a,a,b,a,b,b,a,b,b,b,b,a,b,b,a,a,a,a,b,b,b,b,b,b,b,a,b,b,a,a,b,a,a,b,a,b,b,a,a,b,a,a,a,a,a,b,a,b,b,a,b,b,a,a,a,a,b,a,b,a,b,b,b,b,b,b,b,b,a,b,b,a,b,a,a,a,b,b,b,b,a,b,b,a,b,b,b],[]),
    q0([a,b,a,b,b,b,a,a,a,b,a,b,b,a,b,b,b,a,b,a,b,a,b,b,a,a,a,b,a,a,a,a,b,a,b,b,a,b,a,b,b,b,a,a,b,b,a,a,a,a,a,a,a,b,b,b,b,b,a,a,b,a,b,b,b,b,a,a,b,b,b,b],[]),
    q0([a,b,a,a,b,b,a,b,a,a,b,a,b,a,a,b,a,b,b,a,a,a,b,a,a,a,a,a,b,b,b,b,a,b,a,b,b,b,b,a,a,b,a,b,b,a,b,b],[]),
    q0([b,a,b,b,a,b,a,a,a,a,b,a,a,b,a,a,b,a,b,a,a,a,b,b,a,a,a,b,a,b,a,a],[]),
    q0([a,a,a,a,a,b,a,b,b,b,b,a,b,b,a,a,a,b,b,b,a,a,a,a,b,b,a,a,b,b,b,b],[]),
    q0([b,b,b,a,b,b,b,b,a,a,b,b,b,a,a,b,b,b,b,b,a,b,a,b],[]),
    q0([b,a,b,b,b,b,b,b,b,a,a,b,b,b,b,a,a,a,a,b,b,a,b,b],[]),
    q0([a,b,b,a,a,a,b,b,b,b,a,b,b,a,a,b,b,b,a,a,a,a,a,a],[]),
    q0([b,b,a,b,b,a,a,b,b,a,b,a,a,a,b,a,b,a,a,a,a,a,a,b,a,a,a,b,a,a,b,a,a,a,b,b,a,a,a,b],[]),
    q0([b,b,a,b,b,a,b,b,b,b,b,a,a,a,a,a,b,b,a,b,a,a,b,b,a,b,b,b,b,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,a,a,b,a,a,a,b,b,a,a],[]),
    q0([b,b,a,b,b,a,a,a,a,a,b,a,b,b,b,a,a,a,a,b,b,a,b,b],[]),
    q0([b,b,a,a,b,a,b,a,a,b,b,a,a,a,b,b,b,a,a,b,b,b,a,b],[]),
    q0([b,a,b,a,a,a,b,a,a,a,a,a,a,a,a,a,b,a,b,b,b,a,a,a],[]),
    q0([a,b,b,a,b,a,b,a,b,a,a,b,b,b,b,a,b,b,a,b,a,b,b,b,a,b,b,a,b,a,a,b],[]),
    q0([b,b,b,a,a,a,a,b,b,a,b,b,b,b,b,b,a,b,b,a,a,b,a,a],[]),
    q0([a,b,b,a,a,a,b,b,a,a,a,a,a,a,a,b,a,a,a,b,a,b,a,a],[]),
    q0([b,a,a,b,b,b,b,a,a,b,a,a,b,a,a,a,a,b,b,b,b,b,a,a],[]),
    q0([a,b,b,b,a,b,b,b,a,a,b,b,b,b,b,a,b,b,b,a,b,a,b,a],[]),
    q0([b,b,a,b,a,a,a,b,b,a,b,a,b,a,b,b,b,b,b,a,a,a,b,b],[]),
    q0([a,b,a,b,a,b,a,b,b,a,b,a,b,a,b,b,a,b,a,b,a,b,a,a],[]),
    q0([b,b,a,a,a,b,a,a,b,b,a,b,a,a,a,b,b,a,a,a,a,a,a,a],[]),
    q0([a,b,b,a,a,b,a,b,b,b,a,a,a,b,b,a,a,b,a,b,b,b,a,a,b,a,b,b,b,a,b,a],[]),
    q0([b,b,a,b,a,b,b,b,a,a,a,a,b,a,a,a,a,b,a,a,a,b,a,a],[]),
    q0([a,b,b,a,b,b,a,b,a,a,a,b,b,b,b,a,a,b,a,b,a,a,b,a,b,b,b,b,a,b,b,b],[]),
    q0([b,a,a,a,b,a,b,a,b,a,b,a,a,b,b,b,a,b,b,a,b,a,b,a,b,b,b,b,b,a,a,a],[]),
    q0([a,a,b,a,b,a,b,a,b,a,b,a,b,a,b,b,a,b,b,a,a,b,b,b,b,b,b,b,b,a,b,a,b,a,a,a,a,b,a,a,b,b,a,b,b,a,b,b,b,a,b,b,b,a,b,b],[]),
    q0([b,a,a,a,a,b,a,a,b,b,a,a,a,a,a,b,a,a,b,a,a,a,a,b,a,a,a,a,b,a,a,a,a,a,b,a,b,b,b,a,a,b,a,a,a,a,a,b],[]),
    q0([b,a,a,b,b,a,a,b,b,a,a,b,b,b,a,b,b,b,b,a,b,a,a,b],[]),
    q0([a,b,b,b,a,b,b,b,b,b,b,a,a,a,a,a,b,a,b,a,b,a,a,a,b,b,a,b,b,b,a,a,b,a,a,a,b,a,a,b,b,b,a,a,b,a,b,b],[]),
    q0([b,b,b,b,b,a,b,a,a,b,a,a,a,a,b,b,b,b,b,a,b,b,a,a,a,b,a,b,a,a,a,b,b,b,a,b,a,a,a,a,a,a,a,a,b,b,b,b,a,a,b,b,a,a,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,a,a,a,b,a,b,b,a,b,b,b,a,a,b],[]),
    q0([a,b,a,a,a,b,b,a,b,b,a,a,a,b,a,b,b,a,a,a,b,a,b,a,a,b,a,b,b,b,a,b,b,b,a,a,a,a,b,a,b,b,b,b,a,b,b,b,a,a,a,a,b,a,a,b],[]),
    q0([b,b,a,b,a,a,b,b,b,a,b,b,a,b,a,a,a,b,a,a,b,a,b,b,a,a,a,b,a,a,a,b],[]),
    q0([a,b,b,a,b,a,b,a,b,a,b,b,a,b,b,b,a,b,b,a,b,b,b,b,a,a,a,b,a,b,b,b,a,a,b,b,b,b,a,b,a,b,b,b,a,a,b,b],[]),
    q0([b,a,b,b,a,a,b,b,b,b,b,a,a,b,b,b,a,b,b,b,b,a,a,a],[]),
    q0([a,b,b,b,a,b,a,a,b,b,a,a,a,b,a,b,a,b,a,b,a,b,a,b,a,b,a,a,a,b,a,a],[]),
    q0([a,b,b,b,a,b,a,a,a,a,a,a,b,a,b,b,a,b,a,a,a,b,b,a,a,b,b,b,b,b,b,b,a,b,b,b,a,a,a,b],[]),
    q0([a,a,b,b,b,b,a,a,b,b,a,a,a,a,a,b,a,b,a,b,b,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([a,b,a,b,a,a,a,a,b,b,b,b,b,b,b,a,a,b,a,b,a,a,b,b,b,b,a,b,b,b,b,a,b,b,b,a,a,a,b,a,a,a,b,b,b,a,b,a],[]),
    q0([a,a,a,b,a,a,b,b,b,b,a,a,b,b,b,a,a,b,b,a,b,a,a,b],[]),
    q0([b,b,b,a,a,a,b,a,a,a,a,a,a,b,a,b,a,a,a,b,a,a,a,a,b,a,b,b,b,b,a,a,a,b,a,b,b,b,a,a,a,a,a,a,b,b,a,a,b,a,a,a,a,b,b,a,a,a,a,b,b,a,a,a,a,b,b,a,b,a,a,a,a,b,a,a,a,b,a,b,b,a,b,b,b,a,a,a],[]),
    q0([a,b,a,b,a,a,a,b,a,b,b,a,b,b,b,b,b,b,b,a,b,b,b,b,a,b,a,b,a,b,b,b,b,a,a,b,b,b,a,b],[]),
    q0([a,b,b,b,a,b,b,b,a,b,b,a,b,b,b,b,a,b,a,a,a,b,b,b,a,a,a,a,a,a,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,b,b,b,b,a,a,b,a,b,a,b,a,b,a,b,b,b,b,b,b,b,b],[]),
    q0([a,b,b,a,b,b,a,b,b,a,b,a,a,b,b,b,b,b,a,b,a,b,a,b],[]),
    q0([b,b,b,b,a,b,b,a,b,b,b,a,b,b,b,a,a,a,b,b,b,b,b,b,b,a,b,b,b,a,a,b],[]),
    q0([b,a,a,b,b,b,b,a,b,b,b,b,b,b,b,a,b,b,b,b,a,b,a,b],[]),
    q0([b,b,a,a,a,b,a,a,b,b,a,b,b,a,a,b,b,b,b,b,b,b,a,b],[]),
    q0([b,a,a,a,b,a,b,a,b,b,b,a,a,a,a,a,a,a,b,a,b,b,b,b,b,b,b,b,a,b,a,a,a,a,b,b,a,a,b,a,b,a,a,b,a,b,b,a,b,a,b,b,a,a,a,b],[]),
    q0([a,a,b,a,b,a,a,b,b,a,a,a,b,a,b,a,b,a,a,b,a,a,a,b],[]),
    q0([b,b,b,a,a,a,b,b,b,a,b,b,a,b,b,a,a,b,b,a,b,b,b,a,a,b,a,a,b,b,a,b,b,a,b,a,a,a,a,a,b,b,b,b,a,a,a,a,b,b,a,b,a,a,b,b,a,b,a,a,b,a,a,b],[]),
    q0([b,a,b,a,a,a,b,b,b,a,b,b,a,a,b,b,a,b,a,a,a,a,a,a,b,b,b,b,b,b,a,a,a,b,a,a,a,b,a,a],[]),
    q0([b,b,a,a,a,b,b,a,a,b,a,a,b,a,a,a,a,b,b,a,a,b,a,a],[]),
    q0([b,b,a,a,a,a,b,b,a,a,b,b,a,b,b,b,a,b,a,b,b,a,b,a],[]),
    q0([b,a,a,a,a,a,a,a,b,b,a,b,a,a,a,b,b,b,b,b,a,a,a,a,a,a,a,b,a,b,a,a,a,b,b,b,a,a,a,a,a,a,a,b,a,a,b,a,b,b,a,b,b,b,b,b,b,b,b,a,a,b,a,a,a,a,a,a,a,b,b,a,a,b,b,a,b,a,b,b],[]),
    q0([a,b,a,b,b,b,a,b,b,b,a,a,b,a,b,a,b,b,a,b,a,b,a,b],[]),
    q0([a,b,b,b,b,a,b,a,b,b,b,a,b,b,b,b,b,a,a,b,b,b,a,a,b,b,b,b,a,a,b,b,a,a,a,a,a,b,b,b,a,a,a,b,a,b,a,b],[]),
    q0([b,b,a,a,a,a,b,a,a,a,b,b,b,a,a,a,b,a,b,b,a,a,b,a],[]),
    q0([a,a,b,a,a,b,b,a,b,b,b,a,a,b,b,a,a,b,a,b,a,a,a,b,a,b,a,a,b,a,a,b,b,a,a,a,b,a,b,b],[]),
    q0([b,b,a,b,b,a,a,b,b,b,a,a,a,a,b,b,a,a,a,b,b,a,a,a],[]),
    q0([a,b,b,b,b,a,b,a,b,a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,b,b,a,b,b,b,a,a,b,a,a,b,a,b,a,a,b,a,a,b,b,b,a,b],[]),
    q0([b,b,b,b,b,a,b,a,b,a,b,b,a,a,a,a,b,a,b,a,a,a,b,b,b,a,b,b,b,a,b,a],[]),
    q0([b,a,a,b,a,a,a,a,a,b,a,b,a,b,b,b,a,b,b,a,a,a,a,b],[]),
    q0([b,a,b,b,a,b,a,a,b,a,b,a,a,a,b,b,a,b,a,a,a,a,a,b],[]),
    q0([b,b,b,a,a,a,a,a,a,a,a,a,a,b,b,b,b,b,a,a,a,a,b,a,a,b,b,b,b,a,a,a,b,a,b,b,a,a,a,a],[]),
    q0([a,b,b,a,b,b,b,b,a,b,a,a,a,a,b,b,a,b,a,a,b,a,a,a,a,a,a,b,a,a,a,a,b,b,a,a,a,a,b,a],[]),
    q0([b,b,b,a,a,b,b,b,b,b,a,b,a,a,b,b,b,b,a,b,a,a,a,a,a,a,a,b,a,a,a,a,b,b,b,a,b,a,a,a],[]),
    q0([a,a,a,a,a,b,a,b,a,b,a,b,b,b,a,b,b,b,a,b,a,b,b,a],[]),
    q0([a,a,a,b,a,b,b,a,a,b,a,b,a,b,a,b,a,a,a,a,a,a,a,b,a,b,b,b,b,a,a,b],[]),
    q0([a,a,a,a,b,a,a,a,a,b,b,a,b,a,b,a,a,a,a,b,b,a,b,a,b,a,b,b,a,a,a,a,a,a,a,b,a,a,a,b,b,b,a,a,b,b,b,b,a,b,b,a,a,a,a,a],[]),
    q0([a,a,a,a,a,a,a,b,a,b,a,a,b,a,a,a,b,a,b,b,a,a,a,b],[]),
    q0([a,b,a,b,a,a,a,a,b,a,a,a,b,a,b,a,a,b,a,a,b,a,a,b],[]),
    q0([b,a,b,a,a,b,a,a,b,a,a,b,a,b,a,b,a,b,b,a,b,a,b,b],[]),
    q0([b,b,b,a,b,b,b,b,a,a,b,b,b,a,a,a,b,b,b,b,b,b,a,a],[]),
    q0([a,b,b,b,b,b,a,b,a,b,a,a,a,b,a,b,b,a,b,b,b,b,a,a],[]),
    q0([b,a,b,a,b,b,a,a,b,b,b,b,b,a,a,b,b,b,a,a,a,a,b,b,a,a,a,b,b,b,a,a,b,b,a,a,a,a,b,b,a,b,b,a,a,a,b,b],[]),
    q0([b,a,a,a,a,b,b,b,b,b,a,a,a,a,b,b,a,a,a,b,b,b,a,a,a,a,b,b,a,a,a,a,b,a,b,a,b,b,b,b],[]),
    q0([a,a,a,a,a,a,a,b,a,b,b,a,b,b,a,b,b,a,a,b,b,a,a,b],[]),
    q0([b,b,a,a,b,b,a,b,b,b,a,b,a,b,b,b,a,a,b,b,a,b,b,b,b,b,a,b,a,a,b,a],[]),
    q0([a,b,a,a,b,b,a,b,a,a,b,b,b,a,a,b,a,a,a,b,a,b,a,a],[]),
    q0([b,b,b,a,b,b,b,b,b,b,a,a,b,a,b,a,b,b,b,b,a,a,b,a,a,b,b,b,a,b,b,b,b,a,a,a,b,b,a,a],[]),
    q0([a,a,b,b,a,a,b,b,b,b,b,a,b,b,b,b,a,b,b,a,b,b,b,b,b,b,b,a,b,a,a,b,b,a,a,b,a,b,b,a],[]),
    q0([b,a,b,a,a,b,a,a,b,b,a,a,a,a,b,b,a,b,a,b,a,a,b,b,b,b,a,b,a,a,a,a],[]),
    q0([b,a,b,b,a,a,a,a,b,b,b,a,a,a,a,b,b,b,b,b,b,a,a,a],[]),
    q0([b,b,a,b,b,a,b,b,b,b,a,b,a,b,b,a,a,b,b,b,b,a,a,b,b,b,b,b,a,a,b,b,a,b,a,b,a,b,a,b,a,a,b,b,b,a,b,b,a,a,b,a,b,b,b,b],[]),
    q0([b,b,a,b,b,b,b,a,b,a,a,a,b,b,b,b,b,a,a,b,b,a,b,a],[]),
    q0([a,a,a,b,a,b,b,b,a,a,b,b,b,a,a,b,b,a,a,b,a,b,a,a,a,b,b,b,b,a,b,b,b,b,b,b,b,b,a,a],[]),
    q0([b,a,a,b,b,b,a,a,b,b,b,b,a,b,a,a,a,a,b,a,b,b,a,b,a,b,b,a,b,b,b,a,a,b,b,a,b,a,b,b,a,a,b,b,b,a,a,a],[]),
    q0([a,a,a,a,b,b,b,a,b,b,a,a,a,b,b,a,a,a,a,a,a,b,a,a],[]),
    q0([b,b,b,b,a,a,b,a,b,b,a,a,b,b,a,b,a,b,a,a,a,b,b,b,a,a,a,b,a,b,a,b],[]),
    q0([a,a,b,b,a,a,a,a,a,a,b,b,b,a,b,b,b,b,b,a,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,b,b,b,b,a],[]),
    q0([a,a,a,a,b,b,a,b,a,b,a,b,a,a,b,b,a,a,a,b,b,a,a,b],[]),
    q0([b,b,b,a,a,a,a,a,a,b,b,b,b,b,a,b,b,a,b,a,a,b,a,b,a,a,b,a,a,a,b,a,a,a,a,b,b,b,b,a,a,a,a,b,b,a,a,b,a,b,a,b,b,a,a,b,a,b,a,a,a,b,a,a],[]),
    q0([a,b,a,a,b,b,b,b,b,b,b,a,b,b,b,b,a,a,a,a,a,b,b,b],[]),
    q0([a,b,a,b,a,a,b,b,a,a,a,a,a,b,a,b,b,a,a,a,a,b,a,b,a,b,a,b,b,a,a,b,b,b,b,b,a,a,a,b],[]),
    q0([a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a,b,b,a,b,b,b,a,b,a,a,a,b,a,b,a,a],[]),
    q0([b,b,a,a,b,b,a,b,a,a,a,b,b,b,b,b,b,b,a,b,b,b,b,b,b,b,b,b,a,a,a,b,a,b,a,b,b,b,b,b],[]),
    q0([a,b,b,a,a,b,b,b,a,a,b,a,a,a,b,b,b,b,b,b,b,a,a,a],[]),
    q0([a,b,a,a,b,b,b,b,a,a,a,a,b,a,b,b,a,b,a,b,a,a,b,a,b,a,b,b,b,b,a,a],[]),
    q0([a,a,b,a,b,b,b,b,b,a,a,b,a,b,a,b,b,a,b,b,a,b,b,a,a,a,a,a,b,a,a,a,b,b,b,b,b,b,a,a],[]),
    q0([b,a,b,b,a,b,b,b,b,b,b,b,a,b,b,a,a,a,a,a,a,a,a,b,a,b,a,b,a,a,b,b,a,a,b,b,a,b,a,b,a,b,a,a,b,a,b,a],[]),
    q0([a,a,b,b,a,b,a,a,b,b,a,a,a,b,b,b,a,b,a,b,a,a,a,b,a,b,a,a,a,b,b,b,a,a,a,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,a,a,b,b,b,a,a,b,a,b,a,a,b,a,b,b,b,b,b,b,a,a,a,a,a,a],[]),
    q0([a,b,b,a,a,a,b,b,b,a,a,a,b,b,b,a,a,b,a,b,b,a,b,a],[]),
    q0([a,a,a,a,a,a,b,b,b,a,a,b,a,b,b,a,b,a,a,b,b,a,b,b,a,a,a,a,b,a,a,b,b,b,a,b,b,a,b,a,a,b,a,a,a,a,b,b,b,a,b,b,b,b,a,b,a,b,b,b,a,b,a,b],[]),
    q0([a,a,a,b,a,b,b,b,a,b,a,b,b,a,b,b,b,b,b,a,a,b,a,b,a,b,b,a,b,a,b,a,a,b,a,b,a,a,a,a,b,b,a,a,b,b,a,a],[]),
    q0([b,b,a,b,a,a,b,b,b,a,b,b,b,b,b,a,a,a,a,a,a,a,a,b,b,a,b,a,a,b,a,b,a,a,a,a,a,a,a,b],[]),
    q0([b,b,a,a,a,b,b,a,b,a,a,b,a,a,b,b,b,a,a,a,a,a,b,a],[]),
    q0([b,b,b,b,b,a,b,a,a,a,a,a,a,b,a,b,b,a,b,a,b,a,b,a,a,b,a,a,a,a,a,b],[]),
    q0([b,b,b,a,a,b,b,b,b,b,a,b,a,b,b,b,a,a,b,a,b,b,a,b],[]),
    q0([b,a,b,a,a,b,b,a,a,b,a,a,a,b,b,b,a,b,b,b,a,b,a,b],[]),
    q0([a,b,a,a,a,a,a,a,b,a,b,b,a,a,a,a,a,a,b,b,a,b,b,a],[]),
    q0([b,a,b,a,b,a,b,b,a,b,a,b,b,b,a,a,b,a,b,a,a,b,a,b,b,a,b,b,b,b,b,a,a,b,b,a,a,b,b,b,b,b,b,b,b,a,a,a,b,a,b,b,b,a,b,a],[]),
    q0([a,b,a,b,a,a,a,a,a,b,b,a,b,b,a,b,a,a,a,a,a,b,b,a,a,b,b,a,b,b,b,a],[]),
    q0([b,b,a,a,a,b,a,a,b,a,a,a,a,b,a,a,b,a,b,b,b,a,b,a],[]),
    q0([a,b,a,b,b,a,b,b,a,b,a,b,b,b,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,a,a,a],[]),
    q0([b,a,a,a,b,b,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,b,b],[]),
    q0([a,a,a,b,a,a,b,b,a,b,a,b,b,b,a,b,a,a,a,a,b,b,b,b],[]),
    q0([b,a,b,b,b,b,a,b,a,b,a,b,a,b,a,b,a,a,a,b,b,b,b,b,b,a,b,b,b,a,b,b],[]),
    q0([a,a,a,b,b,b,b,b,a,a,b,a,a,a,a,b,b,a,b,a,b,a,b,b,b,b,a,b,a,b,b,a,a,a,b,a,a,a,a,a],[]),
    q0([b,a,b,b,a,a,b,b,a,b,b,a,a,b,b,b,a,a,b,a,b,b,b,b],[]),
    q0([a,a,b,a,b,a,a,b,b,a,b,b,a,a,a,a,a,a,b,b,b,b,b,a],[]),
    q0([b,a,b,a,a,b,b,a,a,b,a,a,b,a,a,a,b,b,b,b,a,a,b,a,b,a,b,a,a,a,b,a,a,a,b,b,b,a,a,a,b,b,a,b,b,a,b,b,a,a,b,a,b,b,a,b],[]),
    q0([a,b,a,a,b,a,a,a,b,a,a,b,b,b,a,b,b,b,a,b,a,a,b,a,b,a,a,a,b,b,a,a,b,a,a,b,a,b,b,a,b,a,b,a,a,b,b,a,b,b,b,b,a,b,b,b,a,b,b,a,b,a,a,a,b,a,a,a,a,b,a,a,a,a,b,a,b,b,b,a,b,b,b,b,a,b,a,a],[]),
    q0([b,b,b,a,b,b,b,a,a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a],[]),
    q0([b,b,a,b,b,a,a,a,b,a,a,b,a,b,b,b,b,a,a,a,b,a,b,b,a,a,b,b,a,b,b,b,a,a,b,b,b,b,b,b,b,a,b,a,a,b,a,a,a,b,a,a,b,a,a,a,a,a,b,a,b,b,b,b],[]),
    q0([b,a,b,b,b,a,b,a,a,b,b,a,b,b,b,b,b,a,b,b,b,b,a,b,a,a,b,b,a,a,a,a],[]),
    q0([a,b,a,b,a,a,a,a,a,b,b,b,b,a,b,a,a,b,a,b,b,a,b,b,b,a,a,a,b,a,b,a,a,a,a,a,b,a,a,a,b,a,a,b,b,a,a,b,a,b,b,a,b,a,b,b],[]),
    q0([a,b,b,a,b,a,b,a,b,b,b,a,b,b,b,b,b,b,b,a,a,a,b,b],[]),
    q0([b,b,a,b,a,a,a,a,b,b,b,b,b,b,b,a,a,a,b,b,b,a,b,a],[]),
    q0([b,b,a,a,b,b,b,a,b,a,b,a,a,b,a,b,b,b,b,b,a,b,b,b],[])
]).

count([],0).
count([G|GS],N) :- G -> (count(GS,N1), N is N1+1) ; count(GS,N).
 */

/* B
q50(W0,W2) :- q5(W0,W1),q18(W1,W2),true.
q50(W0,W2) :- q61(W0,W1),q39(W1,W2),true.
q79(W0,W2) :- q118(W0,W1),q18(W1,W2),true.
q79(W0,W2) :- q125(W0,W1),q39(W1,W2),true.
q102(W0,W2) :- q38(W0,W1),q39(W1,W2),true.
q102(W0,W2) :- q19(W0,W1),q18(W1,W2),true.
q114(W0,W2) :- q39(W0,W1),q38(W1,W2),true.
q114(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q119(W0,W2) :- q39(W0,W1),q103(W1,W2),true.
q40(W0,W2) :- q39(W0,W1),q72(W1,W2),true.
q40(W0,W2) :- q18(W0,W1),q38(W1,W2),true.
q10(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q10(W0,W2) :- q39(W0,W1),q132(W1,W2),true.
q44(W0,W2) :- q51(W0,W1),q39(W1,W2),true.
q44(W0,W2) :- q118(W0,W1),q18(W1,W2),true.
q18(W0,W1) :- W0 = [a | W1],true.
q55(W0,W2) :- q18(W0,W1),q33(W1,W2),true.
q55(W0,W2) :- q39(W0,W1),q4(W1,W2),true.
q101(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q101(W0,W2) :- q39(W0,W1),q100(W1,W2),true.
q28(W0,W2) :- q110(W0,W1),q39(W1,W2),true.
q28(W0,W2) :- q96(W0,W1),q18(W1,W2),true.
q11(W0,W2) :- q42(W0,W1),q31(W1,W2),true.
q11(W0,W3) :- q42(W0,W1),q11(W1,W2),q31(W2,W3),true.
q92(W0,W2) :- q26(W0,W1),q39(W1,W2),true.
q92(W0,W2) :- q110(W0,W1),q18(W1,W2),true.
q2(W0,W2) :- q18(W0,W1),q93(W1,W2),true.
q2(W0,W2) :- q39(W0,W1),q44(W1,W2),true.
q27(W0,W2) :- q73(W0,W1),q18(W1,W2),true.
q27(W0,W2) :- q135(W0,W1),q39(W1,W2),true.
q0(W0,W2) :- q8(W0,W1),q11(W1,W2),true.
q8(W0,W1) :- q42(W0,W1),true.
q8(W0,W2) :- q42(W0,W1),q8(W1,W2),true.
q14(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q41(W0,W2) :- q109(W0,W1),q39(W1,W2),true.
q41(W0,W2) :- q58(W0,W1),q18(W1,W2),true.
q4(W0,W2) :- q64(W0,W1),q39(W1,W2),true.
q4(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q85(W0,W2) :- q65(W0,W1),q18(W1,W2),true.
q85(W0,W2) :- q27(W0,W1),q39(W1,W2),true.
q122(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q122(W0,W2) :- q18(W0,W1),q66(W1,W2),true.
q123(W0,W2) :- q103(W0,W1),q39(W1,W2),true.
q123(W0,W2) :- q72(W0,W1),q18(W1,W2),true.
q72(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q72(W0,W2) :- q66(W0,W1),q18(W1,W2),true.
q130(W0,W2) :- q18(W0,W1),q132(W1,W2),true.
q130(W0,W2) :- q39(W0,W1),q125(W1,W2),true.
q135(W0,W2) :- q39(W0,W1),q74(W1,W2),true.
q135(W0,W2) :- q18(W0,W1),q32(W1,W2),true.
q67(W0,W2) :- q18(W0,W1),q54(W1,W2),true.
q67(W0,W2) :- q39(W0,W1),q20(W1,W2),true.
q133(W0,W2) :- q39(W0,W1),q105(W1,W2),true.
q133(W0,W2) :- q18(W0,W1),q128(W1,W2),true.
q116(W0,W2) :- q71(W0,W1),q18(W1,W2),true.
q116(W0,W2) :- q14(W0,W1),q39(W1,W2),true.
q88(W0,W2) :- q18(W0,W1),q84(W1,W2),true.
q88(W0,W2) :- q39(W0,W1),q124(W1,W2),true.
q111(W0,W2) :- q100(W0,W1),q39(W1,W2),true.
q111(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q1(W0,W2) :- q38(W0,W1),q18(W1,W2),true.
q1(W0,W2) :- q122(W0,W1),q39(W1,W2),true.
q51(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q51(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q109(W0,W2) :- q16(W0,W1),q39(W1,W2),true.
q109(W0,W2) :- q87(W0,W1),q18(W1,W2),true.
q25(W0,W2) :- q18(W0,W1),q56(W1,W2),true.
q25(W0,W2) :- q39(W0,W1),q97(W1,W2),true.
q78(W0,W2) :- q18(W0,W1),q35(W1,W2),true.
q78(W0,W2) :- q39(W0,W1),q41(W1,W2),true.
q12(W0,W2) :- q18(W0,W1),q43(W1,W2),true.
q12(W0,W2) :- q39(W0,W1),q101(W1,W2),true.
q29(W0,W2) :- q39(W0,W1),q37(W1,W2),true.
q29(W0,W2) :- q18(W0,W1),q10(W1,W2),true.
q134(W0,W2) :- q18(W0,W1),q122(W1,W2),true.
q134(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q5(W0,W2) :- q39(W0,W1),q72(W1,W2),true.
q5(W0,W2) :- q18(W0,W1),q14(W1,W2),true.
q96(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q96(W0,W2) :- q39(W0,W1),q14(W1,W2),true.
q47(W0,W2) :- q39(W0,W1),q121(W1,W2),true.
q47(W0,W2) :- q18(W0,W1),q15(W1,W2),true.
q63(W0,W2) :- q13(W0,W1),q18(W1,W2),true.
q63(W0,W2) :- q1(W0,W1),q39(W1,W2),true.
q16(W0,W2) :- q14(W0,W1),q18(W1,W2),true.
q16(W0,W2) :- q72(W0,W1),q39(W1,W2),true.
q43(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q43(W0,W2) :- q38(W0,W1),q39(W1,W2),true.
q115(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q54(W0,W2) :- q51(W0,W1),q66(W1,W2),true.
q105(W0,W2) :- q39(W0,W1),q51(W1,W2),true.
q105(W0,W2) :- q18(W0,W1),q132(W1,W2),true.
q107(W0,W2) :- q82(W0,W1),q39(W1,W2),true.
q107(W0,W2) :- q50(W0,W1),q18(W1,W2),true.
q87(W0,W2) :- q122(W0,W1),q39(W1,W2),true.
q76(W0,W2) :- q14(W0,W1),q18(W1,W2),true.
q76(W0,W2) :- q48(W0,W1),q39(W1,W2),true.
q30(W0,W2) :- q39(W0,W1),q64(W1,W2),true.
q30(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q17(W0,W2) :- q104(W0,W1),q39(W1,W2),true.
q17(W0,W2) :- q107(W0,W1),q18(W1,W2),true.
q95(W0,W2) :- q39(W0,W1),q47(W1,W2),true.
q95(W0,W2) :- q18(W0,W1),q63(W1,W2),true.
q34(W0,W2) :- q134(W0,W1),q39(W1,W2),true.
q34(W0,W2) :- q130(W0,W1),q18(W1,W2),true.
q24(W0,W2) :- q19(W0,W1),q18(W1,W2),true.
q24(W0,W2) :- q122(W0,W1),q39(W1,W2),true.
q106(W0,W2) :- q39(W0,W1),q100(W1,W2),true.
q121(W0,W2) :- q38(W0,W1),q18(W1,W2),true.
q121(W0,W2) :- q71(W0,W1),q39(W1,W2),true.
q126(W0,W2) :- q75(W0,W1),q39(W1,W2),true.
q126(W0,W2) :- q43(W0,W1),q18(W1,W2),true.
q23(W0,W2) :- q18(W0,W1),q48(W1,W2),true.
q23(W0,W2) :- q39(W0,W1),q125(W1,W2),true.
q90(W0,W2) :- q18(W0,W1),q127(W1,W2),true.
q90(W0,W2) :- q39(W0,W1),q20(W1,W2),true.
q56(W0,W2) :- q62(W0,W1),q39(W1,W2),true.
q56(W0,W2) :- q30(W0,W1),q18(W1,W2),true.
q89(W0,W2) :- q49(W0,W1),q18(W1,W2),true.
q89(W0,W2) :- q22(W0,W1),q39(W1,W2),true.
q113(W0,W2) :- q87(W0,W1),q39(W1,W2),true.
q113(W0,W2) :- q59(W0,W1),q18(W1,W2),true.
q48(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q48(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q49(W0,W2) :- q72(W0,W1),q39(W1,W2),true.
q49(W0,W2) :- q125(W0,W1),q18(W1,W2),true.
q68(W0,W2) :- q18(W0,W1),q3(W1,W2),true.
q68(W0,W2) :- q39(W0,W1),q80(W1,W2),true.
q112(W0,W2) :- q69(W0,W1),q18(W1,W2),true.
q112(W0,W2) :- q17(W0,W1),q39(W1,W2),true.
q71(W0,W2) :- q66(W0,W1),q66(W1,W2),true.
q58(W0,W2) :- q114(W0,W1),q39(W1,W2),true.
q58(W0,W2) :- q111(W0,W1),q18(W1,W2),true.
q104(W0,W2) :- q18(W0,W1),q90(W1,W2),true.
q104(W0,W2) :- q39(W0,W1),q2(W1,W2),true.
q86(W0,W2) :- q39(W0,W1),q91(W1,W2),true.
q86(W0,W2) :- q18(W0,W1),q9(W1,W2),true.
q99(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q99(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q19(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q19(W0,W2) :- q39(W0,W1),q66(W1,W2),true.
q42(W0,W2) :- q18(W0,W1),q83(W1,W2),true.
q42(W0,W2) :- q39(W0,W1),q112(W1,W2),true.
q31(W0,W2) :- q85(W0,W1),q18(W1,W2),true.
q31(W0,W2) :- q94(W0,W1),q39(W1,W2),true.
q7(W0,W2) :- q4(W0,W1),q39(W1,W2),true.
q7(W0,W2) :- q24(W0,W1),q18(W1,W2),true.
q97(W0,W2) :- q57(W0,W1),q39(W1,W2),true.
q97(W0,W2) :- q117(W0,W1),q18(W1,W2),true.
q75(W0,W2) :- q100(W0,W1),q39(W1,W2),true.
q75(W0,W2) :- q122(W0,W1),q18(W1,W2),true.
q37(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q37(W0,W2) :- q103(W0,W1),q39(W1,W2),true.
q117(W0,W2) :- q39(W0,W1),q14(W1,W2),true.
q117(W0,W2) :- q18(W0,W1),q100(W1,W2),true.
q129(W0,W2) :- q103(W0,W1),q18(W1,W2),true.
q129(W0,W2) :- q125(W0,W1),q39(W1,W2),true.
q32(W0,W2) :- q36(W0,W1),q18(W1,W2),true.
q32(W0,W2) :- q40(W0,W1),q39(W1,W2),true.
q60(W0,W2) :- q48(W0,W1),q39(W1,W2),true.
q128(W0,W2) :- q18(W0,W1),q14(W1,W2),true.
q128(W0,W2) :- q39(W0,W1),q19(W1,W2),true.
q61(W0,W2) :- q100(W0,W1),q39(W1,W2),true.
q84(W0,W2) :- q98(W0,W1),q39(W1,W2),true.
q84(W0,W2) :- q76(W0,W1),q18(W1,W2),true.
q93(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q93(W0,W2) :- q18(W0,W1),q51(W1,W2),true.
q26(W0,W2) :- q18(W0,W1),q72(W1,W2),true.
q83(W0,W2) :- q18(W0,W1),q131(W1,W2),true.
q83(W0,W2) :- q39(W0,W1),q78(W1,W2),true.
q59(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q59(W0,W2) :- q39(W0,W1),q48(W1,W2),true.
q33(W0,W2) :- q18(W0,W1),q71(W1,W2),true.
q33(W0,W2) :- q39(W0,W1),q48(W1,W2),true.
q3(W0,W2) :- q18(W0,W1),q99(W1,W2),true.
q3(W0,W2) :- q39(W0,W1),q23(W1,W2),true.
q20(W0,W2) :- q39(W0,W1),q122(W1,W2),true.
q20(W0,W2) :- q18(W0,W1),q72(W1,W2),true.
q9(W0,W2) :- q39(W0,W1),q133(W1,W2),true.
q9(W0,W2) :- q18(W0,W1),q108(W1,W2),true.
q6(W0,W2) :- q75(W0,W1),q18(W1,W2),true.
q6(W0,W2) :- q123(W0,W1),q39(W1,W2),true.
q52(W0,W2) :- q39(W0,W1),q81(W1,W2),true.
q52(W0,W2) :- q18(W0,W1),q67(W1,W2),true.
q62(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q62(W0,W2) :- q39(W0,W1),q72(W1,W2),true.
q108(W0,W2) :- q18(W0,W1),q13(W1,W2),true.
q108(W0,W2) :- q39(W0,W1),q120(W1,W2),true.
q81(W0,W2) :- q18(W0,W1),q79(W1,W2),true.
q81(W0,W2) :- q39(W0,W1),q129(W1,W2),true.
q77(W0,W2) :- q92(W0,W1),q18(W1,W2),true.
q77(W0,W2) :- q6(W0,W1),q39(W1,W2),true.
q124(W0,W2) :- q119(W0,W1),q18(W1,W2),true.
q124(W0,W2) :- q60(W0,W1),q39(W1,W2),true.
q82(W0,W2) :- q116(W0,W1),q18(W1,W2),true.
q82(W0,W2) :- q10(W0,W1),q39(W1,W2),true.
q110(W0,W2) :- q71(W0,W1),q39(W1,W2),true.
q110(W0,W2) :- q48(W0,W1),q18(W1,W2),true.
q98(W0,W2) :- q132(W0,W1),q18(W1,W2),true.
q98(W0,W2) :- q14(W0,W1),q39(W1,W2),true.
q74(W0,W2) :- q18(W0,W1),q70(W1,W2),true.
q74(W0,W2) :- q39(W0,W1),q115(W1,W2),true.
q91(W0,W2) :- q39(W0,W1),q21(W1,W2),true.
q91(W0,W2) :- q18(W0,W1),q12(W1,W2),true.
q132(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q132(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q100(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q53(W0,W2) :- q18(W0,W1),q29(W1,W2),true.
q53(W0,W2) :- q39(W0,W1),q34(W1,W2),true.
q125(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q125(W0,W2) :- q18(W0,W1),q18(W1,W2),true.
q131(W0,W2) :- q39(W0,W1),q77(W1,W2),true.
q131(W0,W2) :- q18(W0,W1),q46(W1,W2),true.
q103(W0,W2) :- q66(W0,W1),q39(W1,W2),true.
q103(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q65(W0,W2) :- q53(W0,W1),q18(W1,W2),true.
q65(W0,W2) :- q52(W0,W1),q39(W1,W2),true.
q38(W0,W2) :- q39(W0,W1),q39(W1,W2),true.
q38(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q39(W0,W1) :- W0 = [b | W1],true.
q21(W0,W2) :- q99(W0,W1),q18(W1,W2),true.
q21(W0,W2) :- q102(W0,W1),q39(W1,W2),true.
q36(W0,W2) :- q103(W0,W1),q39(W1,W2),true.
q36(W0,W2) :- q125(W0,W1),q18(W1,W2),true.
q73(W0,W2) :- q18(W0,W1),q7(W1,W2),true.
q73(W0,W2) :- q39(W0,W1),q89(W1,W2),true.
q118(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q57(W0,W2) :- q14(W0,W1),q18(W1,W2),true.
q57(W0,W2) :- q64(W0,W1),q39(W1,W2),true.
q35(W0,W2) :- q39(W0,W1),q55(W1,W2),true.
q35(W0,W2) :- q18(W0,W1),q28(W1,W2),true.
q66(W0,W1) :- q18(W0,W1),true.
q66(W0,W1) :- q39(W0,W1),true.
q94(W0,W2) :- q39(W0,W1),q86(W1,W2),true.
q94(W0,W2) :- q18(W0,W1),q45(W1,W2),true.
q80(W0,W2) :- q106(W0,W1),q39(W1,W2),true.
q80(W0,W2) :- q134(W0,W1),q18(W1,W2),true.
q127(W0,W2) :- q39(W0,W1),q14(W1,W2),true.
q127(W0,W2) :- q18(W0,W1),q48(W1,W2),true.
q64(W0,W2) :- q39(W0,W1),q18(W1,W2),true.
q64(W0,W2) :- q18(W0,W1),q39(W1,W2),true.
q69(W0,W2) :- q95(W0,W1),q39(W1,W2),true.
q69(W0,W2) :- q25(W0,W1),q18(W1,W2),true.
q45(W0,W2) :- q88(W0,W1),q39(W1,W2),true.
q45(W0,W2) :- q68(W0,W1),q18(W1,W2),true.
q15(W0,W2) :- q39(W0,W1),q38(W1,W2),true.
q15(W0,W2) :- q18(W0,W1),q71(W1,W2),true.
q70(W0,W2) :- q18(W0,W1),q132(W1,W2),true.
q70(W0,W2) :- q39(W0,W1),q118(W1,W2),true.
q13(W0,W2) :- q100(W0,W1),q18(W1,W2),true.
q13(W0,W2) :- q132(W0,W1),q39(W1,W2),true.
q46(W0,W2) :- q18(W0,W1),q126(W1,W2),true.
q46(W0,W2) :- q39(W0,W1),q113(W1,W2),true.
q120(W0,W2) :- q39(W0,W1),q71(W1,W2),true.
q120(W0,W2) :- q18(W0,W1),q125(W1,W2),true.
q22(W0,W2) :- q39(W0,W1),q100(W1,W2),true.
q22(W0,W2) :- q18(W0,W1),q48(W1,W2),true.


goals([
    q0([a,b,b,b,b,a,b,b,b,a,a,b,a,b,a,b,a,a,a,b,b,a,a,b,b,b,b,b,b,b,b,a],[]),
    q0([b,b,b,a,b,b,b,b,a,b,b,a,b,b,b,b,a,b,b,b,a,b,a,b],[]),
    q0([a,a,b,b,a,b,a,b,b,b,b,a,b,a,b,b,a,a,a,b,b,a,b,b],[]),
    q0([a,a,b,a,b,b,a,a,a,a,b,b,b,a,a,a,a,a,b,a,a,b,b,b],[]),
    q0([a,a,a,a,b,a,a,a,b,a,b,b,b,b,b,b,b,b,b,b,a,b,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,b,b,a,b,b,b,a,b,b,a,a,b,b,a],[]),
    q0([a,b,a,a,a,a,b,b,b,a,b,a,a,b,a,a,a,b,a,b,b,b,b,b],[]),
    q0([b,b,a,b,a,b,b,b,a,a,a,a,a,a,a,b,b,b,a,b,a,b,b,a],[]),
    q0([b,b,b,a,a,a,a,a,b,b,a,b,b,a,a,b,b,b,b,b,a,b,a,a],[]),
    q0([a,a,a,a,b,b,a,b,a,b,b,b,a,b,b,b,b,b,a,b,a,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([a,a,a,a,b,a,a,a,a,a,b,b,b,b,b,b,b,a,a,a,a,b,b,a],[]),
    q0([a,a,b,a,a,a,a,b,a,a,b,a,b,b,b,a,b,a,b,a,b,b,b,b,b,b,b,b,a,b,a,b],[]),
    q0([b,b,a,a,b,b,a,b,a,b,a,a,a,b,a,b,b,a,b,a,b,b,b,a],[]),
    q0([b,b,a,b,b,b,a,a,b,b,a,b,b,b,b,a,a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,a,a,b,b,a,a,b,b,a,b,a,a,a,a,a,a,a,a,b,a,a,b,a,b,a],[]),
    q0([b,b,b,b,b,a,b,a,b,b,a,a,b,b,a,b,b,a,a,a,a,a,b,a],[]),
    q0([b,a,b,a,a,b,b,b,b,b,a,a,b,b,b,a,a,a,b,a,b,b,a,a,a,a,a,b,b,b,a,b,a,b,a,b,b,a,a,a],[]),
    q0([b,a,a,a,a,a,a,b,a,a,a,a,b,a,b,b,b,b,b,b,a,a,b,b,b,a,a,a,b,a,a,a],[]),
    q0([a,b,a,b,b,b,a,b,a,b,a,b,a,b,a,b,b,b,b,a,b,a,a,b],[]),
    q0([b,b,a,a,a,a,b,b,a,b,a,b,a,a,a,b,a,a,a,a,b,a,b,b,b,a,b,a,b,a,a,a,b,b,a,a,a,a,a,b,b,b,b,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,b,a,b,a,a,b,b,b,b,a,a,a,b,a,b,b,b,b,a,a,b,b],[]),
    q0([b,b,a,a,a,b,a,a,a,a,a,a,b,a,a,a,b,b,b,a,b,a,a,a],[]),
    q0([a,a,a,a,a,a,a,b,b,b,a,a,b,a,b,a,a,a,a,a,a,b,a,a],[]),
    q0([b,a,a,b,a,a,a,a,b,b,b,a,b,b,a,a,b,b,a,a,b,a,a,a],[]),
    q0([a,a,b,b,b,b,b,b,b,b,a,a,a,b,b,b,a,a,b,b,a,a,a,b],[]),
    q0([b,b,b,a,a,b,b,a,b,a,a,b,b,b,b,a,b,b,a,a,b,b,a,a],[]),
    q0([a,a,b,a,b,a,a,b,a,b,a,b,a,b,a,a,b,a,b,b,b,b,a,a],[]),
    q0([a,a,a,a,a,b,b,a,a,b,a,a,b,a,b,b,b,b,b,a,b,b,b,a,a,b,a,a,a,b,a,a,a,a,b,b,a,a,a,a,a,b,b,b,a,b,a,b,b,a,a,b,a,a,b,a,a,b,b,a,a,b,a,b,b,b,a,a,a,b,b,b,b,b,b,a,a,b,a,a],[]),
    q0([a,b,b,b,b,a,b,a,a,a,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,a,b,b,b,b,b,a],[]),
    q0([a,a,b,a,a,a,a,b,b,a,a,b,a,a,b,b,b,b,b,a,b,b,b,a,a,b,b,b,b,a,a,a,a,a,a,a,b,b,a,a],[]),
    q0([a,b,a,b,b,b,a,a,a,a,b,a,b,a,b,a,a,b,a,b,a,a,b,a,a,b,b,a,b,b,b,b,b,a,a,a,a,b,b,b,b,b,a,a,a,a,b,b,a,a,b,a,a,a,a,a,b,b,b,b,b,b,a,b,b,a,a,b,b,a,b,a,b,b,a,b,a,a,b,a],[]),
    q0([b,b,b,a,b,b,a,b,b,a,a,b,a,a,a,a,a,a,b,b,a,b,a,a,a,b,b,a,b,b,a,a,b,b,b,b,b,a,a,a],[]),
    q0([b,b,b,b,b,b,b,b,b,a,b,a,b,b,a,b,a,b,b,b,b,a,a,a,b,a,a,a,b,a,a,a],[]),
    q0([b,a,a,a,b,b,b,a,b,a,b,a,b,a,a,a,a,a,b,b,a,a,b,a],[]),
    q0([b,b,a,b,a,a,a,b,b,b,a,b,b,b,b,a,b,a,a,b,a,b,b,b],[]),
    q0([b,a,b,a,a,b,b,b,a,a,a,b,a,a,b,b,b,a,a,b,a,b,a,b,b,b,b,a,b,b,b,b,a,b,b,a,a,a,a,a,b,b,b,b,b,a,a,b],[]),
    q0([a,a,a,b,a,a,b,b,a,b,b,b,b,b,b,a,b,b,b,b,b,b,b,b],[]),
    q0([a,b,b,a,b,a,b,a,b,a,b,b,b,b,b,a,b,a,a,a,b,b,a,a],[]),
    q0([a,a,a,a,a,b,a,b,a,b,a,b,a,a,b,b,b,a,a,b,b,b,b,b],[]),
    q0([a,a,b,b,a,b,b,b,a,a,b,a,b,b,b,b,b,b,a,a,a,a,b,b,b,b,a,a,a,a,b,a,a,a,b,b,b,a,b,a,b,a,a,b,b,b,b,b,a,a,a,b,b,a,b,b],[]),
    q0([a,a,b,b,b,b,b,b,a,b,b,b,a,b,a,a,a,a,a,a,b,b,a,a],[]),
    q0([a,a,b,a,a,a,b,b,b,b,b,b,b,a,b,a,b,b,b,b,a,a,a,b],[]),
    q0([a,a,b,b,b,b,b,b,b,a,b,a,a,b,a,b,b,a,a,a,a,b,a,a,a,b,a,a,b,b,a,a],[]),
    q0([b,b,a,b,a,b,b,b,b,b,b,a,b,b,a,a,a,a,b,a,b,b,b,a],[]),
    q0([a,a,a,b,a,a,a,a,a,b,a,a,a,b,a,b,b,a,a,b,b,a,a,b],[]),
    q0([b,a,b,b,a,b,b,b,b,a,b,a,a,b,b,a,a,b,a,a,b,b,b,b,b,a,b,a,a,a,a,a],[]),
    q0([a,b,b,b,b,b,b,a,b,b,a,a,a,a,b,b,b,a,a,a,a,a,b,a],[]),
    q0([a,a,b,b,b,b,b,b,a,b,a,b,a,a,a,b,a,b,b,a,a,b,b,b,a,b,b,a,b,a,b,b],[]),
    q0([a,a,a,a,b,a,b,b,a,a,a,a,a,b,a,b,b,b,a,a,b,a,a,b],[]),
    q0([b,a,a,a,a,b,a,b,b,a,a,a,b,b,a,b,b,b,a,b,b,a,a,b],[]),
    q0([a,a,b,b,b,b,a,a,a,b,a,b,b,b,a,a,a,b,a,a,b,a,b,b,b,b,b,b,a,b,a,b],[]),
    q0([b,b,b,a,b,b,b,b,b,b,b,a,b,b,a,b,b,b,a,b,b,a,a,a,a,b,a,a,b,b,b,a],[]),
    q0([b,a,b,a,a,b,a,a,a,a,b,a,b,a,a,a,a,a,a,a,a,a,b,a],[]),
    q0([b,a,b,b,b,b,b,b,b,b,a,b,b,b,b,a,b,a,a,a,b,a,a,b],[]),
    q0([b,a,a,a,b,a,b,a,a,a,a,b,a,a,b,b,b,b,b,a,a,a,b,a],[]),
    q0([b,b,b,b,a,a,b,a,a,a,a,a,b,a,a,a,b,b,a,a,a,a,b,b,b,a,b,a,a,b,b,b,a,b,b,b,a,a,a,a],[]),
    q0([b,b,a,b,a,b,b,b,b,b,a,a,a,a,a,b,b,b,a,a,a,a,a,b,a,a,a,a,b,b,b,a,b,b,a,b,b,b,a,b],[]),
    q0([b,a,a,a,a,a,a,b,a,a,a,b,b,b,b,a,a,a,b,a,b,a,b,a,a,b,b,a,b,a,b,b],[]),
    q0([b,a,b,b,a,b,b,a,b,b,a,b,b,b,a,a,a,b,a,a,a,a,b,a],[]),
    q0([b,b,b,a,a,a,a,b,b,b,b,a,b,b,a,a,a,b,b,a,a,b,a,b,a,b,b,b,b,a,b,a,a,b,a,a,b,a,a,b,a,b,b,b,b,a,b,b],[]),
    q0([b,a,b,b,b,b,b,a,b,b,a,b,a,a,b,b,b,a,a,a,a,b,b,a],[]),
    q0([a,a,a,b,b,b,b,b,b,b,a,b,a,a,a,b,a,b,b,a,a,a,a,a],[]),
    q0([b,a,a,a,b,b,b,b,a,b,a,a,b,b,a,b,a,b,a,b,b,b,b,a],[]),
    q0([a,b,b,b,b,b,b,a,a,a,b,a,a,b,a,a,a,a,b,b,a,a,b,b,b,a,a,b,b,b,b,a,a,b,b,b,a,b,b,b,b,a,b,b,a,b,b,a,b,b,b,b,b,a,b,b],[]),
    q0([b,b,a,a,b,a,b,a,b,b,a,a,a,b,a,a,a,a,a,a,a,a,b,a],[]),
    q0([b,a,b,a,a,b,a,b,b,b,a,a,b,b,a,b,b,b,a,b,a,a,a,a,b,a,b,a,a,b,b,a,b,b,a,b,b,a,b,a,a,a,b,b,b,a,b,b],[]),
    q0([b,a,a,b,a,a,a,a,b,b,b,a,a,b,b,b,b,a,b,a,b,b,a,b],[]),
    q0([a,a,a,a,b,a,a,a,a,a,b,a,b,b,a,a,a,b,a,a,a,a,b,b,a,a,a,b,b,a,a,b],[]),
    q0([a,b,a,a,a,a,b,b,b,a,a,b,a,b,a,b,a,a,b,b,a,b,b,a],[]),
    q0([a,a,b,a,b,a,a,a,b,b,b,b,b,b,b,a,a,a,b,b,a,a,b,a],[]),
    q0([a,b,a,b,b,a,b,b,b,a,a,a,a,a,b,a,b,a,b,b,a,a,b,a,a,a,b,b,b,b,a,a,a,b,b,a,b,b,a,b,a,a,a,a,a,a,b,b,b,a,a,b,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,b,a,b,b,b,a,b,b,a,b,a,a,b],[]),
    q0([a,b,a,b,a,a,a,a,b,b,a,a,a,a,a,b,a,a,a,a,a,a,a,a,a,b,a,a,a,b,a,a,a,b,a,a,a,a,b,a],[]),
    q0([b,a,b,b,b,a,a,b,a,b,a,b,a,b,a,b,b,a,b,a,a,a,a,a,b,b,b,a,b,b,b,a,b,a,a,a,b,a,b,b,a,b,b,a,b,a,a,b,a,b,b,a,a,a,b,b],[]),
    q0([a,a,a,a,a,a,a,b,b,b,a,a,a,b,b,b,b,b,a,b,a,b,a,a],[]),
    q0([a,a,a,b,a,a,a,a,b,a,a,a,b,b,b,b,b,a,a,a,a,b,a,b,b,a,a,a,a,b,a,b,a,b,b,b,a,a,b,a,a,a,a,a,a,a,b,a],[]),
    q0([a,b,b,b,a,b,a,a,b,a,b,a,a,b,b,a,b,a,a,b,a,b,b,b,a,a,a,a,b,b,a,a,b,a,a,b,b,a,a,a],[]),
    q0([a,b,a,a,b,b,b,b,a,b,b,a,a,b,a,b,a,b,a,b,a,a,b,b,a,a,b,b,a,b,b,a],[]),
    q0([a,a,a,b,a,b,a,b,a,a,a,a,a,b,b,b,b,a,b,b,b,a,a,b],[]),
    q0([a,a,b,a,a,a,b,b,a,b,b,b,b,b,b,a,b,b,b,b,a,b,b,b,a,a,a,b,b,b,a,b,b,b,b,b,b,b,a,a,b,a,a,b,b,b,b,b,a,b,b,b,a,a,b,a,a,a,b,b,b,b,a,b,b,b,a,a,b,b,a,b],[]),
    q0([b,b,a,a,a,a,b,a,b,b,a,a,a,b,a,a,b,b,b,b,a,b,b,a,a,a,a,a,b,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([b,b,a,a,a,b,a,a,a,a,b,b,b,b,a,a,a,a,a,b,a,a,a,b],[]),
    q0([b,a,a,b,a,a,a,a,a,b,b,b,a,a,a,a,b,b,b,b,a,b,a,a],[]),
    q0([a,b,a,b,b,a,b,a,a,b,b,b,b,b,a,b,b,a,a,a,a,a,b,b,b,b,b,a,b,a,b,a,a,a,a,b,a,b,b,a,b,a,b,b,a,a,b,b],[]),
    q0([b,b,a,a,b,b,b,a,b,b,a,a,b,b,a,b,a,a,b,b,a,a,a,a],[]),
    q0([a,b,b,a,a,b,b,b,b,b,b,a,a,b,b,b,b,a,a,a,a,a,a,a],[]),
    q0([a,b,a,b,a,b,a,b,b,b,a,b,a,a,a,a,a,b,a,b,a,b,b,a],[]),
    q0([a,b,b,b,b,b,b,a,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,a],[]),
    q0([b,a,a,b,b,b,b,a,b,a,a,b,b,b,b,a,a,b,b,a,b,a,a,a],[]),
    q0([a,a,b,a,b,b,b,b,a,a,b,a,a,b,b,a,a,a,b,b,b,a,b,a],[]),
    q0([b,b,b,b,b,a,b,a,a,b,a,b,b,b,a,b,a,b,a,b,b,a,a,b],[]),
    q0([a,b,b,b,b,b,a,b,a,b,b,b,a,a,a,a,b,a,a,b,b,a,a,b],[]),
    q0([b,b,a,a,b,b,a,b,a,a,b,a,b,a,a,b,a,b,b,a,b,b,a,a],[]),
    q0([a,a,b,a,a,a,b,a,a,a,a,b,b,b,b,b,a,b,b,b,b,b,a,b,a,a,b,b,a,b,a,a,b,b,a,a,a,b,b,a,b,a,a,b,b,a,b,b,b,a,b,b,a,a,a,b,b,a,a,b,b,a,a,b],[]),
    q0([b,b,b,b,b,a,a,a,b,b,b,a,b,a,a,a,a,a,a,b,b,a,a,b,a,b,a,b,b,a,a,a,a,b,b,b,b,a,b,b],[]),
    q0([a,a,b,b,b,a,a,a,b,a,b,b,a,a,a,a,b,a,b,a,b,a,b,a,a,b,b,a,b,b,b,b,b,a,b,a,b,a,b,a,b,b,b,b,b,b,a,a],[]),
    q0([b,a,b,b,a,b,b,b,a,b,a,b,a,a,b,a,a,b,b,b,b,b,a,b,a,b,b,b,b,b,b,a,a,a,a,a,a,b,b,a],[]),
    q0([a,b,a,a,a,a,b,b,b,b,b,a,a,b,b,a,a,b,a,a,a,b,a,b,a,a,a,a,b,b,b,a,b,a,a,b,a,b,a,a,a,a,b,b,a,a,a,b,a,b,b,b,b,a,a,b],[]),
    q0([a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,b,a,a,b,b,a,b,a,b,b,b,b,a],[]),
    q0([b,a,b,b,a,a,b,b,a,a,a,a,b,a,b,b,a,b,a,a,a,a,a,b],[]),
    q0([b,b,b,a,a,a,a,b,b,a,b,a,a,a,b,a,a,b,b,a,a,b,a,a],[]),
    q0([b,a,a,b,a,b,a,b,b,b,b,b,b,a,b,a,b,a,b,b,b,b,a,a,a,b,a,a,a,a,b,a],[]),
    q0([b,a,b,b,a,b,b,a,b,a,b,b,a,a,a,a,b,b,b,b,b,b,b,a,b,b,a,b,a,a,a,a,a,a,b,a,b,a,b,a,a,a,a,b,a,b,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,a,b,b],[]),
    q0([b,b,a,a,b,b,a,b,b,a,b,b,a,a,b,b,a,a,b,a,b,b,a,a,a,b,b,b,b,a,b,b,b,a,a,b,b,a,b,b],[]),
    q0([a,b,b,a,a,a,b,b,a,a,a,a,b,a,b,a,a,a,a,b,a,b,b,b,b,a,a,a,a,b,b,a,a,b,b,a,a,b,a,a],[]),
    q0([b,a,a,b,a,b,b,a,a,b,a,b,a,b,b,b,b,b,b,a,b,b,a,a,b,a,a,a,a,a,a,b],[]),
    q0([b,a,b,a,b,a,b,a,b,b,a,b,b,b,a,a,b,a,b,b,a,a,b,a],[]),
    q0([b,b,b,a,a,b,b,a,b,a,a,a,b,b,b,b,b,b,b,b,a,a,b,a,a,b,a,a,b,a,b,b,a,a,b,a,b,a,a,a,a,b,b,a,a,a,b,a,b,a,b,b,b,a,b,b,b,a,a,a,b,b,a,a],[]),
    q0([b,b,b,b,a,b,b,a,b,b,a,a,a,a,b,b,b,b,b,b,a,a,a,a],[]),
    q0([a,b,a,b,a,a,a,b,a,b,a,a,b,b,a,b,a,a,a,a,b,b,b,a,b,a,a,b,b,a,a,b,b,b,a,b,b,a,a,a,a,b,b,a,b,a,a,b,a,b,b,a,a,a,b,b,b,a,a,a,a,b,b,a,b,a,b,b,a,b,a,a,b,b,a,a,a,b,b,a,b,a,a,a,b,b,a,a,a,a,a,b,a,b,a,b],[]),
    q0([a,b,b,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,b,b,b,a,b,b],[]),
    q0([b,a,b,b,a,b,a,a,a,b,a,a,a,b,a,b,a,a,b,a,b,b,b,a],[]),
    q0([b,a,a,b,b,a,b,a,b,b,a,a,a,b,b,b,a,a,a,a,b,a,b,b,b,b,b,a,b,a,b,b,a,b,b,a,a,b,a,a,a,a,a,b,a,a,a,b,b,b,b,a,a,b,a,a,a,a,a,a,a,b,b,a,a,a,a,b,b,b,b,b,a,a,a,b,a,a,b,a],[]),
    q0([b,b,a,a,a,a,b,b,b,a,b,b,a,a,a,b,a,a,a,a,a,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([b,a,a,a,b,b,a,b,a,a,b,a,b,b,b,b,b,a,a,a,b,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,a,b,a,a,b,b,b,b,b,a,b,b,a,a,b,b,a,b,a,b,b,a,b,b,a,a,b,b,a,a,b,b,a,b,b,a,b,a,a,b,b,b,b,b,b,a,a,b],[]),
    q0([b,b,b,a,b,b,b,b,b,a,b,a,a,b,b,a,a,a,b,b,a,b,a,a,a,a,a,b,a,b,a,a],[]),
    q0([a,b,a,b,a,a,a,b,b,b,a,a,b,a,b,a,a,a,b,b,b,b,b,b,a,a,b,a,b,a,a,a,a,a,a,b,a,b,a,a,b,a,a,a,a,a,b,b,b,a,b,b,b,a,b,b],[]),
    q0([a,a,b,b,a,b,a,b,a,a,a,b,b,b,b,a,a,a,a,a,a,a,b,a],[]),
    q0([b,b,a,b,a,b,b,b,b,a,b,b,b,b,a,b,b,b,b,b,b,a,a,b],[]),
    q0([b,a,b,a,a,b,a,b,a,a,a,b,a,b,b,a,b,a,b,b,a,a,a,b],[]),
    q0([b,b,a,a,a,b,b,b,b,b,a,a,a,b,b,a,a,a,a,a,a,a,a,a],[]),
    q0([a,a,b,a,a,a,b,a,a,b,b,b,a,b,a,a,a,a,a,a,b,a,b,b,a,a,a,b,b,b,b,b,a,a,a,b,a,a,a,b,a,b,a,a,a,a,a,b],[]),
    q0([b,a,b,a,a,a,b,b,b,b,a,a,b,b,a,b,b,a,b,b,a,a,a,a,b,b,a,b,b,b,b,a,a,b,b,a,b,b,b,b,b,b,b,a,b,a,b,a],[]),
    q0([a,b,b,b,b,b,a,b,b,a,b,b,a,b,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,b,a,b,b,a,b,b,a,a,b,b,b,a,b,b,a,a,a,a,a,a,a,a,b,a,a,b],[]),
    q0([a,a,a,a,b,b,b,a,a,b,a,a,a,b,b,a,a,b,b,a,a,b,a,a],[]),
    q0([a,a,a,a,b,a,b,b,b,b,a,a,b,b,b,a,b,b,a,b,a,a,b,a],[]),
    q0([a,b,b,b,a,a,a,a,b,b,a,a,a,a,b,b,b,b,a,b,b,b,a,a,b,a,b,a,b,a,a,a,a,b,a,a,b,b,b,b,b,b,b,b,b,b,a,a,a,a,a,b,b,a,b,b],[]),
    q0([a,a,a,a,a,a,a,b,a,a,b,a,a,a,a,b,b,a,a,a,a,b,b,a],[]),
    q0([b,b,b,a,a,b,b,a,b,b,b,a,a,a,a,b,a,a,b,b,a,b,b,b,b,a,a,b,b,a,b,b],[]),
    q0([a,b,b,a,a,b,a,b,a,a,b,a,a,b,a,a,b,b,b,a,b,a,a,b],[]),
    q0([b,b,a,b,a,a,a,b,b,a,b,b,b,b,b,a,a,a,b,b,a,a,b,a],[]),
    q0([b,b,a,a,a,b,b,b,a,b,a,b,a,a,b,b,a,b,a,b,b,a,b,b,b,b,a,b,a,a,a,b,a,b,b,a,a,a,b,a,a,b,a,b,b,b,b,b,b,b,a,b,a,b,b,a],[]),
    q0([b,a,b,a,a,b,a,b,b,a,b,a,b,a,b,b,b,b,a,b,a,b,a,a],[]),
    q0([a,a,a,b,b,b,b,b,b,b,a,a,a,b,a,a,a,b,b,b,b,a,a,b],[]),
    q0([a,b,b,b,a,a,a,a,b,b,a,a,a,a,b,b,b,a,b,a,b,a,a,b],[]),
    q0([b,b,a,b,b,a,a,b,b,a,b,b,a,a,b,b,b,a,a,a,b,a,a,b],[]),
    q0([a,a,a,b,a,a,a,a,a,a,b,b,b,b,b,b,a,a,b,a,b,a,b,a,a,b,b,b,b,a,b,a,a,a,a,b,a,a,b,a],[]),
    q0([a,a,b,b,b,b,a,a,a,a,a,b,b,b,b,a,a,b,a,b,a,b,b,a],[]),
    q0([a,a,a,a,a,a,a,b,b,a,b,a,a,b,a,b,a,b,b,a,b,a,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,b,a,b,a,a,a,a,a,a,b,b,a,b,b,b,a,b,a,b,a,a,b,a,a,a,a,a,b,b,b,b],[]),
    q0([b,a,a,a,b,b,b,a,a,a,a,b,b,b,a,a,b,b,b,b,a,a,a,a,a,a,a,b,a,a,b,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,b,a,a,a,b,a,a,a,b,a,a,b,a,a,a,b,b,a,a,a,b,a,b,a,a,a,b,a,a,a],[]),
    q0([a,a,b,b,b,a,a,b,a,a,b,a,a,b,a,a,b,a,b,b,a,a,a,b,a,b,b,b,a,b,b,b,a,b,a,a,a,a,b,a,b,b,a,b,b,b,a,a,a,a,a,a,a,a,b,a,b,b,a,a,a,a,b,a],[]),
    q0([b,a,b,a,b,a,b,a,a,a,b,b,a,b,b,b,b,a,b,b,a,b,b,a,a,b,b,a,a,a,b,b,b,b,a,b,a,a,b,a,b,a,b,b,a,b,a,b],[]),
    q0([a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,a,b,a,b,b,b,b,b,a,b,b,b,b,a,b,b,b],[]),
    q0([b,b,a,a,a,b,a,a,b,a,b,b,a,b,a,a,b,b,b,a,b,a,b,a],[]),
    q0([b,b,b,b,b,a,a,a,b,a,b,b,b,b,b,a,a,a,a,b,b,a,a,b,b,a,a,b,b,a,a,b,b,b,b,a,b,a,a,a],[]),
    q0([b,b,a,b,b,b,b,b,a,a,a,b,b,a,b,a,b,b,a,a,a,a,b,a,b,b,a,a,b,b,a,a,b,b,b,b,b,b,a,a],[]),
    q0([a,a,b,a,b,b,a,a,a,a,a,a,b,b,b,a,a,b,b,a,b,b,b,a],[]),
    q0([a,b,a,b,a,a,a,b,b,a,a,a,b,b,b,b,a,a,b,b,b,b,a,b],[]),
    q0([b,b,a,a,a,a,b,a,a,a,a,a,a,a,a,b,b,a,b,b,b,a,b,b],[]),
    q0([a,b,b,a,a,a,a,a,a,a,a,a,a,b,b,a,a,b,b,b,b,a,b,a],[]),
    q0([b,b,b,a,b,b,a,b,b,b,b,a,a,a,a,b,b,a,a,a,a,a,a,a],[]),
    q0([b,a,a,a,b,b,b,b,b,b,b,a,b,a,a,b,a,b,b,a,a,a,a,a,b,a,a,b,a,b,b,b,a,a,a,a,a,b,a,b,a,b,a,a,a,b,a,a,a,a,a,b,b,a,a,a,b,a,a,b,a,b,b,a],[]),
    q0([a,a,b,a,b,b,a,a,a,a,b,b,b,b,b,b,a,b,a,b,b,a,b,b,b,b,b,a,b,a,a,a],[]),
    q0([a,b,a,b,a,a,a,a,a,a,b,b,b,a,a,b,a,b,a,a,a,b,b,b,b,b,b,a,a,a,b,b],[]),
    q0([a,b,a,a,a,a,b,b,a,b,a,a,a,b,a,b,b,b,a,b,a,b,b,a],[]),
    q0([b,a,b,b,a,a,a,a,b,a,b,a,a,b,b,a,a,a,b,a,a,b,b,a,b,b,a,a,b,a,a,a,a,b,a,b,b,a,a,b],[]),
    q0([b,b,b,a,b,b,a,b,b,a,b,b,a,b,b,a,a,a,a,b,a,b,a,a],[]),
    q0([b,b,a,b,b,b,a,a,a,b,a,b,a,a,b,a,b,a,b,b,b,a,a,a],[]),
    q0([a,a,b,b,a,b,a,b,b,b,b,a,b,b,b,a,a,a,b,b,a,b,b,b,b,b,a,b,b,a,a,a,b,b,b,a,a,a,b,b,a,a,a,b,a,a,b,a],[]),
    q0([b,a,b,b,a,b,b,a,a,a,a,b,b,b,b,a,b,a,b,b,b,a,a,a],[]),
    q0([b,a,b,b,a,a,a,a,b,b,b,a,b,b,b,b,b,a,a,a,b,a,a,b],[]),
    q0([a,b,b,a,a,a,b,b,b,b,b,a,a,b,b,a,b,a,a,b,b,b,b,a,b,a,a,a,b,b,a,a],[]),
    q0([b,b,a,b,a,b,b,b,a,a,b,b,a,a,b,b,a,b,b,b,b,b,a,b],[]),
    q0([a,a,a,b,b,b,b,b,a,a,b,b,a,a,b,b,a,a,b,b,b,b,b,a],[]),
    q0([b,a,a,b,b,b,a,a,b,b,b,b,b,a,b,a,a,b,b,a,b,a,a,b],[]),
    q0([b,b,a,a,a,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,a,b,a],[]),
    q0([b,b,a,b,b,a,a,b,a,b,a,b,a,a,b,b,b,b,b,b,a,a,b,b],[]),
    q0([a,a,a,a,a,b,a,b,b,b,a,b,a,a,a,a,b,b,a,b,a,a,a,a,a,a,a,a,b,b,b,a,a,b,b,b,b,b,b,b],[]),
    q0([a,b,a,a,b,a,b,b,b,b,b,a,b,a,a,b,a,b,b,b,a,a,b,a,a,a,a,b,b,b,a,b,a,a,a,a,b,b,b,b,b,b,a,a,b,b,a,a,a,b,a,b,b,a,a,a],[]),
    q0([a,a,b,a,a,b,b,a,a,b,a,a,b,a,b,b,a,b,a,b,b,b,b,a],[]),
    q0([b,a,a,b,b,b,b,a,b,a,b,b,b,b,a,b,b,a,b,b,b,a,a,a],[]),
    q0([b,b,b,a,a,a,a,b,a,b,a,a,a,a,b,b,b,b,b,b,b,a,b,b],[]),
    q0([b,b,b,b,a,b,b,a,b,a,a,a,a,b,a,a,a,b,b,a,a,b,b,b,a,a,b,a,b,b,b,b,a,a,a,a,a,b,b,a],[]),
    q0([b,b,b,b,a,b,b,a,a,a,b,b,a,a,a,b,b,a,b,a,b,b,a,b,b,a,a,b,a,b,b,a],[]),
    q0([b,a,b,a,a,a,b,a,b,a,a,a,a,a,a,b,b,b,a,b,a,a,b,b,b,a,b,a,a,a,b,a,b,a,b,a,a,b,b,b,b,b,b,a,b,a,a,b],[]),
    q0([b,a,b,b,a,a,a,a,b,b,a,a,a,b,a,a,b,a,a,b,a,a,b,a],[]),
    q0([a,a,b,b,a,a,b,b,a,a,a,b,a,b,b,b,b,b,a,b,a,a,b,a],[]),
    q0([a,b,a,a,a,a,b,b,a,a,a,a,a,a,a,b,a,a,a,b,b,b,b,a,a,b,a,b,a,b,a,a],[]),
    q0([a,b,b,b,b,b,a,b,b,a,b,a,a,a,b,a,a,a,b,b,a,a,a,a],[]),
    q0([a,a,b,b,b,a,a,a,b,a,a,b,a,a,a,a,a,b,a,a,b,b,b,a],[]),
    q0([b,a,a,b,a,a,b,b,b,a,b,b,a,a,a,a,b,b,a,b,a,b,a,b],[]),
    q0([a,b,b,a,a,b,a,b,b,b,a,a,b,a,a,b,b,a,a,a,b,a,a,a,b,a,a,a,a,b,b,a,a,a,b,a,a,a,b,b,b,a,a,b,a,b,a,b,a,a,b,b,b,a,b,b],[]),
    q0([b,a,b,b,b,b,b,a,a,a,b,b,a,b,b,b,a,b,b,b,b,b,b,a,b,a,b,b,a,b,b,a,a,a,a,a,b,b,a,a],[]),
    q0([b,a,a,b,a,a,a,a,a,b,b,a,a,b,b,b,b,a,b,b,b,b,b,b,b,b,a,a,a,a,b,b,b,a,a,a,b,b,b,a,a,b,b,a,a,b,a,a],[]),
    q0([b,b,b,a,b,b,b,b,b,b,a,a,a,a,b,a,b,b,b,b,b,b,b,a,a,b,b,b,a,b,b,b,a,a,b,b,b,a,b,a],[]),
    q0([b,b,a,b,a,b,b,b,a,b,a,a,b,b,a,b,b,b,a,b,a,b,b,a],[]),
    q0([a,a,b,b,b,a,a,b,b,b,b,a,b,b,a,a,b,b,b,a,b,a,a,b],[]),
    q0([a,b,a,a,b,a,b,b,a,b,a,b,a,a,a,b,b,b,b,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,a,a,b,b,a,a,b,a,b,a,b,b,a,b,a,b,a,a],[]),
    q0([a,b,a,a,b,b,b,b,b,b,b,b,b,b,b,a,b,a,a,a,b,a,a,b],[]),
    q0([a,a,a,b,a,a,b,b,a,a,b,a,b,b,a,a,a,a,b,b,b,a,b,b],[]),
    q0([a,b,a,b,b,b,a,b,b,a,b,a,a,b,b,b,a,b,a,b,a,b,a,a],[]),
    q0([a,b,a,a,a,b,a,a,a,a,b,b,a,b,b,a,b,b,b,b,a,b,a,b],[]),
    q0([a,a,a,a,b,b,b,a,b,b,b,a,a,a,a,b,a,a,a,a,a,a,b,a],[]),
    q0([a,a,b,a,b,b,b,b,b,b,a,a,b,a,b,a,a,a,b,a,b,b,b,a],[]),
    q0([b,b,a,a,a,b,a,b,b,a,a,b,b,b,b,a,b,a,a,b,b,a,a,a],[]),
    q0([b,b,a,b,a,a,a,b,b,b,a,a,a,b,b,b,a,b,a,b,a,a,a,b,a,a,a,a,a,a,a,b,a,b,a,a,b,a,a,a,a,a,b,b,a,a,b,a],[]),
    q0([a,a,b,b,a,b,b,b,b,a,b,a,a,b,a,a,a,b,b,b,b,b,a,b,b,b,a,b,b,b,b,b,b,a,b,a,a,b,b,a,b,a,a,b,a,b,b,a],[]),
    q0([b,b,a,b,b,a,a,b,a,b,a,a,b,b,b,b,b,a,a,b,b,b,b,a,b,a,b,a,a,a,b,a,b,b,a,a,b,b,b,b,b,b,b,a,a,a,b,a],[]),
    q0([b,b,b,b,a,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,a,a],[]),
    q0([a,a,a,a,b,b,b,a,b,b,a,b,b,b,b,b,a,a,b,b,a,b,b,a],[]),
    q0([a,b,b,a,b,a,b,a,a,a,a,a,b,b,a,b,b,b,a,a,a,b,b,a,a,a,a,a,a,b,a,b,b,b,a,b,a,a,b,b,a,a,b,a,a,b,b,b],[]),
    q0([b,b,a,a,b,b,b,a,b,a,b,a,a,b,b,a,b,a,a,b,a,a,b,b,a,a,b,b,b,b,a,b,b,a,a,b,b,b,b,b],[]),
    q0([a,b,a,b,a,a,a,b,b,b,a,b,b,b,a,a,a,a,b,a,a,a,b,b,b,b,b,b,a,a,a,b,a,b,b,b,a,a,a,b],[]),
    q0([a,a,a,a,b,b,a,b,b,a,a,b,a,a,b,b,a,b,a,b,a,b,a,a],[]),
    q0([a,b,a,a,a,a,b,b,a,a,b,a,b,b,b,b,b,a,b,a,b,b,b,b],[]),
    q0([b,a,b,a,b,a,b,a,a,b,b,a,a,b,b,b,a,a,b,a,a,b,a,b],[]),
    q0([b,b,a,a,a,a,b,b,a,a,b,b,a,b,b,b,a,b,a,a,a,a,b,b,a,a,a,b,b,a,a,b,a,b,b,a,a,b,b,a],[]),
    q0([b,a,b,a,a,a,b,b,a,a,b,a,b,b,b,b,a,a,a,a,b,a,a,a,b,b,a,b,a,a,b,a],[]),
    q0([a,b,a,b,a,b,b,b,b,b,b,a,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,a,b,b,b,a,b,a,b,a,b,a,a,a,a,b,b,b,a,b],[]),
    q0([a,a,a,b,b,b,b,b,a,a,a,b,a,b,b,a,b,a,a,a,a,a,a,b,a,a,b,b,b,a,b,a,a,b,b,b,a,a,a,b],[]),
    q0([a,a,b,a,b,a,a,b,a,a,a,a,b,a,a,a,b,b,b,b,a,a,a,a],[]),
    q0([b,b,a,a,a,a,b,a,a,b,a,b,a,a,a,b,a,b,a,b,b,a,b,b,b,b,a,b,b,a,a,b,b,a,b,a,b,a,a,b,a,a,b,a,b,b,b,a,a,b,b,a,a,b,b,a],[]),
    q0([a,a,b,a,a,b,b,b,b,a,a,a,b,b,b,b,a,a,a,a,a,b,a,b,a,a,b,b,a,b,b,a,b,a,b,a,b,a,a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a,a,b,a,a,a,a,a,b,a,a,b,b,b,b,a,a,b,b,a,a,a,b,b,a,a,a],[]),
    q0([a,b,b,a,b,a,b,b,b,b,a,a,b,b,b,a,b,b,a,b,a,a,b,a,b,b,a,b,b,b,a,a,a,b,b,b,a,b,b,b,a,a,a,b,a,a,b,a],[]),
    q0([b,b,a,a,a,a,b,a,a,b,a,b,a,a,b,b,b,b,b,b,b,b,b,a,a,a,b,b,a,a,a,a],[]),
    q0([a,b,b,a,b,b,a,b,b,a,b,a,b,a,b,b,a,a,b,b,b,a,b,b],[]),
    q0([b,b,a,b,b,a,a,b,b,b,b,b,a,a,b,a,a,b,a,b,a,a,a,a,b,a,b,b,a,b,a,b],[]),
    q0([a,a,a,a,a,a,a,b,a,a,b,a,b,a,a,b,a,b,b,a,a,b,a,a],[]),
    q0([a,b,a,a,a,b,a,a,a,b,b,a,a,a,b,a,a,a,b,a,a,a,a,a],[]),
    q0([b,a,b,a,a,a,b,a,b,a,a,a,b,b,b,a,b,a,a,b,b,b,b,a,a,b,a,a,b,b,a,b,a,b,a,b,b,b,a,a,b,b,b,b,a,a,a,a],[]),
    q0([a,b,a,a,a,b,b,b,a,b,a,b,b,b,a,b,b,a,b,a,a,b,a,a,a,b,a,a,a,b,a,a],[]),
    q0([b,b,b,a,a,a,a,b,a,a,a,a,a,b,a,b,a,b,b,b,b,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,b,a,a,a,a,b,b,b,b,b,a,b,a,b,a,b],[]),
    q0([a,a,a,b,b,b,b,a,a,a,a,a,a,b,a,b,b,a,b,b,b,b,b,a,a,b,b,a,b,a,a,a,a,a,b,b,b,a,a,b,b,b,a,b,a,a,b,b],[]),
    q0([b,b,a,b,b,a,b,a,a,a,a,a,b,b,b,a,b,a,a,a,b,b,b,a,a,b,a,a,b,b,b,a],[]),
    q0([b,b,b,a,b,b,b,b,a,b,a,b,a,b,b,b,b,a,a,a,a,b,b,b,b,a,a,b,a,b,b,b],[]),
    q0([a,b,a,a,b,b,b,b,b,a,a,b,a,a,a,a,a,b,b,b,a,a,b,b],[]),
    q0([a,a,b,a,b,b,b,b,b,a,b,b,a,b,b,a,a,b,a,b,b,b,b,a],[]),
    q0([a,a,b,b,b,b,a,a,a,a,a,b,b,b,b,a,a,b,b,b,a,a,b,b],[]),
    q0([b,b,b,a,b,b,b,b,b,b,a,b,b,b,b,b,a,a,a,b,a,b,b,b,b,a,b,a,a,b,b,a],[]),
    q0([b,a,a,a,a,b,b,a,b,b,a,b,b,a,a,a,b,b,a,a,b,a,a,a,a,a,b,a,a,b,b,b],[]),
    q0([a,b,a,b,b,b,a,a,b,a,a,b,a,a,a,a,b,b,a,b,a,b,a,b],[]),
    q0([a,b,a,a,b,a,a,a,a,a,b,a,b,b,b,a,a,b,b,b,a,a,b,a,a,b,b,a,b,a,b,b],[]),
    q0([a,b,b,a,b,b,b,b,a,a,b,b,a,b,b,b,b,b,b,b,a,b,b,a,b,a,a,b,b,b,b,a,a,b,b,a,b,a,a,b],[]),
    q0([b,a,a,b,b,a,a,a,b,a,b,b,b,b,a,a,a,a,a,b,b,b,a,b,a,a,a,a,a,b,b,a],[]),
    q0([b,a,b,a,a,b,b,b,a,a,a,a,b,b,b,a,a,a,b,b,a,b,a,a,b,b,a,b,b,a,b,a,a,b,a,b,a,a,a,b,b,b,a,a,b,a,a,a],[]),
    q0([a,b,a,a,a,a,b,b,a,a,b,a,a,b,a,a,b,b,a,a,a,b,a,b,a,b,a,b,b,a,b,a],[]),
    q0([b,b,a,b,b,b,b,b,a,b,a,a,b,a,b,b,b,a,a,b,a,b,a,a],[]),
    q0([a,a,b,a,b,a,a,b,a,b,a,b,a,a,b,b,b,b,a,b,b,b,b,b,a,b,b,a,b,b,a,b,a,b,b,a,b,b,a,a,b,b,a,a,a,a,a,a,a,a,a,b,b,a,a,a],[]),
    q0([b,b,b,a,a,b,b,a,b,a,b,b,a,a,b,b,b,b,b,b,b,b,b,b],[]),
    q0([a,a,a,b,a,a,b,b,a,b,b,b,b,b,a,b,a,b,b,a,b,a,a,b],[]),
    q0([a,a,a,b,b,b,b,b,b,b,b,a,a,b,b,b,a,a,b,a,a,b,b,a,a,b,b,a,a,b,b,b,a,a,a,b,a,b,a,b,a,b,b,a,a,b,b,a],[]),
    q0([b,a,a,a,a,b,a,a,b,b,b,a,a,b,b,a,a,a,a,b,b,a,b,b],[]),
    q0([b,a,b,b,a,a,a,a,a,a,b,a,b,a,b,b,a,a,a,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,a,a,a,b,a,a,a,b,a,b,b,b,b,b,a,a,a,b],[]),
    q0([a,b,a,b,b,a,b,b,b,a,a,b,b,b,b,a,b,a,b,b,a,b,a,a,a,b,a,b,a,b,a,b,b,b,b,b,a,a,a,b],[]),
    q0([b,b,a,a,a,a,b,b,a,a,b,b,a,b,a,a,b,a,a,a,b,b,a,b,b,a,b,b,b,b,a,b,b,a,a,a,b,b,a,b,b,a,b,a,b,a,a,b],[]),
    q0([a,a,a,b,a,b,b,a,a,a,b,a,a,a,a,b,b,a,b,a,a,a,a,a],[]),
    q0([b,a,b,a,a,a,b,b,b,a,b,a,b,a,b,b,b,b,b,b,a,a,b,b],[]),
    q0([a,a,a,b,a,b,b,b,a,b,b,b,a,b,b,b,a,a,a,b,a,a,b,a],[]),
    q0([a,b,a,a,a,b,b,a,a,b,b,a,b,b,b,b,b,b,a,a,b,a,b,a,b,b,a,b,a,b,b,b,a,a,b,b,b,a,a,b,b,b,a,b,a,b,a,b,b,b,a,a,b,b,a,a],[]),
    q0([b,b,a,b,b,b,b,a,b,a,a,b,b,b,a,a,a,b,b,a,a,a,b,a],[]),
    q0([a,a,b,a,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,b,a,a,b],[]),
    q0([b,b,b,b,a,a,b,a,a,a,a,a,a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,b,b,b,b,b],[]),
    q0([a,a,a,a,b,a,a,a,b,b,b,a,a,b,a,b,b,a,b,a,b,b,b,a],[]),
    q0([b,b,a,b,b,a,b,a,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,b,b,a,b,b,b,b,b,a,b,a,a,a,a,a,b,a,a,a,b,b,b,a,a,a,b],[]),
    q0([b,a,b,b,b,b,b,b,b,b,a,a,a,b,a,a,b,b,b,b,a,a,a,b],[]),
    q0([a,b,a,b,a,a,a,a,b,a,a,b,a,a,b,b,a,b,a,b,a,b,a,a],[]),
    q0([a,a,b,a,b,a,b,b,b,b,a,a,b,b,a,b,a,a,b,a,a,b,b,a,a,b,b,b,a,a,b,b,a,b,b,a,a,b,a,a,a,b,a,b,b,b,b,a],[]),
    q0([a,b,a,a,b,b,b,b,b,a,b,a,b,b,a,a,a,b,b,b,b,a,b,b],[]),
    q0([a,b,b,a,a,b,a,b,a,a,b,b,b,b,a,b,b,b,b,b,a,a,a,b,a,a,b,b,b,a,b,a,b,a,a,a,b,b,b,a,b,a,a,b,b,a,a,b],[]),
    q0([b,b,a,b,b,a,b,a,b,b,b,a,b,b,a,b,b,a,b,a,b,a,a,a,b,b,a,a,b,a,b,a,a,a,b,a,a,b,b,b],[]),
    q0([b,b,a,a,a,a,a,b,a,b,b,a,a,b,a,b,b,b,b,a,a,b,a,a],[]),
    q0([a,a,a,b,a,b,b,b,b,b,a,b,a,b,b,b,b,b,a,a,b,b,a,a],[]),
    q0([a,a,a,a,a,b,a,b,b,a,b,b,a,b,b,a,a,a,b,b,a,a,a,b],[]),
    q0([a,b,a,a,b,b,b,b,b,a,b,b,a,a,b,b,b,a,b,a,b,a,a,b],[]),
    q0([a,a,b,b,b,a,a,a,b,b,b,a,a,a,a,b,a,b,b,a,b,a,a,b],[]),
    q0([a,b,b,a,b,a,a,b,a,b,a,b,a,b,b,a,b,b,a,b,b,b,a,a,b,b,b,b,b,a,a,a],[]),
    q0([b,a,b,b,a,b,a,a,a,b,a,a,a,b,a,b,b,b,b,b,a,b,b,b],[]),
    q0([a,a,b,b,b,b,a,a,a,a,b,a,b,b,b,b,a,b,a,a,a,b,a,a],[]),
    q0([b,a,a,b,a,a,a,a,a,a,a,b,b,a,a,b,b,a,b,a,a,b,b,b,b,a,a,b,a,b,b,a,a,a,a,b,b,b,b,a,b,a,b,b,a,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,b,a,b,a,a,a,b,a,b,a,b,a,b,a,b,b,b,a,a,b,b,b,b,b],[]),
    q0([a,b,b,a,a,b,a,b,b,b,a,b,b,b,a,a,a,b,a,b,b,a,a,b],[]),
    q0([b,b,a,b,a,a,a,a,a,a,b,b,a,b,a,a,b,a,a,b,a,a,b,a],[]),
    q0([b,a,a,b,a,a,b,b,a,a,b,a,a,a,a,b,a,b,b,b,a,b,a,a,a,a,b,a,a,b,b,b],[]),
    q0([b,a,b,a,a,b,a,a,b,b,b,b,a,b,b,a,a,b,b,a,b,b,b,b,a,b,b,b,a,a,b,a],[]),
    q0([b,b,a,b,a,a,a,b,a,a,b,a,a,a,b,b,a,a,a,a,b,a,a,b],[]),
    q0([a,b,b,a,a,a,b,b,b,b,a,b,b,b,b,a,a,b,b,b,b,b,a,b,b,a,a,a,a,a,a,b,b,a,b,a,b,b,b,b],[]),
    q0([a,a,a,b,b,a,b,a,b,b,a,b,a,b,a,a,a,a,b,b,b,a,b,a],[]),
    q0([a,a,a,a,b,a,b,b,a,a,b,b,b,a,a,a,b,a,b,b,a,b,a,a,b,b,b,b,a,a,b,b],[]),
    q0([a,a,b,a,a,b,a,a,b,b,b,b,b,a,b,a,a,a,a,a,b,b,a,b,b,a,a,b,a,b,b,a],[]),
    q0([a,a,a,b,b,b,b,b,b,a,a,b,a,b,b,b,a,b,b,b,b,a,a,a,b,a,a,b,b,b,b,a,b,b,a,b,a,a,b,b],[]),
    q0([b,b,a,a,b,b,b,a,b,b,b,b,b,b,a,a,a,b,a,a,b,b,a,a,b,a,b,a,a,b,a,b,b,a,b,a,b,b,b,a,b,a,a,a,a,a,a,a,b,b,a,a,a,a,a,b,b,a,a,b,b,a,a,b,a,b,b,b,b,b,b,a],[]),
    q0([a,a,a,b,a,a,b,b,b,a,a,b,a,a,a,a,b,b,b,b,a,b,a,a],[]),
    q0([b,a,b,a,a,b,b,b,a,a,b,b,b,b,a,a,a,a,b,a,a,b,a,b],[]),
    q0([a,a,b,a,a,a,a,b,b,a,b,a,a,b,a,b,b,a,a,b,a,b,a,b,b,b,a,b,b,b,b,b,a,b,b,b,a,a,b,a],[]),
    q0([a,a,b,b,a,b,b,b,a,b,a,b,a,a,b,b,b,b,a,a,b,b,b,a,b,a,b,b,a,a,b,a,b,a,a,b,b,a,b,b,a,b,b,b,b,b,b,b],[]),
    q0([a,b,b,a,a,b,b,b,a,a,a,b,a,b,b,b,a,b,a,a,a,b,a,a],[]),
    q0([b,b,b,a,a,b,b,b,a,b,a,a,b,a,b,b,a,b,b,b,a,a,b,b],[]),
    q0([b,a,a,a,b,b,b,b,a,a,b,a,b,a,a,b,a,b,a,a,b,a,b,b,b,a,a,b,a,a,a,a,a,b,b,a,a,b,b,b,b,b,a,b,a,b,b,a],[]),
    q0([a,a,b,a,a,a,a,b,a,b,a,b,b,b,a,a,a,a,a,b,b,b,a,b],[]),
    q0([b,b,a,a,a,b,a,a,b,a,a,a,a,b,b,b,a,b,a,b,b,a,a,b],[]),
    q0([a,a,b,a,a,a,b,a,a,b,b,b,a,b,b,b,b,a,b,a,b,a,a,a,b,b,a,a,a,b,b,b,b,b,a,a,a,a,a,a,b,b,a,b,b,b,a,b],[]),
    q0([b,b,a,a,b,b,b,a,a,b,a,a,b,b,b,b,a,b,b,a,b,a,b,b],[]),
    q0([b,a,b,a,b,a,a,a,b,a,b,a,b,a,b,b,b,a,a,a,b,b,a,b,b,b,b,b,b,b,a,b,a,a,a,b,a,b,a,a,a,a,a,b,b,a,a,a],[]),
    q0([b,b,b,a,b,b,b,a,b,b,b,a,a,b,b,a,b,b,b,a,b,b,b,b,a,a,b,a,a,a,a,b],[]),
    q0([a,a,b,b,a,b,a,b,a,a,b,a,b,a,b,a,b,b,a,a,b,b,b,a,b,b,a,b,a,b,b,b,b,a,a,a,a,b,b,b,b,a,b,b,b,b,a,a],[]),
    q0([b,b,a,a,b,b,a,b,a,a,a,b,a,a,a,a,b,b,b,b,b,a,a,b],[]),
    q0([b,b,b,b,b,b,b,a,b,a,a,a,a,b,a,b,a,a,b,a,a,a,b,b,b,a,b,a,a,a,b,b,a,b,a,a,a,a,b,a],[]),
    q0([a,a,a,b,a,b,b,b,a,a,b,b,a,b,b,b,a,b,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,b,a,a,b,a,b,a,a,a,b,a,b,a,b],[]),
    q0([a,a,a,a,b,b,a,b,b,b,b,a,a,a,a,a,a,a,b,b,b,b,b,b,b,b,a,a,b,a,b,a,a,a,a,b,a,a,a,a,a,b,a,a,a,b,a,b,b,a,a,a,a,b,b,a,a,b,a,b,b,b,b,b,b,b,b,a,b,a,b,a],[]),
    q0([a,a,a,b,b,b,b,a,a,b,a,b,b,a,b,b,a,b,b,a,b,a,a,b],[]),
    q0([b,b,a,a,b,a,b,b,a,a,b,b,b,b,a,b,b,b,a,b,a,b,b,a,b,b,a,b,b,a,a,a,b,a,a,b,a,b,a,a,a,a,b,a,b,b,a,b,a,a,a,b,b,b,b,a],[]),
    q0([b,a,a,b,a,a,a,a,b,b,a,a,b,b,b,a,a,a,a,a,a,b,b,b],[]),
    q0([a,b,b,a,b,a,b,a,b,b,a,b,a,a,a,a,b,b,a,a,b,a,b,b],[]),
    q0([b,b,b,b,a,b,b,a,b,a,b,b,a,a,b,b,b,a,a,a,b,b,b,a,a,b,a,b,a,a,a,a,b,a,a,b,b,a,b,b],[]),
    q0([b,a,a,b,b,b,b,b,b,a,b,b,b,b,a,a,b,a,a,b,b,b,a,b],[]),
    q0([b,b,a,b,a,a,b,b,a,a,b,b,b,a,a,a,a,a,a,b,a,a,a,b],[]),
    q0([b,a,b,a,b,b,b,b,a,b,b,a,a,b,a,b,b,a,a,a,b,b,a,a,b,b,a,b,a,a,b,b,b,a,a,a,b,a,b,a,b,a,b,b,a,b,a,b,b,b,b,b,b,b,b,a,a,b,b,b,a,b,b,b,a,a,a,a,b,a,b,b],[]),
    q0([a,b,a,b,a,b,a,b,b,b,b,a,a,b,b,a,a,a,b,a,a,a,b,b,a,b,a,b,a,a,b,b,b,a,a,b,a,b,a,a],[]),
    q0([a,b,a,a,b,a,b,b,b,a,b,b,a,b,b,a,b,a,b,b,b,a,b,b],[]),
    q0([b,b,b,a,b,a,a,b,b,b,b,a,a,a,b,a,b,a,b,a,b,b,a,a,a,a,b,b,b,a,b,b,b,a,b,a,a,b,b,b,b,a,a,a,a,b,a,a,a,b,b,a,a,b,b,b,b,a,a,b,b,b,b,a],[]),
    q0([a,b,b,a,b,b,a,b,a,b,a,a,a,a,b,b,a,b,a,b,a,a,b,b,a,a,b,b,b,b,b,a,b,a,a,b,a,b,b,b],[]),
    q0([a,b,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a,a,b,a,b,a,b,b,a,a,b,b,a,b,b,a],[]),
    q0([a,b,a,a,b,a,a,a,b,a,b,b,a,a,a,a,a,a,b,b,a,a,a,a],[]),
    q0([b,b,b,b,a,a,b,a,b,a,a,b,b,a,a,a,a,b,b,b,b,a,a,b,b,b,a,b,b,b,b,a,b,a,b,a,a,a,a,a,a,a,b,b,a,b,b,a,b,a,a,a,a,a,a,a,a,b,b,b,b,b,a,b],[]),
    q0([a,a,b,b,b,b,b,b,b,a,b,a,b,a,b,b,a,b,a,a,a,a,b,a],[]),
    q0([b,a,a,a,a,a,a,b,b,b,b,a,b,b,b,b,a,a,a,a,a,b,a,a],[]),
    q0([b,b,a,a,b,a,b,a,a,a,a,a,b,b,b,a,a,a,b,a,b,a,b,b,a,a,a,b,b,b,b,b,b,b,a,a,b,a,a,a],[]),
    q0([a,a,b,a,b,a,a,a,b,a,b,a,b,a,b,a,a,a,a,a,b,b,a,b,b,b,b,a,a,a,a,a,b,a,a,b,b,a,b,b],[]),
    q0([a,b,a,a,a,b,b,a,a,b,a,a,b,a,a,a,a,b,b,b,a,b,a,b],[]),
    q0([a,b,a,a,a,b,b,b,a,b,a,a,b,a,b,b,b,b,a,a,b,a,a,a],[]),
    q0([a,b,a,b,b,b,a,b,a,a,b,a,a,a,a,b,a,a,b,a,b,b,a,b],[]),
    q0([a,a,a,a,b,a,b,a,a,b,a,a,a,a,b,b,a,b,b,a,a,a,a,b],[]),
    q0([b,b,a,a,a,a,b,a,b,b,b,b,b,a,b,a,a,b,b,b,b,a,a,a],[]),
    q0([b,b,b,a,b,a,b,b,a,b,a,b,a,a,b,b,a,a,a,a,b,a,a,b],[]),
    q0([b,a,b,a,b,a,a,a,a,b,b,a,b,b,b,b,a,b,b,a,b,b,b,b,a,b,a,a,a,b,a,b,a,a,a,b,b,b,b,b,a,a,b,a,b,a,a,b,b,b,a,a,b,b,b,b],[]),
    q0([a,b,b,b,b,a,b,b,b,b,a,b,b,a,a,a,a,a,b,a,b,a,b,b,b,b,a,b,a,a,b,b],[]),
    q0([a,b,a,b,b,a,a,b,b,b,a,b,a,a,b,b,b,b,a,a,b,a,b,b,b,b,a,a,b,b,b,b,a,b,a,a,b,a,a,a],[]),
    q0([a,a,a,b,a,b,b,a,b,b,a,b,b,a,a,b,b,b,a,a,b,b,a,a],[]),
    q0([b,a,b,a,b,a,b,b,a,b,a,a,a,a,b,b,b,b,b,b,b,b,a,a],[]),
    q0([b,b,a,a,b,b,a,b,b,b,a,b,b,b,b,a,b,b,b,a,b,b,a,a,b,a,a,a,a,a,a,a,a,b,a,a,b,a,b,a],[]),
    q0([a,a,a,a,b,a,b,b,a,a,b,a,a,a,b,a,a,a,a,b,a,a,b,a],[]),
    q0([b,a,a,a,a,a,a,b,b,a,a,a,b,b,b,a,a,a,a,a,b,a,b,b,a,a,a,b,b,b,b,b,a,b,b,a,b,a,a,a],[]),
    q0([a,a,b,b,a,b,b,b,b,b,a,a,a,b,a,a,b,a,a,b,b,b,b,a],[]),
    q0([a,a,a,a,b,b,b,a,b,b,a,a,a,a,b,b,b,a,a,b,b,a,a,a],[]),
    q0([a,b,b,a,b,b,b,b,a,b,a,a,a,a,b,a,a,b,b,b,b,a,b,b,a,b,b,b,b,a,a,a,a,a,b,a,a,a,b,b,b,b,b,a,b,b,b,b,b,a,b,b,b,b,a,a,b,b,a,a,b,b,b,a],[]),
    q0([b,b,a,b,a,b,b,b,a,a,b,a,a,b,a,a,b,b,b,a,a,a,a,b,b,b,b,a,a,a,b,b],[]),
    q0([a,b,a,b,a,a,b,a,a,a,b,b,a,b,a,b,a,b,b,b,b,b,a,a],[]),
    q0([a,b,b,a,b,a,b,a,a,b,a,a,a,b,a,b,a,b,b,a,b,a,a,a],[]),
    q0([b,a,b,a,a,b,a,a,a,b,a,a,b,a,b,b,b,b,b,a,b,a,a,a],[]),
    q0([b,a,b,b,b,b,b,b,b,a,b,b,b,b,b,a,b,b,b,b,a,a,b,b],[]),
    q0([b,b,b,b,a,b,b,a,a,b,b,a,b,b,b,b,a,a,a,b,a,a,b,b],[]),
    q0([b,b,b,a,a,b,b,b,b,b,a,a,a,a,b,a,b,b,a,b,a,b,b,b,b,b,b,a,a,a,a,a,b,b,a,b,a,b,a,b],[]),
    q0([b,a,a,b,b,a,b,a,a,b,b,b,b,a,b,b,a,a,a,a,a,b,b,a],[]),
    q0([b,b,b,a,a,a,a,b,b,b,a,a,b,b,a,b,b,a,a,a,b,b,a,a,b,a,b,a,b,b,b,b,a,b,b,b,a,b,a,b,a,a,b,b,a,b,b,a,a,a,b,a,a,b,a,b],[]),
    q0([b,b,b,a,b,b,a,a,b,a,b,a,a,a,b,b,a,a,b,a,b,b,a,a,b,a,a,b,a,a,b,a],[]),
    q0([b,b,b,a,a,b,a,b,b,a,b,b,b,b,b,b,a,b,a,b,a,a,b,a,a,a,b,a,b,a,a,b,a,a,b,b,a,b,b,a],[]),
    q0([a,b,b,a,a,b,a,b,b,a,a,b,b,b,a,a,b,b,a,a,b,b,a,a],[]),
    q0([b,a,b,b,a,a,b,b,b,a,b,b,a,b,a,a,b,b,b,b,a,a,b,b],[]),
    q0([a,a,a,a,b,a,a,a,a,b,a,b,a,a,a,b,b,b,b,b,a,a,a,b],[]),
    q0([a,b,b,b,a,a,a,a,a,a,b,a,a,b,a,a,b,a,a,b,a,b,b,a],[]),
    q0([a,a,b,a,a,a,b,a,a,a,a,a,b,a,b,b,a,a,a,a,b,a,b,b,b,a,b,a,b,b,b,a,a,a,a,b,a,b,a,a],[]),
    q0([a,a,a,b,b,b,b,a,b,b,b,a,b,b,b,a,b,a,a,a,a,a,b,b],[]),
    q0([a,a,b,b,a,b,a,b,a,b,a,a,a,b,b,b,a,b,b,a,a,a,a,a],[]),
    q0([b,a,b,a,a,b,a,a,b,a,a,b,a,a,a,a,b,b,a,a,a,a,a,b,b,a,b,b,b,b,a,a],[]),
    q0([b,b,a,b,b,b,b,a,b,a,b,a,b,b,b,b,a,b,a,b,a,b,a,a,a,b,a,a,a,a,a,b,b,b,b,b,a,a,a,b],[]),
    q0([b,a,a,b,a,b,b,a,b,b,b,b,a,b,b,a,a,a,a,b,b,b,b,b,b,b,a,b,b,a,a,b,a,a,b,a,b,b,a,a,b,a,a,a,a,a,b,a,b,b,a,b,b,a,a,a,a,b,a,b,a,b,b,b,b,b,b,b,b,a,b,b,a,b,a,a,a,b,b,b,b,a,b,b,a,b,b,b],[]),
    q0([a,b,a,b,b,b,a,a,a,b,a,b,b,a,b,b,b,a,b,a,b,a,b,b,a,a,a,b,a,a,a,a,b,a,b,b,a,b,a,b,b,b,a,a,b,b,a,a,a,a,a,a,a,b,b,b,b,b,a,a,b,a,b,b,b,b,a,a,b,b,b,b],[]),
    q0([a,b,a,a,b,b,a,b,a,a,b,a,b,a,a,b,a,b,b,a,a,a,b,a,a,a,a,a,b,b,b,b,a,b,a,b,b,b,b,a,a,b,a,b,b,a,b,b],[]),
    q0([b,a,b,b,a,b,a,a,a,a,b,a,a,b,a,a,b,a,b,a,a,a,b,b,a,a,a,b,a,b,a,a],[]),
    q0([a,a,a,a,a,b,a,b,b,b,b,a,b,b,a,a,a,b,b,b,a,a,a,a,b,b,a,a,b,b,b,b],[]),
    q0([b,b,b,a,b,b,b,b,a,a,b,b,b,a,a,b,b,b,b,b,a,b,a,b],[]),
    q0([b,a,b,b,b,b,b,b,b,a,a,b,b,b,b,a,a,a,a,b,b,a,b,b],[]),
    q0([a,b,b,a,a,a,b,b,b,b,a,b,b,a,a,b,b,b,a,a,a,a,a,a],[]),
    q0([b,b,a,b,b,a,a,b,b,a,b,a,a,a,b,a,b,a,a,a,a,a,a,b,a,a,a,b,a,a,b,a,a,a,b,b,a,a,a,b],[]),
    q0([b,b,a,b,b,a,b,b,b,b,b,a,a,a,a,a,b,b,a,b,a,a,b,b,a,b,b,b,b,b,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,a,a,a,b,a,a,a,b,b,a,a],[]),
    q0([b,b,a,b,b,a,a,a,a,a,b,a,b,b,b,a,a,a,a,b,b,a,b,b],[]),
    q0([b,b,a,a,b,a,b,a,a,b,b,a,a,a,b,b,b,a,a,b,b,b,a,b],[]),
    q0([b,a,b,a,a,a,b,a,a,a,a,a,a,a,a,a,b,a,b,b,b,a,a,a],[]),
    q0([a,b,b,a,b,a,b,a,b,a,a,b,b,b,b,a,b,b,a,b,a,b,b,b,a,b,b,a,b,a,a,b],[]),
    q0([b,b,b,a,a,a,a,b,b,a,b,b,b,b,b,b,a,b,b,a,a,b,a,a],[]),
    q0([a,b,b,a,a,a,b,b,a,a,a,a,a,a,a,b,a,a,a,b,a,b,a,a],[]),
    q0([b,a,a,b,b,b,b,a,a,b,a,a,b,a,a,a,a,b,b,b,b,b,a,a],[]),
    q0([a,b,b,b,a,b,b,b,a,a,b,b,b,b,b,a,b,b,b,a,b,a,b,a],[]),
    q0([b,b,a,b,a,a,a,b,b,a,b,a,b,a,b,b,b,b,b,a,a,a,b,b],[]),
    q0([a,b,a,b,a,b,a,b,b,a,b,a,b,a,b,b,a,b,a,b,a,b,a,a],[]),
    q0([b,b,a,a,a,b,a,a,b,b,a,b,a,a,a,b,b,a,a,a,a,a,a,a],[]),
    q0([a,b,b,a,a,b,a,b,b,b,a,a,a,b,b,a,a,b,a,b,b,b,a,a,b,a,b,b,b,a,b,a],[]),
    q0([b,b,a,b,a,b,b,b,a,a,a,a,b,a,a,a,a,b,a,a,a,b,a,a],[]),
    q0([a,b,b,a,b,b,a,b,a,a,a,b,b,b,b,a,a,b,a,b,a,a,b,a,b,b,b,b,a,b,b,b],[]),
    q0([b,a,a,a,b,a,b,a,b,a,b,a,a,b,b,b,a,b,b,a,b,a,b,a,b,b,b,b,b,a,a,a],[]),
    q0([a,a,b,a,b,a,b,a,b,a,b,a,b,a,b,b,a,b,b,a,a,b,b,b,b,b,b,b,b,a,b,a,b,a,a,a,a,b,a,a,b,b,a,b,b,a,b,b,b,a,b,b,b,a,b,b],[]),
    q0([b,a,a,a,a,b,a,a,b,b,a,a,a,a,a,b,a,a,b,a,a,a,a,b,a,a,a,a,b,a,a,a,a,a,b,a,b,b,b,a,a,b,a,a,a,a,a,b],[]),
    q0([b,a,a,b,b,a,a,b,b,a,a,b,b,b,a,b,b,b,b,a,b,a,a,b],[]),
    q0([a,b,b,b,a,b,b,b,b,b,b,a,a,a,a,a,b,a,b,a,b,a,a,a,b,b,a,b,b,b,a,a,b,a,a,a,b,a,a,b,b,b,a,a,b,a,b,b],[]),
    q0([b,b,b,b,b,a,b,a,a,b,a,a,a,a,b,b,b,b,b,a,b,b,a,a,a,b,a,b,a,a,a,b,b,b,a,b,a,a,a,a,a,a,a,a,b,b,b,b,a,a,b,b,a,a,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,a,a,a,b,a,b,b,a,b,b,b,a,a,b],[]),
    q0([a,b,a,a,a,b,b,a,b,b,a,a,a,b,a,b,b,a,a,a,b,a,b,a,a,b,a,b,b,b,a,b,b,b,a,a,a,a,b,a,b,b,b,b,a,b,b,b,a,a,a,a,b,a,a,b],[]),
    q0([b,b,a,b,a,a,b,b,b,a,b,b,a,b,a,a,a,b,a,a,b,a,b,b,a,a,a,b,a,a,a,b],[]),
    q0([a,b,b,a,b,a,b,a,b,a,b,b,a,b,b,b,a,b,b,a,b,b,b,b,a,a,a,b,a,b,b,b,a,a,b,b,b,b,a,b,a,b,b,b,a,a,b,b],[]),
    q0([b,a,b,b,a,a,b,b,b,b,b,a,a,b,b,b,a,b,b,b,b,a,a,a],[]),
    q0([a,b,b,b,a,b,a,a,b,b,a,a,a,b,a,b,a,b,a,b,a,b,a,b,a,b,a,a,a,b,a,a],[]),
    q0([a,b,b,b,a,b,a,a,a,a,a,a,b,a,b,b,a,b,a,a,a,b,b,a,a,b,b,b,b,b,b,b,a,b,b,b,a,a,a,b],[]),
    q0([a,a,b,b,b,b,a,a,b,b,a,a,a,a,a,b,a,b,a,b,b,a,b,b,a,a,a,a,b,b,b,b],[]),
    q0([a,b,a,b,a,a,a,a,b,b,b,b,b,b,b,a,a,b,a,b,a,a,b,b,b,b,a,b,b,b,b,a,b,b,b,a,a,a,b,a,a,a,b,b,b,a,b,a],[]),
    q0([a,a,a,b,a,a,b,b,b,b,a,a,b,b,b,a,a,b,b,a,b,a,a,b],[]),
    q0([b,b,b,a,a,a,b,a,a,a,a,a,a,b,a,b,a,a,a,b,a,a,a,a,b,a,b,b,b,b,a,a,a,b,a,b,b,b,a,a,a,a,a,a,b,b,a,a,b,a,a,a,a,b,b,a,a,a,a,b,b,a,a,a,a,b,b,a,b,a,a,a,a,b,a,a,a,b,a,b,b,a,b,b,b,a,a,a],[]),
    q0([a,b,a,b,a,a,a,b,a,b,b,a,b,b,b,b,b,b,b,a,b,b,b,b,a,b,a,b,a,b,b,b,b,a,a,b,b,b,a,b],[]),
    q0([a,b,b,b,a,b,b,b,a,b,b,a,b,b,b,b,a,b,a,a,a,b,b,b,a,a,a,a,a,a,a,a],[]),
    q0([b,b,b,b,b,b,b,a,a,a,b,b,b,b,a,a,b,a,b,a,b,a,b,a,b,b,b,b,b,b,b,b],[]),
    q0([a,b,b,a,b,b,a,b,b,a,b,a,a,b,b,b,b,b,a,b,a,b,a,b],[]),
    q0([b,b,b,b,a,b,b,a,b,b,b,a,b,b,b,a,a,a,b,b,b,b,b,b,b,a,b,b,b,a,a,b],[]),
    q0([b,a,a,b,b,b,b,a,b,b,b,b,b,b,b,a,b,b,b,b,a,b,a,b],[]),
    q0([b,b,a,a,a,b,a,a,b,b,a,b,b,a,a,b,b,b,b,b,b,b,a,b],[]),
    q0([b,a,a,a,b,a,b,a,b,b,b,a,a,a,a,a,a,a,b,a,b,b,b,b,b,b,b,b,a,b,a,a,a,a,b,b,a,a,b,a,b,a,a,b,a,b,b,a,b,a,b,b,a,a,a,b],[]),
    q0([a,a,b,a,b,a,a,b,b,a,a,a,b,a,b,a,b,a,a,b,a,a,a,b],[]),
    q0([b,b,b,a,a,a,b,b,b,a,b,b,a,b,b,a,a,b,b,a,b,b,b,a,a,b,a,a,b,b,a,b,b,a,b,a,a,a,a,a,b,b,b,b,a,a,a,a,b,b,a,b,a,a,b,b,a,b,a,a,b,a,a,b],[]),
    q0([b,a,b,a,a,a,b,b,b,a,b,b,a,a,b,b,a,b,a,a,a,a,a,a,b,b,b,b,b,b,a,a,a,b,a,a,a,b,a,a],[]),
    q0([b,b,a,a,a,b,b,a,a,b,a,a,b,a,a,a,a,b,b,a,a,b,a,a],[]),
    q0([b,b,a,a,a,a,b,b,a,a,b,b,a,b,b,b,a,b,a,b,b,a,b,a],[]),
    q0([b,a,a,a,a,a,a,a,b,b,a,b,a,a,a,b,b,b,b,b,a,a,a,a,a,a,a,b,a,b,a,a,a,b,b,b,a,a,a,a,a,a,a,b,a,a,b,a,b,b,a,b,b,b,b,b,b,b,b,a,a,b,a,a,a,a,a,a,a,b,b,a,a,b,b,a,b,a,b,b],[]),
    q0([a,b,a,b,b,b,a,b,b,b,a,a,b,a,b,a,b,b,a,b,a,b,a,b],[]),
    q0([a,b,b,b,b,a,b,a,b,b,b,a,b,b,b,b,b,a,a,b,b,b,a,a,b,b,b,b,a,a,b,b,a,a,a,a,a,b,b,b,a,a,a,b,a,b,a,b],[]),
    q0([b,b,a,a,a,a,b,a,a,a,b,b,b,a,a,a,b,a,b,b,a,a,b,a],[]),
    q0([a,a,b,a,a,b,b,a,b,b,b,a,a,b,b,a,a,b,a,b,a,a,a,b,a,b,a,a,b,a,a,b,b,a,a,a,b,a,b,b],[]),
    q0([b,b,a,b,b,a,a,b,b,b,a,a,a,a,b,b,a,a,a,b,b,a,a,a],[]),
    q0([a,b,b,b,b,a,b,a,b,a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,b,b,a,b,b,b,a,a,b,a,a,b,a,b,a,a,b,a,a,b,b,b,a,b],[]),
    q0([b,b,b,b,b,a,b,a,b,a,b,b,a,a,a,a,b,a,b,a,a,a,b,b,b,a,b,b,b,a,b,a],[]),
    q0([b,a,a,b,a,a,a,a,a,b,a,b,a,b,b,b,a,b,b,a,a,a,a,b],[]),
    q0([b,a,b,b,a,b,a,a,b,a,b,a,a,a,b,b,a,b,a,a,a,a,a,b],[]),
    q0([b,b,b,a,a,a,a,a,a,a,a,a,a,b,b,b,b,b,a,a,a,a,b,a,a,b,b,b,b,a,a,a,b,a,b,b,a,a,a,a],[]),
    q0([a,b,b,a,b,b,b,b,a,b,a,a,a,a,b,b,a,b,a,a,b,a,a,a,a,a,a,b,a,a,a,a,b,b,a,a,a,a,b,a],[]),
    q0([b,b,b,a,a,b,b,b,b,b,a,b,a,a,b,b,b,b,a,b,a,a,a,a,a,a,a,b,a,a,a,a,b,b,b,a,b,a,a,a],[]),
    q0([a,a,a,a,a,b,a,b,a,b,a,b,b,b,a,b,b,b,a,b,a,b,b,a],[]),
    q0([a,a,a,b,a,b,b,a,a,b,a,b,a,b,a,b,a,a,a,a,a,a,a,b,a,b,b,b,b,a,a,b],[]),
    q0([a,a,a,a,b,a,a,a,a,b,b,a,b,a,b,a,a,a,a,b,b,a,b,a,b,a,b,b,a,a,a,a,a,a,a,b,a,a,a,b,b,b,a,a,b,b,b,b,a,b,b,a,a,a,a,a],[]),
    q0([a,a,a,a,a,a,a,b,a,b,a,a,b,a,a,a,b,a,b,b,a,a,a,b],[]),
    q0([a,b,a,b,a,a,a,a,b,a,a,a,b,a,b,a,a,b,a,a,b,a,a,b],[]),
    q0([b,a,b,a,a,b,a,a,b,a,a,b,a,b,a,b,a,b,b,a,b,a,b,b],[]),
    q0([b,b,b,a,b,b,b,b,a,a,b,b,b,a,a,a,b,b,b,b,b,b,a,a],[]),
    q0([a,b,b,b,b,b,a,b,a,b,a,a,a,b,a,b,b,a,b,b,b,b,a,a],[]),
    q0([b,a,b,a,b,b,a,a,b,b,b,b,b,a,a,b,b,b,a,a,a,a,b,b,a,a,a,b,b,b,a,a,b,b,a,a,a,a,b,b,a,b,b,a,a,a,b,b],[]),
    q0([b,a,a,a,a,b,b,b,b,b,a,a,a,a,b,b,a,a,a,b,b,b,a,a,a,a,b,b,a,a,a,a,b,a,b,a,b,b,b,b],[]),
    q0([a,a,a,a,a,a,a,b,a,b,b,a,b,b,a,b,b,a,a,b,b,a,a,b],[]),
    q0([b,b,a,a,b,b,a,b,b,b,a,b,a,b,b,b,a,a,b,b,a,b,b,b,b,b,a,b,a,a,b,a],[]),
    q0([a,b,a,a,b,b,a,b,a,a,b,b,b,a,a,b,a,a,a,b,a,b,a,a],[]),
    q0([b,b,b,a,b,b,b,b,b,b,a,a,b,a,b,a,b,b,b,b,a,a,b,a,a,b,b,b,a,b,b,b,b,a,a,a,b,b,a,a],[]),
    q0([a,a,b,b,a,a,b,b,b,b,b,a,b,b,b,b,a,b,b,a,b,b,b,b,b,b,b,a,b,a,a,b,b,a,a,b,a,b,b,a],[]),
    q0([b,a,b,a,a,b,a,a,b,b,a,a,a,a,b,b,a,b,a,b,a,a,b,b,b,b,a,b,a,a,a,a],[]),
    q0([b,a,b,b,a,a,a,a,b,b,b,a,a,a,a,b,b,b,b,b,b,a,a,a],[]),
    q0([b,b,a,b,b,a,b,b,b,b,a,b,a,b,b,a,a,b,b,b,b,a,a,b,b,b,b,b,a,a,b,b,a,b,a,b,a,b,a,b,a,a,b,b,b,a,b,b,a,a,b,a,b,b,b,b],[]),
    q0([b,b,a,b,b,b,b,a,b,a,a,a,b,b,b,b,b,a,a,b,b,a,b,a],[]),
    q0([a,a,a,b,a,b,b,b,a,a,b,b,b,a,a,b,b,a,a,b,a,b,a,a,a,b,b,b,b,a,b,b,b,b,b,b,b,b,a,a],[]),
    q0([b,a,a,b,b,b,a,a,b,b,b,b,a,b,a,a,a,a,b,a,b,b,a,b,a,b,b,a,b,b,b,a,a,b,b,a,b,a,b,b,a,a,b,b,b,a,a,a],[]),
    q0([a,a,a,a,b,b,b,a,b,b,a,a,a,b,b,a,a,a,a,a,a,b,a,a],[]),
    q0([b,b,b,b,a,a,b,a,b,b,a,a,b,b,a,b,a,b,a,a,a,b,b,b,a,a,a,b,a,b,a,b],[]),
    q0([a,a,b,b,a,a,a,a,a,a,b,b,b,a,b,b,b,b,b,a,b,a,a,b,a,a,b,b,b,b,a,a,b,a,a,b,b,b,b,a],[]),
    q0([a,a,a,a,b,b,a,b,a,b,a,b,a,a,b,b,a,a,a,b,b,a,a,b],[]),
    q0([b,b,b,a,a,a,a,a,a,b,b,b,b,b,a,b,b,a,b,a,a,b,a,b,a,a,b,a,a,a,b,a,a,a,a,b,b,b,b,a,a,a,a,b,b,a,a,b,a,b,a,b,b,a,a,b,a,b,a,a,a,b,a,a],[]),
    q0([a,b,a,a,b,b,b,b,b,b,b,a,b,b,b,b,a,a,a,a,a,b,b,b],[]),
    q0([a,b,a,b,a,a,b,b,a,a,a,a,a,b,a,b,b,a,a,a,a,b,a,b,a,b,a,b,b,a,a,b,b,b,b,b,a,a,a,b],[]),
    q0([a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a,b,b,a,b,b,b,a,b,a,a,a,b,a,b,a,a],[]),
    q0([b,b,a,a,b,b,a,b,a,a,a,b,b,b,b,b,b,b,a,b,b,b,b,b,b,b,b,b,a,a,a,b,a,b,a,b,b,b,b,b],[]),
    q0([a,b,b,a,a,b,b,b,a,a,b,a,a,a,b,b,b,b,b,b,b,a,a,a],[]),
    q0([a,b,a,a,b,b,b,b,a,a,a,a,b,a,b,b,a,b,a,b,a,a,b,a,b,a,b,b,b,b,a,a],[]),
    q0([a,a,b,a,b,b,b,b,b,a,a,b,a,b,a,b,b,a,b,b,a,b,b,a,a,a,a,a,b,a,a,a,b,b,b,b,b,b,a,a],[]),
    q0([b,a,b,b,a,b,b,b,b,b,b,b,a,b,b,a,a,a,a,a,a,a,a,b,a,b,a,b,a,a,b,b,a,a,b,b,a,b,a,b,a,b,a,a,b,a,b,a],[]),
    q0([a,a,b,b,a,b,a,a,b,b,a,a,a,b,b,b,a,b,a,b,a,a,a,b,a,b,a,a,a,b,b,b,a,a,a,b,b,b,a,b],[]),
    q0([a,a,b,a,b,a,a,a,b,b,b,a,a,b,a,b,a,a,b,a,b,b,b,b,b,b,a,a,a,a,a,a],[]),
    q0([a,b,b,a,a,a,b,b,b,a,a,a,b,b,b,a,a,b,a,b,b,a,b,a],[]),
    q0([a,a,a,a,a,a,b,b,b,a,a,b,a,b,b,a,b,a,a,b,b,a,b,b,a,a,a,a,b,a,a,b,b,b,a,b,b,a,b,a,a,b,a,a,a,a,b,b,b,a,b,b,b,b,a,b,a,b,b,b,a,b,a,b],[]),
    q0([a,a,a,b,a,b,b,b,a,b,a,b,b,a,b,b,b,b,b,a,a,b,a,b,a,b,b,a,b,a,b,a,a,b,a,b,a,a,a,a,b,b,a,a,b,b,a,a],[]),
    q0([b,b,a,b,a,a,b,b,b,a,b,b,b,b,b,a,a,a,a,a,a,a,a,b,b,a,b,a,a,b,a,b,a,a,a,a,a,a,a,b],[]),
    q0([b,b,a,a,a,b,b,a,b,a,a,b,a,a,b,b,b,a,a,a,a,a,b,a],[]),
    q0([b,b,b,b,b,a,b,a,a,a,a,a,a,b,a,b,b,a,b,a,b,a,b,a,a,b,a,a,a,a,a,b],[]),
    q0([b,b,b,a,a,b,b,b,b,b,a,b,a,b,b,b,a,a,b,a,b,b,a,b],[]),
    q0([b,a,b,a,a,b,b,a,a,b,a,a,a,b,b,b,a,b,b,b,a,b,a,b],[]),
    q0([a,b,a,a,a,a,a,a,b,a,b,b,a,a,a,a,a,a,b,b,a,b,b,a],[]),
    q0([b,a,b,a,b,a,b,b,a,b,a,b,b,b,a,a,b,a,b,a,a,b,a,b,b,a,b,b,b,b,b,a,a,b,b,a,a,b,b,b,b,b,b,b,b,a,a,a,b,a,b,b,b,a,b,a],[]),
    q0([a,b,a,b,a,a,a,a,a,b,b,a,b,b,a,b,a,a,a,a,a,b,b,a,a,b,b,a,b,b,b,a],[]),
    q0([b,b,a,a,a,b,a,a,b,a,a,a,a,b,a,a,b,a,b,b,b,a,b,a],[]),
    q0([a,b,a,b,b,a,b,b,a,b,a,b,b,b,a,a,b,a,b,a,a,b,a,b,a,a,a,a,a,a,a,a],[]),
    q0([b,a,a,a,b,b,b,b,a,b,a,a,a,b,a,b,a,b,b,b,a,a,b,b],[]),
    q0([a,a,a,b,a,a,b,b,a,b,a,b,b,b,a,b,a,a,a,a,b,b,b,b],[]),
    q0([b,a,b,b,b,b,a,b,a,b,a,b,a,b,a,b,a,a,a,b,b,b,b,b,b,a,b,b,b,a,b,b],[]),
    q0([a,a,a,b,b,b,b,b,a,a,b,a,a,a,a,b,b,a,b,a,b,a,b,b,b,b,a,b,a,b,b,a,a,a,b,a,a,a,a,a],[]),
    q0([b,a,b,b,a,a,b,b,a,b,b,a,a,b,b,b,a,a,b,a,b,b,b,b],[]),
    q0([a,a,b,a,b,a,a,b,b,a,b,b,a,a,a,a,a,a,b,b,b,b,b,a],[]),
    q0([b,a,b,a,a,b,b,a,a,b,a,a,b,a,a,a,b,b,b,b,a,a,b,a,b,a,b,a,a,a,b,a,a,a,b,b,b,a,a,a,b,b,a,b,b,a,b,b,a,a,b,a,b,b,a,b],[]),
    q0([a,b,a,a,b,a,a,a,b,a,a,b,b,b,a,b,b,b,a,b,a,a,b,a,b,a,a,a,b,b,a,a,b,a,a,b,a,b,b,a,b,a,b,a,a,b,b,a,b,b,b,b,a,b,b,b,a,b,b,a,b,a,a,a,b,a,a,a,a,b,a,a,a,a,b,a,b,b,b,a,b,b,b,b,a,b,a,a],[]),
    q0([b,b,b,a,b,b,b,a,a,a,a,b,b,b,b,a,b,a,b,a,a,a,a,a],[]),
    q0([b,b,a,b,b,a,a,a,b,a,a,b,a,b,b,b,b,a,a,a,b,a,b,b,a,a,b,b,a,b,b,b,a,a,b,b,b,b,b,b,b,a,b,a,a,b,a,a,a,b,a,a,b,a,a,a,a,a,b,a,b,b,b,b],[]),
    q0([b,a,b,b,b,a,b,a,a,b,b,a,b,b,b,b,b,a,b,b,b,b,a,b,a,a,b,b,a,a,a,a],[]),
    q0([a,b,a,b,a,a,a,a,a,b,b,b,b,a,b,a,a,b,a,b,b,a,b,b,b,a,a,a,b,a,b,a,a,a,a,a,b,a,a,a,b,a,a,b,b,a,a,b,a,b,b,a,b,a,b,b],[]),
    q0([a,b,b,a,b,a,b,a,b,b,b,a,b,b,b,b,b,b,b,a,a,a,b,b],[]),
    q0([b,b,a,b,a,a,a,a,b,b,b,b,b,b,b,a,a,a,b,b,b,a,b,a],[]),
    q0([b,b,a,a,b,b,b,a,b,a,b,a,a,b,a,b,b,b,b,b,a,b,b,b],[])
]).

count([],0).
count([G|GS],N) :- G -> (count(GS,N1), N is N1+1) ; count(GS,N).

 */