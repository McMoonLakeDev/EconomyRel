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
import com.minecraft.moonlake.economyrel.api.MoonLakeEconomyRelSource;
import com.minecraft.moonlake.validate.Validate;
import net.milkbowl.vault.economy.AbstractEconomy;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class SourceAbstract extends AbstractEconomy implements Economy, MoonLakeEconomyRelSource {

    private final EconomyRelPlugin main;
    private final static String MONEY = "\uFFE5";

    public SourceAbstract(EconomyRelPlugin main) {
        this.main = main;
    }

    protected final EconomyRelPlugin getMain() {
        return main;
    }

    //
    // Vault API Method

    @Override
    public boolean isEnabled() {
        return getMain().isEnabled();
    }

    @Override
    public String getName() {
        return getMain().getName();
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return 2;
    }

    @Override
    public String format(double money) {
        return money + MONEY;
    }

    @Override
    public String currencyNamePlural() {
        return MONEY;
    }

    @Override
    public String currencyNameSingular() {
        return MONEY;
    }

    @Override
    public boolean hasAccount(String player) {
        return hasDataSource(player);
    }

    @Override
    public boolean hasAccount(String player, String world) {
        return hasDataSource(player);
    }

    @Override
    public double getBalance(String player) {
        return getMoney(player);
    }

    @Override
    public double getBalance(String player, String world) {
        return getMoney(player);
    }

    @Override
    public boolean has(String player, double money) {
        return getMoney(player) - money >= 0d;
    }

    @Override
    public boolean has(String player, String world, double money) {
        return getMoney(player) - money >= 0d;
    }

    @Override
    public EconomyResponse withdrawPlayer(String player, double money) {
        double oldMoney = getMoney(player);
        boolean result = takeMoney(player, money);
        return new EconomyResponse(money, oldMoney, result ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, null);
    }

    @Override
    public EconomyResponse withdrawPlayer(String player, String world, double money) {
        return withdrawPlayer(player, money);
    }

    @Override
    public EconomyResponse depositPlayer(String player, double money) {
        double oldMoney = getMoney(player);
        boolean result = giveMoney(player, money);
        return new EconomyResponse(money, oldMoney, result ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, null);
    }

    @Override
    public EconomyResponse depositPlayer(String player, String world, double money) {
        return depositPlayer(player, money);
    }

    @Override
    public EconomyResponse createBank(String player, String world) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse deleteBank(String player) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankBalance(String player) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankHas(String player, double money) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankWithdraw(String player, double money) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankDeposit(String player, double money) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse isBankOwner(String player, String world) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse isBankMember(String player, String world) {
        return new EconomyResponse(0d, 0d, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public List<String> getBanks() {
        return null;
    }

    @Override
    public boolean createPlayerAccount(String player) {
        return createDataSource(player);
    }

    @Override
    public boolean createPlayerAccount(String player, String world) {
        return createDataSource(player);
    }
    ///



    //
    // MoonLake Economy Method

    private String validatePlayerName(Player player) {
        return Validate.checkNotNull(player).getName();
    }

    protected abstract boolean createDataSource(String name);

    @Override
    public boolean hasDataSource(Player player) {
        return hasDataSource(validatePlayerName(player));
    }

    @Override
    public double getMoney(Player player) {
        return getMoney(validatePlayerName(player));
    }

    @Override
    public boolean giveMoney(Player player, double amount) {
        return giveMoney(validatePlayerName(player), amount);
    }

    @Override
    public boolean takeMoney(Player player, double amount) {
        return takeMoney(validatePlayerName(player), amount);
    }

    @Override
    public boolean resetMoney(Player player) {
        return resetMoney(validatePlayerName(player));
    }

    @Override
    public int getPoint(Player player) {
        return getPoint(validatePlayerName(player));
    }

    @Override
    public boolean givePoint(Player player, int amount) {
        return givePoint(validatePlayerName(player), amount);
    }

    @Override
    public boolean takePoint(Player player, int amount) {
        return takePoint(validatePlayerName(player), amount);
    }

    @Override
    public boolean resetPoint(Player player) {
        return resetPoint(validatePlayerName(player));
    }
    ///
}
