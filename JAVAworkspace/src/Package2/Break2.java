package Package2;

public class Break2 {
	public static void main(String[] args) {
		Outter: for (char upper = 'A'; upper <= 'Z'; upper++) 
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + " - " + lower);
				
				if (lower == 'g')	break;
				
				if (upper == 'K')	break Outter;
			}
		
		
		System.out.println("종료되었습니다.");
	}
}
