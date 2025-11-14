package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class TownRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner mot stadens centrum. Ett jättelikt, " +
                "elakt troll står mitt på torget och terroriserar stadens invånare!");
        Enemy troll = new Enemy("Troll", 100, 0, 20);

        while (player.isAlive() && troll.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(troll);
                ui.showMessage("Du attackerar trollet! Trollets HP: " + troll.getHealth());
                if (troll.isAlive()) {
                    troll.attack(player);
                    ui.showMessage("Trollet attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade trollet! Stadens invånare hyllar dig som en hjälte!");
                    player.setDefeatedTroll(true);
                    player.addScore(100);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}
