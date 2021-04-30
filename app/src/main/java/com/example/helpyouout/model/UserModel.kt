package com.example.helpyouout.model

import com.google.gson.annotations.SerializedName

data class UserModel(

		@field:SerializedName("Message")
	val message: String? = null,

		@field:SerializedName("message")
	val failMessage: String? = null,

		@field:SerializedName("data")
	val data: UserData? = null,

		@field:SerializedName("status")
	val status: Boolean? = null
)

data class UserData(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("gender")
	var gender: String? = null,

	@field:SerializedName("dob")
	var dob: String? = null,

	@field:SerializedName("verified")
	var verified: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	var email: String? = null
)
