package zekrommegaboss.insta.portals;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class OriteOreBlock extends Block{

	public OriteOreBlock(Settings settings) {
		super(settings);
		//TODO Auto-generated constructor stub
	}
	
	protected int getExperienceWhenMined(Random random) {
		return MathHelper.nextInt(random, 2, 5);
	}

	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);
			if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
				int size = this.getExperienceWhenMined(world.random);
				this.dropExperience(world, pos, size);
			}
	}
}
