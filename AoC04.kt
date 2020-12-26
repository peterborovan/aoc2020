import java.io.File
import java.util.*

/*
    byr (Birth Year)
    iyr (Issue Year)
    eyr (Expiration Year)
    hgt (Height)
    hcl (Hair Color)
    ecl (Eye Color)
    pid (Passport ID)
    cid (Country ID)

 */
fun main() {
    val x = listOf("byr","iyr","eyr","hgt", "hcl", "ecl","pid")
    val input = //"AoC04.test"
                 "AoC04.txt"
    var sum = 0
    var sumb = 0
    var sc = Scanner(File(input))
    var lines = mutableListOf<String>()
    var oneline = ""
    while (sc.hasNextLine()) {
        val line = sc.nextLine()
        if (line == ".") break
        if (line.trim().length == 0) {
            //println(line)
            lines.add(line)
            var b1 = true
            x.forEach {if (!oneline.contains(it)) b1 = false}
            if (b1)
                sum++
            val parts = oneline.split(" ")
            var valid = true
            for (p in parts) {
                if (p.isNullOrBlank())
                    continue
                val kk = p.split(":")
                //println("${kk[0]}-${kk[1]}")
                val k = kk[0]
                val v = kk[1]
                if (k == "byr") {
                    if (v.length == 4 && v[0].isDigit() && v[1].isDigit() && v[2].isDigit() && v[3].isDigit() &&
                     v.toInt() >= 1920 && v.toInt() <= 2002) {}
                    else {
                        //println("$k-$v byr")
                        valid = false
                    }
                }
                if (k == "iyr") {
                    if (v.length == 4 && v[0].isDigit() && v[1].isDigit() && v[2].isDigit() && v[3].isDigit() &&
                        v.toInt() >= 2010 && v.toInt() <= 2020) {}
                    else {
                        //println("$k-$v iyr")
                        valid = false
                    }
                }
                if (k == "eyr") {
                    if (v.length == 4 && v[0].isDigit() && v[1].isDigit() && v[2].isDigit() && v[3].isDigit() &&
                        v.toInt() >= 2020 && v.toInt() <= 2030) {}
                    else {
                        //println("$k-$v eyr")
                        valid = false
                    }
                }
                if (k == "hgt") {
                    if (!(v.endsWith("cm") || v.endsWith("in"))) {
                        //println("$k-$v hgt")
                        valid = false
                    }
                    if (v.endsWith("cm")) {
                        val i = v.substring(0,v.indexOf("cm"))
                        try {
                            val e = i.toInt()
                            if (e >= 150 && e <= 193) {}
                            else {
                                //println("$k-$v hgt")
                                valid = false
                            }
                        } catch (e :Exception) {
                            //println("$k-$v hgt")
                            valid = false
                        }
                    } else
                    if (v.endsWith("in")) {
                        val i = v.substring(0,v.indexOf("in"))
                        //println(".$i.")
                        try {
                            val e = i.toInt()
                           // println(e)
                            if (e >= 59 && e <= 76) {}
                            else {
                                //println("$k-$v in")
                                valid = false
                            }
                        } catch (e :Exception) {
                            //println(e.message)
                            //println("$k-$v in")
                            valid = false
                        }
                    }

                }
                if (k == "hcl") {
                    val z = "0123456789abcdef"
                    if (v.length == 7 &&
                        v[0] == '#' &&
                        z.contains(v[1]) &&
                        z.contains(v[2]) &&
                        z.contains(v[3]) &&
                        z.contains(v[4]) &&
                        z.contains(v[5]) &&
                        z.contains(v[6]) ) {}
                    else {
                        //println("$k-$v hcl")
                        valid = false
                    }

                }
                if (k == "ecl") {
                    if (v == "amb" || v == "blu" || v == "brn" || v == "gry" ||
                        v == "grn" || v == "hzl" || v == "oth") {}
                    else {
                        //println("$k-$v ecl")
                        valid = false
                    }
                }
                if (k == "pid") {
                    if (v.length == 9 &&
                        v[0].isDigit() &&
                        v[1].isDigit() &&
                        v[2].isDigit() &&
                        v[3].isDigit() &&
                        v[4].isDigit() &&
                        v[5].isDigit() &&
                        v[6].isDigit() &&
                        v[7].isDigit() &&
                        v[8].isDigit()) {}
                    else {
                        //println("$k-$v pid")
                        valid = false
                    }
                }
            }
            if (b1 && valid)
                sumb ++
            oneline = ""

        }
        oneline += (" " + line)
    }
    sc.close()
    println("A: $sum")
    println("B: $sumb")
}