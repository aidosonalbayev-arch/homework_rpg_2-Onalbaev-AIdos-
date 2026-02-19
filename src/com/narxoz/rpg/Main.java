package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.loot.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import java.util.List;

/**
 * Main demonstration class for the RPG Enemy System.
 *
 * ============================================================
 * CREATIONAL PATTERNS CAPSTONE
 * ============================================================
 *
 * This demo must showcase ALL FOUR creational design patterns
 * working together in one unified system:
 *
 *   1. ABSTRACT FACTORY — Create themed enemy component families
 *   2. BUILDER          — Construct complex enemies step-by-step
 *   3. FACTORY METHOD   — Embedded in Builder.build() and Director
 *   4. PROTOTYPE        — Clone enemies into variants efficiently
 *
 * The patterns work together in a pipeline:
 *
 *   Abstract Factory (themed components)
 *          |
 *          v
 *   Builder (assembles enemy from components)
 *          |
 *          v  <-- Factory Method: build() produces the Enemy
 *   Prototype (clones built enemy into variants)
 *
 * ============================================================
 * YOUR TASKS:
 * ============================================================
 *
 * Your Main.java should demonstrate each pattern clearly,
 * then show them working together. Follow the structure below.
 *
 * Expected output flow:
 *   Part 1: Abstract Factory creates themed components
 *   Part 2: Builder constructs complex enemies
 *   Part 3: Prototype clones enemies into variants
 *   Part 4: Full pipeline — all patterns integrated
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        // ============================================================
        // PART 1: ABSTRACT FACTORY PATTERN
        // ============================================================
        // TODO: Create themed component factories
        //   - FireComponentFactory
        //   - IceComponentFactory
        //   - ShadowComponentFactory
        //
        // TODO: Show that each factory creates MATCHING components
        //   EnemyComponentFactory fireFactory = new FireComponentFactory();
        //   List<Ability> fireAbilities = fireFactory.createAbilities();
        //   LootTable fireLoot = fireFactory.createLootTable();
        //   String fireAI = fireFactory.createAIBehavior();
        //
        // TODO: Display the components from each factory
        //   Show that Fire factory creates fire abilities + fire loot
        //   Show that Ice factory creates ice abilities + ice loot
        //   Show that they CANNOT be mixed (consistency guaranteed!)
        //
        // Think: How is this similar to HW1's EquipmentFactory?

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        // Your Abstract Factory demonstration here...
        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("--- Fire Theme Components ---");
        List<Ability> fireAbilities = fireFactory.createAbilities();
        LootTable fireLoot = fireFactory.createLootTable();
        String fireAI = fireFactory.createAIBehavior();

        System.out.println("Abilities:");
        for (Ability ability : fireAbilities) System.out.println("  " + ability);
        System.out.println("Loot: " + fireLoot.getLootInfo());
        System.out.println("AI: " + fireAI + "\n");
        
        System.out.println("--- Ice Theme Components ---");
        List<Ability> iceAbilities = iceFactory.createAbilities();
        LootTable iceLoot = iceFactory.createLootTable();
        String iceAI = iceFactory.createAIBehavior();
        
        System.out.println("Abilities:");
        for (Ability ability : iceAbilities) System.out.println("  " + ability);
        System.out.println("Loot: " + iceLoot.getLootInfo());
        System.out.println("AI: " + iceAI + "\n");
        
        System.out.println("--- Shadow Theme Components ---");
        List<Ability> shadowAbilities = shadowFactory.createAbilities();
        LootTable shadowLoot = shadowFactory.createLootTable();
        String shadowAI = shadowFactory.createAIBehavior();
        
        System.out.println("Abilities:");
        for (Ability ability : shadowAbilities) System.out.println("  " + ability);
        System.out.println("Loot: " + shadowLoot.getLootInfo());
        System.out.println("AI: " + shadowAI + "\n");

        // ============================================================
        // PART 2: BUILDER PATTERN
        // ============================================================
        // TODO: Build complex enemies using your EnemyBuilder
        //
        // Build at least:
        //   - One complex boss (Dragon) using BossEnemyBuilder
        //     Use the FireComponentFactory to get themed components!
        //   - One medium enemy using BasicEnemyBuilder
        //
        // TODO: Show the fluent interface in action:
        //   Enemy dragon = new BossEnemyBuilder()
        //       .setName("Ancient Fire Dragon")
        //       .setHealth(50000)
        //       .setDamage(500)
        //       .setAbilities(fireFactory.createAbilities())
        //       .setLootTable(fireFactory.createLootTable())
        //       .addPhase(1, 50000)
        //       .addPhase(2, 30000)
        //       .addPhase(3, 15000)
        //       .build();
        //
        // TODO: Show the Director creating preset enemies:
        //   EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        //   Enemy miniBoss = director.createMiniBoss();
        //   Enemy raidBoss = director.createRaidBoss();
        //
        // Think: Where is Factory Method here? (Hint: build() IS the factory method!)
        // Think: How does the Director use Factory Method delegation?

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // Your Builder demonstration here...
        System.out.println("--- Building Fire Dragon with BossEnemyBuilder ---");
        Enemy fireDragon = new BossEnemyBuilder()
            .setName("Ancient Fire Dragon")
            .setHealth(50000)
            .setDamage(500)
            .setDefense(200)
            .setSpeed(50)
            .setElement("FIRE")
            .setAbilities(fireFactory.createAbilities())
            .addPhase(1, 50000)
            .addPhase(2, 30000)
            .addPhase(3, 15000)
            .setLootTable(fireFactory.createLootTable())
            .setAI(fireFactory.createAIBehavior())
            .build();
        
        fireDragon.displayInfo();
        
        System.out.println("--- Using EnemyDirector to create Mini Boss ---");
        EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        Enemy miniBoss = director.createMiniBoss(iceFactory);
        System.out.println("Director created Mini Boss (Ice theme):");
        miniBoss.displayInfo();

        System.out.println("--- Building Goblin with BasicEnemyBuilder ---");
        Enemy goblin = new BasicEnemyBuilder()
            .setName("Forest Goblin")
            .setHealth(100)
            .setDamage(15)
            .setDefense(5)
            .setSpeed(35)
            .setElement("NONE")
            .setLootTable(fireFactory.createLootTable())
            .setAI("COWARD")
            .build();
        
        goblin.displayInfo();

        // ============================================================
        // PART 3: PROTOTYPE PATTERN
        // ============================================================
        // TODO: Create a template registry and populate it
        //   EnemyRegistry registry = new EnemyRegistry();
        //   registry.registerTemplate("goblin", baseGoblin);
        //   registry.registerTemplate("dragon", baseDragon);
        //
        // TODO: Clone enemies to create difficulty variants
        //   Enemy eliteGoblin = registry.createFromTemplate("goblin");
        //   eliteGoblin.multiplyStats(2.0);  // 2x stats
        //
        // TODO: Clone enemies to create elemental variants
        //   Enemy fireDragon = registry.createFromTemplate("dragon");
        //   fireDragon.setElement("FIRE");
        //   fireDragon.setAbilities(fireFactory.createAbilities());
        //
        // TODO: Prove deep copy works!
        //   Modify cloned enemy's abilities.
        //   Show that the original template is UNCHANGED.
        //
        // Think: What would happen with shallow copy here?

        EnemyRegistry registry = new EnemyRegistry();
        
        Enemy baseGoblin = new Goblin("Base Goblin");
        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("dragon", fireDragon);
        registry.registerTemplate("ice-miniboss", miniBoss);
        
        System.out.println("Templates registered:");
        registry.listTemplates();
        System.out.println();
        
        System.out.println("--- Difficulty Variants from Goblin Template ---");
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.setName("Elite Goblin");
        
        System.out.println("Base Goblin:");
        baseGoblin.displayInfo();
        
        System.out.println("Elite Goblin (2x stats):");
        eliteGoblin.displayInfo();
        
        System.out.println("--- Deep Copy Verification ---");
        Enemy original = registry.createFromTemplate("goblin");
        original.setName("Original Goblin");
        original.addAbility(new FlameBreath());
        
        Enemy clone = original.clone();
        clone.setName("Cloned Goblin");
        clone.addAbility(new PoisonStab());
        
        System.out.println("Original abilities count: " + original.getAbilities().size() + 
                          " (FlameBreath only)");
        System.out.println("Clone abilities count: " + clone.getAbilities().size() + 
                          " (FlameBreath + PoisonStab)");
        System.out.println("Deep copy verified: Original unchanged!\n");

        // ============================================================
        // PART 4: ALL PATTERNS WORKING TOGETHER
        // ============================================================
        // TODO: Show the full pipeline
        //
        // Step 1: Abstract Factory creates Shadow components
        //   EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        //
        // Step 2: Builder assembles Demon Lord with Shadow components
        //   Enemy demonLord = new BossEnemyBuilder()
        //       .setName("Demon Lord")
        //       .setAbilities(shadowFactory.createAbilities())
        //       .setLootTable(shadowFactory.createLootTable())
        //       .build();
        //
        // Step 3: Register as Prototype template
        //   registry.registerTemplate("demon-lord", demonLord);
        //
        // Step 4: Clone variants
        //   Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        //   greaterDemon.multiplyStats(2.0);
        //
        // Display all variants showing each pattern's contribution!

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        // Your integration demonstration here...

        // Step 1: Abstract Factory
        System.out.println("Step 1: Abstract Factory creates Shadow components");
        EnemyComponentFactory shadowFactory2 = new ShadowComponentFactory();
        
        // Step 2: Builder + Director
        System.out.println("Step 2: Director & Builder assemble Demon Lord");
        EnemyDirector director2 = new EnemyDirector(new BossEnemyBuilder());
        Enemy demonLord = director2.createRaidBoss(shadowFactory2);
        demonLord.setName("Demon Lord");
        demonLord.displayInfo();
        
        // Step 3: Register as Prototype
        System.out.println("Step 3: Register Demon Lord as Prototype template");
        registry.registerTemplate("demon-lord", demonLord);
        
        // Step 4: Clone variants
        System.out.println("Step 4: Clone Demon Lord variants");
        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.setName("Greater Demon");
        greaterDemon.multiplyStats(2.0);
        
        Enemy demonPrince = registry.createFromTemplate("demon-lord");
        demonPrince.setName("Demon Prince");
        demonPrince.multiplyStats(3.0);
        demonPrince.setElement("SHADOW+FIRE");
        demonPrince.addAbility(new MeteorStorm());
        
        System.out.println("Greater Demon (2x stats):");
        greaterDemon.displayInfo();
        
        System.out.println("Demon Prince (3x stats + hybrid element + Meteor Storm):");
        demonPrince.displayInfo();


        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();
        // TODO: Print a summary showing which patterns were demonstrated
        // Example:
        // System.out.println("Abstract Factory: Themed component families (Fire, Ice, Shadow)");
        // System.out.println("Builder: Complex step-by-step enemy construction");
        // System.out.println("Factory Method: Embedded in Builder.build() and Director");
        // System.out.println("Prototype: Efficient template cloning with deep copy");

        System.out.println("ABSTRACT FACTORY: Themed component families (Fire, Ice, Shadow)");
        System.out.println("  - Guarantees consistent themed components");
        System.out.println("  - FireFactory creates fire abilities + fire loot + aggressive AI\n");
        
        System.out.println("BUILDER: Complex step-by-step enemy construction");
        System.out.println("  - Fluent interface for readable code");
        System.out.println("  - Validation in build() prevents invalid enemies\n");
        
        System.out.println("DIRECTOR: Preset configurations using Builder");
        System.out.println("  - createMiniBoss(), createRaidBoss() methods");
        System.out.println("  - Delegates to Builder without knowing concrete type\n");
        
        System.out.println("FACTORY METHOD: Embedded in Builder.build()");
        System.out.println("  - build() creates Enemy objects polymorphically");
        System.out.println("  - Different builders return different Enemy types\n");
        
        System.out.println("PROTOTYPE: Efficient template cloning with deep copy");
        System.out.println("  - Registry stores templates, returns clones");
        System.out.println("  - Deep copy verified: modifying clone doesn't affect original");
        System.out.println("  - Created difficulty variants (Elite Goblin)");
        System.out.println("  - Created elemental variants (Demon Lord variants)\n");

        System.out.println("=== Demo Complete ===");
    }

    // TODO: Add helper methods as needed
    // Consider:
    // - displayEnemyDetails(Enemy enemy)
    // - demonstrateDeepCopy(Enemy original, Enemy clone)
    // - createThemeDemo(EnemyComponentFactory factory, String themeName)

    static class PoisonStab implements Ability {
        private String name = "Poison Stab";
        private int damage = 25;
        private String description = "A poisoned dagger strike";
        
        @Override
        public String getName() { return name; }
        
        @Override
        public int getDamage() { return damage; }
        
        @Override
        public String getDescription() { return description; }
        
        @Override
        public Ability clone() {
            PoisonStab clone = new PoisonStab();
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
}
