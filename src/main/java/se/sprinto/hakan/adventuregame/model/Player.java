package se.sprinto.hakan.adventuregame.model;

public class Player extends AbstractCharacter {
    private boolean foundKey;
    private boolean defeatedGoblin;
    private boolean defeatedBook;
    private boolean openedChest;
    private boolean defeatedTroll;

    private Player(Builder builder) /*bytt ut parametrarna mot buildern */ {
        super(builder.name, builder.health, builder.score, builder.strength); /* lagt till builder framför  */
        this.foundKey = builder.foundKey;
        this.defeatedGoblin = builder.defeatedGoblin;
        this.defeatedBook = builder.defeatedBook;
        this.openedChest = builder.openedChest;
        this.defeatedTroll = builder.defeatedTroll;
    }

    public boolean hasFoundKey() {
        return foundKey;
    }

    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
    }

    public boolean hasDefeatedGoblin() {
        return defeatedGoblin;
    }

    public void setDefeatedGoblin(boolean defeatedGoblin) {
        this.defeatedGoblin = defeatedGoblin;
    }

    public boolean hasDefeatedBook() { return defeatedBook; }

    public void setDefeatedBook(boolean defeatedBook) { this.defeatedBook = defeatedBook; }

    public boolean hasOpenedChest() {
        return openedChest;
    }

    public void setOpenedChest(boolean openedChest) {
        this.openedChest = openedChest;
    }

    public boolean hasDefeatedTroll() {return defeatedTroll; }

    public void setDefeatedTroll(boolean defeatedTroll) {this.defeatedTroll = defeatedTroll;}

    public boolean hasWon() {
        return foundKey && openedChest && defeatedTroll;
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (!target.isAlive()) {
            addScore(50);
        }
    }

    //Lagt till builder för Player nedan
        public static class Builder {
        private String name;
        private int health;
        private int score;
        private int strength;
        private boolean foundKey;
        private boolean defeatedGoblin;
        private boolean defeatedBook;
        private boolean openedChest;
        private boolean defeatedTroll;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder health(int health) {
            this.health = health;
            return this;
        }

        public Builder score(int score) {
            this.score = score;
            return this;
        }

        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder foundKey(boolean foundKey) {
            this.foundKey = foundKey;
            return this;
        }

        public Builder defeatedGoblin(boolean defeatedGoblin) {
            this.defeatedGoblin = defeatedGoblin;
            return this;
        }

        public Builder defeatedBook(boolean defeatedBook) {
            this.defeatedBook = defeatedBook;
            return this;
        }

        public Builder openedChest(boolean openedChest) {
            this.openedChest = openedChest;
            return this;
        }

        public Builder defeatedTroll(boolean defeatedTroll) {
            this.defeatedTroll = defeatedTroll;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }
}
