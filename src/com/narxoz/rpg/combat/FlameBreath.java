package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    private String name;
    private int damage;
    private String description;

    public FlameBreath() {
        this.name = "Flame Breath";
        this.damage = 50;
        this.description = "Unleashes a fiery breath that scorches enemies in front of you.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override   
    public String getDescription() {
        return description;
    }

    @Override
    public Ability clone() {
        FlameBreath clone = new FlameBreath();
        clone.name = this.name;
        clone.damage = this.damage; 
        clone.description = this.description;
        return clone;
    }

    @Override
    public String toString() {
        return name + "(damage: " + damage + "): " + description;
    }
}