package io.github.i4XK.client.mod.mods;

import io.github.i4XK.client.event.EventTarget;
import io.github.i4XK.client.events.EventUpdate;
import io.github.i4XK.client.mod.Mod;
import io.github.i4XK.client.mod.ModData;
import io.github.i4XK.compatability.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;

public class Sprint extends Mod {
    public Sprint(ModData data) {
        super(data);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        EntityPlayerSP p = Wrapper.instance.getPlayer();
        if (p.moveForward > 0.0 || p.moveStrafing > 0.0) {
            p.setSprinting(true);
        }
    }
}