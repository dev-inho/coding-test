package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 정렬하는 문제
 */
public class SortArray {

    /**
     * 정수 배열을 정렬해서 반환하는 solution 함수를 완성하세요.
     * 제약 조건
     * 1. 정수 배열의 10의 5승이하입니다.
     * 2. 정수 배열의 각 데이터 값은 -100,000 이상 100,000이상입니다.
     */
    public static void solution() {
        int[] array = {1, -5, 2, 4, 3};

        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        solution();
    }
}
