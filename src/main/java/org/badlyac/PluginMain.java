package org.badlyac;
import org.badlyac.Projectiles.LargeFireball;
import org.badlyac.Projectiles.DragonFireball;
import org.badlyac.Projectiles.SmallFireball;
import org.badlyac.Projectiles.WitherSkull;
import org.badlyac.TpCommand.TpCommand;
import org.badlyac.permission.op.OpCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin {

    public static PluginMain instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new LargeFireball(),this);
        Bukkit.getPluginManager().registerEvents(new SmallFireball(),this);
        Bukkit.getPluginManager().registerEvents(new WitherSkull(),this);
        Bukkit.getPluginManager().registerEvents(new DragonFireball(),this);

        this.getCommand("gop").setExecutor(new OpCommand());
        this.getCommand("rop").setExecutor(new OpCommand());
        TpCommand tpCommand = new TpCommand();
        this.getCommand("rtp").setExecutor(tpCommand);
    }
    public static PluginMain getInstance() {
        return instance;
    }
}
