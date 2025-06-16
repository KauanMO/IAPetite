package com.aipetite.recommender.exception

class UserNotFoundByEmailException(email: String) : RuntimeException("User not found with email: $email")