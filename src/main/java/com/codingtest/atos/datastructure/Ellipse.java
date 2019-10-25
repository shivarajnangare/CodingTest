package com.codingtest.atos.datastructure;

/**
 * Created by Chronos on 10/24/2019.
 */
public class Ellipse extends Materials{

    Integer horizontalDiameter;
    Integer verticalDiameter;

    public Ellipse(Integer positionX, Integer positionY, Integer horizontalDiameter, Integer verticalDiameter){
        super(positionX,positionY);
        if(horizontalDiameter<0||verticalDiameter<0)
            throw new RuntimeException("HorizontalDiameter and VerticalDiameter of Ellipse should be positive values." +
                    " horizontalDiameter : "+horizontalDiameter+", verticalDiameter : "+verticalDiameter);
        this.horizontalDiameter=horizontalDiameter;
        this.verticalDiameter=verticalDiameter;
    }

    public String generate(){
        return "Ellipse ("+positionX+","+positionY+") diameterH="+horizontalDiameter+" diameterV="+verticalDiameter;
    }
}
