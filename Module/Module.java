package com.example.examplemod.Module;

import com.example.OptionMode;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    public String name;
    public boolean toggled;
    public int keyCode;

    public Category category;
    public static Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, int key, Category c) {
        this.name = name;
        this.keyCode = key;
        this.category = c;
    }

    public boolean isEnabled() {
        return toggled;
    }

    private void addSettings(double xPos, double zPos, double yPos) {
    }

    protected void addSettings(OptionMode mode) {
    }

    public int getKey() {
        return keyCode;
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void setKey(int key) {
        this.keyCode = key;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return this.name;
    }

    protected float[] getRainbow() {
        return new float[0];
    }

    public enum Category {
        COMBAT,
        Test,
        MOVEMENT,
        PLAYER,
        RENDER,
        CLIENT,
        EXPLOIT;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }
}
