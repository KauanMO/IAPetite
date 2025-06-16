package com.aipetite.recommender.repository

import com.aipetite.recommender.model.AppUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<AppUser, Long> {
    fun findByEmail(emai: String): AppUser?
}