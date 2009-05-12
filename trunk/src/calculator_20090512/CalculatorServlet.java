package calculator_20090512;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
  resp.getWriter().println(calculate(req.getParameterMap()));
}

public String calculate(Map<String, String[]> hashMap) {
  // TODO Auto-generated method stub
  String[] op = hashMap.get("oper");
  if (op[0].equals("+")) {
    return String.valueOf(Integer.parseInt(hashMap.get("num1")[0]) +
           Integer.parseInt(hashMap.get("num2")[0]));
  } else {
    throw new UnsupportedOperationException("Operation " + op[0] 
        + "not supported yet");
  }
}
}
