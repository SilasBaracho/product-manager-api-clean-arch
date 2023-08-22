package sb.pma.domain.ingredient.model

import java.time.LocalDateTime

interface Ingredient {
    val id: Long?
    val name: String
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime?
}
