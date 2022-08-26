package com.example.examplemod.Module.CLIENT;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class ClientColor extends Module {

    public ClientColor() {
        super("ClientColor", Keyboard.KEY_NONE, Category.MOVEMENT);

        ExampleMod.instance.settingsManager.rSetting(new Setting("R", this, 0, 0, 255, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("G", this, 165, 0, 255, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("B", this, 0, 0, 255, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("A", this, 255, 0, 255, true));
    }
}
