/*
 * Copyright (C) 2017 The MoonLake Authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.minecraft.moonlake.economyrel;

import com.minecraft.moonlake.MoonLakePlugin;
import com.minecraft.moonlake.economyrel.api.MoonLakeEconomyRel;
import com.minecraft.moonlake.economyrel.api.MoonLakeEconomyRelSource;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class EconomyRelPlugin extends JavaPlugin implements MoonLakeEconomyRel {

    private MoonLakeEconomyRelSource dataSource;
    private EconomyRelPluginConfig configuration;

    public EconomyRelPlugin() {
    }

    @Override
    public void onEnable() {
        if(!setupMoonLake()) {
            this.getLogger().log(Level.SEVERE, "前置月色之湖核心API插件加载失败.");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.configuration = new EconomyRelPluginConfig(this);
        this.getLogger().info("月色之湖经济重制 EconomyRel 插件 v" + getDescription().getVersion() + " 成功加载.");
    }

    @Override
    public void onDisable() {
    }

    private boolean setupMoonLake() {
        Plugin plugin = this.getServer().getPluginManager().getPlugin("MoonLake");
        return plugin != null && plugin instanceof MoonLakePlugin;
    }

    @Override
    public EconomyRelPluginConfig getConfiguration() {
        return configuration;
    }

    @Override
    public MoonLakeEconomyRelSource getDataSource() {
        return dataSource;
    }
}
