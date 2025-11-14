package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        //Ändrat nedan så meddelandena visar uppdaterad version och författare från properties-filen
        ui.showMessage("Version: " + AppInfo.getInstance().getProperty("app.version"));
        ui.showMessage("Författare: " + AppInfo.getInstance().getProperty("app.author"));
        String name = ui.getInput("Ange ditt namn:");
        Player player = new Player.Builder() //Ändrat konstruktorn till builder pattern
                .name(name)
                .health(100)
                .score(0)
                .strength(10)
                .foundKey(false)
                .defeatedGoblin(false)
                .defeatedBook(false)
                .openedChest(false)
                .defeatedTroll(false)
                .build();

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

