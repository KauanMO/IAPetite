package com.aipetite.recommender.controller

import com.aipetite.recommender.dto.recommendation.OutDishDTO
import com.aipetite.recommender.dto.recommendation.ScrapRecomResponseDTO
import com.aipetite.recommender.service.RecommendationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("recommendation")
class RecommendationController(
    val service: RecommendationService
) {
    @GetMapping
    fun getRecommendation(@RequestParam tags: List<String>?, userId: Long): ResponseEntity<ScrapRecomResponseDTO> {
        val recommendedDishes = service.getRecommendation(tags ?: emptyList(), userId)

        return ResponseEntity.ok(
            recommendedDishes
        )
    }
}