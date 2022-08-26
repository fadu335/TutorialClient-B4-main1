package com.example.examplemod.Module.MOVEMENT;

import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class BedrockClip extends Module {
    public  BedrockClip() {
        super("BedrockClip", Keyboard.KEY_NONE, Category.MOVEMENT);


    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.onGround) {
            if (mc.player.hurtTime == 10) {
                mc.player.posY = 3;
            }
        }

    }
}


