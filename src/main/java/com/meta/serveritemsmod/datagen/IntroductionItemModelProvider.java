package com.meta.serveritemsmod.datagen;

import com.meta.serveritemsmod.ServerItemsMod;
import com.meta.serveritemsmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class IntroductionItemModelProvider extends ItemModelProvider {
    public IntroductionItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, ServerItemsMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.NOMALHELPTICKET.get());
        basicItem(ModItems.SUPERHELPTICKET.get());
        basicItem(ModItems.NOMALGATETICKET.get());
        basicItem(ModItems.RAERGATETICKET.get());
        basicItem(ModItems.SUPERRAERGATETICKET.get());
        basicItem(ModItems.ULTRARAERGATETICKET.get());

    }
}
