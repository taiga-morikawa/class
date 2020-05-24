import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class class_select extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res )
	throws ServletException, IOException
	{     
		
		final String URL = "jdbc:mysql://localhost/nhs90416db?useUnicode=true&characterEncoding=UTF-8";
		final String USER = "root";     
		final String PASSWORD = "";
		final String DRIVER = "org.gjt.mm.mysql.Driver";
		
		
		
		Connection con = null;
		Statement stmt = null;
		
		String  class_no,syusseki_no,gakuseki_no,simei_1,simei_2,kana_1,kana_2,umare;
		
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter(); 
		
		String select_idStr = req.getParameter( "SELECT_ID" );
		String class_noStr = req.getParameter("CLASS_NO");
		String gakunen_noStr = req.getParameter("GAKUNEN_NO");
		String teacher_noStr = req.getParameter("teacher_no");
		
		StringBuffer  sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head><title>クラス名簿検索</title></head>");
		sb.append("<body bgcolor='#ffffff'>");
		sb.append("class_select.java");
		sb.append("<center>");
		sb.append("<CAPTION><FONT SIZE='+3' COLOR='#0000FF'>");
		sb.append("<B>");
		sb.append("＜ ＜ クラス名簿検索 ＞ ＞");     
		sb.append("</B></FONT></CAPTION>");
		sb.append("<BR><BR><BR>");
		if(select_idStr.equals("1"))
		{
			sb.append("  <font size='+2'>");
			sb.append("検索結果　クラス:");
			sb.append("</font>");
			sb.append(" <font size='+2' color='deeppink'>");
			sb.append(class_noStr);
			sb.append("</font>");
			sb.append("<br><br>");
			sb.append("<table border='1' bordercolor='darkblue'>");
			sb.append("  <tr>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("出席");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("学籍");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("氏名(性)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("氏名(名)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("カナ(性)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("カナ(名)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("生年月日");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("   </tr>");
			
		}
		
		else
		{
			sb.append("<font size='+2'>");
			sb.append("検索結果　クラス:");
			sb.append("</font>");
			sb.append(" <font size='+2' color='deeppink'>");
			sb.append(gakunen_noStr);
			sb.append("年");
			sb.append("</font>");
			sb.append("<br><br>");
			sb.append("<table border='1' bordercolor='darkblue'>");
			sb.append("  <tr>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("クラス");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("出席");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("学籍");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("氏名(性)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("氏名(名)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("カナ(性)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("カナ(名)");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("    <td bgcolor='darkblue'>");
			sb.append("      <font color='white'>");
			sb.append("生年月日");
			sb.append("      </font>");
			sb.append("    </td>");
			sb.append("   </tr>");
		}
		
		try
		{
			//MySQL Driverローディング
			Class.forName(DRIVER);
			
			//MySQLへの接続
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			
			//SQL 格納
			stmt = con.createStatement();
			
			//SQL 実行
			StringBuffer  query = new StringBuffer();
			if(select_idStr.equals("1"))
			{
				query.append(" SELECT * FROM class_table WHERE class_no = '");
				query.append(class_noStr);
				query.append("' ORDER BY syusseki_no");
				
				System.out.print(query);
				
				ResultSet rs = stmt.executeQuery(query.toString());
				//class_no,syusseki_no,gakuseki_no,simei_1,simei_2,kana_1,kana_2,umare;
				//検索結果 取得
				while( rs.next() )
				{
					syusseki_no   = rs.getString ( "syusseki_no" );
					gakuseki_no   = rs.getString ( "gakuseki_no" );
					simei_1       = rs.getString ( "simei_1" );
					simei_2       = rs.getString ( "simei_2" );
					kana_1        = rs.getString ( "kana_1" );
					kana_2        = rs.getString ( "kana_2" );
					umare         = rs.getString ( "umare" );
					
					sb.append("  <tr>");
					sb.append("    <td>");
					sb.append(        syusseki_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        gakuseki_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        simei_1);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        simei_2);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        kana_1);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        kana_2);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        umare);
					sb.append("    </td>");
						sb.append("  </tr>");
				}
			}
			else if(select_idStr.equals("2"))
			{
				query.append(" SELECT * FROM class_table WHERE class_no like '");
				query.append("___");
				query.append(gakunen_noStr);
				query.append("%");
				query.append("'");
				query.append("ORDER BY class_no,syusseki_no");
				
				ResultSet rs = stmt.executeQuery(query.toString());
				
				//検索結果 取得
				while( rs.next() )
				{
					class_no      = rs.getString ("class_no");
					syusseki_no   = rs.getString ( "syusseki_no" );
					gakuseki_no   = rs.getString ( "gakuseki_no" );
					simei_1       = rs.getString ( "simei_1" );
					simei_2       = rs.getString ( "simei_2" );
					kana_1        = rs.getString ( "kana_1" );
					kana_2        = rs.getString ( "kana_2" );
					umare         = rs.getString ( "umare" );
					
					sb.append("  <tr>");
					sb.append("    <td>");
					sb.append(        class_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        syusseki_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        gakuseki_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        simei_1);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        simei_2);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        kana_1);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        kana_2);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        umare);
					sb.append("    </td>");
					sb.append("  </tr>");
				}
			}
			else if(select_idStr.equals("3"))
			{
				query.append(" SELECT class_no FROM tannin_table where ");
				query.append(teacher_noStr);
				query.append("'");
				query.append("ORDER BY class_no");
				
				ResultSet rs = stmt.executeQuery(query.toString());
				
				//検索結果 取得
				while( rs.next() )
				{
					class_no      = rs.getString ("class_no");
					syusseki_no   = rs.getString ( "syusseki_no" );
					gakuseki_no   = rs.getString ( "gakuseki_no" );
					simei_1       = rs.getString ( "simei_1" );
					simei_2       = rs.getString ( "simei_2" );
					kana_1        = rs.getString ( "kana_1" );
					kana_2        = rs.getString ( "kana_2" );
					umare         = rs.getString ( "umare" );
					
					sb.append("  <tr>");
					sb.append("    <td>");
					sb.append(        class_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        syusseki_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        gakuseki_no);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        simei_1);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        simei_2);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        kana_1);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        kana_2);
					sb.append("    </td>");
					sb.append("    <td>");
					sb.append(        umare);
					sb.append("    </td>");
					sb.append("  </tr>");
				}	
			}
		
			sb.append("</table><br>");
			sb.append("</center><br><br>");
			sb.append("<HR><A HREF='/JV27/class_select.html'>");
			sb.append("名簿検索に戻る");
			sb.append("</A>  ");
			sb.append("<A HREF='/JV27/class_inex.html'>");
			sb.append("ホームへ戻る");
			sb.append("</A>  ");
			sb.append("</body>");
			sb.append("</html>");
			out.println( sb.toString() );
		
			//切断
			stmt.close();
			con.close();
		}
		//例外処理
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