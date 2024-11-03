# Programmers solutions in Java

| 문제 유형        | 위치                                                                      |
|--------------|-------------------------------------------------------------------------|
| 탐욕법          | [greedy](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fgreedy)               |
| 다이나믹 프로그래밍   | [dp](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fdp)                       |
| DFS          | [dfs](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fdfs)                     |
| BFS          | [bfs](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fbfs)                     |
| 이분탐색         | [binarysearch](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fbinarysearch)   |
| 투포인터         | [twopointers](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Ftwopointers)     |
| 슬라이딩 윈도우     | [slidingwindow](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fslidingwindow) |
| 정렬           | [sort](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fsort)                   |
| 그래프          | [graph](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fgraph)                 |
| 자료구조(스택 & 큐) | [stackqueue](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fstackqueue)       |
| 자료구조(해시)     | [hash](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fhash)                   |
| 완전탐색         | [bruteforce](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fbruteforce)       |
| 백트래킹         | [backtracking](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fbacktracking)   |
| 자료구조(힙)      | [heap](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fheap)                   |
| 수학적 문제       | [mathematics](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fmathematics)     |
| 문자열 처리       | [string](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fstring)               |
| 복합 유형 및 기타   | [courses](src%2Fmain%2Fjava%2Flearn%2Fchallenges%2Fcourses)             |

### 1. 일반적인 시간 복잡도 기준과 입력 크기
대부분의 컴퓨터에서는 1초에 약 10^8번(1억)의 연산을 처리할 수 있다고 가정

| 입력 크기 `n`       | 적절한 시간 복잡도           | 설명                                                                                    |
|-----------------|----------------------|---------------------------------------------------------------------------------------|
| `n ≤ 10`        | `O(n!)`, `O(2^n)`    | 매우 작은 입력이므로 **완전 탐색**(Brute Force)이나 **재귀적 백트래킹**도 허용                                 |
| `n ≤ 20`        | `O(2^n)`, `O(n!)`    | **완전 탐색**, **재귀적 백트래킹** 가능하며, 모든 경우의 수를 시도해도 가능한 크기                                   |
| `n ≤ 100`       | `O(n^3)`             | 3중 반복문을 허용하며, **그래프 문제**에서 **플로이드 워셜**과 같은 알고리즘 가능                                    |
| `n ≤ 1,000`     | `O(n^2)`             | 2중 반복문을 사용한 **브루트 포스**나 **동적 계획법**(DP)이 적합                                            |
| `n ≤ 100,000`   | `O(n log n)`         | **합병 정렬**, **힙 정렬**, **퀵 정렬**(평균), **이진 탐색**과 같은 정렬 알고리즘이 적합하며, 대부분의 효율적인 탐색 알고리즘도 가능 |
| `n ≤ 1,000,000` | `O(n)`               | 단일 반복문, **선형 탐색**, **해시 테이블** 등을 사용하는 알고리즘이 적합                                        |
| `n > 10^7`      | `O(log n)` 또는 `O(1)` | 매우 큰 입력 크기이므로 **로그 시간** 또는 **상수 시간**의 알고리즘이 필요                                        |

### 2. 제한 조건을 통해 시간 복잡도 판단하는 방법

- **제한 조건 분석**: 문제에 주어진 제한 조건을 통해 `n`의 크기를 확인합니다. 예를 들어, `1 ≤ n ≤ 1,000`이라면 **`O(n^2)`**의 시간 복잡도가 적절할 수 있습니다.
- **연산 가능 횟수 추정**: 일반적으로 **1억 번 연산을 1초**로 가정하여 입력 크기 `n`에 따른 시간 초과 여부를 판단합니다.
- **적합한 알고리즘 선택**: 문제의 입력 크기에 따라 적절한 알고리즘을 선택합니다. 이때 알고리즘의 시간 복잡도를 알고 있으면 도움이 됩니다.

### 3. 시간 복잡도에 따른 알고리즘 선택 예시

| 시간 복잡도       | 적절한 알고리즘 유형                                       | 예시 문제                                   |
|--------------|---------------------------------------------------|-----------------------------------------|
| O(1)         | 해시 테이블, 배열 인덱싱	                                   | 상수 시간에 접근 가능한 데이터 조회, 스택에서의 push/pop 연산 |
| `O(n)`       | 슬라이딩 윈도우, 투 포인터, 해시맵, 큐, BFS	                     | 배열의 연속된 구간에서 최댓값을 찾거나 중복 체크 문제, BFS 탐색  |
| `O(n log n)` | 합병 정렬, 퀵 정렬, 이진 탐색, 균형 이진 트리, 그리디, 분할 정복, 위상 정렬 	 | 대규모 데이터를 정렬하거나, 이진 탐색을 사용해 값을 찾는 문제     |
| `O(n^2)`     | 브루트 포스, 다이나믹 프로그래밍, 플로이드-워셜, 스택, DFS	             | 그래프의 모든 정점 간 탐색, 2중 루프를 사용하는 최적화 문제     |
| `O(2^n)`     | 백트래킹, 분할 정복, 동적 계획법 (메모이제이션), 완전 탐색	              | 입력 크기가 작고, 모든 경우를 탐색하는 문제               |
| `O(n!)`      | 백트래킹, 완전 탐색	                                      | 입력 크기가 작고, 모든 경우를 탐색하는 문제               |
