package org.badlyac.Projectiles.Lib;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class Projectiles {
    public static void launchLargeFireball(Player player) {
        Location loc = player.getLocation();
        Vector dir = loc.getDirection().normalize();
        org.bukkit.entity.Fireball fireball = player.getWorld().spawn(loc.add(0, 1.6, 0), org.bukkit.entity.LargeFireball.class);
        fireball.setVelocity(dir.multiply(1));
        fireball.setShooter(player);
        fireball.setIsIncendiary(false);
        fireball.setYield(3);
    }
    public static void launchSmallFireball(Player player) {
        Location loc = player.getLocation();
        Vector dir = loc.getDirection().normalize();
        org.bukkit.entity.SmallFireball fireball = player.getWorld().spawn(loc.add(0, 1.6, 0), org.bukkit.entity.SmallFireball.class);
        fireball.setVelocity(dir.multiply(1));
        fireball.setShooter(player);
        fireball.setIsIncendiary(false);
        fireball.setYield(1);
    }
    public static void launchWitherSkull(Player player) {
        Location loc = player.getLocation();
        Vector dir = loc.getDirection().normalize();
        org.bukkit.entity.WitherSkull fireball = player.getWorld().spawn(loc.add(0, 1.6, 0), org.bukkit.entity.WitherSkull.class);
        fireball.setVelocity(dir.multiply(1));
        fireball.setShooter(player);
        fireball.setIsIncendiary(false);
        fireball.setYield(3);
    }
    public static void launchDragonFireball(Player player) {
        Location loc = player.getLocation();
        Vector dir = loc.getDirection().normalize();
        org.bukkit.entity.DragonFireball fireball = player.getWorld().spawn(loc.add(0, 1.6, 0), org.bukkit.entity.DragonFireball.class);
        fireball.setVelocity(dir.multiply(1));
        fireball.setShooter(player);
        fireball.setIsIncendiary(false);
        fireball.setYield(1);
    }
}
