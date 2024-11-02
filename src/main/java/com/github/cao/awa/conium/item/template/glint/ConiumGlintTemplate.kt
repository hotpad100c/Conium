package com.github.cao.awa.conium.item.template.glint

import com.github.cao.awa.conium.item.template.ConiumItemTemplate
import com.github.cao.awa.conium.template.ConiumTemplates
import com.google.gson.JsonElement
import net.minecraft.component.DataComponentTypes
import net.minecraft.item.Item
import net.minecraft.registry.RegistryWrapper.WrapperLookup

class ConiumGlintTemplate(private val glint: Boolean) : ConiumItemTemplate(ConiumTemplates.GLINT) {
    companion object {
        @JvmStatic
        fun create(element: JsonElement, registryLookup: WrapperLookup): ConiumGlintTemplate {
            return ConiumGlintTemplate(element.asBoolean)
        }
    }

    override fun settings(settings: Item.Settings) {
        // Set glint override.
        settings.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, this.glint)
    }
}