package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example complex boss enemy — THE REASON BUILDER PATTERN EXISTS.
 *
 * ============================================================
 * READ THIS CAREFULLY — THIS IS THE CORE LEARNING MOMENT!
 * ============================================================
 *
 * Look at this constructor. REALLY look at it.
 * Count the parameters. Imagine using it in Main.java.
 * Imagine a teammate trying to understand what each parameter means.
 *
 * This is called the "Telescoping Constructor" anti-pattern.
 * It's the #1 problem that the Builder pattern solves.
 *
 * YOUR MISSION:
 * After studying this horror, you will create an EnemyBuilder
 * that constructs DragonBoss (and other complex enemies)
 * step-by-step, with clear and readable code.
 *
 * Compare:
 *
 *   BEFORE (Telescoping Constructor — current code):
 *   new DragonBoss("Fire Dragon", 50000, 500, 200, 50, "FIRE",
 *       abilities, 30000, 15000, 5000, loot, "AGGRESSIVE",
 *       true, true, 20);
 *   // What does 'true, true, 20' mean? Nobody knows!
 *
 *   AFTER (Builder Pattern — your implementation):
 *   new BossEnemyBuilder()
 *       .setName("Fire Dragon")
 *       .setHealth(50000)
 *       .setDamage(500)
 *       .setDefense(200)
 *       .setSpeed(50)
 *       .setElement("FIRE")
 *       .addAbility(new FlameBreath())
 *       .addAbility(new WingBuffet())
 *       .addPhase(1, 50000)
 *       .addPhase(2, 30000)
 *       .addPhase(3, 15000)
 *       .setLootTable(fireLoot)
 *       .setAI("AGGRESSIVE")
 *       .build();
 *   // Every parameter is labeled! Readable! Maintainable!
 *
 * ============================================================
 * TODO: After implementing your Builder, REFACTOR this class!
 * ============================================================
 * - Remove (or simplify) the telescoping constructor
 * - Make DragonBoss constructable ONLY through a Builder
 * - Make the built DragonBoss IMMUTABLE (no setters!)
 * - The Builder handles all the complexity
 */
public class DragonBoss implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    /**
     * THE TELESCOPING CONSTRUCTOR FROM HELL.
     *
     * Count the parameters: FIFTEEN (15).
     * Can you tell which parameter is which when calling this?
     * Can you remember the order?
     * What if you want to add a 16th parameter later?
     *
     * THIS is why the Builder pattern exists.
     *
     * After you implement your Builder, this constructor should be
     * either simplified (package-private, called only by Builder)
     * or replaced entirely.
     */
    DragonBoss(String name, int health, int damage, int defense, int speed,
        String element, List<Ability> abilities, Map<Integer, Integer> phases,
        LootTable lootTable, String aiBehavior,
        boolean canFly, boolean hasBreathAttack, int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.phases = phases != null ? phases : new HashMap<>();
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    // TODO: Implement methods from Enemy interface

    // public String getName() {
    //     return name;
    // }

    // public int getHealth() {
    //     return health;
    // }

    // public void displayInfo() {
    //     System.out.println("=== " + name + " (Dragon Boss) ===");
    //     System.out.println("Health: " + health + " | Damage: " + damage
    //             + " | Defense: " + defense + " | Speed: " + speed);
    //     System.out.println("Element: " + element);
    //     System.out.println("Abilities (" + abilities.size() + "):");
    //     // TODO: Display each ability's details
    //     System.out.println("Boss Phases: " + phases.size());
    //     for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
    //         System.out.println("  Phase " + phase.getKey()
    //                 + ": triggers at " + phase.getValue() + " HP");
    //     }
    //     System.out.println("AI Behavior: " + aiBehavior);
    //     System.out.println("Can Fly: " + canFly
    //             + " | Breath Attack: " + hasBreathAttack
    //             + " | Wingspan: " + wingspan);
    //     // TODO: Display loot table
    // }

    // TODO: Implement clone() for Prototype pattern
    // DragonBoss has MANY fields that need deep copying:
    //   - abilities (List<Ability>) → deep copy each ability
    //   - phases (Map<Integer, Integer>) → copy the map
    //   - lootTable → deep copy
    //   - primitive fields → direct copy
    //
    // This is more complex than Goblin.clone()!
    // That's the challenge of Prototype with complex objects.

    // TODO: Add helper methods for variant creation
    // - void setElement(String element) — for elemental variants
    // - void multiplyStats(double multiplier) — for difficulty tiers

    @Override
    public String getName() { return name; }
    @Override
    public int getHealth() { return health; }
    @Override
    public int getDamage() { return damage; }
    @Override
    public int getDefense() { return defense; }
    @Override
    public int getSpeed() { return speed; }
    @Override
    public String getElement() { return element; }
    @Override
    public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override
    public LootTable getLootTable() { return lootTable; }
    
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
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
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly + " | Breath Attack: " + hasBreathAttack + 
                          " | Wingspan: " + wingspan);
        if (lootTable != null) {
            System.out.println(lootTable.getLootInfo());
        }
        System.out.println();
    }
    
    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability ability : this.abilities) {
            clonedAbilities.add(ability.clone());
        }
        
        return new DragonBoss(
            this.name, this.health, this.damage, this.defense, this.speed,
            this.element, clonedAbilities, new HashMap<>(this.phases),
            this.lootTable != null ? this.lootTable.clone() : null,
            this.aiBehavior, this.canFly, this.hasBreathAttack, this.wingspan
        );
    }
    
    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }
    
    @Override
    public void setElement(String element) { this.element = element; }
    
    @Override
    public void addAbility(Ability ability) { this.abilities.add(ability); }

}
