import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class class_update1 extends HttpServlet
{
	public void doPost
	(
		HttpServletRequest req,
		HttpServletResponse res
	)
	throws ServletException,IOException
	{
		/***DB:URL*/
		final String URL = "jdbc:mysql://localhost/nhs90416db?useUnicode=true&characterEncoding=UTF-8";
		/*** DB:USER */
		final String USER = "root";
		/*** DB:PASSWORD */
		final String PASSWORD = "";
		/*** DB:DRIVER */
		final String DRIVER = "org.gjt.mm.mysql.Driver";
		
		Connection con = null;
		Statement stmt = null;
		
		String class_no,syusseki_no,gakuseki_no,simei_1,simei_2,kana_1,kana_2,umare;
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter();
		
		//webブラウザのFormからパラメータを取得
		String class_noStr = req.getParameter("CLASS_NO");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append(" <head><title>名簿更新</title></head>");
		sb.append(" <body bgcolor='#ffffff'>");
		sb.append("class_update1.java");
		sb.append("  <center>");
		sb.append("   <caption><font size='+3' color='#0000ff'><b>");
		sb.append("＜＜クラス名簿更新＞＞");
		sb.append("   </b></font></caption>");
		sb.append("   <br><br><br>");
		sb.append("検索結果　クラス：");
		sb.append("   <font size='+2' color='deeppink'>");
		sb.append(class_noStr);
		sb.append("   </font><br><br>");
		sb.append("   <form method='POST' action='./class_update2'>");
		sb.append("    <font color='blue'>");
		sb.append("変更する名簿を選択して変更ボタンを押してください。");
		sb.append("    </font><br><br>");
		sb.append("    <table border='1' bordercolor='darkblue'>");
		sb.append("     <tr>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("変更");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("出席");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("学籍");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("氏名(姓)");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("氏名(名)");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("カナ(姓)");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("カナ(名)");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("      <td bgcolor='darkblue'>");
		sb.append("       <font color='white'>");
		sb.append("生年月日");
		sb.append("       </font>");
		sb.append("      </td>");
		sb.append("     </tr>");
		
		try
		{
			//MySQL Driver ローディング
			Class.forName(DRIVER);
			//MySQL への接続
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			//SQL 格納
			stmt = con.createStatement();
			//SQL 実行
			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM class_table WHERE class_no = '");
			query.append(class_noStr);
			query.append("' ORDER BY syusseki_no ASC");
			ResultSet rs = stmt.executeQuery(query.toString());
			
			//検索結果 取得
			while(rs.next())
			{
				class_no = rs.getString("class_no");
				syusseki_no = rs.getString("syusseki_no");
				gakuseki_no = rs.getString("gakuseki_no");
				simei_1 = rs.getString("simei_1");
				simei_2 = rs.getString("simei_2");
				kana_1 = rs.getString("kana_1");
				kana_2 = rs.getString("kana_2");
				umare = rs.getString("umare");
				
				sb.append("     <tr>");
				sb.append("      <td align='center' bgcolor='darkblue'>");
				sb.append("       <input type='radio' name='GAKUSEKI_NO' value='");
				sb.append(gakuseki_no);
				sb.append("       '>");
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(syusseki_no);
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(gakuseki_no);
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(simei_1);
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(simei_2);
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(kana_1);
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(kana_2);
				sb.append("       </td>");
				sb.append("       <td>");
				sb.append(umare);
				sb.append("       </td>");
				sb.append("      </tr>");
			}
			sb.append("     </table><br>");
			sb.append("     <input type='submit' value='変更'>");
			sb.append("   </form>");
			sb.append("  </center><br><br>");
			sb.append("  <hr><a href='../class_update.html'>");
			sb.append("名簿更新に戻る");
			sb.append("  </a>　");
			sb.append("  <a href='../class_index.html'>");
			sb.append("ホームに戻る");
			sb.append("  </a>");
			sb.append(" </body>");
			sb.append("</html>");
			out.println(sb.toString());
			//切断
			stmt.close();
			con.close();
		}
		//例外処理
		catch(SQLException ex)
		{
			out.println("---SQL Exception--" + "<BR>");
			out.println("Message　:" + "<BR>");
			while(ex != null)
			{
				out.println(ex.getMessage() + "<BR>");
				ex = ex.getNextException();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace(out);
		}
	}
}