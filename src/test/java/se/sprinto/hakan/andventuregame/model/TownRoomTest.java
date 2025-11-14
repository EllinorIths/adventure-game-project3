package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.TownRoom;
import se.sprinto.hakan.andventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TownRoomTest {

    @Test
    public void testEnterRoom() {
        TownRoom townRoom = new TownRoom();
        Player player = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(30) //Förutsatt att styrkan har ökat (av boken och svärdet), villkor för att kunna besegra trollet
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        townRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasDefeatedTroll());

    }

}
