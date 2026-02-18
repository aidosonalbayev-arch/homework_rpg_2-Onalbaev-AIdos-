package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class Skeleton implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private LootTable lootTable;
    
    public Skeleton(String name) {
        this.name = name;
        this.health = 80;
        this.damage = 20;
        this.defense = 10;
        this.speed = 20;
        this.element = "NONE";
        this.abilities = new ArrayList<>();
    }
    
    public Skeleton(String name, int health, int damage, int defense, int speed,
                    String element, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = new ArrayList<>();
        this.lootTable = lootTable;
    }
    
    @Override
    public String getName() { return name; }
    @Override
    public int getHealth() { return health; }
    @Override
    public int getDamage() { return damage; }
    @Override
    public int getDefense() { return defense; }
    @Override
    public int getSpeed() { return speed; }
    @Override
    public String getElement() { return element; }
    @Override
    public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override
    public LootTable getLootTable() { return lootTable; }
    
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + 
                          " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability);
        }
        if (lootTable != null) {
            System.out.println(lootTable.getLootInfo());
        }
        System.out.println();
    }
    
    @Override
    public Enemy clone() {
        Skeleton clone = new Skeleton(
            this.name, this.health, this.damage, this.defense, this.speed,
            this.element, this.lootTable != null ? this.lootTable.clone() : null
        );
        
        for (Ability ability : this.abilities) {
            clone.abilities.add(ability.clone());
        }
        return clone;
    }
    
    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }
    
    @Override
    public void setElement(String element) { this.element = element; }
    
    @Override
    public void addAbility(Ability ability) { this.abilities.add(ability); }
}