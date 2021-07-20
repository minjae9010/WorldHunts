package tk.mjsv.EventHanler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import tk.mjsv.TimerHandler.Timer;
import tk.mjsv.WorldHunter;

public class EventH implements Listener {
    private static final String index = WorldHunter.index;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(index + e.getPlayer().getName() + "님이 WorldHunter에 접속하셨습니다");
//        e.joinMessage(Component.text(index+" "+e.getPlayer().getName()+"님이 WorldHunter에 접속하셨습니다"));
    }

    @EventHandler
    public void onPlayerDrink(PlayerItemConsumeEvent e) {
        if (((PotionMeta) (e.getItem().getItemMeta())).getBasePotionData().getType() == PotionType.WATER) {
            Timer.hm.put(e.getPlayer(), 100);
            e.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
            e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (Timer.set) {
            Timer.hm.put(e.getEntity(), 100);
            e.getEntity().removePotionEffect(PotionEffectType.BLINDNESS);
            e.getEntity().removePotionEffect(PotionEffectType.SLOW);
        }
    }


}
