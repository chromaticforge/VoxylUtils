package com.github.chromaticforge.voxyl;

import cc.polyfrost.oneconfig.libs.universal.UChat;
import com.github.chromaticforge.voxyl.config.VoxylConfig;
import com.github.chromaticforge.voxyl.utils.RegexValues;
import com.github.chromaticforge.voxyl.utils.ServerUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = VoxylUtils.ID, name = VoxylUtils.NAME, version = VoxylUtils.VER)
public class VoxylUtils {
    public static final String ID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VER = "@VER@";

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        new VoxylConfig();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChatEvent(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();

        if (ServerUtils.isVoxyl()) {
            if (VoxylConfig.gg && msg.matches(RegexValues.end)) {
                UChat.say("/ac " + VoxylConfig.ggText);
            } else if (VoxylConfig.gl && msg.matches(RegexValues.start)) {
                UChat.say("/ac " + VoxylConfig.glText);
            }
        }
    }
}
