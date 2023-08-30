package org.example.User;

import java.util.Set;


public class Computer extends Player {
    private Set<String> citiesList;

    public Computer(String name, Set<String> citiesList, Set<String> usedCities) {
        super(name, usedCities);
        this.citiesList = citiesList;
    }

    @Override
    public String getSmartCityStartingWith(char letter) {
        for (String city : citiesList) {
            if (!usedCities.contains(city) && Character.toLowerCase(city.charAt(0)) == Character.toLowerCase(letter)) {
                usedCities.add(city);
                return city;
            }
        }
        return null;
    }

    @Override
    public void addUsedCity(String city) {
        usedCities.add(city);
    }
}