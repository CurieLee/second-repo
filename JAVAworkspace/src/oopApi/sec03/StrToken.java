package oopApi.sec03;
import java.util.StringTokenizer;

public class StrToken {

	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(text, "/");
		
		int countToken = st.countTokens();
		System.out.println("token count: " + countToken);
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
