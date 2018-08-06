package io.github.i4XK.client.mod;

import io.github.i4XK.client.Client;
import io.github.i4XK.client.event.EventManager;
import org.lwjgl.Sys;

public class Mod {
    public ModData data;
    boolean active;

    public Mod(ModData data) {
        this.data = data;
    }

    public void setActive(boolean active) {
        if(active){
            EventManager.register(this);
            this.onEnable();
        }else{
            EventManager.unregister(this);
            this.onDisable();
        }
        this.onToggle();
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    public void onToggle() {

    }
    public void onEnable() {

    }

    public void onDisable() {

    }
    public void onPress(int key){
        for(Mod m : Client.INSTANCE.moduleManager.mods){
            if( m.data.bind == key){
                m.setActive(!m.isActive());
            }
        }
    }
}
