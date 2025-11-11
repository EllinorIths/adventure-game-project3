package se.sprinto.hakan.andventuregame.view;

import se.sprinto.hakan.adventuregame.view.UI;

public class FakeUI implements UI {
    private String input;
    @Override
    public void showMessage(String message) {

    }

    public void setInput(String input) {

        this.input = input;
    }

    @Override
    public String getInput(String prompt) {
        return input;
    }

}
