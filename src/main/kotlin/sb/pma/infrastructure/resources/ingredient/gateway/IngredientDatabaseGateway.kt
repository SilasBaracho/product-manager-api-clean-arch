package sb.pma.infrastructure.resources.ingredient.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.ingredient.gateway.IngredientGateway
import sb.pma.core.domain.ingredient.model.Ingredient
import sb.pma.core.domain.ingredient.model.IngredientImpl
import sb.pma.infrastructure.config.db.repository.IngredientRepository
import sb.pma.infrastructure.resources.ingredient.adapter.IngredientAdapter
import java.time.LocalDateTime
import java.util.Optional

@Component
class IngredientDatabaseGateway(
    private val ingredientAdapter: IngredientAdapter,
    private val ingredientRepository: IngredientRepository
): IngredientGateway {

    override fun save(ingredient: Ingredient): Ingredient {
        return ingredientRepository.save(
            ingredientAdapter.toSchema(ingredient)
        ).let {
            ingredientAdapter.toDomain(it)
        }
    }

    override fun delete(ingredient: Ingredient) {
        val ingredientSchema = ingredientAdapter.toSchema(ingredient)
        ingredientRepository.delete(ingredientSchema)
    }

    override fun findAll(): MutableList<Ingredient> {
        val ingredients = mutableListOf<Ingredient>()
        ingredientRepository.findAll().map {
            val ingredient = ingredientAdapter.toDomain(it)
            ingredients.add(ingredient)
        }

        return ingredients
    }

    override fun findById(id: Long): Optional<Ingredient> {
        return ingredientRepository.findById(id).map { ingredientAdapter.toDomain(it) }
    }

    override fun findByName(name: String): Optional<Ingredient> {
        return ingredientRepository.findByName(name).map { ingredientAdapter.toDomain(it) }
    }

    override fun findOrCreateIngredientByName(name: String): Ingredient {
        return this.findByName(name)
            .orElseGet {
                this.save(
                    IngredientImpl(name = name, createdAt = LocalDateTime.now())
                )
            }
    }

}