package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {
    private String name;
    private int damage;
    private String description;

    public MeteorStorm() {
        this.name = "Meteor Storm";
        this.damage = 150;
        this.description = "Summons a storm of meteors that strike all enemies in the area";
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
        MeteorStorm clone = new MeteorStorm();
        clone.name = this.name;
        clone.damage = this.damage;
        clone.description = this.description;
        return clone;
    }

    @Override
    public String toString() {
        return name + "(Damage: " + damage + ") - " + description;
    }
    
}
