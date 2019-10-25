package com.codingtest.atos.datastructure;

/**
 * Created by Chronos on 10/24/2019.
 */
public class Textbox extends Materials {

    Integer width;
    Integer height;
    String text;

    public Textbox(Integer postionX, Integer positionY, Integer width, Integer height) {
        super(postionX, positionY);
        this.width = width;
        this.height = height;
        if(width<0||height<0)
            throw new RuntimeException("width and height of Textbox should be positive values." +
                    " width : "+width+", height : "+height);
        this.text = "";
    }

    public Textbox(Integer postionX, Integer positionY, Integer width, Integer height, String text) {
        super(postionX, positionY);
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public String generate() {
        if (text == null || text.isEmpty())
            return "Textbox (" + positionX + "," + positionY + ") width=" + width + " height=" + height;
        else
            return "Textbox (" + positionX + "," + positionY + ") width=" + width + " height=" + height + "text=" + text;
    }
}
