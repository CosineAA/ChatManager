package com.cosine.chatmanager

import com.cosine.chatmanager.command.ChatCommand
import com.cosine.chatmanager.listener.ChatListener
import org.bukkit.plugin.java.JavaPlugin

class ChatManager : JavaPlugin() {

    override fun onEnable() {
        logger.info("채팅 관리 플러그인 활성화")

        getCommand("채팅").executor = ChatCommand()
        server.pluginManager.registerEvents(ChatListener(), this)
    }

    override fun onDisable() {
        logger.info("채팅 관리 플러그인 비활성화")
    }
}