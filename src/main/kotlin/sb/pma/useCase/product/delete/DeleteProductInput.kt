package sb.pma.useCase.product.delete

import java.util.UUID

data class DeleteProductInput(
    val id: UUID
): java.io.Serializable{}
