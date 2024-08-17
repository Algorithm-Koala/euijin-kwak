package com.kez.algorithm_koala.`1주차`

/**
 * 문제
 * 나코더 기장 재민이는 동아리 회식을 준비하기 위해서 장부를 관리하는 중이다.
 *
 * 재현이는 재민이를 도와서 돈을 관리하는 중인데, 애석하게도 항상 정신없는 재현이는 돈을 실수로 잘못 부르는 사고를 치기 일쑤였다.
 *
 * 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
 *
 * 재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다. 재민이를 도와주자!
 *
 * 입력
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 *
 * 이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 *
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 *
 * 출력
 * 재민이가 최종적으로 적어 낸 수의 합을 출력한다. 최종적으로 적어낸 수의 합은 231-1보다 작거나 같은 정수이다.
 *
 * 풀이 생각 적어보기
 * 1. 일단 누가봐도 스택을 사용하라고 협박하는 듯한 문제
 * 2. 그렇기 때문에 stack 자료구조 사용 0들어올시 pop() 그외에는 push()
 * 3. 마지막에 남은 숫자 더하기
 * */

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val count = readLine().toInt()
    val stack = Stack<Int>()
    (0..<count).forEach {
        val input = readLine().toInt()
        if (input == 0) {
            stack.pop()
        } else {
            stack.push(input)
        }
    }
    println(stack.sum())
}

/**
 * GPT 최적화 (+48ms) ?? 쓸모 없는 최적화였다...
 *
 * ArrayDeque가 Stack보다 더 나은 이유는 다음과 같습니다:
 *
 * 1. Stack은 레거시 클래스:
 * Stack은 Java 1.0에서 도입된 오래된 클래스입니다. Vector를 상속받아 구현되었기 때문에, 스레드 안전성을 위해 모든 메서드가 synchronized로 동기화되어 있습니다. 이로 인해 동기화가 필요하지 않은 환경에서 성능이 떨어질 수 있습니다.
 * 2. ArrayDeque는 더 효율적이고 유연함:
 * 비동기화: ArrayDeque는 동기화되지 않으며, 대부분의 단일 스레드 애플리케이션에서는 이점이 있습니다. 비동기화된 자료 구조는 불필요한 락 오버헤드를 피하여 더 빠르게 동작합니다.
 * 메모리 관리: ArrayDeque는 내부적으로 배열을 사용하여 데이터를 관리하며, 필요에 따라 크기를 동적으로 조정합니다. 이는 Stack보다 메모리 관리 측면에서 더 효율적입니다.
 * 유연한 사용: ArrayDeque는 양쪽에서 요소를 추가하거나 제거할 수 있는 데크 구조를 제공합니다. 이를 통해 LIFO(스택)와 FIFO(큐) 양쪽 모두로 사용할 수 있어 더 유연합니다.
 * 3. ArrayDeque의 성능:
 * ArrayDeque는 Stack에 비해 성능이 더 우수합니다. 동기화 오버헤드가 없고, 적응형 크기 조정 덕분에 삽입 및 삭제 연산이 더 빠릅니다.
 * 4. Java 표준 라이브러리에서의 권장 사항:
 * Java 표준 라이브러리에서 Stack 대신 ArrayDeque 또는 LinkedList를 스택이나 큐 자료 구조로 사용하는 것이 권장됩니다. 이는 Stack이 레거시 클래스임을 명확히 하고 있으며, 더 나은 성능을 가진 대체 옵션을 제공하기 위함입니다.
 * 결론:
 * ArrayDeque는 Stack의 모든 기능을 대체할 수 있으며, 동기화되지 않은 환경에서 더 나은 성능을 제공합니다. 따라서, 현대적인 애플리케이션에서는 Stack 대신 ArrayDeque를 사용하는 것이 일반적으로 더 나은 선택입니다.
 *
 *
 * fun main() = with(System.`in`.bufferedReader()) {
 *     val count = readLine().toInt()
 *     val deque = ArrayDeque<Int>()
 *     (0 until count).forEach {
 *         val input = readLine().toInt()
 *         if (input == 0) {
 *             deque.removeLastOrNull()
 *         } else {
 *             deque.addLast(input)
 *         }
 *     }
 *     println(deque.sum())
 * }
 * */