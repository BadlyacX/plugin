package org.badlyac.Projectiles;

import org.badlyac.Projectiles.Lib.Projectiles;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LargeFireball implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE || player.getGameMode() == GameMode.CREATIVE) &&
                (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) &&
                player.getInventory().getItemInMainHand().getType() == Material.GHAST_TEAR) {
            Projectiles.launchLargeFireball(player);
            if (player.getGameMode() != GameMode.CREATIVE) {
                ItemStack ghastTear = player.getInventory().getItemInMainHand();
                if (ghastTear.getAmount() == 1) {
                    player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                } else {
                    ghastTear.setAmount(ghastTear.getAmount() - 1);
                }
            }
            event.setCancelled(true);
        }
    }
}
