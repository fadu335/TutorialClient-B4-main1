package com.example.examplemod.Utils;

import me.leansani.cactusware.Client;
import me.leansani.cactusware.module.CLIENT.SelfDestruction;
import me.leansani.cactusware.module.MISC.Recording;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.Display;

public class MinecraftNameUtil {
    private boolean ready1 = false;
    private boolean ready2 = false;

    @SubscribeEvent
    public void onUpdate(TickEvent.PlayerTickEvent e) {
        if (!Client.Sleep && !SelfDestruction.SelfDestruction && !Recording.Recording) {
            ready1 = true;
        } else {
            ready2 = true;
        }
    }

    @SubscribeEvent
    public void onUpdatee(TickEvent.PlayerTickEvent e) {
        if (ready1 && ready2) {
            ready2 = false;
            Display.setTitle("RockstarLegit 2.0");
        }
        if (ready2 && ready1) {
            ready1 = false;
            Display.setTitle("Minecraft 1.12.2");
        }
    }
}
