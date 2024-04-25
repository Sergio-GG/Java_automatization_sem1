import org.example.domain.Door;
import org.example.service.DoorService;
import org.example.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlayerServiceTest {
    @Test
    public void checkChooseDoor(){
        //given
        DoorService doorService = mock(DoorService.class);
        when(doorService.getDoor(1)).thenReturn(new Door(1));
        //when
        PlayerService playerService = new PlayerService(doorService);
        Door door = playerService.chooseDoor(2);
        //then
        Assertions.assertEquals(1, door.getNumber());
    }
    @Test
    public void checkGetDoors(){
        //given
        DoorService doorService = mock(DoorService.class);
        when(doorService.getDoors()).thenReturn(Arrays.asList(new Door(1), new Door(2), new Door(3)));
        //when
        PlayerService playerService = new PlayerService(doorService);
        List<Door> doors = playerService.getDoors();
        //then
        Assertions.assertEquals(3, doors.size());
    }
    @Test
    public void checkOpenLooseDoor(){
        //given
        DoorService doorService = mock(DoorService.class);
        Door door1 = new Door(1);
        Door door2 = new Door(5);
        Door door3 = new Door(3);
        when(doorService.getRandomDoor(door1, door2)).thenReturn(door3);
        //when
        PlayerService playerService = new PlayerService(doorService);
        Door door = playerService.openLooseDoor(door1, door2);
        //then
        Assertions.assertEquals(3, door.getNumber());
    }
    @Test
    public void checkRemoveDoor() {
        //given
        DoorService doorService = mock(DoorService.class);
        List<Door> doors = new ArrayList<>();
        Door door1 = new Door(1);
        Door door2 = new Door(0);
        Door door3 = new Door(3);
        Door door4 = new Door(1);

        doors.add(door1);
        doors.add(door2);
        doors.add(door3);
        doors.add(door4);

        //when
        PlayerService playerService = new PlayerService(doorService);
        playerService.removeDoor(door4);
        //then
        verify(doorService, times(1)).deleteDoor(door4);
    }
}
