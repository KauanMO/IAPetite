package com.aipetite.recommender.model

import jakarta.persistence.*

@Entity
data class AppUser(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String,
    val email: String,
    val password: String,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "app_user_diet",
        joinColumns = [JoinColumn(name = "app_user_id")],
        inverseJoinColumns = [JoinColumn(name = "app_diet_id")]
    )
    val diets: Set<AppDiet> = emptySet()
)
