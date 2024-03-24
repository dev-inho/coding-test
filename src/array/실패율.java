package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 실패율 {

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] arr2 = {4, 4, 4, 4, 4};

        int[] answer1 = solution(5, arr1);
        int[] answer2 = solution(4, arr2);

        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(answer2));
    }

    /**
     * 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 커 게임의 인기도가 하락
     *   동적으로 게임 시간을 늘려 난이도 조절하기로 함.
     *   실패율을 계산하는데 난관에 부딪힘
     *
     *   실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     * @param N 전체 스테이지의 개수
     * @param stages 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
     *
     * @return 실패율이 높은 스테이지부터 내림차순으로 반환
     *
     * @condition 1 <= N <= 500
     * @condition 1<= stages.length <= 200000
     * @condition 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 한다.
     * @condition 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의한다.
     * @condition stages 안에는 N + 1이 존재하는데 이는 N번째를 클리어한 사람을 의미한다.
     */

    public static int[] solution(int N, int[] stages) {

        double[][] failureRates = new double[N][2]; // [스테이지 번호, 실패율]

        Arrays.sort(stages); // 스테이지 정렬

        // 실패율 계산
        for (int i = 1; i <= N; i++) {
            int reached = 0; // 도달한 사용지
            int notCleared = 0; // 클리어한 사용자

            for (int stage : stages) {
                if (stage == i) notCleared++;
                if (stage >= i) reached++;
            }

            System.out.println(String.format("[%d번째 스테이지] 도달한 사용자 : %d / 클리어한 사용자 : %d", i, notCleared, reached));

            double failureRate = reached > 0 ? (double) notCleared / reached : 0;

            failureRates[i - 1][0] = i;
            failureRates[i - 1][1] = failureRate;
        }

        // 실패율에 따라 정렬
        Arrays.sort(failureRates, (a, b) -> Double.compare(b[1], a[1]));

        return Arrays.stream(failureRates)
                .map(rate -> (int) rate[0])
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
