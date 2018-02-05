package com.flamingvikinggoat.blackmagic.entitites;

import com.flamingvikinggoat.blackmagic.core.BlackMagic;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

    public static void registerEntities(){
        registerEntity(EntityDemon.class, "demon", 64, 20, true);
    }

    public static void generateSpawnEgg(){
        EntityRegistry.registerEgg(EntityDemon.class, 0, 255);
    }


    private static int entityID = 0;

    private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(entityClass, entityName, entityID++, BlackMagic.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

}
