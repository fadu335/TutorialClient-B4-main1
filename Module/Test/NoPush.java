package com.example.examplemod.Module.Test;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import com.example.examplemod.other.font.asm.Events.EntityCollisionEvent;
import com.example.examplemod.other.font.asm.Events.PushOutOfBlocksEvent;
import com.example.examplemod.other.font.asm.Events.WaterCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class NoPush extends Module {
    public NoPush() {
        super("NoPush", Keyboard.KEY_NONE, Category.PLAYER);

        ExampleMod.instance.settingsManager.rSetting(new Setting("Entities", this, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Liquids", this, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Blocks", this, true));
    }

    @SubscribeEvent
    public void onEntityCollision(EntityCollisionEvent e) {
        boolean entities = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Entities").getValBoolean();

        if (entities) {
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onWaterCollision(WaterCollisionEvent e) {
        boolean liquids = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Liquids").getValBoolean();

        if (liquids) {
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPushOutOfBlocks(PushOutOfBlocksEvent e) {
        boolean blocks = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Blocks").getValBoolean();

        if (blocks) {
            e.setCanceled(true);
        }
    }
}
