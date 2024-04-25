import org.example.domain.Door;
import org.example.service.DoorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DoorServiceTest {

    @Test
    public void checkDoorsSize(){
        //given
        DoorService doorService = new DoorService();
        //when
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(1));
        doors.add(new Door(2));
        doors.add(new Door(3));
        //then
        Assertions.assertEquals(doors.size(), doorService.getDoors().size());
    }

    @Test
    public void checkDeleteDoor(){
        //given
        DoorService doorService = new DoorService();
        //when
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(1));
        doors.add(new Door(2));
        doors.add(new Door(3));
        doors.add(new Door(4));
        doors.remove(3);
        //then
        Assertions.assertEquals(doors.size(), doorService.getDoors().size());
    }
    @Test
    public void checkGetDoor(){
        //given
        DoorService doorService = new DoorService();
        //when
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(1));
        doors.add(new Door(2));
        doors.add(new Door(3));

        //then
        Assertions.assertEquals(doors.get(2).getNumber(), doorService.getDoors().get(2).getNumber());
    }
    @Test
    public void checkGetLooseDoor(){
        //given
        DoorService doorService = new DoorService();
        //when
        Door looseDoor = doorService.getRandomDoor(doorService.getDoor(0), doorService.getDoor(1));
        //then
        Assertions.assertEquals(3, looseDoor.getNumber());
    }
}
