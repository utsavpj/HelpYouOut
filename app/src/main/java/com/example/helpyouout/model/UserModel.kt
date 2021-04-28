package com.example.helpyouout.model

import com.google.gson.annotations.SerializedName

data class UserModel(

		@field:SerializedName("Message")
	val message: String? = null,

		@field:SerializedName("data")
	val data: UserData? = null,

		@field:SerializedName("status")
	val status: Boolean? = null
)

data class UserData(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("dob")
	val dob: String? = null,

	@field:SerializedName("verified")
	val verified: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
