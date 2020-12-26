import java.io.File

fun pair(x:Int, y:Int, z:Int) = listOf(x,y,z)

fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val lines = File("AoC24"+sf)
        .readLines()
    //.map { it.replace(" ", "")}
//        .toTypedArray()

    var mapa = mutableSetOf<List<Int>>()
    for(x in lines) {
        var l = x
        var x = 0
        var y = 0
        var z = 0
        while (l.length > 0) {
            var skip = 2
            //println(l.subSequence(0,3))
            if (l.startsWith("e")) {
                skip = 1
                x++
                z--
            } else if (l.startsWith("w")) {
                skip = 1
                x--
                z++
            } else if (l.startsWith("sw")) {
                x--
                y++
            } else if (l.startsWith("se")) {
                y++
                z--
            } else if (l.startsWith("ne")) {
                x++
                y--
            } else if (l.startsWith("nw")) {
                y--
                z++
            }
            l = l.substring(skip, l.length)
        }
        if (mapa.contains(pair(x,y,z)))
            mapa.remove(pair(x,y,z))
        else
            mapa.add(pair(x,y,z))
    }
    println("A: ${mapa.count()}")

    repeat (100) {
      var minx = 99999
      var maxx = -999999
      var miny = 99999
      var maxy = -99999
      var minz = 99999
      var maxz = -99999
        for (k in mapa) {
            val x = k[0]
            val y = k[1]
            val z = k[2]
            minx = Math.min(minx, x)
            miny = Math.min(miny, y)
            minz = Math.min(minz, z)

            maxx = Math.max(maxx, x)
            maxy = Math.max(maxy, y)
            maxz = Math.max(maxz, z)
        }
        //println("loop $it,  $minx, $maxx, $miny, $maxy, $minz, $maxz")
        var m2 = mutableSetOf<List<Int>>()
        for(x in minx-1..maxx+1) {
            for(y in miny-1..maxy+1) {
                for(z in minz-1..maxz+1) {
                    var nb = 0
                    if (mapa.contains(pair(x+1,y,z-1))) nb++
                    if (mapa.contains(pair(x-1,y,z+1)) ) nb++
                    if (mapa.contains(pair(x+1,y-1,z)) ) nb++
                    if (mapa.contains(pair(x-1,y+1,z)) ) nb++
                    if (mapa.contains(pair(x,y+1,z-1)) ) nb++
                    if (mapa.contains(pair(x,y-1,z+1)) ) nb++
                    if (mapa.contains(pair(x,y,z))) {
                        if (!(nb == 0 || nb > 2))
                            m2.add(pair(x,y,z))
                    } else {
                        if (nb == 2)
                            m2.add(pair(x,y,z))
                    }
                }
            }
        }
        mapa = m2
    }
    println("B: ${mapa.count()}")
}
