package calculator_20090512;

import calculator_20090512.Server;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Random;

public class ServerTest extends TestCase {

  private Server calculatorServer;
  
  private int port = 4040;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    calculatorServer = new Server();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    calculatorServer.stop();
  }
  
  public void testServerIsUp() throws Exception {
    assertTrue(calculatorServer.isHealthy());
    calculatorServer.start(port);
    Socket calculatorSocket = new Socket(InetAddress.getLocalHost(), port);
  }
  
  public void testHealthRequestReturnsOk() throws Exception {
    calculatorServer.start(port);
    HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:" + port + "/healthz").openConnection();
    connection.connect();
    String response = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
    assertEquals("OK", response);
  }
  
  public void testServletForCalculatorExists() throws Exception {
    calculatorServer.start(port);
    int int1 = new Random().nextInt(10);
    HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:" + port + "/calc?num1=3&num2=" + int1 +"&oper=%2B").openConnection();
    connection.connect();
    String response = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
    assertEquals(String.valueOf(3 + int1), response);
  }
}
