package singleton;

import com.kodilla.patterns.singleton.SettingsFileEngine;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsFileEngineTestSuite {

    @BeforeClass
    public static void openSettingsFile(){
        SettingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile(){
        SettingsFileEngine.getInstance().close();
    }

    @Test
    public void testGetFileName(){
        //When
        //Then
        String filename = SettingsFileEngine.getInstance().getFileName();
        System.out.println("Opened " + filename);
        //
        Assert.assertEquals("myapp.settings", filename);
    }

    @Test
    public void testLoadSettings(){
        //When
        //Then
        boolean result = SettingsFileEngine.getInstance().loadSettings();
        //
        Assert.assertTrue(result);
    }

    @Test
    public void testSaveSettings(){
        //When
        //Then
        boolean result = SettingsFileEngine.getInstance().saveSettings();
        //
        Assert.assertTrue(result);
    }
}
