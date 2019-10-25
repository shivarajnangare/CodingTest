package com.codingtest.atos.datastructure;

/**
 * Created by Chronos on 10/24/2019.
 */
public class Circle extends Materials{

    Integer diameter;

    public Circle(Integer positionX,Integer positionY,Integer diameter){
        super(positionX,positionY);
        if(diameter<0)
            throw new RuntimeException("Diameter of Circle should be positive values. diameter : "
                    +diameter);
        this.diameter=diameter;
    }

    public String generate(){
        return "Circle ("+positionX+","+positionY+") size="+diameter;
    }
}
