package com.example.examplemod.Module.Visual;

import com.example.examplemod.Module.Module;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class DamageParticls extends Module {


    public DamageParticls() {
        super("DamageParticles", Keyboard.KEY_NONE, Category.RENDER);
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent e) {
        for (int i = 12; i >= 0; i = i - 1) {
            mc.player.onCriticalHit(e.getTarget());
        }
    }
}


