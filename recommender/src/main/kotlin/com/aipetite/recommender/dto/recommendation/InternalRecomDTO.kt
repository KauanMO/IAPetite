package com.aipetite.recommender.dto.recommendation

data class InternalRecomDTO(
    val name: String,
    val image: String,
    val ingredients: List<String>,
    val howToSteps: List<String>
)
