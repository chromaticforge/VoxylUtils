package com.github.chromaticforge.voxyl.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;

import java.util.Arrays;

public class ServerUtils {
    private static final String[] addresses = {"voxyl.net", "bedwarspractice.club", "bedwarspractice.net"};

    public static boolean isVoxyl() {
        ServerData data = Minecraft.getMinecraft().getCurrentServerData();
        return Arrays.asList(addresses).contains(data.serverIP);
    }
}
