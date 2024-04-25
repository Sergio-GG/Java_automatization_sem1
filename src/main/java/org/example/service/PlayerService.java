package org.example.service;

import org.example.domain.Door;
import org.example.domain.Player;

import java.util.List;

public class PlayerService {
    DoorService doorService;

    public PlayerService(DoorService doorService) {
        this.doorService = doorService;
    }

    public Door chooseDoor(int num){
        return doorService.getDoor(num - 1);
    }

    public List<Door> getDoors(){
        return doorService.getDoors();
    }

    public Door openLooseDoor(Door victoryDoor, Door choiceDoor){
        return doorService.getRandomDoor(victoryDoor, choiceDoor);
    }
    public void removeDoor(Door door){
        doorService.deleteDoor(door);
    }


}
