package com.application.generateGame;

public class Card {
    public String icon;
    public boolean isVisible = false;
    public int position;

    public void setIcon(String icon) { this.icon = icon; }
    public void setVisible(boolean isVisible) { this.isVisible = isVisible; }
    public void setPosition(int position) { this.position = position; }
}
