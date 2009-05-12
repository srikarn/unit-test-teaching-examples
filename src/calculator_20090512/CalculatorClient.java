package calculator_20090512;

public class CalculatorClient {

  /**
   * @param args
   * @throws Exception 
   */
  public static void main(String[] args) throws Exception {
    Server server = new Server();
    server.start(8080);
    
  }

}
