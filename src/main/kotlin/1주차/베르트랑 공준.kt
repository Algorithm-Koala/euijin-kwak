package com.kez.algorithm_koala.`1주차`

/**
 * 문제
 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 *
 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 *
 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 *
 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
 *
 * 입력의 마지막에는 0이 주어진다.
 *
 * 출력
 * 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 *
 * 제한
 * 1 ≤ n ≤ 123,456
 *
 * 문제 풀이 생각
 * 1. 일단 소수를 구하는 문제이기 때문에 소수 알고리즘인 에라토스테네스의 체를 활용한다.
 * 2. 각 테스트 케이스별 소수의 갯수를 구하여 출력한다.
 * 3. 음 근데 풀다보니 n과 2n 사이에 어떤 매커니즘이 있을 것 같다.
 * 4. 어쨋든 구해야하는 범위는 (2n - n) -2 이므로 n -2 인 것이다.
 * 5. 그렇다면 n -2 사이즈 내에서 소수를 찾는 함수를 설계해야하는 것이다.
 * */

fun main() {
    val inputs = mutableListOf<Int>()
    while (true) {
        when (val input = readln().toInt()) {
            0 -> break
            else -> inputs.add(input)
        }
    }

    inputs.map {
        findPrimes(it * 2).count()
    }.forEach {
        println(it)
    }
}

fun findPrimes(n: Int): List<Int> {
    if (n < 2) return emptyList()

    val isPrime = BooleanArray(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..n) {
        if (isPrime[i]) {
            for (j in (i * 2)..n step i) {
                isPrime[j] = false
            }
        }
    }

    return isPrime.indices.filter {
        it > n / 2 && isPrime[it]
    }
}

/**
 *
 * 결과: https://www.acmicpc.net/source/82610672
 * GPT 최적화 코드 (-260ms)
 *
 * fun main() {
 *     val inputs = mutableListOf<Int>()
 *     while (true) {
 *         when (val input = readln().toInt()) {
 *             0 -> break
 *             else -> inputs.add(input)
 *         }
 *     }
 *
 *     // 에라토스테네스의 체를 통해 최대 2 * 123,456 범위의 소수를 미리 계산해둡니다.
 *     val maxN = 123_456 * 2
 *     val isPrime = findPrimesUpTo(maxN)
 *
 *     // 각 입력에 대해 n보다 크고 2n 이하의 소수 개수를 출력합니다.
 *     inputs.forEach { n ->
 *         val count = (n + 1..n * 2).count { isPrime[it] }
 *         println(count)
 *     }
 * }
 *
 * fun findPrimesUpTo(n: Int): BooleanArray {
 *     val isPrime = BooleanArray(n + 1) { true }
 *     isPrime[0] = false
 *     isPrime[1] = false
 *
 *     val sqrtN = kotlin.math.sqrt(n.toDouble()).toInt()
 *
 *     for (i in 2..sqrtN) {
 *         if (isPrime[i]) {
 *             for (j in i * i..n step i) {
 *                 isPrime[j] = false
 *             }
 *         }
 *     }
 *
 *     return isPrime
 * }
 *
 * */