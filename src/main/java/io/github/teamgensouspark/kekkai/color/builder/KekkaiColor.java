package io.github.teamgensouspark.kekkai.color.builder;

import java.awt.Color;

public class KekkaiColor {
    private Color normal;
    private Color darker;
    private Color brighter;

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

    public Integer getRGB() {
        return normal.getRGB();
    }

    public String getHEX() {
        Color rgb = new Color(getRGB());
        return String.format("#%02X%02X%02X", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    public static KekkaiColor fromRGB(int red, int green, int blue) {
        return new KekkaiColor(new Color(red, green, blue));
    }

    public static KekkaiColor fromRGB(int color) {
        return new KekkaiColor(new Color(color));
    }

    public static KekkaiColor fromHEX(String color) {
        return new KekkaiColor(Color.decode(color));
    }

    public static KekkaiColor fromColor(Color color) {
        return new KekkaiColor(color);
    }

}
