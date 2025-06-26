package com.aipetite.recommender.dto.recommendation

data class ScrapRecomResponseDTO(
    val dishes: List<InternalRecomDTO>,
    val totalPages: Int
)
