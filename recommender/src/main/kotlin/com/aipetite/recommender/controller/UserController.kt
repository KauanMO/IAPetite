package com.aipetite.recommender.controller

import com.aipetite.recommender.dto.user.OutUserDTO
import com.aipetite.recommender.dto.user.UserLoginDTO
import com.aipetite.recommender.dto.user.UserRegisterDTO
import com.aipetite.recommender.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val service: UserService) {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun createUser(@RequestBody body: UserRegisterDTO): ResponseEntity<OutUserDTO> {
        val user = service.createUser(body)

        return ResponseEntity.ok(OutUserDTO(user))
    }

    @PostMapping
    @RequestMapping("login")
    fun login(@RequestBody body: UserLoginDTO): ResponseEntity<OutUserDTO> {
        val user = service.login(body)

        return ResponseEntity.ok(OutUserDTO(user))
    }
}