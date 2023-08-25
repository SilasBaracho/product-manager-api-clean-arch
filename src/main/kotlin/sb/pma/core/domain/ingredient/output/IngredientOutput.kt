package sb.pma.core.domain.ingredient.output

import java.time.LocalDateTime

interface IngredientOutput {
    val id: Long
    val name: String
    val createdAt: LocalDateTime?
    val updatedAt: LocalDateTime?
}
