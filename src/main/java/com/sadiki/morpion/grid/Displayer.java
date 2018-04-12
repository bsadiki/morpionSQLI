package com.sadiki.morpion.grid;

import com.sadiki.morpion.Morpion;
import com.sadiki.morpion.grid.box.Box;

public class Displayer {
    String display(Box[][] boxesMatrix) {
        StringBuilder display = new StringBuilder();
        for (Box[] boxes : boxesMatrix) {
            for (Box box : boxes) {
                display.append(box.display());
                display.append("|");
            }
            display.deleteCharAt(display.length() - 1);
            display.append(Morpion.LINE_SEPARATOR);
        }
        return display.toString();
    }
}
