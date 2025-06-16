package com.aipetite.recommender.service

import com.aipetite.recommender.dto.user.UserLoginDTO
import com.aipetite.recommender.dto.user.UserRegisterDTO
import com.aipetite.recommender.exception.IncorrectPasswordException
import com.aipetite.recommender.exception.UserNotFoundByEmailException
import com.aipetite.recommender.exception.UserNotFoundByIdException
import com.aipetite.recommender.model.AppUser
import com.aipetite.recommender.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(
    val repository: UserRepository,
    val dietService: DietService
) {
    fun createUser(body: UserRegisterDTO): AppUser {
        val diets = body.diets.map { name ->
            dietService.findByName(name)
        }.toSet()

        val user = AppUser(
            name= body.name,
            email = body.email,
            password = body.password,
            diets = diets
        )

        return repository.save(user)
    }

    fun login(body: UserLoginDTO): AppUser {
        val userFound: AppUser = repository.findByEmail(body.email) ?: throw UserNotFoundByEmailException(body.email)

        if(userFound.password != body.password) throw IncorrectPasswordException()

        return userFound
    }

    fun getByUserId(userId: Long): AppUser {
        val userFound: Optional<AppUser> = repository.findById(userId)

        if(!userFound.isPresent) throw UserNotFoundByIdException(userId)

        return userFound.get()
    }
}