package com.codingtest.atos.datastructure;

/**
 * Created by shivarajn on 10/24/2019.
 */
public class Square extends Materials{

    Integer width;

    public Square(Integer positionX,Integer positionY,Integer width){
        super(positionX,positionY);
        if(width<0)
            throw new RuntimeException("Width of Square should be positive values." +
                    " width : "+width);
        this.width=width;
    }

    public String generate(){
        return "Square ("+positionX+","+positionY+") size="+width;
    }
}
