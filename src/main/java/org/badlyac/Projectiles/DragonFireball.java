package org.badlyac.Projectiles;


import org.badlyac.Projectiles.Lib.Projectiles;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class DragonFireball implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if ((player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) &&
                (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) &&
                player.getInventory().getItemInMainHand().getType() == Material.DRAGON_EGG) {
            Projectiles.launchDragonFireball(player);
            event.setCancelled(true);


        } else if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) &&
                player.getInventory().getItemInMainHand().getType() == Material.DRAGON_EGG && player.getGameMode() == GameMode.CREATIVE) {
            Projectiles.launchDragonFireball(player);
            event.setCancelled(true);
        }
    }
}
