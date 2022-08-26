package com.example.examplemod.Module.MOVEMENT;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class DamageSpeed extends Module {
    public DamageSpeed() {
        super("DamageSpeed", Keyboard.KEY_NONE, Category.MOVEMENT);

        ExampleMod.instance.settingsManager.rSetting(new Setting("Speed", this, 1, 0, 10, false));
}

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.hurtTime > 0) {
            mc.player.motionY = 0;
            mc.player.motionZ += ExampleMod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();
            mc.player.motionX -= ExampleMod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();
        }
        }
    }
