package pl.edu.ug.tent.springweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    out.println("<html><body>");
    out.println("<form action='/calc' method='POST'>");
    out.println("<input type='text' name='liczba1'>");
    out.println("<input type='text' name='liczba2'>");
    out.println("</form><table><tr>");
    out.println("<form action='/calc' method='POST'>");
    out.println("<td><label for='plus'>+</label><input type='radio' name='maths' id='plus' value='+'</td>");
    out.println("<td><label for='minus'>-</label><input type='radio' name='maths' id='minus' value='-'</td>");
    out.println("<td><label for='star'>*</label><input type='radio' name='maths' id='star' value='*'</td>");
    out.println("<td><label for='slash'>/</label><input type='radio' name='maths' id='slash' value='/'</td>");
    out.println("</tr></form><tr>");
    out.println("<form action='/calc' method='POST'>");
    out.println("<td><input type='submit' name='result' value='='</td>");
    out.println("</tr></table></form>");
    out.println("</body></html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String number1 = req.getParameter("liczba1");
    String number2 = req.getParameter("liczba2");
    String maths = req.getParameter("maths");
    String zero = "Nie wolno dzielić przez 0!";
    String equals = "=";
    double b = 0;
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html><body>");
    out.println("<form action='/calc' method='POST'>");
    out.println("<input type='text' name='liczba1'>");
    out.println("<input type='text' name='liczb2'>");
    out.println("</form><table><tr>");
    out.println("<form action='/calc' method='POST'>");
    out.println("<td><label for='plus'>+</label><input type='radio' name='maths' id='plus' value='+'</td>");
    out.println("<td><label for='minus'>-</label><input type='radio' name='maths' id='minus' value='-'</td>");
    out.println("<td><label for='star'>*</label><input type='radio' name='maths' id='star' value='*'</td>");
    out.println("<td><label for='slash'>/</label><input type='radio' name='maths' id='slash' value='/'</td>");
    out.println("</tr></form><tr>");
    out.println("<form action='/calc' method='POST'>");
    out.println("<td><input type='submit' name='result' value='='</td>");
    out.println("</tr></table></form>");
    if (maths == "+"){
      b = plus(Double.valueOf(number1), Double.valueOf(number2));
      out.println("<h3>" + number1 + maths + number2 + equals + b + "</h3>");
    }
    if (maths == "-"){
      b = minus(Double.valueOf(number1), Double.valueOf(number2));
      out.println("<h3>" + number1 + maths + number2 + equals + b + "</h3>");
    }
    if (maths == "*"){
      b = star(Double.valueOf(number1), Double.valueOf(number2));
      out.println("<h3>" + number1 + maths + number2 + equals + b + "</h3>");
    }
    if (maths == "/"){
      if (Double.valueOf(number2) == 0) out.println("<h3>" + zero + "</h3>");
      else{
        b = slash(Double.valueOf(number1), Double.valueOf(number2));
        out.println("<h3>" + number1 + maths + number2 + equals + b + "</h3>");
      }
    }
    else out.println("<h3>" + "null" + "</h3>");
    out.println("</body></html>");

  }

  private double plus(double n1, double n2){
    return n1 + n2;
  }

  private double minus(double n1, double n2){
    return n1 - n2;
  }

  private double star(double n1, double n2){
    return n1 * n2;
  }

  private double slash(double n1, double n2){
    return n1 / n2;
  }

}

