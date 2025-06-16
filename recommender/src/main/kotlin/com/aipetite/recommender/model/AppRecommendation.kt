package com.aipetite.recommender.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class AppRecommendation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    val user: AppUser,

    @ManyToMany
    val dishes: List<AppDish>,

    val acceptedDishId: Long? = null,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
