package com.example.examplemod.Module.COMBAT;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import com.example.examplemod.Utils.FriendsUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import yea.bushroot.clickgui.Setting;

public class HitBox extends Module {
    public HitBox() {
        super("HitBox", Keyboard.KEY_NONE, Category.COMBAT);
        ExampleMod.instance.settingsManager.rSetting(new Setting("Size", this, 0.4, 0.3, 4, false));
    }
    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if (this.toggled) {
            float size = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "Size").getValDouble();

            for (EntityPlayer player : mc.world.playerEntities) {
                if (player != null && player != mc.player) {
                    if (!FriendsUtil.isFriend(player)) {
                        player.setEntityBoundingBox(new AxisAlignedBB(
                                player.posX - size,
                                player.getEntityBoundingBox().minY,
                                player.posZ - size,
                                player.posX + size,
                                player.getEntityBoundingBox().maxY,
                                player.posZ + size
                        ));
                    } else {
                        player.setEntityBoundingBox(new AxisAlignedBB(
                                player.posX - 0,
                                player.getEntityBoundingBox().minY,
                                player.posZ - 0,
                                player.posX + 0,
                                player.getEntityBoundingBox().maxY,
                                player.posZ + 0
                        ));
                    }
                }
            }
        } else {
            for (EntityPlayer player : mc.world.playerEntities) {
                if (player != null && player != mc.player) {
                    if (!FriendsUtil.isFriend(player)) {
                        player.setEntityBoundingBox(new AxisAlignedBB(
                                player.posX - 0.3F,
                                player.getEntityBoundingBox().minY,
                                player.posZ - 0.3F,
                                player.posX + 0.3F,
                                player.getEntityBoundingBox().maxY,
                                player.posZ + 0.3F
                        ));
                    }
                }
            }
        }
    }
}
