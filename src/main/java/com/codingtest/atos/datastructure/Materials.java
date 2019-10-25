package com.codingtest.atos.datastructure;

/**
 * Created by Chronos on 10/24/2019.
 */
public abstract class Materials {
    Integer positionX;
    Integer positionY;

    public Materials(Integer positionX,Integer positionY){
        if(positionX<0||positionY<0)
            throw new RuntimeException("Positions should be positive values. positionX : "
                    +positionX+", positionY : "+positionY);
        this.positionX=positionX;
        this.positionY=positionY;
    }

    public abstract String generate();
}
