package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    private String name;
    private int damage;
    private String description;

    public Vanish() {
        this.name = "Vanish";
        this.damage = 0;
        this.description = "Allows the user to disappear from sight, avoiding all damage for a short duration.";
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
        Vanish clone = new Vanish();
        clone.name = this.name;
        clone.damage = this.damage; 
        clone.description = this.description;
        return clone;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
    
}
