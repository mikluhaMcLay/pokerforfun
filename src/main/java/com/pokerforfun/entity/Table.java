package com.pokerforfun.entity;

import java.awt.print.PageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.pokerforfun.entity.TableType.CASH;

public class Table {
    public static final int DEFAULT_SMALL_BLIND = 5;
    public static final int DEFAULT_BIG_BLIND = 5;

    private final List<User> players;
    private final int smallBlind;
    private final int bigBlind;
    private final TableType tableType;

    public Table(Collection<User> players, int smallBlind, int bigBlind, TableType tableType) {
        this.players = new CopyOnWriteArrayList<>(players);
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.tableType = tableType;
    }

    public Table(Collection<User> players) {
        this.players = new CopyOnWriteArrayList<>(players);
        smallBlind = DEFAULT_SMALL_BLIND;
        bigBlind = DEFAULT_BIG_BLIND;
        tableType = CASH;
    }

    public List<User> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public TableType getTableType() {
        return tableType;
    }

    @Override
    public String toString() {
        return "Table{" +
                "players=" + Arrays.toString(players.toArray()) +
                ", smallBlind=" + smallBlind +
                ", bigBlind=" + bigBlind +
                ", tableType=" + tableType +
                '}';
    }
}
