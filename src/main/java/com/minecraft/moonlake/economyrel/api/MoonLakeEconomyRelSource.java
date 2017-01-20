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


package com.minecraft.moonlake.economyrel.api;

import org.bukkit.entity.Player;

public interface MoonLakeEconomyRelSource {

    boolean hasDataSource(String name);

    double getMoney(String name);

    boolean giveMoney(String name, double amount);

    boolean takeMoney(String name, double amount);

    boolean resetMoney(String name);

    int getPoint(String name);

    boolean givePoint(String name, int amount);

    boolean takePoint(String name, int amount);

    boolean resetPoint(String name);

    boolean hasDataSource(Player player);

    double getMoney(Player player);

    boolean giveMoney(Player player, double amount);

    boolean takeMoney(Player player, double amount);

    boolean resetMoney(Player player);

    int getPoint(Player player);

    boolean givePoint(Player player, int amount);

    boolean takePoint(Player player, int amount);

    boolean resetPoint(Player player);
}
