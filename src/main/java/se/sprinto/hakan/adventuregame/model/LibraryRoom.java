package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class LibraryRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går in i ett bibliotek med väggarna täckta av bokhyllor." +
                "Du öppnar en intressant bok men den slår igen på dina fingrar, det är en förtrollad bok! " +
                    "Boken attackerar!");
        Enemy book = new Enemy("Bok", 20, 0, 5);

        while (player.isAlive() && book.isAlive()) {
                String choice2 = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice2.equalsIgnoreCase("a")) {
                    player.attack(book);
                    ui.showMessage("Du attackerar boken! Bokens HP: " + book.getHealth());
                if (book.isAlive()) {
                        book.attack(player);
                        ui.showMessage("Boken attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                        ui.showMessage("Du besegrade boken!");
                        player.setDefeatedBook(true);
                        player.addStrength(10);
                        player.addScore(20);
                        ui.showMessage("Du läser boken, den handlar om avancerad stridskonst. " +
                                "Du känner dig starkare! Din styrka: " + player.getStrength());
                }
            } else if (choice2.equalsIgnoreCase("r")) {
                    ui.showMessage("Du springer därifrån!");
                    break;
            }
        }
    }
}
