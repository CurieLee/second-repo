package com.mc.studyhelper.presentation;

import java.util.List;
import java.util.Scanner;

import com.mc.studyhelper.domain.StudyHelper;
import com.mc.studyhelper.domain.StudyPlan;

public class Menu {

	public void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("공부하고 싶은 프로그래밍 언어 개념을 물어보세요! ");
		String input = scan.nextLine();
		
		// 난이도, 소요시간, 선행 프로그래밍 언어, 프로젝트
		StudyHelper helper = new StudyHelper();
		StudyPlan plan = helper.execute(input);
		
		System.out.println(plan);
	
	}
}
