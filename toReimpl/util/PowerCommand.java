package com.legobmw99.allomancy.util;

import com.legobmw99.allomancy.network.packets.AllomancyPowerPacket;
import net.minecraft.command.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerCommand extends CommandBase {

    private final List aliases;
    protected int level;
    protected String[] names = { "Uninvested", "Iron Misting", "Steel Misting", "Tin Misting", "Pewter Misting", "Zinc Misting", "Brass Misting", "Copper Misting", "Bronze Misting", "Mistborn" };

    public PowerCommand() {
        aliases = new ArrayList();
        aliases.add("ap");
    }

    @Override
    public String getName() {
        return "allomancy";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.allomancy.usage";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        World world = sender.getEntityWorld();

        if (world.isRemote) {

        } else {
            if ((args.length == 0 || args.length > 2)) {
                throw new WrongUsageException(this.getUsage(sender), new Object[0]);
            } else {

                level = parseInt(args[0]) - 1;

                PlayerEntity entityplayer = args.length > 1 ? getPlayer(server, sender, args[1]) : getCommandSenderAsPlayer(sender);

                if (level < -1){
                	throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] {level+1,0});
                }
                if(level > 8) {
                	throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] {level+1,9});
                }
                

                if (entityplayer != null) {

                    AllomancyCapability cap = AllomancyCapability.forPlayer(entityplayer);
                    cap.setAllomancyPower(level);

                    Registry.network.sendTo(new AllomancyPowerPacket(level), (ServerPlayerEntity) entityplayer);

                    notifyCommandListener(sender, this, "commands.allomancy.success", new Object[] { entityplayer.getName(), names[(level + 1)]});

                } else {
                    sender.sendMessage(new StringTextComponent("Player not found"));
                }
            }
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender.canUseCommand(2, this.getName());
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return args.length == 2 ? getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.<String>emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 1;
    }

}
