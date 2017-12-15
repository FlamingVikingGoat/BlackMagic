package com.fvg.blackmagic.entitites;

import com.fvg.blackmagic.items.ModItems;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityDemon extends EntityCreature {

    public EntityDemon(World worldIn) {
        super(worldIn);

        setupAiTasks();

        this.setSize(0.6f, 2.9f);
    }



    @Override
    /**
     * if the entity got a PathEntity it returns true, else false
     */
    public boolean hasPath() {
        /*For now, this will return false. However, eventually demons will need to be trapped.

        return !this.navigator.noPath();
        */

        return false;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        //TODO: Have values change based on summon spell
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);


        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(666666.666D);

    }

    protected void setupAiTasks(){
        clearAiTasks();
        this.tasks.addTask(0, new EntityAIWander(this, 1.0F));

    }

    protected void clearAiTasks(){
        tasks.taskEntries.clear();
        targetTasks.taskEntries.clear();
    }



    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }


    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.deathbringer;
    }

    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        super.dropFewItems(p_70628_1_, p_70628_2_);
        this.dropItem(ModItems.deathbringer, rand.nextInt(3) * p_70628_2_);
    }

    @Override
    protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEnchantmentBasedOnDifficulty(difficulty);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return livingdata;
    }

    @Override
    public float getEyeHeight() {
        return 2.6F;
    }
}

