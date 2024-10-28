package com.github.cao.awa.conium.bedrock.world.player.screen

import com.github.cao.awa.conium.bedrock.script.BedrockScriptAnonymousObjectMap
import com.github.cao.awa.conium.bedrock.world.player.BedrockPlayer
import com.github.cao.awa.conium.bedrock.world.player.screen.title.BedrockScreenDisplayTitle

class BedrockOnScreenDisplay(val player: BedrockPlayer) {
    private val screenDisplayTitle = BedrockScreenDisplayTitle("", "")

    fun setTitle(title: String, properties: BedrockScriptAnonymousObjectMap) = this.screenDisplayTitle.setTitle(title, properties)
    fun updateSubtitle(title: String) = this.screenDisplayTitle.updateSubtitle(title)
}