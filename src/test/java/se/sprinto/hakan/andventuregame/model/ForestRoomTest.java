package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.ForestRoom;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.UI;
import se.sprinto.hakan.andventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest {

    @Test
    public void testEnterRoom() {
        ForestRoom forestRoom = new ForestRoom();
        Player player = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        forestRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasFoundKey());
        assertEquals(20, player.getScore());


    }
}
