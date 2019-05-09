package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuit {
    @Rule
    public TestName name = new TestName();
    @Before
    public void befor() {
        System.out.println("Test Case: " + name.getMethodName() + " - begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: " + name.getMethodName() + " - end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> result = exterminator.exterminate(emptyList);
        //Then
        Assert.assertEquals(emptyList, result);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> result = exterminator.exterminate(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 2, 4, 5, 6, 7, 8, 9)));
        //Then
        Assert.assertEquals(Arrays.asList(2, 4, 6, 8), result);
    }

}
