package com.aipetite.recommender.model

import com.aipetite.recommender.utils.DishTagEnum
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany

@Entity
data class AppDish(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val description: String,

    @ElementCollection
    val ingredients: List<String> = emptyList(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "dish_diet",
        joinColumns = [JoinColumn(name = "dish_id")],
        inverseJoinColumns = [JoinColumn(name = "diet_id")]
    )
    val diets: Set<AppDiet> = emptySet(),

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    val tags: Set<DishTagEnum> = emptySet()
)
