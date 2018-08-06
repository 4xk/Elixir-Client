package io.github.i4XK.compatability;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.World;

public enum Wrapper {
    INSTANCE;

    public Minecraft getMC() {
        return Minecraft.getMinecraft();
    }
    public void setFlying(boolean f){
        getPlayer().capabilities.isFlying = f;
    }
    public EntityPlayerSP getPlayer() {
        return getMC().player;
    }

    public WorldClient getWorld() {
        return getMC().world;
    }

    public FontRenderer getFR() {
        return getMC().fontRenderer;
    }
}
