package boon4681.ScreenCapt;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class color {
    private static double colorDistance(Color c1, Color c2)
    {
        int red1 = c1.getRed();
        int red2 = c2.getRed();
        int rmean = (red1 + red2) >> 1;
        int r = red1 - red2;
        int g = c1.getGreen() - c2.getGreen();
        int b = c1.getBlue() - c2.getBlue();
        return Math.sqrt((((512+rmean)*r*r)>>8) + 4*g*g + (((767-rmean)*b*b)>>8));
    }
    public static BHashMap<Material,Color> set() {
        BHashMap<Material,Color> temp = new BHashMap<Material,Color>();
        temp.add(Material.WHITE_CONCRETE,new Color(200,200,200));
        temp.add(Material.RED_CONCRETE,new Color(143,33,33));
        temp.add(Material.YELLOW_CONCRETE,new Color(240,170,21));
        temp.add(Material.BLUE_CONCRETE,new Color(45,45,144));
        temp.add(Material.BROWN_CONCRETE,new Color(95,60,31));
        temp.add(Material.CYAN_CONCRETE,new Color(20,120,140));
        temp.add(Material.GRAY_CONCRETE,new Color(55,58,62));
        temp.add(Material.GREEN_CONCRETE,new Color(73,91,36));
        temp.add(Material.LIGHT_BLUE_CONCRETE,new Color(37,138,200));
        temp.add(Material.LIGHT_GRAY_CONCRETE,new Color(126,126,116));
        temp.add(Material.LIME_CONCRETE,new Color(93,168,24));
        temp.add(Material.MAGENTA_CONCRETE,new Color(169,48,159));
        temp.add(Material.ORANGE_CONCRETE,new Color(225,99,2));
        temp.add(Material.PINK_CONCRETE,new Color(212,100,141));
        temp.add(Material.PURPLE_CONCRETE,new Color(101,32,157));
        temp.add(Material.BLACK_CONCRETE,new Color(10,8,15));

        temp.add(Material.WHITE_WOOL,new Color(250,250,250));
        temp.add(Material.RED_WOOL,new Color(172,43,36));
        temp.add(Material.YELLOW_WOOL,new Color(253,211,52));
        temp.add(Material.BLUE_WOOL,new Color(58,64,166));
        temp.add(Material.BROWN_WOOL,new Color(126,80,47));
        temp.add(Material.CYAN_WOOL,new Color(22,150,152));
        temp.add(Material.GRAY_WOOL,new Color(68,75,78));
        temp.add(Material.GREEN_WOOL,new Color(91,120,22));
        temp.add(Material.LIGHT_BLUE_WOOL,new Color(72,193,228));
        temp.add(Material.LIGHT_GRAY_WOOL,new Color(153,153,153));
        temp.add(Material.LIME_WOOL,new Color(123,195,27));
        temp.add(Material.MAGENTA_WOOL,new Color(200,80,190));
        temp.add(Material.ORANGE_WOOL,new Color(250,130,30));
        temp.add(Material.PINK_WOOL,new Color(245,165,190));
        temp.add(Material.PURPLE_WOOL,new Color(133,47,180));
        temp.add(Material.BLACK_WOOL,new Color(28,28,32));

        temp.add(Material.STONE,new Color(143,143,143));
        temp.add(Material.JUNGLE_PLANKS,new Color(191,142,107));
        temp.add(Material.DIRT,new Color(150,100,70));
        temp.add(Material.BIRCH_PLANKS,new Color(215,200,141));
        temp.add(Material.END_STONE,new Color(246,250,189));
        temp.add(Material.PACKED_ICE,new Color(146,185,255));
        temp.add(Material.SNOW_BLOCK,new Color(255,255,255));
        return temp;
    }
    private static Material find(BHashMap<Material,Color> temp,Color in){
        double min = 100000000;
        Material save = null;
        for (Material material : temp.getKeySet()){
            double calc = colorDistance(temp.get(material),in);
            if(calc<min){
                min = calc;
                save = material;
            }
        }
        return save;
    }
    public static void run(BufferedImage in,BHashMap<Material,Color> temp){
        World world = Bukkit.getWorlds().get(0);
        for(int y=0;y<in.getHeight();y++){
            for (int x=0;x<in.getWidth();x++){
                Material save = find(temp,new Color(in.getRGB(x,y)));
                if(world.getBlockAt(x,0,y).getType()==save) continue;
                world.getBlockAt(x,0,y).setType(save);
            }
        }
    }
}