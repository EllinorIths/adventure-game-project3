package se.sprinto.hakan.andventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Enemy;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testAttack() {

        Player player  = new Player.Builder()
                .name("name")
                .health(100)
                .score(0)
                .strength(10)
                .foundKey(false)
                .defeatedEnemy(false)
                .openedChest(false)
                .build();

        Enemy enemy = new Enemy("Vätte", 20, 0, 5 );

        player.attack(enemy);

        assertEquals(10, enemy.getHealth());


    }

}
