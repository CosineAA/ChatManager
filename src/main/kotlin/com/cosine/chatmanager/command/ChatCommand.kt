package com.cosine.chatmanager.command

import com.cosine.chatmanager.service.ChatService
import com.cosine.chatmanager.util.Variable.freeze
import com.cosine.chatmanager.util.Variable.prefix
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ChatCommand : CommandExecutor, ChatService {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.isOp) return false
        if (args.isEmpty()) {
            help(sender)
            return false
        }
        when (args[0]) {
            "청소" -> clearChat()
            "토글" -> freezeChat()
        }
        return false
    }

    private fun help(sender: CommandSender) {
        sender.sendMessage("$prefix /채팅 청소")
        sender.sendMessage("$prefix /채팅 토글")
    }

    override fun freezeChat() {
        if (freeze) {
            freeze = false
            Bukkit.broadcastMessage("$prefix 전체 채팅 잠금이 해제됩니다.")
        } else {
            freeze = true
            Bukkit.broadcastMessage("$prefix 전체 채팅을 잠급니다.")
        }
    }

    override fun clearChat() {
        repeat(50) {
            Bukkit.broadcastMessage("§f")
        }
        Bukkit.broadcastMessage("$prefix 채팅이 청소되었습니다.")
    }
}