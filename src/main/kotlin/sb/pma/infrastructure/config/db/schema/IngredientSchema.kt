package sb.pma.infrastructure.config.db.schema

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GenerationType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "ingredient")
data class IngredientSchema(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_ingredient")
    val id: Long? = null,

    @Column(name= "name")
    val name: String,

    @Column(name= "created_at")
    val createdAt: LocalDateTime,

    @Column(name= "updated_at")
    val updatedAt: LocalDateTime? = null
): java.io.Serializable {}
