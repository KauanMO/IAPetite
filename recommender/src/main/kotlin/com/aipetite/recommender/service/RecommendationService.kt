package com.aipetite.recommender.service

import com.aipetite.recommender.model.AppDish
import com.aipetite.recommender.model.AppUser
import com.aipetite.recommender.repository.RecommendationRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class RecommendationService(
    val repository: RecommendationRepository,
    val userService: UserService
) {
    fun getRecommendation(tags: List<String>, userId: Long): List<AppDish> {
        val userFound: AppUser = userService.getByUserId(userId)

        return emptyList()
    }



}