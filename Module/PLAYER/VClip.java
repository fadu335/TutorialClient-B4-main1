package com.example.examplemod.Module.PLAYER;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class VClip extends Module {

    double x,z,y;

    public VClip() {
        super("VClip", Keyboard.KEY_NONE, Category.PLAYER);
        ExampleMod.instance.settingsManager.rSetting(new Setting("yUp", this, 0.05, 3.0, 200.0, false ));
    }

    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        double yUp = ExampleMod.instance.settingsManager.getSettingByName(this.name, "yUp").getValDouble();
       x = mc.player.posX;
       y = mc.player.posY;
       z = mc.player.posZ;
       mc.player.setPosition(x + 0 , y + yUp , z + 0);
       toggle();
    }

}
