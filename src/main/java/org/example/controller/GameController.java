package org.example.controller;

import org.example.domain.Door;
import org.example.service.DoorService;
import org.example.service.PlayerService;
import org.example.view.View;

import java.util.Random;
import java.util.Scanner;

public class GameController {

    PlayerService playerService;
    View view;
    Random random;

    public static int changeCounter = 0;
    public static int notChangeCounter = 0;


    public void runGame() throws InterruptedException{
        this.playerService = new PlayerService(new DoorService());
        this.view = new View();
        this.random = new Random();
        int victoryDoorNumber = 1 + random.nextInt(2);
        Door victoryDoor = playerService.chooseDoor(victoryDoorNumber);
        System.out.println("(Победная дверь " + victoryDoor+")");


        view.startGame();
        view.showDoors(playerService.getDoors());
        view.chooseDoor();
        int choice = 1 + random.nextInt(3);
        Door choiceDoor = playerService.chooseDoor(choice);
        view.showChoiceDoor(choiceDoor);
        Door looseDoor = playerService.openLooseDoor(victoryDoor, choiceDoor);
        view.showLooseDoor(looseDoor);
        view.changeDoor();
        int answer = random.nextInt(2);
        switch (answer) {
            case (0) -> {
                System.out.println("Вы не изменили свой выбор и...");
                Thread.sleep(1000);
                if (choiceDoor == victoryDoor) {
                    ++notChangeCounter;
                    view.printVictory();
                } else view.printLoose();
            }
            case (1) -> {
                System.out.println("Вы изменили свой выбор и ...");
                Thread.sleep(1000);
                playerService.removeDoor(choiceDoor);
                playerService.removeDoor(looseDoor);
                Door choiceDoor2 = playerService.getDoors().get(0);
                if (choiceDoor2 == victoryDoor) {
                    ++changeCounter;
                    view.printVictory();
                } else view.printLoose();
            }
        }
    }
    public int getChangeCounter(){
        return changeCounter;
    }
    public int getNotChangeCounter(){
        return notChangeCounter;
    }
}



