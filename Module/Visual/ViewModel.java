package com.example.examplemod.Module.Visual;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Module.Module;
import com.example.examplemod.other.font.asm.Events.RenderHeldItemEvent;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import yea.bushroot.clickgui.Setting;

import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;

public class ViewModel extends Module {

    public ViewModel() {
        super("ViewModel", Keyboard.KEY_NONE, Category.RENDER);

        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftX", this, 0.0, -2.5, 2.5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftY", this, 0.0, -2.5, 2.5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftZ", this, 0.0, -2.5, 2.5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftYaw", this, 0.0, -200, 200, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftPitch", this, 0.0, -200, 200, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftRoll", this, 0.0, -200, 200, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("LeftScale", this, 1, 0, 2, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightX", this, -0.0, -2.5, 2.5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightY", this, -0.0, -2.5, 2.5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightZ", this, -0.0, -2.5, 2.5, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightYaw", this, 0.0, -200, 200, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightPitch", this, 0.0, -200, 200, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightRoll", this, 0.0, -200, 200, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("RightScale", this, 1, 0, 2, false));
    }
    @SubscribeEvent
    public void onRenderItemPre(RenderHeldItemEvent.Pre event) {
        double leftx = ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftX").getValDouble();
        double lefty = ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftY").getValDouble();
        double leftz = ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftZ").getValDouble();
        float leftscale = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftScale").getValDouble();
        double rightx = ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightX").getValDouble();
        double righty = ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightY").getValDouble();
        double rightz = ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightZ").getValDouble();
        float rightscale = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightScale").getValDouble();

        switch (event.getSide()) {
            case LEFT:
                GlStateManager.translate(leftx, lefty, leftz);
                GlStateManager.scale(leftscale, leftscale, leftscale);
                break;
            case RIGHT:
                GlStateManager.translate(rightx, righty, rightz);
                GlStateManager.scale(rightscale, rightscale, rightscale);
                break;
        }
    }

    @SubscribeEvent
    public void onRenderItemPost(RenderHeldItemEvent.Post event) {
        float leftyaw = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftYaw").getValDouble();
        float leftpitch = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftPitch").getValDouble();
        float leftroll = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "LeftRoll").getValDouble();
        float rightyaw = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightYaw").getValDouble();
        float rightpitch = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightPitch").getValDouble();
        float rightroll = (float) ExampleMod.instance.settingsManager.getSettingByName(this.name, "RightRoll").getValDouble();

        switch (event.getSide()) {
            case LEFT:
                GlStateManager.rotate(leftyaw, 0, 1, 0);
                GlStateManager.rotate(leftpitch, 1, 0, 0);
                GlStateManager.rotate(leftroll, 0, 0, 1);
                break;

            case RIGHT:
                GlStateManager.rotate(rightyaw, 0, 1, 0);
                GlStateManager.rotate(rightpitch, 1, 0, 0);
                GlStateManager.rotate(rightroll, 0, 0, 1);
                break;
        }
    }
    }


















