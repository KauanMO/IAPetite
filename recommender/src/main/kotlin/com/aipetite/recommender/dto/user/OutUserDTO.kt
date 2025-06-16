package com.aipetite.recommender.dto.user

import com.aipetite.recommender.model.AppUser

data class OutUserDTO(
    val id: Long,
    val name: String,
    val email: String,
    val diets: Set<String>
) {
    constructor(user: AppUser) : this(
        id = user.id,
        name = user.name,
        email = user.email,
        diets = user.diets.map { it.name }.toSet()
    )
}
