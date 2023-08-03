package io.github.teamgensouspark.kekkai.color.builder;

import java.awt.Color;

public class KekkaiColor {
    Color normal;
    Color darker;
    Color brighter;

    public KekkaiColor(Color color) {
        this.normal = color;
        this.brighter = color.brighter();
        this.darker = color.darker();
    }
    
    public KekkaiColor getDarkderColor() {
        return KekkaiColor.fromColor(darker);
    }

    public KekkaiColor getBrighterColor() {
        return KekkaiColor.fromColor(brighter);
    }
    
    public int getRGB(){
        return normal.getRGB();
    }

    public static KekkaiColor fromRGB(int red, int green, int blue) {
        return new KekkaiColor(new Color(red, green, blue));
    }

    public static KekkaiColor fromRGB(int color) {
        return new KekkaiColor(new Color(color));
    }

    public static KekkaiColor fromColor(Color color) {
        return new KekkaiColor(color);
    }

}
