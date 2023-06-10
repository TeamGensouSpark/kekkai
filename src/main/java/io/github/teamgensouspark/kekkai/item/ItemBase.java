package io.github.teamgensouspark.kekkai.item;

import io.github.teamgensouspark.kekkai.Kekkai;
import io.github.teamgensouspark.kekkai.interfaces.IHasModel;
import io.github.teamgensouspark.kekkai.register.RegisterInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name,CreativeTabs tab){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(tab);

        RegisterInit.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        Kekkai.proxy.registerItemRenderer(this, 0, "inventory");
    }

}