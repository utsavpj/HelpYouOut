package com.example.helpyouout.model

import com.google.gson.annotations.SerializedName

data class AllQuestionModel(

	@field:SerializedName("data")
	val data: List<QuestionData?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

