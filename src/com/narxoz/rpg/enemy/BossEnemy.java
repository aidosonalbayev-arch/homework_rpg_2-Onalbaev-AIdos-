package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BossEnemy extends AbstractEnemy {
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;
    
    public BossEnemy(String name, int health, int damage, int defense, int speed,
                     String element, LootTable lootTable, String aiBehavior,
                     boolean canFly, boolean hasBreathAttack, int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();  // phases инициализация
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }
    
    // ADD PHASE METHOD - осы методты қосу керек
    public void addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (BOSS) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + 
                          " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability ability : abilities) {
            System.out.println("  - " + ability);
        }
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI: " + aiBehavior);
        System.out.println("Can Fly: " + canFly + " | Breath Attack: " + hasBreathAttack + 
                          " | Wingspan: " + wingspan);
        if (lootTable != null) {
            System.out.println(lootTable.getLootInfo());
        }
        System.out.println();
    }
    
    @Override
    public Enemy clone() {
        BossEnemy clone = new BossEnemy(
            this.name, this.health, this.damage, this.defense, this.speed,
            this.element, this.lootTable != null ? this.lootTable.clone() : null,
            this.aiBehavior, this.canFly, this.hasBreathAttack, this.wingspan
        );
        
        for (Ability ability : this.abilities) {
            clone.abilities.add(ability.clone());
        }
        
        clone.phases = new HashMap<>(this.phases);
        
        return clone;
    }

    @Override
    public void setName(String name) {
       this.name = name;
    }
}