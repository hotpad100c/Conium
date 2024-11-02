package com.github.cao.awa.conium.recipe

import com.github.cao.awa.conium.recipe.template.ConiumRecipeTemplate
import com.github.cao.awa.conium.template.ConiumTemplate
import com.github.cao.awa.conium.template.ConiumTemplates
import com.google.gson.JsonObject
import net.minecraft.recipe.Recipe
import net.minecraft.registry.RegistryWrapper.WrapperLookup

class ConiumBedrockRecipeBuilder(private val template: ConiumRecipeTemplate<*>) {
    companion object {
        private val bedrockRecipes = listOf(
            ConiumTemplates.BEDROCK_RECIPE_SHAPED,
            ConiumTemplates.BEDROCK_RECIPE_SHAPELESS,
            ConiumTemplates.BEDROCK_RECIPE_FURNACE,
        )

        @JvmStatic
        fun create(type: String, jsonObject: JsonObject, registryLookup: WrapperLookup): ConiumBedrockRecipeBuilder {
            return ConiumBedrockRecipeBuilder(ConiumTemplate.deserializeTemplate(type, jsonObject, registryLookup) as ConiumRecipeTemplate<*>)
        }

        @JvmStatic
        fun findBedrock(jsonObject: JsonObject, registryLookup: WrapperLookup): ConiumBedrockRecipeBuilder {
            for (bedrockRecipe in this.bedrockRecipes) {
                jsonObject[bedrockRecipe]?.asJsonObject?.let {
                    return create(bedrockRecipe, it, registryLookup)
                }
            }

            throw IllegalArgumentException("Unable to find bedrock recipe in: $jsonObject")
        }
    }

    fun build(): List<Recipe<*>> = this.template.results()
}