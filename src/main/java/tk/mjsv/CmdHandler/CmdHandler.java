package tk.mjsv.CmdHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk.mjsv.WorldHunter;

import java.util.List;

public class CmdHandler implements TabExecutor {
    private static String index = WorldHunter.index;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        switch(label){
            case "팀":
                TeamHandler.Command(sender,args);
                break;
            case "타이머":

        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        switch(alias){
            case "팀":
                TeamHandler.TabExcutor(sender,args);
                break;
            case "타이머":
                break;
        }
        return null;
    }
}