package com.example.examplemod;

import com.example.examplemod.Module.CLIENT.*;
import com.example.examplemod.Module.COMBAT.*;
import com.example.examplemod.Module.EXPLOIT.*;
import com.example.examplemod.Module.MOVEMENT.*;
import com.example.examplemod.Module.Module;
import com.example.examplemod.Module.PLAYER.*;
import com.example.examplemod.Module.Visual.*;
import font.FontUtils;
import org.lwjgl.opengl.Display;
import yea.bushroot.clickgui.ClickGuiManager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static String name = "TutorialClient B2 | User: null | Build: 0.0.5 | UID: 1337 " ;
    public static String cName = "Tutorial§Client §fB§a3";
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();

    public static ClickGuiManager clickGuiManager;

    public static void startup() {
        Display.setTitle(name);


        //Client
        modules.add(new ClickGUI());
        modules.add(new AntiInviz());
        modules.add(new Panic());
        modules.add(new Jump());
        modules.add(new NotificationsTest());


        //COMBAT
        modules.add(new AntiBot());
        modules.add(new HitBox());
        modules.add(new AimBot());
        modules.add(new FastBow());
        modules.add(new KillAura());
        modules.add(new TriggerBot());
        modules.add(new Velocity());

        //EXPLOIT
        modules.add(new AntiLevitation());
        modules.add(new AutoRespawn());
        modules.add(new FakeCreative());
        modules.add(new HackerDetector());
        modules.add(new LongJump());
        modules.add(new Strength());
        modules.add(new SpeedMine());


        //MOVEMENT
        modules.add(new AirJump());
        modules.add(new BHOP());
        modules.add(new BoatFly());
        modules.add(new DamageSpeed());
        modules.add(new DamageFly());
        modules.add(new FastFall());
        modules.add(new Fly());
        modules.add(new Glide());
        modules.add(new HightJump());
        modules.add(new InvWalk());
        modules.add(new Jesus());
        modules.add(new NoClip());
        modules.add(new Speed());
        modules.add(new Spider());
        modules.add(new Sprint());
        modules.add(new WaterLeave());


        //PLAYER
        modules.add(new AntiAfk());
        modules.add(new BedrockClip());
        modules.add(new BlockReach());
        modules.add(new FakePlayer());
        modules.add(new ItemsESP());
        modules.add(new NameTags());
        modules.add(new MiddleClickPearl());
        modules.add(new VClip());


        //Visual
        modules.add(new AttackTrace());
        modules.add(new DamageParticls());
        modules.add(new SwingAnimation());
        modules.add(new FullBright());
        modules.add(new ViewModel());
        modules.add(new TargetHUD());
        modules.add(new ChestESP());
        modules.add(new GlowESP());
        modules.add(new Tracers());
        modules.add(new BoxESP());
        modules.add(new PlayerEntity());
        modules.add(new SpawnerESP());


        clickGuiManager = new ClickGuiManager();

        FontUtils.bootstrap();
    }

    public static ArrayList<Module> getModulesInCategory(Module.Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : modules) {
            if (m.getCategory().name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }
}
