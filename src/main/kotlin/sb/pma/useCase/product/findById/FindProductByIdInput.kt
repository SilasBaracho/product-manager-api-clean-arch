package sb.pma.useCase.product.findById

import java.util.UUID

data class FindProductByIdInput(
    val id: UUID
): java.io.Serializable{}
