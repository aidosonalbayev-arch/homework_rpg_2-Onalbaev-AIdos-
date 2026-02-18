package com.narxoz.rpg.loot;
import java.util.*;

public class IceLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public IceLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Ice Sword");
        this.items.add("Frost Shield");
        this.items.add("Glacier Staff");
        this.goldDrop = 400;
        this.experienceDrop = 800;
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
        IceLootTable clone = new IceLootTable();
        clone.items = new ArrayList<>(this.items);
        clone.goldDrop = this.goldDrop;
        clone.experienceDrop = this.experienceDrop;
        return clone;
    }

    @Override
    public String getLootInfo() {
        StringBuilder info = new StringBuilder("Loot: ");
        info.append(String.join(", ", items));
        info.append(" | Gold: ").append(goldDrop);
        info.append(" | XP: ").append(experienceDrop);
        return info.toString();
    }
    
}
