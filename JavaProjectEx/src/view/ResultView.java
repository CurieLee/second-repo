package view;

// 컨트롤러가 사용자에게 결과를 보여줄때 활용
public class ResultView {
	public static void successMsg(String msg) {
		System.out.println("성공: " + msg);
	}
	
	public static void errorMsg(String msg) {
		System.out.println("실패: " + msg);
	}
}
