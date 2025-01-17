package com.legobmw99.allomancy.items;

import com.legobmw99.allomancy.Allomancy;
import com.legobmw99.allomancy.util.Registry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GrinderItem extends Item {

    public GrinderItem() {
        super(new Item.Properties().group(Registry.allomancy_group).maxStackSize(1));
        setRegistryName(new ResourceLocation(Allomancy.MODID, "allomantic_grinder"));
    }

    @Override
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack.copy();
    }
}
