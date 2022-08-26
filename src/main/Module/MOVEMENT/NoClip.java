package com.example.examplemod.Module.MOVEMENT;

import com.example.EventTarget;
import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class NoClip extends Module {

    public NoClip() {
        super("NoClip", Keyboard.KEY_NONE, Category.MOVEMENT);
    }




    @EventTarget
    public void onFullCube(TickEvent.PlayerTickEvent event ) {
        if (mc.world != null) {
            event.setCanceled(true);
          }

      }
    @EventTarget
    public void onPush(TickEvent.PlayerTickEvent event ) {
        event.setCanceled(true);

    }

    @EventTarget
    public void onLivingUpdate(TickEvent.PlayerTickEvent event) {
        if (mc.player != null) {
            mc.player.noClip = true;
            mc.player.motionY = 0;
            mc.player.onGround = false;
            mc.player.capabilities.isFlying = false;
            if (mc.gameSettings.keyBindJump.isKeyDown()) {
                mc.player.motionY += 0.5;

            }

            if (mc.gameSettings.keyBindSneak.isKeyDown()) {
                mc.player.motionY -= 0.5;
        }
            event.setCanceled(true);

    }


    }

}


