package com.example.examplemod.Module.CLIENT;

import com.example.examplemod.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Jump extends Module {

    public Jump() {
        super("Jump", Keyboard.KEY_NONE, Category.CLIENT);
    }

    @SubscribeEvent
    public void TickEvent(TickEvent.PlayerTickEvent e) {
        if (!mc.isGamePaused()) {
            if (mc.player.onGround && Keyboard.isKeyDown(mc.gameSettings.keyBindJump.getKeyCode()))

                mc.player.jump();
        }
    }
}
