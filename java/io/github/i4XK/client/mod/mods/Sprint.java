package io.github.i4XK.client.mod.mods;

import io.github.i4XK.client.Client;
import io.github.i4XK.client.event.EventTarget;
import io.github.i4XK.client.events.EventRenderHUD;
import io.github.i4XK.client.events.EventUpdate;
import io.github.i4XK.client.mod.Mod;
import io.github.i4XK.client.mod.ModData;
import io.github.i4XK.compatability.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Sprint extends Mod {
    public Sprint(ModData data) {
        super(data);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        EntityPlayerSP p = Wrapper.INSTANCE.getPlayer();
        if(p.moveForward > 0.0 || p.moveStrafing > 0.0) {
            p.setSprinting(true);
        }
    }
}