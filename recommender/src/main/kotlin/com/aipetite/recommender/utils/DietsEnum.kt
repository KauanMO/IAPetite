package com.aipetite.recommender.utils

enum class DietsEnum(val description: String, searchName: String) {
    GLUTTEN_FREE("sem glúten", "sem_gluten"),
    VEGETARIAN("vegetariano"),
    LACTO_VEGETARIAN("lacto-vegetariano"),
    OVO_VEGETARIAN("ovo-vegetariano"),
    VEGAN("vegano"),
    LOW_CARB("low-carb")
}