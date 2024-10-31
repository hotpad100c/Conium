package com.github.cao.awa.conium.event.context

import com.github.cao.awa.conium.event.type.DynamicArgType
import com.github.cao.awa.conium.parameter.DynamicArgs
import com.github.cao.awa.conium.parameter.ParameterSelective
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor

class ConiumEventContext<P : ParameterSelective?, R>(
    private val dynamicArgs: DynamicArgs<P, R>
) {
    private var ariseTrigger: P? = null
    private var presageTrigger: P? = null
    private var varyingTrigger: P? = null

    private val args: MutableMap<DynamicArgType<*>, Any?> = CollectionFactor.hashMap()
    private val attaches: MutableList<ConiumEventContext<*, *>> = CollectionFactor.arrayList()

    fun arise(trigger: P): ConiumEventContext<P, R> {
        this.ariseTrigger = trigger
        return this
    }

    fun presage(trigger: P): ConiumEventContext<P, R> {
        this.presageTrigger = trigger
        return this
    }

    fun varying(trigger: P): ConiumEventContext<P, R> {
        this.varyingTrigger = trigger
        return this
    }

    fun resetArgs(args: MutableMap<DynamicArgType<*>, Any?>): ConiumEventContext<P, R> {
        this.args.clear()
        this.args.putAll(args)
        return this
    }

    fun <X> put(arg: DynamicArgType<X>, value: X) {
        this.args[arg] = value
    }

    fun <X> dynamic(arg: DynamicArgType<X>) {
        this.args[arg] = arg
    }

    fun attach(context: ConiumEventContext<*, Boolean>): ConiumEventContext<P, R> {
        this.attaches.add(context)
        return this
    }

    fun attach(context: MutableList<ConiumEventContext<*, Boolean>>): ConiumEventContext<P, R> {
        this.attaches.addAll(context)
        return this
    }

    fun hasPresaging(): Boolean {
        return this.presageTrigger != null
    }

    fun presaging(identity: Any): Boolean {
        var success = this.presageTrigger == null || this.dynamicArgs.arising(
            identity,
            this.args,
            this.presageTrigger!!
        ) as Boolean
        for (attach in this.attaches) {
            if (attach.hasPresaging()) {
                val attachSuccess = attach.resetArgs(this.args)
                    .presaging(identity)
                success = success && attachSuccess
            }
        }
        return success
    }

    fun hasArising(): Boolean {
        return this.ariseTrigger != null
    }

    fun arising(identity: Any): Boolean {
        var success = this.dynamicArgs.arising(identity, this.args, this.ariseTrigger!!) as Boolean
        for (attach in this.attaches) {
            if (attach.hasArising()) {
                val attachSuccess = attach.resetArgs(this.args)
                    .arising(identity)

                success = success && attachSuccess
            }
        }
        return success
    }
}
