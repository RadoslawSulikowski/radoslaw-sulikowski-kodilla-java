package singleton;

import com.kodilla.patterns.singleton.Logger;
import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog(){
        //Given
        Logger.getInstance().log("First log");
        //When
        String resultLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("First log", resultLog);
    }

}
