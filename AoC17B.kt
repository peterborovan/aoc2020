import java.io.File


fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val lines = File("AoC17"+sf)
        .readLines()
        .map { it.toCharArray().toTypedArray()}
        .toTypedArray()

    val SIZE = 50
    //val SIZE = 120
    val SIZE2 = 2*SIZE
    var p = Array(SIZE2) {
        Array(SIZE2) {
            Array(SIZE2) {
                Array(SIZE2) {'.'} }}}

    //println("start")

    var minx = SIZE
    var maxx = SIZE
    var miny = SIZE
    var maxy = SIZE

    var minz = SIZE2
    var minw = SIZE2
    var maxz = 0
    var maxw = 0
    for(i in 0 until lines.count()) {
        for(j in 0 until lines.count()) {
            p[SIZE][SIZE][SIZE + i][SIZE + j] = lines[i][j]
            minz = Math.min(minz, SIZE+i)
            maxz = Math.max(maxz, SIZE+i)
            minw = Math.min(minw, SIZE+j)
            maxw = Math.max(maxw, SIZE+j)
        }
    }


    var np = Array(SIZE2) { Array(SIZE2) { Array(SIZE2) { Array(SIZE2) {'.'}} }}

    repeat(6) {
        //println("$minx, $maxx, $miny, $maxy, $minz, $maxz, $minw, $maxw")
        for (x in minx - 1..maxx + 1) {
            for (y in miny - 1..maxy + 1) {
                for (z in minz - 1..maxz + 1) {
                    for (w in minw - 1..maxw + 1) {
                        var active = 0
                        for (dx in -1..1) {
                            for (dy in -1..1) {
                                for (dz in -1..1) {
                                    for (dw in -1..1) {
                                        if (dx == 0 && dy == 0 && dz == 0 && dw == 0) continue
                                        if (p[x + dx][y + dy][z + dz][w + dw] == '#')
                                            active++
                                    }
                                }
                            }
                        }
                        if (p[x][y][z][w] == '#') {
                            if (active == 2 || active == 3) {
                                np[x][y][z][w] = p[x][y][z][w]
                            } else {
                                np[x][y][z][w] = '.'
                            }
                        } else {
                            if (active == 3) {
                                np[x][y][z][w] = '#'
                            } else {
                                np[x][y][z][w] = p[x][y][z][w]
                            }
                        }
                    }
                }
            }
        }


        minx--
        maxx++
        miny--
        maxy++
        minz--
        maxz++
        minw--
        maxw++

        for (x in minx..maxx) {
            for (y in miny..maxy) {
                for (z in minz..maxz) {
                    for (w in minw..maxw) {
                        p[x][y][z][w] = np[x][y][z][w]
                    }
                }
            }
        }
    }
    var count = 0
    for (x in minx..maxx) {
        for (y in miny..maxy) {
            for (z in minz..maxz) {
                for (w in minw..maxw) {
                    if (p[x][y][z][w] == '#')
                        count++
                }
            }
        }
    }
    println("B: $count")
}

