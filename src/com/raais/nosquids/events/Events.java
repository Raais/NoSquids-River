package com.raais.nosquids.events;

import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Squid;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Events implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
            if (!event.isCancelled()) {
                Entity entity = event.getEntity();

                if (entity instanceof Squid) {

                    Biome biome = event.getLocation().getBlock().getBiome();

                    if (biome == Biome.RIVER) {

                        CreatureSpawnEvent.SpawnReason reason = event.getSpawnReason();

                        if (reason == CreatureSpawnEvent.SpawnReason.NATURAL) {
                            event.setCancelled(true);
                        }

                    }

                }
            }
    }


}
