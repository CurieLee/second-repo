package algorithm_quiz.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Meeting implements Comparable<Meeting> {

	String idx;
	// int idx;
    int start;
    int end;

    public Meeting(String idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }

	public static List<Integer> meetingSchedule(List<Meeting> meetings) {
        meetings.sort(Comparator.comparingInt(m -> m.end));

        List<Integer> selected = new ArrayList<>();
        int currentTime = 0;

        for (Meeting m : meetings) {
            if (currentTime <= m.start) {
                // selected.add(m.idx);
                currentTime = m.end;
            }
        }

        return selected;
    }
	
	// 해설
	 public String getIdx() {
		 return idx;
	 }

	 public int getStart() {
		 return start;
	 }

	 public int getEnd() {
		 return end;
	 }

	 @Override
	 public String toString() {
		 return "Meeting [idx=" + idx + ", start=" + start + ", end=" + end + "]";
	 }
		
	 public int compareTo(Meeting o) {
		 return end - o.end;
	 }

}
