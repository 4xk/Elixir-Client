package io.github.i4XK.client.mod.mods;

import io.github.i4XK.client.event.EventTarget;
import io.github.i4XK.client.events.EventUpdate;
import io.github.i4XK.client.mod.Mod;
import io.github.i4XK.client.mod.ModData;
import io.github.i4XK.compatability.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

public class Aura extends Mod {
    Entity target;

    public Aura(ModData data) {
        super(data);
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(EventUpdate eu) {

        for (Entity e : Wrapper.INSTANCE.getWorld().loadedEntityList) {
            if (isValid(e)) {
                target = e; //a
            }
        }
        if (target != null ) {
            Wrapper.INSTANCE.getPlayer().rotationYaw = getRotations(target)[0];
            Wrapper.INSTANCE.getPlayer().rotationPitch = getRotations(target)[1];
            if(getCooldown() > 0.9f) {
                Wrapper.INSTANCE.getMC().playerController.attackEntity(Wrapper.INSTANCE.getPlayer(), target);
                Wrapper.INSTANCE.getPlayer().swingArm(EnumHand.MAIN_HAND);
                target = null;
            }
        }
    }

    public boolean isValid(Entity e) {
        return !e.isDead && e != Wrapper.INSTANCE.getPlayer() && Wrapper.INSTANCE.getPlayer().getDistance(e) < 4 && e instanceof EntityLivingBase;

    }
    public static float getCooldown()
    {
        return Wrapper.INSTANCE.getPlayer().getCooledAttackStrength(0.0f);

    }
    private float[] getRotations(double x, double y, double z) {
        double diffX = x + .5D - Wrapper.INSTANCE.getPlayer().posX;
        double diffY = (y + .5D) / 2D - (Wrapper.INSTANCE.getPlayer().posY + Wrapper.INSTANCE.getPlayer().getEyeHeight());
        double diffZ = z + .5D - Wrapper.INSTANCE.getPlayer().posZ;

        double dist = MathHelper.sqrt(diffX * diffX + diffZ * diffZ);
        float yaw = (float) (Math.atan2(diffZ, diffX) * 180D / Math.PI) - 90F;
        float pitch = (float) -(Math.atan2(diffY, dist) * 180D / Math.PI);

        return new float[] { yaw, pitch };
    }

    public static float[] getRotations(Entity ent) {
        double x = ent.posX;
        double z = ent.posZ;
        double y = ent.posY + (double) (ent.getEyeHeight() / 2.0f);
        return getRotationFromPosition(x, z, y);
    }

    public static float[] getRotationFromPosition(double x, double z, double y) {
        double xDiff = x - Wrapper.INSTANCE.getPlayer().posX;
        double zDiff = z - Wrapper.INSTANCE.getPlayer().posZ;
        double yDiff = y - Wrapper.INSTANCE.getPlayer().posY - 1.2;
        double dist = MathHelper.sqrt(xDiff * xDiff + zDiff * zDiff);
        float yaw = (float) (Math.atan2(zDiff, xDiff) * 180.0 / 3.141592653589793) - 90.0f;
        float pitch = (float) (-Math.atan2(yDiff, dist) * 180.0 / 3.141592653589793);
        return new float[] { yaw, pitch };
    }
}
