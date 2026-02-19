package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;
    
    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }
    
    public void setBuilder(EnemyBuilder builder) {
        this.builder = builder;
    }
    
    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
            .setName("Minion")
            .setHealth(100)
            .setDamage(15)
            .setDefense(5)
            .setSpeed(30)
            .setElement("NONE")
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();  // Factory Method called here
    }
    
    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
            .setName("Elite Warrior")
            .setHealth(500)
            .setDamage(40)
            .setDefense(20)
            .setSpeed(25)
            .setElement("NONE")
            .setAbilities(factory.createAbilities())
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();  // Factory Method called here
    }
    
    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
            .setName("Mini Boss")
            .setHealth(2000)
            .setDamage(80)
            .setDefense(40)
            .setSpeed(20)
            .setElement(factory.createAbilities().get(0).getName().split(" ")[0]) 
            .setAbilities(factory.createAbilities())
            .addPhase(1, 2000)
            .addPhase(2, 1000)
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();
    }
    
    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
            .setName("Raid Boss")
            .setHealth(10000)
            .setDamage(200)
            .setDefense(100)
            .setSpeed(15)
            .setElement(factory.createAbilities().get(0).getName().split(" ")[0])
            .setAbilities(factory.createAbilities())
            .addPhase(1, 10000)
            .addPhase(2, 7000)
            .addPhase(3, 4000)
            .addPhase(4, 2000)
            .setLootTable(factory.createLootTable())
            .setAI(factory.createAIBehavior())
            .build();  // Factory Method called here
    }
}