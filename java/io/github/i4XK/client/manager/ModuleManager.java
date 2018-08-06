package io.github.i4XK.client.manager;

import io.github.i4XK.client.gui.Hud;
import io.github.i4XK.client.mod.Mod;
import io.github.i4XK.client.mod.ModData;
import io.github.i4XK.client.mod.mods.Aura;
import io.github.i4XK.client.mod.mods.Flight;
import io.github.i4XK.client.mod.mods.Sprint;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Mod> mods;

    public ModuleManager() {
        mods = new ArrayList<>();
        mods.add(new Hud(new ModData("Hud", ModData.Category.Render, Keyboard.KEY_X))); //String name, Category category, int bind, Category cat){ Keyboard.KEY_SUBTRACT
        mods.add(new Sprint(new ModData("Sprint", ModData.Category.Movement, Keyboard.KEY_Z))); //String name, Category category, int bind, Category cat){ Keyboard.KEY_SUBTRACT
        mods.add(new Flight(new ModData("Fly", ModData.Category.Movement, Keyboard.KEY_G))); //String name, Category category, int bind, Category cat){ Keyboard.KEY_SUBTRACT
        mods.add(new Aura(new ModData("Aura", ModData.Category.Combat, Keyboard.KEY_R))); //String name, Category category, int bind, Category cat){ Keyboard.KEY_SUBTRACT

    }

    public Mod getModule(String name) {
        for (Mod m : mods) {
            if (m.data.name.equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
}
