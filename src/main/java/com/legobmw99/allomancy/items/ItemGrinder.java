package common.legobmw99.allomancy.items;

import net.minecraft.item.Item;

import common.legobmw99.allomancy.common.Registry;

public class ItemGrinder extends Item {

	public ItemGrinder() {
		super();
		this.setCreativeTab(Registry.tabsAllomancy);
		this.setMaxDamage(31);
		this.maxStackSize = 1;
		this.setUnlocalizedName("handgrinder");
	}

}