import java.io.File

fun main() {
    val input =
        //"AoC12.test"
        "AoC12.txt"
    var lines = File(input)
        .readLines()
        //.map {it.toCharArray()}
        //.toTypedArray()
    var x =0
    var y = 0
    var dx = 1
    var dy = 0
    for(l in lines) {
        val ch = l[0]
        val c = Integer.parseInt(l.substring(1,l.length))
        //println("$ch $c")
        if (ch == 'F') {
            x += dx*c
            y += dy*c
        } else if (ch == 'N') {
            y -= c
        } else if (ch == 'S') {
            y += c
        } else if (ch == 'E') {
            x += c
        } else if (ch == 'W') {
            x -= c
        } else if (ch == 'R') {
            repeat(c/90) {
                var tmp = dy
                dy = dx
                dx = -tmp
            }
        } else if (ch == 'L') {
            repeat(c/90) {

                var tmp = dy
                dy = dx
                dx = -tmp

                tmp = dy
                dy = dx
                dx = -tmp

                tmp = dy
                dy = dx
                dx = -tmp
            }
        }
        //println("$x $y $dx $dy")
    }
    println("A: ${Math.abs(x)+Math.abs(y)}")
    //---------------- partB
    x =0
    y = 0
    dx = 10
    dy = -1
    for(l in lines) {
        val ch = l[0]
        val c = Integer.parseInt(l.substring(1,l.length))
        //println("$ch $c")
        if (ch == 'F') {
            x += dx*c
            y += dy*c
        } else if (ch == 'N') {
            dy -= c
        } else if (ch == 'E') {
            dx += c
        } else if (ch == 'S') {
            dy += c
        } else if (ch == 'W') {
            dx -= c
        } else if (ch == 'R') {
            repeat(c/90) {
                var tmp = dy
                dy = dx
                dx = -tmp
            }
        } else if (ch == 'L') {
            repeat(c/90) {

                var tmp = dy
                dy = dx
                dx = -tmp

                tmp = dy
                dy = dx
                dx = -tmp

                tmp = dy
                dy = dx
                dx = -tmp
            }
        }
        //println("$x $y $wpx $wpy")
    }
    println("B: ${Math.abs(x)+Math.abs(y)}")
}
