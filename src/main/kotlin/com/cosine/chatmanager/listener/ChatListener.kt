package com.cosine.chatmanager.listener

import com.cosine.chatmanager.util.Variable.freeze
import com.cosine.chatmanager.util.Variable.prefix
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatListener : Listener {

    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent) {
        val player = event.player
        if (freeze) {
            event.isCancelled = true
            player.sendMessage("$prefix 채팅이 잠겨 이용하실 수 없습니다.")
        }
    }
}