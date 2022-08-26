package com.example.examplemod.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

import javax.annotation.Nonnull;

public class SoundUtil {
    public Minecraft mc = Minecraft.getMinecraft();

    public static void playSound(String in) {
        Minecraft.getMinecraft().getSoundHandler().playSound(new ISound() {

            @Nonnull
            @Override
            public ResourceLocation getSoundLocation() {return new ResourceLocation("sounds/" + in + ".ogg");}

            @Nonnull
            @Override
            public SoundEventAccessor createAccessor(SoundHandler handler) {return new SoundEventAccessor(new ResourceLocation("sounds/" + in + ".ogg"), in);}

            @Nonnull
            @Override
            public Sound getSound() {
                return new Sound(in, 1, 1, 1, Sound.Type.SOUND_EVENT, false);
            }

            @Nonnull
            @Override
            public SoundCategory getCategory() {
                return SoundCategory.PLAYERS;
            }

            @Override
            public boolean canRepeat() {
                return false;
            }

            @Override
            public int getRepeatDelay() {
                return 0;
            }

            @Override
            public float getVolume() {
                return 1;
            }

            @Override
            public float getPitch() {
                return 1;
            }

            @Override
            public float getXPosF() {return Minecraft.getMinecraft().player != null ? (float) Minecraft.getMinecraft().player.posX : 0;}

            @Override
            public float getYPosF() {return Minecraft.getMinecraft().player != null ? (float) Minecraft.getMinecraft().player.posY: 0;}

            @Override
            public float getZPosF() {return Minecraft.getMinecraft().player != null ? (float) Minecraft.getMinecraft().player.posZ : 0;}

            @Nonnull
            @Override
            public AttenuationType getAttenuationType() {
                return AttenuationType.LINEAR;
            }
        });
    }
}
