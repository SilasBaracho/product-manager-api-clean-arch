package sb.pma.infrastructure.config.db.schema

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import sb.pma.infrastructure.config.db.schema.compositeKey.ProductIngredientId
import java.math.BigDecimal

@Entity
@Table(name = "product_ingredients")
@IdClass(ProductIngredientId::class)
data class ExtraProductIngredientSchema(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    val product: ProductSchema,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient")
    val ingredient: IngredientSchema,

    @Column(name = "additional_cost")
    val additionalCost: BigDecimal? = BigDecimal.ZERO,
): java.io.Serializable{}
