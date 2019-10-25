package com.codingtest.atos.generate;

import com.codingtest.atos.datastructure.*;

/**
 * Created by shivarajn on 10/24/2019.
 */
public class GenerateMaterial {

    public enum MaterialType {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE, TEXTBOX;
    }

    public static Materials generateMaterial(MaterialType materialType){

        Materials materials=null;
        switch(materialType){
            case CIRCLE:
                materials=new Circle(10,10,10);
                break;
            case ELLIPSE:
                materials=new Ellipse(10,10,10,10);
                break;
            case RECTANGLE:
                materials=new Rectangle(10,10,10,10);
                break;
            case SQUARE:
                materials=new Square(10,10,10);
                break;
            case TEXTBOX:
                materials=new Textbox(10,10,-110,10);
                break;
        }
        if(materials==null)
            throw new RuntimeException("Material Type "+materialType+" not covered");
        return materials;
    }
}
