package zekrommegaboss.insta.portals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import zekrommegaboss.insta.portals.food.Spaghetti;

public class InstaPortals implements ModInitializer {
	public static final Item TELEPORT_ORB = new Item(new Item.Settings());
	public static final Item SPAGHETTI = new Item(new Item.Settings().food(Spaghetti.SPAGHETTI));

	public static final Block PORTAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block ORITE_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	
	public static final ItemGroup INSTA_PORTALS = FabricItemGroupBuilder.create(
		new Identifier("instaportals", "instaportals"))
		.icon(() -> new ItemStack(TELEPORT_ORB))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(ORITE_ORE_BLOCK));
			stacks.add(new ItemStack(PORTAL_BLOCK));
			stacks.add(new ItemStack(TELEPORT_ORB));
			stacks.add(new ItemStack(SPAGHETTI));
		})
		.build();

	public static ConfiguredFeature<?, ?> ORITE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ORITE_ORE_BLOCK.getDefaultState(), 5))
	.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64))).spreadHorizontally().repeat(10);
	

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("instaportals", "teleport_orb"), TELEPORT_ORB);
		Registry.register(Registry.BLOCK, new Identifier("instaportals", "portal_block"), PORTAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("instaportals", "portal_block"), new BlockItem(PORTAL_BLOCK, new Item.Settings()));
		Registry.register(Registry.BLOCK, new Identifier("instaportals", "orite_ore_block"), ORITE_ORE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("instaportals", "orite_ore_block"), new BlockItem(ORITE_ORE_BLOCK, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier("instaportals", "spaghetti"), SPAGHETTI);
		RegistryKey<ConfiguredFeature<?, ?>> oriteOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("instaportals", "orite_ore_block"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oriteOreOverworld.getValue(), ORITE_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oriteOreOverworld);
	}
}
