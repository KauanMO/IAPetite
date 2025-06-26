package com.aipetite.recommender.service

import com.aipetite.recommender.dto.recommendation.RecomReqDTO
import com.aipetite.recommender.dto.recommendation.ScrapRecomResponseDTO
import com.aipetite.recommender.repository.RecommendationRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.lang.RuntimeException

@Service
class RecommendationService(
    val repository: RecommendationRepository,
    val userService: UserService
) {
    fun getRecommendation(tags: List<String>, userId: Long): ScrapRecomResponseDTO {
        val restTemplate = RestTemplate()

        val req = RecomReqDTO(tags, 1)

        val response =
            restTemplate.postForEntity(
                "http://localhost:5001/scrap-dishes",
                req,
                ScrapRecomResponseDTO::class.java
            )

        return response.body
            ?: throw RuntimeException()
    }
}