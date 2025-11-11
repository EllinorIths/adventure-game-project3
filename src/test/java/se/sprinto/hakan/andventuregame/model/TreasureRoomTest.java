package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.TreasureRoom;
import se.sprinto.hakan.andventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureRoomTest {

    @Test
    public void testEnterRoom() {
        TreasureRoom treasureRoom = new TreasureRoom();
        Player player = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(10)
                .foundKey(true) //satt till true för att förutsätta att spelaren har nyckeln
                .defeatedEnemy(false)
                .openedChest(false)
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        treasureRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasOpenedChest());
        assertEquals(100, player.getScore());


    }

}
