package `1주차`

import java.io.BufferedReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val case = readLine().toInt()
    val bw = System.out.bufferedWriter()
    for (i in 0 until case) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        val distance = end - start
        val max = sqrt(distance.toDouble()).toInt()

        if (max.toDouble() == sqrt(distance.toDouble())) bw.write((max * 2 - 1).toString())
        else if (distance in max * max + 1..(max * max) + max) bw.write((max * 2).toString())
        else bw.write((max * 2 + 1).toString())
        bw.newLine()
    }
    bw.flush()
    bw.close()
}