import java.io.File

fun pr(inp : Array<CharArray>) {
    var s = 0

    for (i in 0 until inp.size) {
        for (j in 0 until inp[i].size) {
            print(inp[i][j])
        }
        println()
    }
}

fun count(inp : Array<CharArray>) : Int {
    var s = 0

    for (i in 0 until inp.size)
        for (j in 0 until inp[i].size) {
            if (inp[i][j] == '#')
                s++
        }
    return s
}

fun sim(inp : Array<CharArray>) : Array<CharArray> {
    var o = Array(inp.size) { CharArray(inp[0].size) {'.'} }
    for (i in 0 until inp.size)
        for (j in 0 until inp[i].size) {
            if (inp[i][j] == 'L') {
                var nocc = 0
                for (a in -1 .. 1) {
                    for (b in -1..1) {
                        if (a == 0 && b == 0)
                            continue
                        try {
                            if (inp[i + a][j + b] == '#')
                                nocc++
                        } catch (e:Exception) {}
                    }
                }
                if (nocc == 0)
                    o[i][j] = '#'
                else
                    o[i][j] = inp[i][j]
            } else if (inp[i][j] == '#') {
                var nocc = 0
                for (a in -1 .. 1) {
                    for (b in -1..1) {
                        if (a == 0 && b == 0)
                            continue
                        try {
                            if (inp[i + a][j + b] == '#')
                                nocc++
                        } catch (e:Exception) {}
                    }
                }
                if (nocc >= 4)
                    o[i][j] = 'L'
                else
                    o[i][j] = inp[i][j]
            } else
             o[i][j] = inp[i][j]
        }
    return o
}

fun sim2(inp : Array<CharArray>) : Array<CharArray> {
    var o = Array(inp.size) { CharArray(inp[0].size) {'.'} }
    for (i in 0 until inp.size)
        for (j in 0 until inp[i].size) {
            if (inp[i][j] == 'L') {
                var nocc = 0
                for (a in -1 .. 1) {
                    for (b in -1..1) {
                        if (a == 0 && b == 0)
                            continue
                        lab@
                        for(k in 1 .. 1000) {
                            try {
                                if (inp[i + k*a][j + k*b] == '#') {
                                    nocc++
                                    break@lab
                                }
                                if (inp[i + k*a][j + k*b] == 'L') {
                                    break@lab
                                }
                            } catch (e: Exception) {
                                break@lab
                            }
                        }
                    }
                }
                if (nocc == 0)
                    o[i][j] = '#'
                else
                    o[i][j] = inp[i][j]
            } else if (inp[i][j] == '#') {
                var nocc = 0
                for (a in -1 .. 1) {
                    for (b in -1..1) {
                        if (a == 0 && b == 0)
                            continue
                        lab@
                        for(k in 1 .. 1000) {
                            try {
                                if (inp[i + k*a][j + k*b] == '#') {
                                    nocc++
                                    break@lab
                                }
                                if (inp[i + k*a][j + k*b] == 'L') {
                                    break@lab
                                }
                            } catch (e: Exception) {
                                break@lab
                            }
                        }
                    }
                }
                if (nocc >= 5)
                    o[i][j] = 'L'
                else
                    o[i][j] = inp[i][j]
            } else
                o[i][j] = inp[i][j]
        }
    return o
}



fun main() {
    val input =
        //"AoC11.test"
        "AoC11.txt"
    var lines = File(input)
        .readLines()
        .map {it.toCharArray()}
        .toTypedArray()


    var oldA = 0
    while (true) {
        val newlines = sim(lines)
        if (oldA == count(newlines)) {
            println("A: $oldA")
            break
        }
        oldA = count(newlines)
        lines = newlines
    }
    ///-------------------- partB
    lines = File(input)
        .readLines()
        .map {it.toCharArray()}
        .toTypedArray()

    var oldB = 0
    while (true) {
        val newlines = sim2(lines)
        if (oldB == count(newlines)) {
            println("B: $oldB")
            break
        }
        oldB = count(newlines)
        lines = newlines
    }
}
