package com.github.cao.awa.conium.template

import com.github.cao.awa.conium.item.ConiumItem
import com.github.cao.awa.sinuatum.manipulate.Manipulate
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.function.BiFunction
import java.util.function.Function
import kotlin.reflect.KClass

abstract class ConiumTemplate<T>(private val name: String) {
    companion object {
        private val templates: MutableMap<String, BiFunction<JsonElement, WrapperLookup, ConiumTemplate<*>>> = CollectionFactor.hashMap()

        @JvmStatic
        fun register(name: String, template: BiFunction<JsonElement, WrapperLookup, ConiumTemplate<*>>) {
            this.templates[name] = template
        }

        fun deserializeTemplates(
            json: JsonObject,
            registryLookup: WrapperLookup,
            wrapper: (String) -> ConiumTemplate<*>? = { _ -> null }
        ): MutableList<ConiumTemplate<*>> {
            val templates: MutableList<ConiumTemplate<*>> = CollectionFactor.arrayList()

            val sharingContext = CollectionFactor.hashMap<Class<*>, Any>()

            for (entry in json.entrySet()) {
                val name = entry.key
                val value = entry.value

                wrapper(name)?.let {
                    it.sharingContext = sharingContext
                }

                deserializeTemplate(name, value, registryLookup).let {
                    it.sharingContext = sharingContext
                    templates.add(it)
                }
            }

            return templates
        }

        fun deserializeTemplate(name: String, json: JsonElement, registryLookup: WrapperLookup): ConiumTemplate<*> {
            return this.templates[name]?.apply(json, registryLookup) ?: throw IllegalArgumentException("Unable to deserialize template '$name' because it does not exist")
        }
    }

    // This contexts will be set in deserializing templates, do not set it again in feature.
    private lateinit var sharingContext: Map<Class<*>, Any>

    // Use 'sharedContext' to delegate because reassignment shared contexts is unexpected.
    // So only allow to get, instead to set it.
    val sharedContext: Map<Class<*>, Any> get() = this.sharingContext

    fun <T : Any> getContext(clazz: KClass<T>): T? = getContext(clazz.java)

    fun <T> getContext(clazz: Class<T>): T? = Manipulate.cast(this.sharedContext[clazz])

    fun name(): String = this.name

    abstract fun attach(item: T)

    abstract fun complete(item: T)
}
