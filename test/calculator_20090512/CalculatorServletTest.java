package calculator_20090512;

import calculator_20090512.Calculator;
import calculator_20090512.CalculatorServlet;

import org.jmock.integration.junit3.MockObjectTestCase;

import java.util.HashMap;

public class CalculatorServletTest extends MockObjectTestCase {

  Calculator calculator;
  CalculatorServlet calculatorServlet = new CalculatorServlet();
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    calculator = mock(Calculator.class);
  }
  
  public void testAdditionOfTwoInts() throws Exception {
    HashMap<String, String[]> params = new HashMap<String, String[]>();
    params.put("num1", new String[] {"5"});
    params.put("num2", new String[] {"2"});
    params.put("oper", new String[] {"+"});
    
    String response = calculatorServlet.calculate(params);
    assertEquals("7", response);
  }
  
  
  public void testAdditionOfNegativeInts() throws Exception {
    HashMap<String, String[]> params = new HashMap<String, String[]>();
    params.put("num1", new String[] {"-5"});
    params.put("num2", new String[] {"2"});
    params.put("oper", new String[] {"+"});
    
    String response = calculatorServlet.calculate(params);
    assertEquals("-3", response);
  }
  
  
}
