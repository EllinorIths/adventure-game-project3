package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.LakeRoom;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.andventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LakeRoomTest {

    @Test
    public void enterRoomTest() {
        LakeRoom lakeRoom = new LakeRoom();
        Player player = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        lakeRoom.enterRoom(player, fakeUI);

        assertEquals(110, player.getHealth()); //Ursprungligen 100, får +10 av att fiska
        assertEquals(20, player.getScore());


    }
}
