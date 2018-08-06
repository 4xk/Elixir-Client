package io.github.i4XK.client.gui;

import io.github.i4XK.client.Client;
import io.github.i4XK.client.event.EventTarget;
import io.github.i4XK.client.events.EventRenderHUD;
import io.github.i4XK.client.mod.Mod;
import io.github.i4XK.client.mod.ModData;
import io.github.i4XK.compatability.Wrapper;
import it.unimi.dsi.fastutil.doubles.DoubleComparator;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Hud extends Mod {
    public Hud(ModData data) {
        super(data);
    }


    @EventTarget
    public void onRender(EventRenderHUD e) {
        GL11.glPushMatrix();
        ScaledResolution sr = new ScaledResolution(Wrapper.INSTANCE.getMC());
        GuiInventory.drawEntityOnScreen(sr.getScaledWidth() - 20,sr.getScaledHeight() - 10,20,1,1,Wrapper.INSTANCE.getPlayer());
        GL11.glPopMatrix();
        GL11.glPushMatrix();

        GL11.glScaled(1.5, 1.5, 1.5);
        String name = Client.INSTANCE.info.get("name");
        int xpos = 1;
        int xpos2 = 1;
        Gui.drawRect(0, 0, Wrapper.INSTANCE.getFR().getStringWidth(name) + 1, 10, 0xee000000);
        for (int i = 0; i < name.length(); i++) {
            Wrapper.INSTANCE.getFR().drawString(name.charAt(i) + "", xpos, 1, getLogoRainbow(xpos * 1000000000, 1, 200).getRGB());
            xpos += Wrapper.INSTANCE.getFR().getStringWidth(name.charAt(i) + "");
        }
        for (int i = 0; i < Wrapper.INSTANCE.getFR().getStringWidth(name); i++) {
            Gui.drawRect(xpos2, 9, xpos2 + 1, 10, getLogoRainbow((i * 1) * 1000000, 1, 200).getRGB());
            xpos2 += 1;
        }
        int y = 1;
        GL11.glPopMatrix();
        CopyOnWriteArrayList<Mod> mods = new CopyOnWriteArrayList<Mod>();
        for (Mod module : Client.INSTANCE.moduleManager.mods) {
            if (!module.isActive())
                continue;
                mods.add(module);

        }

        mods.sort(Comparator.comparingDouble(m -> -Wrapper. INSTANCE.getFR().getStringWidth(m.data.name) - Wrapper.INSTANCE.getFR().getStringWidth(m.data.name)));
        for (Mod module : mods) {
            String str = module.data.name;
            String mod = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
            ScaledResolution s = new ScaledResolution(Wrapper.INSTANCE.getMC());
            int x = s.getScaledWidth() - Wrapper.INSTANCE.getFR().getStringWidth(mod);
            Gui.drawRect(x -4, y, x - 3, y + 12, getLogoRainbow(y * 10000, 1, 100).getRGB());
            Gui.drawRect(x - 3, y, x + s.getScaledWidth(), y + 12, 0x80000000);
            drawStringR(mod, x - 1, y + 3, y * 100000);
            y += 12;
        }

        Wrapper.INSTANCE.getFR().drawStringWithShadow("§7Ver: §r" + Client.INSTANCE.info.get("version"),1,20,getLogoRainbow(100000,1f,10000).getRGB());
        Wrapper.INSTANCE.getFR().drawStringWithShadow("§7MC: §r" + Client.INSTANCE.info.get("mc"),1,30,getLogoRainbow(100000,1f,10000).getRGB());
        Gui.drawRect(1,40,Wrapper.INSTANCE.getFR().getStringWidth("§7MC: §r" + Client.INSTANCE.info.get("mc")) + 2,41,-1);

        int px = MathHelper.abs((int) Wrapper.INSTANCE.getPlayer().posX);
        int py = MathHelper.abs((int) Wrapper.INSTANCE.getPlayer().posY);
        int pz = MathHelper.abs((int) Wrapper.INSTANCE.getPlayer().posZ);
        int fps = Wrapper.INSTANCE.getMC().getDebugFPS();
        Wrapper.INSTANCE.getFR().drawStringWithShadow("§7FPS: §r" + fps, 1, 42, getLogoRainbow(100000,1f,10000).getRGB());
        Wrapper.INSTANCE.getFR().drawStringWithShadow("§7X: §r" + px, 1, 52, getLogoRainbow(100000,1f,10000).getRGB());
        Wrapper.INSTANCE.getFR().drawStringWithShadow("§7Y: §r" + py, 1, 62, getLogoRainbow(100000,1f,10000).getRGB());
        Wrapper.INSTANCE.getFR().drawStringWithShadow("§7Z: §r" + pz, 1, 72, getLogoRainbow(100000,1f,10000).getRGB());


    }

    public static Color getLogoRainbow(long offset, float brightness, int speed) {
        float hue = (float) (System.nanoTime() + (offset * speed)) / 1.0E10F % 1.0F;
        long color = Long
                .parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 0.4f, 1F)).intValue()), 16);
        Color c = new Color((int) color);
        return new Color(c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, c.getAlpha() / 255.0F);
    }

    public void drawStringR(String t, int x, int y, int o) {
        int xpos = x;
        for (int i = 0; i < t.length(); i++) {
            String s = t.charAt(i) + "";
            Wrapper.INSTANCE.getFR().drawStringWithShadow(s, xpos, y, getLogoRainbow(o * i, 1, 200).getRGB());
            xpos += Wrapper.INSTANCE.getFR().getStringWidth(s);
        }
    }
}
