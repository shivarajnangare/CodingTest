package com.codingtest.atos.datastructure;

/**
 * Created by shivarajn on 10/24/2019.
 */
public class Rectangle extends Materials{

    Integer width;
    Integer height;

    public Rectangle(Integer positionX,Integer positionY,Integer width,Integer height){
        super(positionX,positionY);
        if(width<0||height<0)
            throw new RuntimeException("Width and Height of Rectangle should be positive values." +
                    " width : "+width+", height : "+height);
        this.width=width;
        this.height=height;
    }

    public String generate(){
        return "Rectangle ("+positionX+","+positionY+") width="+width+" height="+height;
    }
}
