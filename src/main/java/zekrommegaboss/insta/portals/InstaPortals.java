package zekrommegaboss.insta.portals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InstaPortals implements ModInitializer {

	public static final Item TELEPORT_ORB = new Item(new Item.Settings().group(ItemGroup.MISC));

	public static final Block PORTAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1.5F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block ORITE_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	
	public static final Item SPAGHETTI = new Item(new Item.Settings().group(ItemGroup.FOOD).food(Spaghetti.SPAGHETTI));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("instaportals", "teleport_orb"), TELEPORT_ORB);
		Registry.register(Registry.BLOCK, new Identifier("instaportals", "portal_block"), PORTAL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("instaportals", "portal_block"), new BlockItem(PORTAL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("instaportals", "orite_ore_block"), ORITE_ORE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("instaportals", "orite_ore_block"), new BlockItem(ORITE_ORE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("instaportals", "spaghetti"), SPAGHETTI);
	}
}
