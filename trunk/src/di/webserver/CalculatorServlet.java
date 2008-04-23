package di.webserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;

@SuppressWarnings("serial")
public class CalculatorServlet extends HttpServlet {
  
  private final Calculator calculator;

  @Inject
  public CalculatorServlet(Calculator calculator) {
    this.calculator = calculator;
    System.out.println("http://localhost:8080/calc?op=add&a=1&b=2");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    float a = Float.parseFloat(req.getParameter("a"));
    float b = Float.parseFloat(req.getParameter("b"));
    float result = calculator.calculate(req.getParameter("op"), a, b);
    PrintWriter writer = resp.getWriter();
    writer.println("result = " + result);
    writer.flush();
  }

}
