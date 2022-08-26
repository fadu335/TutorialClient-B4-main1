package com.example.examplemod.Module.CLIENT;

import com.example.examplemod.Module.Module;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class AntiInviz extends Module {

    public AntiInviz() {
        super("AntiInviz", Keyboard.KEY_NONE, Category.CLIENT);
    }


    static SoundEvent ENTITY_BLAZE_SHOOT;

    @SubscribeEvent
    public void onRender(RenderLivingEvent.Specials.Pre e) {
        mc.player.playSound(ENTITY_BLAZE_SHOOT , 5F, 5F);
    }
}
