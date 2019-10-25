package com.codingtest.atos;

import com.codingtest.atos.datastructure.Materials;
import com.codingtest.atos.generate.GenerateMaterial;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chronos on 10/24/2019.
 */
public class TestMaterialGeneration {

    @Test
    public void ValidResult(){
        Materials m = GenerateMaterial.generateMaterial(GenerateMaterial.MaterialType.CIRCLE);

        Assert.assertEquals("Circle (10,10) size=10",m.generate());
    }

    @Test(expected = RuntimeException.class)
    public void GenerateException(){
        Materials m = GenerateMaterial.generateMaterial(GenerateMaterial.MaterialType.TEXTBOX);
    }
}
