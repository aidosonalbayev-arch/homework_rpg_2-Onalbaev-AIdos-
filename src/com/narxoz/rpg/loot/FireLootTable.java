package com.narxoz.rpg.loot;
import java.util.*;

import jdk.jfr.Experimental;

public class FireLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public FireLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Fire Sword");
        this.items.add("Flame Shield");
        this.items.add("Inferno Staff");
        this.goldDrop = 500;
        this.experienceDrop = 1000;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public LootTable clone() {
        FireLootTable clone = new FireLootTable();
        clone.items = new ArrayList<>(this.items);
        clone.goldDrop = this.goldDrop;
        clone.experienceDrop = this.experienceDrop;
        return clone;
    }
    
}
