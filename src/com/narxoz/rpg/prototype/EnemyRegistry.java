package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;
import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> templates;
    
    public EnemyRegistry() {
        this.templates = new HashMap<>();
    }
    
    public void registerTemplate(String key, Enemy template) {
        templates.put(key, template);
    }
    
    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) {
            throw new IllegalArgumentException("Unknown template: " + key);
        }
        return template.clone();
    }
    
    public void listTemplates() {
        System.out.println("Registered Templates:");
        for (String key : templates.keySet()) {
            System.out.println("  - " + key);
        }
    }
    
    public boolean hasTemplate(String key) {
        return templates.containsKey(key);
    }
}