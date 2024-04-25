package org.example.service;

import org.example.domain.Door;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoorService {
    List<Door> doors = new ArrayList<>();

    public DoorService() {
        this.doors = createDoors();
    }

    private List<Door> createDoors(){
        doors.add(new Door(1));
        doors.add(new Door(2));
        doors.add(new Door(3));
        return doors;
    }

    public void deleteDoor(Door door){
        doors.remove(door);
    }

    public Door getDoor(int doorNum){
        return doors.get(doorNum);
    }

    public List<Door> getDoors(){
        return doors;
    }

    public Door getRandomDoor(Door victoryDoor, Door choiceDoor){
        Random random = new Random();
        int number;
        while (true){
            number = 1 + random.nextInt(3);
            if((doors.get(number - 1)) == victoryDoor || (doors.get(number - 1)) == choiceDoor ){
                continue;
            }else break;
        }
        return doors.get(number - 1);
    }
}
