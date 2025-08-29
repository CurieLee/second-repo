package com.mc.studyhelper.domain;

import com.mc.llm.models.gemini.chat.Format;
import com.mc.llm.models.gemini.chat.code.SchemaType;

public record StudyPlanFormat(
		SchemaType difficulty,
		SchemaType period,
		SchemaType firststepLanguage,
		SchemaType recommandedProject
	) implements Format {

	public static final StudyPlanFormat INSTANCE = 
			new StudyPlanFormat(SchemaType.STRING, SchemaType.STRING, SchemaType.STRING, SchemaType.STRING);
}
