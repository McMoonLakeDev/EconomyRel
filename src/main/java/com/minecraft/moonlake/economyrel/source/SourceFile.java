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


package com.minecraft.moonlake.economyrel.source;

import com.minecraft.moonlake.economyrel.EconomyRelPlugin;

public class SourceFile extends SourceAbstract {

    public SourceFile(EconomyRelPlugin main) {
        super(main);
    }

    @Override
    protected boolean createDataSource(String name) {
        return false;
    }

    @Override
    public boolean hasDataSource(String name) {
        return false;
    }

    @Override
    public double getMoney(String name) {
        return 0;
    }

    @Override
    public boolean giveMoney(String name, double amount) {
        return false;
    }

    @Override
    public boolean takeMoney(String name, double amount) {
        return false;
    }

    @Override
    public boolean resetMoney(String name) {
        return false;
    }

    @Override
    public int getPoint(String name) {
        return 0;
    }

    @Override
    public boolean givePoint(String name, int amount) {
        return false;
    }

    @Override
    public boolean takePoint(String name, int amount) {
        return false;
    }

    @Override
    public boolean resetPoint(String name) {
        return false;
    }
}
