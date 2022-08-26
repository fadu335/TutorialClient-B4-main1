package com.example.examplemod.Module.MOVEMENT;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

import java.util.ArrayList;
import java.util.Objects;

public class Spider extends Module {
    public Spider() {
        super("Spider", Keyboard.KEY_NONE, Category.MOVEMENT);

    ArrayList<String> options = new ArrayList<>();

     options.add("Vanila");
        options.add("Jump");

        ExampleMod.instance.settingsManager.rSetting(new Setting("Mode", this, options, "Mode"));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Motion", this, 0.3, 0.1, 2, false));


    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        String mode = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Mode").getValString();
        double motion = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Motion").getValDouble();

        if (Objects.equals(mode, "Vanila")) {
            if (mc.player.collidedHorizontally) {
                mc.player.motionY = motion;
            }
        }         if (Objects.equals(mode, "Jump"))
            if (mc.player.collidedHorizontally && !mc.player.collidedVertically) {
                if (mc.player.moveStrafing == 0 && mc.player.moveForward > 0) {
                    if (mc.player.motionY < -0.225) {
                        mc.player.jump();
                        mc.player.setSprinting(false);
                        mc.player.onGround = true;
                        if (mc.player.motionY > 1) {
                            mc.player.motionY += 1.01;
                        } else {
                            mc.player.motionY /= 1.01;
                        }
                    }
                }


    }
}
}