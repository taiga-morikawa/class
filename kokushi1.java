import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class kokushi1 extends HttpServlet{
  public void doPost(
    HttpServletRequest req,
    HttpServletResponse res)
    throws ServletException,IOException{
      PrintWriter out;
      req.setCharacterEncoding("UTF-8");
      res.setContentType("text/html;charset=UTF-8");
      out = res.getWriter();
      
      int gozen, gogo;
    //webブラウザのFormからパラメータを取得
      String namaeStr = req.getParameter("namae");
      String gakunenStr = req.getParameter("gakunen");
      String gozenStr = req.getParameter("gozen");
      String gogoStr = req.getParameter("gogo");

		gozen = Integer.parseInt(gozenStr);
		gogo = Integer.parseInt(gogoStr);
		
      //入力データの表示
      StringBuffer sb = new StringBuffer();
      sb.append("<HTML><BODY>");
      sb.append("param1.java");
      sb.append("<CENTER><h1>");
      sb.append("国家試験判定");
      sb.append("<br><br>");
      sb.append(gakunenStr + "の" + namaeStr + "さん");
      sb.append("<br><br>");
      sb.append("あなたの得点は");
      sb.append("<br><br>");
      sb.append("午前" + gozenStr + "点");
      sb.append("午後" + gogoStr + "点");
      sb.append("合計");
      sb.append(gozen + gogo);
      sb.append("点");
      if((gozen >= 65 && gogo >=65) && gogo + gogo >= 140){
      sb.append("判定結果は合格です");
      }else{
      sb.append("判定結果は不合格です");
      }
      
      out.println(sb.toString());
  }
}

      
      
      