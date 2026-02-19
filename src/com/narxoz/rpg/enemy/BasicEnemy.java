package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;

public class BasicEnemy extends AbstractEnemy {

    public BasicEnemy(String name, int health, int damage, int defense, int speed,
            String element, LootTable lootTable, String aiBehavior) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = new ArrayList<>();
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " ===");
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability);
        }
        System.out.println("AI: " + aiBehavior);
        if (lootTable != null) {
            System.out.println(lootTable.getLootInfo());
        }
        System.out.println();
    }

    @Override
    public Enemy clone() {
        BasicEnemy clone = new BasicEnemy(
                this.name, this.health, this.damage, this.defense, this.speed,
                this.element, this.lootTable != null ? this.lootTable.clone() : null,
                this.aiBehavior);

        for (Ability ability : this.abilities) {
            clone.abilities.add(ability.clone());
        }
        return clone;
    }

    @Override
    public void setName(String name) {
       this.name = name;
    }
}
