package com.legobmw99.allomancy.util.proxy;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

public class ServerProxy extends CommonProxy {

    @Override
    public void clientInit(FMLClientSetupEvent e) {
        // no-op
    }

    @Override
    public void init(FMLCommonSetupEvent e) {
        super.init(e);
    }

    @Override
    public void serverInit(FMLServerStartingEvent e) {
        e.getCommandDispatcher();//e.registerServerCommand(new PowerCommand());
    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only run this on the client!");
    }

    @Override
    public PlayerEntity getClientPlayer() {
        throw new IllegalStateException("Only run this on the client!");
    }

}