package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.LibraryRoom;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.andventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryRoomTest {

    @Test
    public void testEnterRoom() {
        LibraryRoom libraryRoom = new LibraryRoom();
        Player player = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        libraryRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasDefeatedBook());
        assertEquals(20, player.getStrength()); //10 från början + 10 av att läsa boken

    }
}
