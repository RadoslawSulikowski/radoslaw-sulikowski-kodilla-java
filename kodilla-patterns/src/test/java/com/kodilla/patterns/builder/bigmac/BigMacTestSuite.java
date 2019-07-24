package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;
import static com.kodilla.patterns.builder.bigmac.BigMac.*;

public class BigMacTestSuite {
    @Test
    public void testBigMacNew(){
        //Given
        BigMac bigmac = new BigMacBuilder()
                .ingredient(ONION)
                .bun(SESAME)
                .burgers(5)
                .sauce(BARBECUE)
                .ingredient(SHRIMPS)
                .ingredient(CHILI_PEPPERS)
                .ingredient(PICKLE)
                .ingredient(LETTUCE)
                .ingredient(MUSHROOMS)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(6, howManyIngredients);
    }
}
