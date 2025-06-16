package com.aipetite.recommender.repository

import com.aipetite.recommender.model.AppRecommendation
import org.springframework.data.jpa.repository.JpaRepository

interface RecommendationRepository : JpaRepository<AppRecommendation, Long> {
}