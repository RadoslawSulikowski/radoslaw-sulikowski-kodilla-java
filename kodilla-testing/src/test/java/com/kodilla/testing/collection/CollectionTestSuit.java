package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;

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
        ArrayList<Integer> result = exterminator.exterminate(new ArrayList(){{add(1); add(2); add(3); add(4); add(5); add(6); add(7); add(8); add(9); }});
        //Then
        Assert.assertEquals(new ArrayList(){{add(2); add(4); add(6); add(8);}}, result);
    }

}
