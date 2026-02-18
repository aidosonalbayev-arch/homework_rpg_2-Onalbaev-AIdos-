package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.ShadowLootTable;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory {
    
    @Override
    public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new ShadowStrike());
        abilities.add(new Vanish());
        abilities.add(new DarkNova());
        return abilities;
    }
    
    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }
    
    @Override
    public String createAIBehavior() {
        return "TACTICAL - Uses stealth, ambush tactics, and strikes from shadows";
    }
}