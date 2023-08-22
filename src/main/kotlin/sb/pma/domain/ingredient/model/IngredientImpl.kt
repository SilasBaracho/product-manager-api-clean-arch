package sb.pma.domain.ingredient.model

import java.time.LocalDateTime

data class IngredientImpl(
    override val id: Long? = null,
    override val name: String,
    override val createdAt: LocalDateTime = LocalDateTime.now(),
    override val updatedAt: LocalDateTime? = null
): Ingredient, java.io.Serializable{}