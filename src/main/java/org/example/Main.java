package org.example;

import org.example.controller.GameController;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameController gameController = new GameController();
        for (int i = 0; i < 100; i++) {
            gameController.runGame();
            System.out.println("================================================");
        }
        System.out.println("================================================");
        System.out.println("Побед после изменения выбора: " + gameController.getChangeCounter());
        System.out.println("Побед без изменения выбора: " + gameController.getNotChangeCounter());
    }
}