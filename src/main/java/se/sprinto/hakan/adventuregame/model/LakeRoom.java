package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class LakeRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner mot en stillsam sjö. Fiskar hoppar i vattnet.");
        String choice = ui.getInput("Vill du prova att fiska? (ja/nej)");
        if(choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Du sätter dig vid sjön med ett metspö. " +
                    "Efter en stund har du dragit upp en fisk som du grillar över öppen eld.");
            player.addHealth(10);
            player.addScore(20);
            ui.showMessage("Din hälsa ökar! Din HP: " + player.getHealth());
        } else {
            ui.showMessage("Du lämnar sjön.");
        }
    }
}
