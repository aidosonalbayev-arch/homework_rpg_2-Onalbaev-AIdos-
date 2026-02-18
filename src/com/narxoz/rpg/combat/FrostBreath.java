package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    private String name;
    private int damage;
    private String description;

    public FrostBreath() {
        this.name = "Frost Breath";
        this.damage = 40;
        this.description = "Unleashes a chilling breath that freezes enemies in front of you.";
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
        FrostBreath clone = new FrostBreath();
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
