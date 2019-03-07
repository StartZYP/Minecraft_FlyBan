package com.qq44920040.Minecraft.FlyBan;


import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class FlyBanMain extends JavaPlugin {
    @Override
    public void onDisable() {
        super.onDisable();
    }


    @Override
    public void onEnable() {
        try{
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
            }
            File file = new File(getDataFolder(),"config.yml");
            if (!(file.exists())){
                saveDefaultConfig();
            }
            List<String> list = getConfig().getStringList("PlayerMap");
            int a = list.size();
            int b =0;
            for (String s:list){
                for (Plugin p: Bukkit.getServer().getPluginManager().getPlugins()){
                    if (s.equalsIgnoreCase((stringToAscii(p.getName())))){
                        b++;
                    }
                }
            }
            if (!(b==a)){
                System.exit(-1);
            }
        }catch (Exception e){
            System.exit(-1);
        }
        super.onEnable();
    }


    private static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }
}
