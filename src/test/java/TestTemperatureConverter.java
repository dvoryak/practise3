import entity.TemperatureConverter;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TestTemperatureConverter {
    private static TemperatureConverter converter;

    @BeforeClass
    public static void init() {
        converter = new TemperatureConverter();
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {25.0,77.0,298.15},{50.0,122.0,323.15},
                {90.0,194.0,363.15},{22.0,71.6,295.15},
                {40.0,104.0,313.15},{60.0,140.0,333.15}
        });
    }

    @Parameterized.Parameter
    public double celsius;

    @Parameterized.Parameter(1)
    public double fahrenheit;

    @Parameterized.Parameter(2)
    public double kelvin;


    @Test
    public void convertFtoC() {
        double result = converter.convertFtoC(fahrenheit);
        assertEquals("convertFtoC failed",celsius,result,0.1);
    }

    @Test
    public void convertFtoK() {
        double result = converter.convertFtoK(fahrenheit);
        assertEquals("convertFtoK failed",kelvin,result,0.1);
    }

    @Test
    public void convertCtoF() {
        double result = converter.convertCtoF(celsius);
        assertEquals("convertCtoF failed",fahrenheit,result,0.1);
    }

    @Test
    public void convertCtoK() {
        double result = converter.convertCtoK(celsius);
        assertEquals("convertCtoK failed",kelvin,result,0.1);
    }

    @Test
    public void convertKtoC() {
        double result = converter.convertKtoC(kelvin);
        assertEquals("convertKtoC failed",celsius,result,0.1);
    }

    @Test
    public void convertKtoF() {
        double result = converter.convertKtoF(kelvin);
        assertEquals("convertKtoF failed",fahrenheit,result,0.1);
    }
}
