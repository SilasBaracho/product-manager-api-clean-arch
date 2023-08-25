package sb.pma.core.domain.ingredient.output

import sb.pma.core.domain.ingredient.model.Ingredient
import java.time.LocalDateTime

data class IngredientOutputImpl(
    override val id: Long,
    override val name: String,
    override val createdAt: LocalDateTime?,
    override val updatedAt: LocalDateTime? = null
): IngredientOutput, java.io.Serializable{
    constructor(ingredient: Ingredient) : this(
        id = ingredient.id!!,
        name = ingredient.name,
        createdAt = ingredient.createdAt,
        updatedAt = ingredient.updatedAt
    )
}
