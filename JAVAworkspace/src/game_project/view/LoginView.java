package game_project.view;

import java.util.Scanner;

import game_project.controller.Controller;

public class LoginView {
	private Controller controller = Controller.getInstance();
    private Scanner scan = new Scanner(System.in);
    
    public void login() {
        System.out.println();
        System.out.println("************************************");
        System.out.println("\t로그인");
        System.out.println("************************************");
        
        System.out.print("아이디 입력: ");
        String user_id = scan.nextLine();
        
        System.out.print("비밀번호 입력: ");
        String password = scan.nextLine();
        
        boolean loginSuccess = controller.login(user_id, password);
        
        if (loginSuccess) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
        }
    }
}
