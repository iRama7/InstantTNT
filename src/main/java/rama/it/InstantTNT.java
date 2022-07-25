package rama.it;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class InstantTNT extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent e){
        if(e.getBlockPlaced().getType().equals(Material.TNT)){
            e.getBlockPlaced().setType(Material.AIR);
            Location loc = e.getBlockPlaced().getLocation();
            Bukkit.getWorld(loc.getWorld().getName()).spawnEntity(loc, EntityType.PRIMED_TNT);
        }
    }

}
