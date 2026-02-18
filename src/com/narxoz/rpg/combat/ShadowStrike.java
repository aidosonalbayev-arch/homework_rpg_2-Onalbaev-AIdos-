package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    private String name;
    private int damage;
    private String description;

    public ShadowStrike() {
        this.name = "Shadow Strike";
        this.damage = 70;
        this.description = "Strikes the enemy from the shadows, dealing high damage and briefly stunning them.";
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
        ShadowStrike clone = new ShadowStrike();
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
