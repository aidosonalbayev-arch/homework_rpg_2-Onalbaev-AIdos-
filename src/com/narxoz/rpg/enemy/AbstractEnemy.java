package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractEnemy implements Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;
    protected List<Ability> abilities;
    protected Map<Integer, Integer> phases;
    protected LootTable lootTable;
    protected String aiBehavior;
    
    public AbstractEnemy() {
        this.abilities = new ArrayList<>();
        this.phases = new HashMap<>();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getHealth() {
        return health;
    }
    
    @Override
    public int getDamage() {
        return damage;
    }
    
    @Override
    public int getDefense() {
        return defense;
    }
    
    @Override
    public int getSpeed() {
        return speed;
    }
    
    @Override
    public String getElement() {
        return element;
    }
    
    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }
    
    @Override
    public LootTable getLootTable() {
        return lootTable;
    }
    
    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }
    
    @Override
    public void setElement(String element) {
        this.element = element;
    }
    
    @Override
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }
    
    protected void copyBasicStats(AbstractEnemy source) {
        this.name = source.name;
        this.health = source.health;
        this.damage = source.damage;
        this.defense = source.defense;
        this.speed = source.speed;
        this.element = source.element;
        this.aiBehavior = source.aiBehavior;
    }
    
    @Override
    public abstract AbstractEnemy clone();
}