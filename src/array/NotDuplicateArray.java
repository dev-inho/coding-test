package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 배열 제어하기
 */
public class NotDuplicateArray {

    /**
     * 정수 배열을 하나 받아 배열의 중복을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution 함수를 구현하라
     * 제약 조건
     *   -. 배열의 길이는 2 이상 1,000 이하입니다.
     *   -. 각 배열 데이터 값은 -100,000 이상 100,000 이하입니다.
     */

    public static int[] solution(int[] array) {
        if (array == null || array.length < 1) { // 잘못된 데이터 제한
            return null;
        }

        return Arrays.stream(array)
                .boxed() // 기본형 배열을 래퍼 클래스로 형태로 박싱
                .distinct()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue) // 래퍼 클래스를 기본형으로 언박싱
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 1, 3, 4};
        int[] arr2 = {2, 1, 1, 3, 2, 5, 4};

        System.out.println(Arrays.toString(solution(arr1)));;
        System.out.println(Arrays.toString(solution(arr2)));;
    }
}
