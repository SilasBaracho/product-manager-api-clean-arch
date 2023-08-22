package sb.pma.useCase.ingredient

import sb.pma.domain.ingredient.model.Ingredient
import sb.pma.domain.ingredient.model.IngredientImpl
import java.time.LocalDateTime

data class IngredientOutput(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime? = null
): java.io.Serializable{
    constructor(ingredient: Ingredient) : this(
        id = ingredient.id!!,
        name = ingredient.name,
        createdAt = ingredient.createdAt,
        updatedAt = ingredient.updatedAt
    )
}
