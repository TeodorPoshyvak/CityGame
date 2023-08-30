package org.example.User;

import java.util.Set;

public abstract class Player {
    protected Set<String> usedCities;
    protected String name;

    public Player(String name, Set<String> usedCities) {
        this.name = name;
        this.usedCities = usedCities;
    }

    public String getName() {
        return name;
    }

    public boolean hasUsedCity(String city) {
        return usedCities.contains(city);
    }

    public abstract String getSmartCityStartingWith(char letter);

    public abstract void addUsedCity(String city);
}
