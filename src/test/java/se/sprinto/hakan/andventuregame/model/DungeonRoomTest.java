package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.DungeonRoom;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.andventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DungeonRoomTest {

    @Test
    public void testEnterRoom() {
        DungeonRoom dungeonRoom = new DungeonRoom();
        Player player = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(10)
                .foundKey(false)
                .defeatedEnemy(false)
                .openedChest(false)
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        dungeonRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasDefeatedEnemy());

    }

}
