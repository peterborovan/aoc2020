import java.io.File
import kotlin.system.exitProcess

val monster = listOf(
    "                  # ",
    "#    ##    ##    ###",
    " #  #  #  #  #  #   "
)

var mcount = 0
var tmr = mutableMapOf<Int, List<List<String>>>()
var sol = Array(12) { Array(12) { 0}}
var img = Array(12) { Array(12) { emptyList<String>()}}
var img8 = Array(12) { Array(12) { emptyList<String>()}}
var used =  mutableSetOf<Int>()
var bigImg = mutableListOf<String>()

var testImg = listOf(".####...#####..#...###..",
"#####..#..#.#.####..#.#.",
".#.#...#.###...#.##.##..",
"#.#.##.###.#.##.##.#####",
"..##.###.####..#.####.##",
"...#.#..##.##...#..#..##",
"#.##.#..#.#..#..##.#.#..",
".###.##.....#...###.#...",
"#.####.#.#....##.#..#.#.",
"##...#..#....#..#...####",
"..#.##...###..#.#####..#",
"....#.##.#.#####....#...",
"..##.##.###.....#.##..#.",
"#...#...###..####....##.",
".#.##...#.##.#.#.###...#",
"#.###.#..####...##..#...",
"#.###...#.##...#.######.",
".###.###.#######..#####.",
"..##.#..#..#.#######.###",
"#.#..##.########..#..##.",
"#.#####..#.#...##..#....",
"#....##..#.#########..##",
"#...#.....#..##...###.##",
"#..###....##.#...##.##.#")

var mpart = mutableSetOf<Pair<Int,Int>>()

fun markMonster(x:Int, y:Int) {
    for(dx in 0 until monster.count()) {
        for (dy in 0 until monster[dx].count()) {
            if (monster[dx][dy] == '#') {
                    mpart.add(Pair(x + dx, y + dy))
            }
        }
    }
}

fun checkMonster(x:Int, y:Int, img : List<String>) : Boolean {
    for(dx in 0 until monster.count()) {
        for (dy in 0 until monster[dx].count()) {
            if (monster[dx][dy] == '#') {
                try {
                    if (img[x + dx][y + dy] != '#')
                        return false
                } catch (e: Exception) {
                    return false
                }
            }
        }
    }
    return true
}

fun nonMonsterIn(img : List<String>) : Int {
    var sum = 0
    for (mx in 0 until img.count()) {
        for (my in 0 until img.count()) {
            if (img[mx][my] == '#' && (!mpart.contains(Pair(mx,my))))
                sum++
        }
    }
    return sum
}

fun checkMonsterIn(s:String, img : List<String>) {
    for (mx in 0 until img.count()) {
        for (my in 0 until img.count()) {
            //println("$mx,$my")
            if (checkMonster(mx, my, img)) {
                //println("$s - monster $mx $my")
                markMonster(mx,my)
                mcount++
            }
        }
    }
}

fun isOk(i:Int, j:Int) : Boolean {
    if (i > 0) {
        val i1 = img[i-1][j]
        val i2 = img[i][j]
        for(r in 0..9) {
            if (i1[9][r] != i2[0][r])
                return false
        }
    }
    if (j > 0) {
        val i1 = img[i][j-1]
        val i2 = img[i][j]
        for(r in 0..9) {
            if (i1[r][9] != i2[r][0])
                return false
        }
    }
    return true
}
fun reku(i : Int, j : Int) {
    //println("$i:$j")
    if (i == 12 && j == 0) {
//        for(a in 0..11) {
//            for(b in 0..11)
//                print("${sol[a][b]}, ")
//            println()
//        }
        var res = 1L
        res *= sol[0][0]
        res *= sol[0][11]
        res *= sol[11][0]
        res *= sol[11][11]
        println("A: $res")
        //pr(img[0][0])
        //println()
        for(a in 0..11) {
            for (b in 0..11) {
                img8[a][b] = img[a][b].subList(1, 9).map { it.substring(1,9)}
            }
        }
        for(a in 0 until 12*8) {
            var line = ""
            for (b in 0 until 12) {
                line += img8[a/8][b][a % 8]
            }
            //println(line.length)
            bigImg.add(line)
            line = ""
        }
        val b0 = bigImg
        val b1 = rot90(b0)
        val b2 = rot90(b1)
        val b3 = rot90(b2)

        val f0 = flipH(bigImg)
        val f1 = rot90(f0)
        val f2 = rot90(f1)
        val f3 = rot90(f2)

//        checkMonsterIn("b0", b0)
//        checkMonsterIn("b1", b1)
//        checkMonsterIn("b2", b2)
//        checkMonsterIn("b3", b3)
//        checkMonsterIn("f0", f0)
        checkMonsterIn("f1", f1)
//        checkMonsterIn("f2", f2)
//        checkMonsterIn("f3", f3)

        //checkMonsterIn("test", testImg)

//        println("mcount $mcount")
//        println()
        val pb = nonMonsterIn(f1)
        println("B: $pb")

        //println(bigImg.count())
        //println(bigImg[0].count())
        exitProcess(1)
    } else {
        for((k, rots) in tmr) {
            if (used.contains(k))
                continue
            for(rot in rots) {
                sol[i][j] = k
                img[i][j] = rot
                used.add(k)
                if (isOk(i, j)) {
                    if (j == 11) reku(i + 1, 0)
                    else reku(i, j + 1)
                }
                used.remove(k)
            }
        }
    }
}


fun pr(inp : List<String>) {
    for(i in 0 until inp.count())
        println(inp[i])
}

fun transp(inp : List<String>) : List<String> {
  val size = inp.size
  var x = Array(size) {Array(size) {'.'} }
    for(i in 0 until size)
        for(j in 0 until size) {
            x[j][i] = inp[i][j]
        }
    val r = x.map{ it.toCharArray().concatToString()}
    return r
}
fun flipH(inp : List<String>) : List<String> {
    return inp.reversed()
}
fun flipV(inp : List<String>) : List<String> {
    return inp.map{ it.reversed()}
}
fun rot90(inp : List<String>) : List<String> {
    return flipV(transp(inp))
}


fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val lines = File("AoC20"+sf)
        .readLines()
        //.map { it.replace(" ", "")}
//        .toTypedArray()
    var tm = mutableMapOf<Int, List<String>>()
    var ctile = mutableListOf<String>()
    var ctindex = 0
    for(l in lines) {
        if (l.startsWith("Tile")) {
            ctindex = l.substring(l.indexOf(" ")+1, l.indexOf(":")).toInt()
        } else if (l.isNullOrEmpty()){
            tm[ctindex] = ctile
            ctile = mutableListOf<String>()
        } else {
            ctile.add(l)
            //println(l)
        }

    }
//    println(tm.count())
//    println(tm.keys)
//    pr(tm[2957]!!)
//    println("transp:")
//    pr(transp(tm[2957]!!))
//
//    println("flipV:")
//    pr(flipV(tm[2957]!!))
//
//    println("flipH:")
//    pr(flipH(tm[2957]!!))
//
//    println("rot90:")
//    pr(rot90(tm[2957]!!))
//
    for((key, t) in tm) {
        val t1 = rot90(t)
        val t2 = rot90(t1)
        val t3 = rot90(t2)

        val u = flipH(t)
        val u1 = rot90(u)
        val u2 = rot90(u1)
        val u3 = rot90(u2)
        tmr[key] = listOf(t,t1,t2,t3,u,u1,u2,u3)
    }
    reku(0,0)
}
