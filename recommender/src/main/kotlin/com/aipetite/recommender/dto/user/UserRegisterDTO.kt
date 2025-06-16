package com.aipetite.recommender.dto.user

data class UserRegisterDTO(
    val name: String,
    val email: String,
    val password: String,
    val diets: List<String>
)
