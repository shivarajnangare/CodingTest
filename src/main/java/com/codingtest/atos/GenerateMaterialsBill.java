package com.codingtest.atos;

import com.codingtest.atos.datastructure.Materials;
import com.codingtest.atos.generate.GenerateMaterial;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.FileHandler;

/**
 * Created by shivarajn on 10/24/2019.
 */
public class GenerateMaterialsBill {

    private static final Logger logger = LoggerFactory.getLogger(GenerateMaterialsBill.class);

    public static void main(String[] args) {

        try{
            Materials m = GenerateMaterial.generateMaterial(GenerateMaterial.MaterialType.CIRCLE);
            System.out.println(m.generate());
            Materials m1 = GenerateMaterial.generateMaterial(GenerateMaterial.MaterialType.TEXTBOX);
            System.out.println(m1.generate());
        }catch (Throwable e){
            logger.error(e.getMessage());
            System.out.println("+++++Abort+++++");
        }
    }
}
