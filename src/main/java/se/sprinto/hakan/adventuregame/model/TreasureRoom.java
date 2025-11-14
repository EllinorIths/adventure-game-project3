package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class TreasureRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du hittar en skattkista. Den verkar låst...");

        String choice = ui.getInput("Vill du försöka öppna kistan? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            if (player.hasFoundKey()) {
                player.setOpenedChest(true);
                player.addStrength(10);
                player.addScore(100);
                ui.showMessage("Du öppnar kistan med din nyckel! Den innehöll ett nytt svärd! " +
                        "Din styrka ökar! Din styrka: " + player.getStrength());

            } else {
                ui.showMessage("Kistan är låst, du saknar nyckeln...");
            }
        } else {
            ui.showMessage("Du lämnar kistan orörd.");
        }
    }
}
