package game_project.view;

import java.util.Scanner;

import game_project.controller.Controller;

public class LoginView {
	private Controller controller = Controller.getInstance();
    private Scanner scan = new Scanner(System.in);
    
    public void login() {
        System.out.println();
        System.out.println("************************************");
        System.out.println("\t\t로그인");
        System.out.println("************************************");
        
        System.out.print("아이디 입력: ");
        String user_id = scan.nextLine();
        
        System.out.print("비밀번호 입력: ");
        String password = scan.nextLine();
        
        controller.login(user_id, password);
    }
}
