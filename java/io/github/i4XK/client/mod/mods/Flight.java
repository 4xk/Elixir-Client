package io.github.i4XK.client.mod.mods;

import io.github.i4XK.client.event.EventTarget;
import io.github.i4XK.client.events.EventUpdate;
import io.github.i4XK.client.mod.Mod;
import io.github.i4XK.client.mod.ModData;
import io.github.i4XK.compatability.Wrapper;

public class Flight extends Mod {
    public Flight(ModData data) {
        super(data);
    }

    @Override
    public void onEnable() {
        Wrapper.INSTANCE.setFlying(true);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Wrapper.INSTANCE.setFlying(false);
        super.onDisable();
    }
    @EventTarget
    public void onUpdate(EventUpdate e){
        Wrapper.INSTANCE.setFlying(true);
    }
}
