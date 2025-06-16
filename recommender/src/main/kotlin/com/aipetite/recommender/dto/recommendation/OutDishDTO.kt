package com.aipetite.recommender.dto.recommendation

import com.aipetite.recommender.model.AppDish
import com.aipetite.recommender.utils.DishTagEnum

data class OutDishDTO(
    val id: Long,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val tags: Set<DishTagEnum>
) {
    constructor(dish: AppDish) : this(
        id = dish.id,
        name = dish.name,
        description = dish.description,
        ingredients = dish.ingredients,
        tags = dish.tags
    )
}
