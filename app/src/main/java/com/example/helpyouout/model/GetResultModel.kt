package com.example.helpyouout.model

import com.google.gson.annotations.SerializedName

data class GetResultModel(

		@field:SerializedName("data")
	val data: List<ScoreItems?>? = null,

		@field:SerializedName("message")
	val message: String? = null,

		@field:SerializedName("status")
	val status: Boolean? = null
)

data class ScoreItems(

	@field:SerializedName("score")
	val score: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("userId")
	val userId: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
