package boon4681.ScreenCapt;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class core extends JavaPlugin {
    private run run = null;
    @Override
    public void onEnable() {
        run = new run();
        run.runTaskTimer(this,0,2);
    }
    @Override
    public void onDisable() {
        run.cancel();
    }
}
