package com.github.cao.awa.conium.block.template

import com.github.cao.awa.conium.block.ConiumBlock
import com.github.cao.awa.conium.template.ConiumTemplate
import net.minecraft.block.AbstractBlock

abstract class ConiumBlockTemplate(name: String) : ConiumTemplate<ConiumBlock>(name) {
    override fun attach(target: ConiumBlock) {
        // Do nothing.
    }

    override fun complete(target: ConiumBlock) {
        // Do nothing.
    }

    open fun settings(settings: AbstractBlock.Settings) {
        // Do nothing.
    }
}
