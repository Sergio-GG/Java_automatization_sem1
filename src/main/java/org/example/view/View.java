package org.example.view;

import org.example.domain.Door;

import java.util.List;

public class View {

    public void startGame(){
        System.out.println("Игра началась!");
    }
    public void printVictory(){
        System.out.println("Вы угадали дверь");
    }
    public void printLoose(){
        System.out.println("Вы не угадали дверь");
    }
    public void chooseDoor(){
        System.out.println("Выберите дверь");
    }
    public void changeDoor(){
        System.out.println("Желаете сменить дверь?д/н");
    }

    public void showDoors(List<Door> doors){
        System.out.println("Перед вами двери: ");
        System.out.println(doors);
    }
    public void showLooseDoor(Door door){
        System.out.println("Открываем дверь с козой: ");
        System.out.println(door);
    }

    public void showChoiceDoor(Door door){
        System.out.println("Вы выбрали дверь: " + door);
    }

}
