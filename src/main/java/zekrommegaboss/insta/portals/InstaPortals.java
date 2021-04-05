package zekrommegaboss.insta.portals;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InstaPortals implements ModInitializer {

	public static final Item TELEPORT_ORB = new Item(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("instaportals", "teleport_orb"), TELEPORT_ORB);
	}
}
