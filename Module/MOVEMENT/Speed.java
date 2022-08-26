package com.example.examplemod.Module.MOVEMENT;

import com.example.examplemod.Module.Module;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_NONE, Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.player.isInWater() ? null : mc.player.onGround && mc.player.moveForward > 0F) {
            mc.player.setSprinting(true);
            final float yaw = mc.player.rotationYaw * 0.017453292f;
            final EntityPlayerSP player3 = mc.player;
            player3.motionX -= MathHelper.sin(yaw) * (0.1 / 3.0);
            final EntityPlayerSP player4 = mc.player;
            player4.motionZ += MathHelper.cos(yaw) * (0.1 / 3.0);
        }
    }

    }

