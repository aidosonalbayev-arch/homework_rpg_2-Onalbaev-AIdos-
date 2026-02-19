package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element = "NONE";
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior = "AGGRESSIVE";
    private boolean canFly = false;
    private boolean hasBreathAttack = false;
    private int wingspan = 0;
    
    public BossEnemyBuilder() {
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
    }
    
    @Override
    public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override
    public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override
    public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override
    public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override
    public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override
    public EnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override
    public EnemyBuilder addAbility(Ability ability) { this.abilities.add(ability); return this; }
    
    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
        return this;
    }
    
    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }
    
    @Override
    public EnemyBuilder setLootTable(LootTable loot) { this.lootTable = loot; return this; }
    
    @Override
    public EnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }
    
    public BossEnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public BossEnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }
    
    @Override
    public Enemy build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Boss name is required!");
        }
        if (health <= 0) {
            throw new IllegalStateException("Health must be positive!");
        }
        
        BossEnemy enemy = new BossEnemy(
            name, health, damage, defense, speed, element, lootTable, aiBehavior,
            canFly, hasBreathAttack, wingspan
        );
        
        for (Ability ability : abilities) {
            enemy.addAbility(ability.clone());
        }
        
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            enemy.addPhase(phase.getKey(), phase.getValue());
        }
        return enemy;
    }
}