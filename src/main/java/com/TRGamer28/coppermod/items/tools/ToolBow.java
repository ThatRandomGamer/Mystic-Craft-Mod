package com.TRGamer28.coppermod.items.tools;
 
import com.TRGamer28.coppermod.init.ModItems;
import com.TRGamer28.coppermod.util.IHasModel;
import com.TRGamer28.mysticcraft.Main;
 
import javax.annotation.Nullable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class ToolBow extends Item implements IHasModel
{
    public ToolBow(String name)
    {
        this.maxStackSize = 1;
        this.setMaxDamage(1024);
        this.setCreativeTab(CreativeTabs.COMBAT);
        setUnlocalizedName(name);
        setRegistryName(name);
       
 
        ModItems.ITEMS.add(this);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
       
        {
       
            @SideOnly(Side.CLIENT)
            public float apply1(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != ModItems.COPPERBOW ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
 
            @Override
            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                // TODO Auto-generated method stub
                return 0;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }
   
    @Override
   
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
 
       
    }
   
    private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
 
                if (this.isArrow(itemstack))
                {
                    return itemstack;
                }
            }
 
            return ItemStack.EMPTY;
        }
    }
 
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() instanceof ItemArrow;
    }
 
    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(entityplayer);
 
            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;
 
            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(Items.ARROW);
                }
 
                float f = getArrowVelocity(i);
 
                if ((double)f >= 0.1D)
                {
                    boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));
 
                    if (!worldIn.isRemote)
                    {
                        ItemArrow itemarrow = (ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW);
                        EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
 
                        if (f == 1.0F)
                        {
                            entityarrow.setIsCritical(true);
                        }
 
                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
 
                        if (j > 0)
                        {
                            entityarrow.setDamage(entityarrow.getDamage() + (double)j * 1.5D + 1.5D);
                        }
 
                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
 
                        if (k > 0)
                        {
                            entityarrow.setKnockbackStrength(k);
                        }
 
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
                        {
                            entityarrow.setFire(200);
                        }
 
                        stack.damageItem(1, entityplayer);
 
                        if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
                        {
                            entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        }
 
                        worldIn.spawnEntity(entityarrow);
                    }
 
                    worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
 
                    if (!flag1 && !entityplayer.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
 
                        if (itemstack.isEmpty())
                        {
                            entityplayer.inventory.deleteStack(itemstack);
                        }
                    }
 
                    entityplayer.addStat(StatList.getObjectUseStats(this));
                }
            }
        }
    }
 
    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 23.0F;
        f = (f * f + f * 5.0F) / 6.0F;
 
        if (f > 3.0F)
        {
            f = 3.0F;
        }
 
        return f;
    }
 
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
 
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
 
    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn).isEmpty();
 
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;
 
        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return flag ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL, itemstack);
        }
        else
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
    }
 
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
 
   
}