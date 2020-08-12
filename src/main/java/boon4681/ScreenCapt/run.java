package boon4681.ScreenCapt;

import org.bukkit.scheduler.BukkitRunnable;

public class run extends BukkitRunnable {
    @Override
    public void run() {
        color.run(capt.resize(capt.WOW(),capt.WOW().getWidth()/10,capt.WOW().getHeight()/10),color.set());
    }
}
