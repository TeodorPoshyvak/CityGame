package org.example.User;

import java.util.Set;

public class User extends Player {
    public User(String name, Set<String> usedCities) {
        super(name, usedCities);
    }

    @Override
    public String getSmartCityStartingWith(char letter) {
        return null;
    }

    @Override
    public void addUsedCity(String city) {
        usedCities.add(city);
    }
}
