import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class class_update3 extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException, IOException
	{
		final String URL = "jdbc:mysql://localhost/nhs90416db?useUnicode=true&characterEncodi ng=UTF-8";
		final String USER = "root";
		final String PASSWORD = "";
		final String DRIVER = "org.gjt.mm.mysql.Driver";
		Connection con = null;
		Statement stmt = null;
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter();
		
		String class_noStr = req.getParameter( "CLASS_NO" );
		String syusseki_noStr = req.getParameter( "SYUSSEKI_NO" );
		String gakuseki_noStr = req.getParameter( "GAKUSEKI_NO" );
		String simei_1Str = req.getParameter( "SIMEI_1" );
		String simei_2Str = req.getParameter( "SIMEI_2" );
		String kana_1Str = req.getParameter( "KANA_1" );
		String kana_2Str = req.getParameter( "KANA_2" );
		String umareStr = req.getParameter( "UMARE" );
		
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = con.createStatement();

			StringBuffer  query = new StringBuffer();
			query.append("UPDATE class_table SET class_no = '");
			query.append(class_noStr);
			query.append("',syusseki_no = '");
			query.append(syusseki_noStr);
			query.append("',gakuseki_no = '");
			query.append(gakuseki_noStr);
			query.append("',simei_1 = '");
			query.append(simei_1Str);
			query.append("',simei_2 = '");
			query.append(simei_2Str);
			query.append("',kana_1 = '");
			query.append(kana_1Str);
			query.append("',kana_2 = '");
			query.append(kana_2Str);
			query.append("',umare = '");
			query.append(umareStr);
			query.append("' WHERE gakuseki_no = '");
			query.append(gakuseki_noStr);
			query.append("'");
			stmt.executeUpdate(query.toString());
			
			StringBuffer  sb = new StringBuffer();
			sb.append("<html>");
			sb.append("<head><title>名簿変更</title></head>");
			sb.append("<body bgcolor='#ffffff'>");
			sb.append("update3.java");
			sb.append("<center>");
			sb.append("<CAPTION><FONT SIZE='+3' COLOR='#0000FF'>");
			sb.append("<B>");
			sb.append("＜＜名簿変更 ＞＞");
			sb.append("</B></FONT></CAPTION>");
			sb.append("<BR><BR><BR>");
			sb.append("<h1>");
			sb.append("名簿変更完了しました。");
			sb.append("</h1>");
			sb.append("</center><br><br>");
			sb.append("<HR><A HREF='../class_update.html'>");
			sb.append("名簿変更に戻る");
			sb.append("</A>");
			sb.append("<A HREF='../class_index.html'>");
			sb.append("ホームへ戻る");
			sb.append("</A>");
			sb.append("</body>");
			sb.append("</html>");
			out.println(sb.toString());
			
			
			stmt.close();
			con.close();
			
		}
		
		catch (SQLException ex)
		{
			out.println( " --- SQL Exception --" + "<BR>" );
			out.println( "Message   : " + "<BR>" );
			while(ex != null)
			{
				out.println( ex.getMessage() + "<BR>" );
				ex = ex.getNextException();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace (out);
		}
	}
}