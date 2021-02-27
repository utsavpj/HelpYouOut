package com.example.helpyouout.model

import com.google.gson.annotations.SerializedName

data class QuestionModel(

		@field:SerializedName("data")
	val questionData: QuestionData? = null,

		@field:SerializedName("message")
	val message: String? = null,

		@field:SerializedName("status")
	val status: Boolean? = null
)

data class QuestionData(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("question")
	val question: String? = null,

	@field:SerializedName("value2")
	val value2: String? = null,

	@field:SerializedName("value1")
	val value1: String? = null,

	@field:SerializedName("value4")
	val value4: String? = null,

	@field:SerializedName("value3")
	val value3: String? = null,

	@field:SerializedName("option3")
	val option3: String? = null,

	@field:SerializedName("option4")
	val option4: String? = null,

	@field:SerializedName("option1")
	val option1: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("option2")
	val option2: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
