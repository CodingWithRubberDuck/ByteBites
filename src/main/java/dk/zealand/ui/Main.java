package dk.zealand.ui;

import dk.zealand.domain.Dish;
import dk.zealand.service.MenuService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final MenuService menuService = new MenuService();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("ByteBites – festivalens foodtruck");

        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> showDishes();
                case "2" -> System.out.println(
                        "Oprettelse af bestillinger er endnu ikke implementeret."
                );
                case "0" -> running = false;
                default -> System.out.println(
                        "Ugyldigt valg. Vælg 0, 1 eller 2."
                );
            }
        }

        System.out.println("Programmet er afsluttet.");
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1. Vis retter");
        System.out.println("2. Opret bestilling");
        System.out.println("0. Afslut");
        System.out.print("Vælg: ");
    }

    private void showDishes() {
        List<Dish> dishes = menuService.getDishes();
        System.out.println("Retter:");

        for (int i = 0; i < dishes.size(); i++) {
            Dish dish = dishes.get(i);
            System.out.printf("%d. %s - %d kr.%n", i + 1, dish.getName(), dish.getPrice());
        }
    }
}
