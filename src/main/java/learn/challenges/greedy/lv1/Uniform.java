package learn.challenges.greedy.lv1;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 제목: 체육복
 *
 * Time Complexity: O(n) HashSet 연산은 평균적으로 O(1)
 * Space Complexity: O(n)
 */
public class Uniform {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        // 잃어버린 학생과 여벌 체육복 있는 학생 set에 추가
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        // 여벌 체육복을 가져왔지만 도난당한 학생 처리
        HashSet<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);

        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);

        int answer = n - lostSet.size(); // 잃어버린 학생 수만큼 감소

        // 체육복 빌려주기
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
                answer++;
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
                answer++;
            }
        }

        return answer;
    }

    public int solution1(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] uniform = new int[n];

        for(int i = 0; i < n; i++) {
            uniform[i]++; // 1인당 체육복 1개
            if(i < lost.length) uniform[lost[i]-1]--;         // 도난 당한 체육복을 뺀다
            if(i < reserve.length) uniform[reserve[i]-1]++;   // 여벌 체육복을 더한다
        }

        for(int i=0; i < n; i++) {
            // 체육복이 없으면
            if(uniform[i] == 0) {
                if(i != 0 && uniform[i-1] > 1) { // 앞번호 학생
                    uniform[i]++;
                    uniform[i-1]--;
                }else if(i != n-1 && uniform[i+1] > 1) { // 뒷번호 학생
                    uniform[i]++;
                    uniform[i+1]--;
                }
            }
        }

        for(int i=0; i < n; i++) {
            if(uniform[i] > 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Uniform solution = new Uniform();
        solution.solution1(5, new int[]{2, 4}, new int[]{1, 2, 5});    // 5
        solution.solution(5, new int[]{2, 4}, new int[]{3});  // 4
        solution.solution(5, new int[]{4, 5}, new int[]{3, 4});  // 4
        solution.solution(5, new int[]{1, 2}, new int[]{2, 3});  // 4
    }
}
