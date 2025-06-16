package com.aipetite.recommender.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundByEmailException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleException(e: UserNotFoundByEmailException): Map<String, String> {
        return mapOf("Error: " to e.message.orEmpty())
    }

    @ExceptionHandler(IncorrectPasswordException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleException(e: IncorrectPasswordException): Map<String, String> {
        return mapOf("Error: " to e.message.orEmpty())
    }
}