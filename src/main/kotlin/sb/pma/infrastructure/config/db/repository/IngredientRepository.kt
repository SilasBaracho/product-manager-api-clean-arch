package sb.pma.infrastructure.config.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sb.pma.infrastructure.config.db.schema.IngredientSchema
import java.util.Optional

@Repository
interface IngredientRepository: JpaRepository<IngredientSchema, Long> {

    fun findByName(name: String): Optional<IngredientSchema>

}