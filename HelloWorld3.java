import java.io.*; //import パッケージ.クラス;
import javax.servlet.*;//(*)はすべてのクラス
import javax.servlet.http.*;
public class HelloWorld3 extends HttpServlet{//extends(継承)HttpServlet(サーブレットの場合のクラス)
  public void doGet(//Getで送ってGetで送る
      HttpServletRequest req,//クラスのインスタンス化
      HttpServletResponse res )
         throws ServletException, IOException{
    PrintWriter out;
    req.setCharacterEncoding("UTF-8");
    res.setContentType("text/html;charset=UTF-8");
    out = res.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>Hello World</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("    <center><h1>Hello World!!</h1>");
    out.println("    <br><br>");
    out.println("ようこそ　JAVAの世界へ");
    out.println("    </center><br>");
    out.println("    <a href='../helloworld.html'>");
    out.println("トップへ戻る");
    out.println("    </a>");
    out.println("  </body>");
    out.println("</html>");
  }
}
