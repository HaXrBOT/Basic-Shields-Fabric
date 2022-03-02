package com.github.crimsondawn45.basicshields.module;

import com.github.crimsondawn45.basicshields.initializers.BasicShields;
import com.github.crimsondawn45.basicshields.object.BasicShieldItem;
import com.github.crimsondawn45.basicshields.util.ContentModule;
import com.github.crimsondawn45.basicshields.util.ModItem;
import com.github.crimsondawn45.basicshields.util.RecipeHelper;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag.Identified;
import net.minecraft.util.Identifier;

public class CitrineModule extends ContentModule {

    //Bronze Stuff
    public ModItem citrine_shield;
    public JsonObject citrine_shield_recipe;

    //Tag
    public Identified<Item> citrine_tag;

    public CitrineModule(boolean alwaysLoad, String...ids) {
        super(alwaysLoad, ids);
    }

    @Override
    public void registerContent() {

        //Tag
        citrine_tag = TagFactory.ITEM.create(new Identifier("c","citrines"));

        //Item
        citrine_shield = new ModItem("citrine_shield",
        new BasicShieldItem(new FabricItemSettings().maxDamage(BasicShields.CONFIG.citrine_shield_durability).group(BasicShields.SHIELDS),
        BasicShields.CONFIG.citrine_shield_cooldown,
        BasicShields.CONFIG.citrine_shield_enchantability,
        citrine_tag));

        //Recipe
        citrine_shield_recipe = RecipeHelper.createShieldRecipe(citrine_tag.getId(), true, citrine_shield.getIdentifier());
    }
    
}