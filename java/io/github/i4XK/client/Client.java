package io.github.i4XK.client;

import com.google.common.collect.Maps;
import io.github.i4XK.client.event.EventManager;
import io.github.i4XK.client.event.EventTarget;
import io.github.i4XK.client.events.EventKeyPress;
import io.github.i4XK.client.gui.Hud;
import io.github.i4XK.client.log.Logger;
import io.github.i4XK.client.manager.ModuleManager;
import io.github.i4XK.client.mod.Mod;
import org.lwjgl.opengl.Display;

import java.util.HashMap;

public class Client {
    public static Client INSTANCE;
    public HashMap<String, String> info = Maps.newHashMap();
    Logger logger;
    public ModuleManager moduleManager;

    public Client() {
        INSTANCE = this;
    }

    public void init() {
        info.put("mc", "1.12.1");
        info.put("version", "0.1");
        info.put("name", "Elixir");
        logger = new Logger(info.get("name"));
        logger.log("Client starting!", Logger.LogType.info);
        Display.setTitle(info.get("name") + " " + info.get("version"));
        moduleManager = new ModuleManager();
        EventManager.register(this);
    }

    @EventTarget
    public void onKey(EventKeyPress e) {
        for (Mod m : moduleManager.mods) {
            if(e.key() == m.data.bind){
                m.setActive(!m.isActive());
            }
        }
    }

}
