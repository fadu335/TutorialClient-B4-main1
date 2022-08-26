package com.example.examplemod.Module.Visual;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class CustomFOV extends Module {

    public CustomFOV() {
        super("CustomFOV", Keyboard.KEY_NONE, Category.RENDER);

        ExampleMod.instance.settingsManager.rSetting(new Setting("FOV", this, 140, 5, 170, true));
}

    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent e) {
        float fov = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "FOV").getValDouble();

        mc.gameSettings.fovSetting = fov;
}
}
