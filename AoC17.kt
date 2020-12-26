import java.io.File


fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val lines = File("AoC17"+sf)
        .readLines()
        .map { it.toCharArray().toTypedArray()}
        .toTypedArray()

    val SIZE = 120
    val SIZE2 = 2*SIZE+1
    var p = Array(SIZE2) { Array(SIZE2) { Array(SIZE2) {'.'} }}

    var miny = SIZE2
    var minz = SIZE2
    var maxy = 0
    var maxz = 0
    for(i in 0 until lines.count()) {
        for(j in 0 until lines.count()) {
            p[SIZE][SIZE + i][SIZE + j] = lines[i][j]
            miny = Math.min(miny, SIZE+i)
            maxy = Math.max(maxy, SIZE+i)
            minz = Math.min(minz, SIZE+j)
            maxz = Math.max(maxz, SIZE+j)
        }
    }
    var minx = SIZE
    var maxx = SIZE

    //println("$minx, $maxx, $miny, $maxy, $minz, $maxz")

    var np = Array(SIZE2) { Array(SIZE2) { Array(SIZE2) {'.'} }}

    repeat(6) {
        for (x in minx - 1..maxx + 1) {
            for (y in miny - 1..maxy + 1) {
                for (z in minz - 1..maxz + 1) {
                    var active = 0
                    for (dx in -1..1) {
                        for (dy in -1..1) {
                            for (dz in -1..1) {
                                if (dx == 0 && dy == 0 && dz == 0) continue
                                if (p[x + dx][y + dy][z + dz] == '#')
                                    active++
                            }
                        }
                    }
                    if (p[x][y][z] == '#') {
                        if (active == 2 || active == 3) {
                            np[x][y][z] = p[x][y][z]
                        } else {
                            np[x][y][z] = '.'
                        }
                    } else {
                        if (active == 3) {
                            np[x][y][z] = '#'
                        } else {
                            np[x][y][z] = p[x][y][z]
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

        for (x in minx..maxx) {
            for (y in miny..maxy) {
                for (z in minz..maxz) {
                    p[x][y][z] = np[x][y][z]
                }
            }
        }
    }
    var count = 0
    for (x in minx..maxx) {
        for (y in miny..maxy) {
            for (z in minz..maxz) {
                if (p[x][y][z] == '#')
                    count++
            }
        }
    }
    println("A: $count")
}

