package com.aipetite.recommender.exception

import java.lang.RuntimeException

class UserNotFoundByIdException(userId: Long) : RuntimeException("User not found with id: $userId")