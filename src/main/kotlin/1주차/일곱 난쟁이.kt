package com.kez.algorithm_koala.`1주차`

/**
 * 문제
 * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
 *
 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 *
 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 *
 * 입력
 * 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
 *
 * 출력
 * 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.*/

/**
 * 풀이 생각 적어보기
 * [1]
 * 일단 난쟁이들 키의 조합이 100 이 되는 경우를 찾아야 한다.
 * 1. 난쟁이들의 키를 모두 합한다.
 * 2. 모두 합한 키에서 100과의 차를 구한다.
 * 3. 해당 차만큼의 합을 가진 난쟁이를 제외한다.
 * 4. 그렇다면 해당 차 만큼의 합을 가진 난쟁이를 어떻게 구할지 감이 안온다...
 * 5. 접근 방식은 옳은 것 같아 숫자 쌍을 구하는 알고리즘을 찾아본 후 딕셔너리(Dictionary) 방법을 사용했다.
 *
 * [2]
 * 1. 난쟁이의 키를 더해나가는 과정에서 100이 넘는 경우 다른 조합으로 100을 만드는 경우를 산정한다.
 * 2. 효울적이지 못하다고 생각하여 제외
 * */

fun main() {
    val shortPersonHeightList = (0..8).map {
        readln().toInt()
    }
    val allHeight = shortPersonHeightList.sum()
    val diff = allHeight - 100
    val array = mutableListOf<Int>()

    val excludeShortPersons = mutableListOf<Int>()

    for (i in shortPersonHeightList) {
        val complement = diff - i
        if (complement in array) {
            excludeShortPersons.add(i)
            excludeShortPersons.add(complement)
            break
        } else {
            array.add(i)
        }
    }
    val result = shortPersonHeightList.filter { it !in excludeShortPersons }.sorted()
    result.forEach { println(it) }
}

/**
 * 결과
 * https://www.acmicpc.net/source/82601478
 *
 * GPT 가 최적화한 코드
 *
 * fun main() {
 *     val shortPersonHeightList = (0..8).map {
 *         readln().toInt()
 *     }
 *     val allHeight = shortPersonHeightList.sum()
 *     val diff = allHeight - 100
 *
 *     val excludePair = shortPersonHeightList.withIndex().find { (index, height) ->
 *         val complement = diff - height
 *         shortPersonHeightList.subList(index + 1, shortPersonHeightList.size).contains(complement)
 *     }
 *
 *     val result = if (excludePair != null) {
 *         val complement = diff - excludePair.value
 *         shortPersonHeightList.filter { it != excludePair.value && it != complement }
 *     } else {
 *         shortPersonHeightList
 *     }
 *
 *     println(result)
 * }
 *
 * 코드 설명:
 * withIndex()와 find 사용: withIndex()를 사용해 인덱스와 값을 함께 가져오고, find를 사용해 조건에 맞는 두 명을 한 번에 찾습니다. 이로 인해 불필요한 리스트(array, excludeShortPersons)가 필요 없어졌습니다.
 *
 * subList 사용: subList를 사용하여 이미 확인한 값들을 제외한 나머지 리스트에서 complement를 찾습니다. 이로 인해 탐색 범위를 줄여 성능을 최적화했습니다.
 *
 * filter 사용: 제외할 두 명의 사람을 찾았다면, filter를 사용하여 그들을 제외한 나머지 리스트를 반환합니다.
 *
 * */