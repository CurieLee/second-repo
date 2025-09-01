package algorithm_quiz.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {
	
		List<Meeting> meetings = Arrays.asList(
	            new Meeting("개발", 1, 10),
	            new Meeting("기획", 5, 6),
	            new Meeting("인사", 13, 15),
	            new Meeting("총무", 14, 17),
	            new Meeting("QA", 8, 14),
	            new Meeting("CS", 3, 12)
	        );
		
		List<Integer> result = Meeting.meetingSchedule(meetings);

		String output = result.stream()
                .map(idx -> idx + "번 회의")
                .reduce((a, b) -> a + " - " + b)
                .orElse("");

        System.out.println(output);
	}
	
	// 해설
	private static void q2() {
		List<Meeting> meetings = createMeetings();
		List<Meeting> timetable = new ArrayList<Meeting>();
		Collections.sort(meetings);
		
		timetable.add(meetings.getFirst());
		meetings.removeFirst();
		
		for (Meeting meeting: meetings) {
			if (timetable.getLast().getEnd() <= meeting.getStart()) {
				timetable.add(meeting);
			}
		}
	}
	
	private static List<Meeting> createMeetings() {
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting("개발", 1, 10));
		meetings.add(new Meeting("기획", 5, 6));
		meetings.add(new Meeting("인사", 13, 15));
		meetings.add(new Meeting("총무", 14, 17));
		meetings.add(new Meeting("QA", 8, 14));
		meetings.add(new Meeting("CS", 3, 12));
		return meetings;
	}
}
