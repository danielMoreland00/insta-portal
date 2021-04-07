package zekrommegaboss.insta.portals.food;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Spaghetti extends Item {
	public static final FoodComponent SPAGHETTI = (new FoodComponent.Builder()).hunger(10).saturationModifier(1.2f).build();
	
	public Spaghetti(Settings settings) {
		super(settings);
	}
}
