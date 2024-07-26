package tfar.xpcraftingtable.recipe;

import net.minecraft.world.entity.player.Player;

public interface XPRecipe {

    int getXP();
    default boolean hasEnough(Player player) {
        return player.totalExperience >= getXP();
    }
}
