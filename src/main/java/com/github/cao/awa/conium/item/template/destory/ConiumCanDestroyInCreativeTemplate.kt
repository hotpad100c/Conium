package com.github.cao.awa.conium.item.template.destory

import com.github.cao.awa.conium.item.ConiumItem
import com.github.cao.awa.conium.item.template.ConiumItemTemplate
import com.github.cao.awa.conium.template.ConiumTemplates.Item.CAN_DESTROY_IN_CREATIVE
import com.google.gson.JsonElement
import net.minecraft.registry.RegistryWrapper.WrapperLookup

class ConiumCanDestroyInCreativeTemplate(private val canDestroy: Boolean) : ConiumItemTemplate(CAN_DESTROY_IN_CREATIVE) {
    companion object {
        @JvmStatic
        fun create(element: JsonElement, registryLookup: WrapperLookup): ConiumCanDestroyInCreativeTemplate = ConiumCanDestroyInCreativeTemplate(element.asBoolean)
    }

    override fun complete(item: ConiumItem) {
        item.canMinePredicate = { _, _, _, _, player -> !player.isCreative || this.canDestroy }
    }
}
