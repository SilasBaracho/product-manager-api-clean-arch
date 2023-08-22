package sb.pma.infrastructure.config.db.schema.compositeKey

import java.util.UUID

data class ProductIngredientId(
    val product: UUID? = null,
    val ingredient: Long? = null
) : java.io.Serializable {}