package di.webserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("serial")
public class TimeServlet extends HttpServlet {

  private final Provider<Date> dateProvider;

  @Inject
  public TimeServlet(Provider<Date> dateProvider) {
    this.dateProvider = dateProvider;
    System.out.println("http://localhost:8080/time");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    writer.println(dateProvider.get().toString());
  }
  
}
