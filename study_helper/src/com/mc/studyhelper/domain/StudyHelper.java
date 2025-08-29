package com.mc.studyhelper.domain;

import java.util.List;
import java.util.Map;

import com.mc.llm.models.BaseModel;
import com.mc.llm.models.BaseRequest;
import com.mc.llm.models.BaseResponse;
import com.mc.llm.models.LLMContext;
import com.mc.llm.models.LLMProvider;
import com.mc.llm.models.gemini.chat.GeminiRequest;

public class StudyHelper {
	
	private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";
	
	private BaseModel model = new LLMContext().initChatModel(API_URL, LLMProvider.GEMINI);
	
	public StudyHelper() {
		
	}

	public StudyPlan execute(String input) {
		
		input += ". 이 프로그래밍 언어의 난이도, 미리 학습하면 좋은 프로그래밍 언어,"
				+ "학습 소욕간, 학습 후 하면 좋은 프로젝트 아이디어를 추천해줘.";
		
		BaseRequest req = new GeminiRequest<StudyPlanFormat>(input, StudyPlanFormat.INSTANCE);
		BaseResponse resp = model.invoke(req);
		List<Map<String, Object>> res = resp.messageToMap();
		System.out.println(res);
		
		return StudyPlan.fromMap(res.getFirst());
	}
}
