package com.raais.nosquids.events;

import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Squid;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDropItemEvent;

public class Events implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
            if (!event.isCancelled()) {
                Entity entity = event.getEntity();

                if (entity instanceof Squid) {

                    Biome biome = event.getLocation().getBlock().getBiome();

                    if (!(biome == Biome.OCEAN)) {

                        CreatureSpawnEvent.SpawnReason reason = event.getSpawnReason();


                        if (reason == CreatureSpawnEvent.SpawnReason.NATURAL) {
                            event.setCancelled(true);
                            entity.remove();
                        }

                    }

                }
            }
    }

    @EventHandler
    public void onDrop(EntityDropItemEvent event) {
        if (!event.isCancelled()) {
            Entity entity = event.getEntity();

            if (entity instanceof Squid) {

                Item item = event.getItemDrop();

                Biome biome = item.getLocation().getBlock().getBiome();

                if (!(biome == Biome.OCEAN)) {
                    event.setCancelled(true);
                    item.remove();
                }
            }
        }
    }


}
