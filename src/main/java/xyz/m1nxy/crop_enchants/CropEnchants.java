package xyz.m1nxy.crop_enchants;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.m1nxy.crop_enchants.enchantment.DelicateEnchantment;
import xyz.m1nxy.crop_enchants.enchantment.FeatherFootEnchantment;
import xyz.m1nxy.crop_enchants.enchantment.LumberjackEnchantment;
import xyz.m1nxy.crop_enchants.enchantment.ReplenishEnchantment;

import static net.minecraft.enchantment.Enchantment.Rarity.VERY_RARE;
import static net.minecraft.entity.EquipmentSlot.*;
import static net.minecraft.registry.Registries.ENCHANTMENT;

public class CropEnchants implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("crop_enchants");

    public static final Enchantment DELICATE;
    public static final Enchantment REPLENISH;
    public static final Enchantment LUMBERJACK;
    public static final Enchantment FEATHERFOOT;

    static {
        DELICATE = new DelicateEnchantment(VERY_RARE, MAINHAND, OFFHAND);
        REPLENISH = new ReplenishEnchantment(VERY_RARE, MAINHAND, OFFHAND);
        LUMBERJACK = new LumberjackEnchantment(VERY_RARE, MAINHAND, OFFHAND);
        FEATHERFOOT = new FeatherFootEnchantment(VERY_RARE, FEET);
    }

    @Override
    public void onInitialize() {
        Registry.register(ENCHANTMENT, new Identifier("crop_enchants", "delicate"), DELICATE);
        Registry.register(ENCHANTMENT, new Identifier("crop_enchants", "replenish"), REPLENISH);
        Registry.register(ENCHANTMENT, new Identifier("crop_enchants", "lumberjack"), LUMBERJACK);
        Registry.register(ENCHANTMENT, new Identifier("crop_enchants", "feather_foot"), FEATHERFOOT);
        LOGGER.info("Registered Commands");
    }
}
