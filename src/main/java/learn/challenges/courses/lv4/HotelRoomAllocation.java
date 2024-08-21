package learn.challenges.courses.lv4;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64063
 * 제목: 호텔 방 배정
 *
 * Time Complexity: 재귀호출 최악의 경우 O(n * log k) (k는 방의 최대 번호, n은 요청 수)
 * Space Complexity: O(k) (k개의 방 번호를 HashMap에 저장)
 */
public class HotelRoomAllocation {

    Map<Long, Long> emptyRooms = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    private long findRoom(long roomNumber) {
        if (!emptyRooms.containsKey(roomNumber)) { // 방이 비어 있는 경우
            emptyRooms.put(roomNumber, roomNumber + 1);
            return roomNumber;
        }

        long emptyRoom = findRoom(emptyRooms.get(roomNumber));
        emptyRooms.put(roomNumber, emptyRoom);
        return emptyRoom;
    }

    /*
     * Time Complexity: O(n * log k) - (k는 방의 최대 번호, n은 요청 수)
     * Space Complexity: O(k) - TreeSet으로 최대 k개의 방번호 저장
     */
    public long[] solution2(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        // 빈방 리스트
        Set<Long> set = new TreeSet<>();
        for (long i = 1; i <= k; i++) {
            set.add(i);
        }

        for (long i = 0; i < room_number.length; i++) {
            long room = room_number[(int) i];
            if(set.contains(room)) {
                set.remove(room);
                answer[(int) i] = room;
            } else {
                Long other_room = ((TreeSet<Long>) set).ceiling(room);
                set.remove(other_room);
                answer[(int) i] = other_room;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HotelRoomAllocation solution = new HotelRoomAllocation();
        System.out.println(Arrays.toString(solution.solution(10, new long[]{1,3,4,1,3,1})));
        System.out.println(Arrays.toString(solution.solution(1, new long[]{1})));
        System.out.println(Arrays.toString(solution.solution(2, new long[]{1,2})));
        System.out.println(Arrays.toString(solution.solution(3, new long[]{1,1})));
        System.out.println(Arrays.toString(solution.solution(10, new long[]{1,1,1,1,1,5,8,5})));
    }
}
