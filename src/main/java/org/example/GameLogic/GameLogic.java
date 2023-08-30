package org.example.GameLogic;

import org.example.User.Computer;
import org.example.User.Player;
import org.example.User.User;
import org.example.Utils.ListName;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GameLogic {
    private Set<String> citiesList;
    private Player humanPlayer;
    private Player computerPlayer;
    private Player currentPlayer;

    public GameLogic(Set<String> citiesList) {
        this.citiesList = citiesList;
        this.humanPlayer = new User("Human", new HashSet<>());
        this.computerPlayer = new Computer("Computer", citiesList, new HashSet<>());
        this.currentPlayer = humanPlayer;
    }

    public void play() throws UnsupportedEncodingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(currentPlayer.getName() + ", введіть місто:");
            try {
                String inputCity = reader.readLine().toLowerCase();
                System.out.println(inputCity);
                if (inputCity.equals("здаюсь")) {
                    System.out.println("Комп'ютер виграв! Гра завершена.");
                    break;
                }

                if (!isValidCity(inputCity)) {
                    System.out.println("Введене місто недійсне або вже використане. Спробуйте інше місто.");
                    continue;
                }

                humanPlayer.addUsedCity(inputCity);

                char lastLetter = inputCity.charAt(inputCity.length() - 1);
                String computerCity = computerPlayer.getSmartCityStartingWith(lastLetter);

                if (computerCity == null) {
                    System.out.println("Вітаємо, " + currentPlayer.getName() + "! Ви виграли.");
                    break;
                }

                System.out.println("Комп'ютер: " + computerCity);
                humanPlayer.addUsedCity(computerCity);

                if (currentPlayer == humanPlayer) {
                    currentPlayer = computerPlayer;
                } else {
                    currentPlayer = humanPlayer;
                }

                if (isGameOver()) {
                    System.out.println("Гра закінчена. Немає більше можливих ходів.");
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValidCity(String city) {
        return citiesList.contains(city) && !humanPlayer.hasUsedCity(city);
    }
    private boolean isGameOver() {
        return citiesList.stream()
                .filter(city -> !humanPlayer.hasUsedCity(city))
                .anyMatch(city -> computerPlayer.getSmartCityStartingWith(city.charAt(city.length() - 1)) != null);
    }


    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        ListName listName1 = new ListName();
        listName1.listNames();
        Set<String> cityList = new HashSet<>(listName1.getListName());

        GameLogic game = new GameLogic(cityList);
        game.play();
    }
}
