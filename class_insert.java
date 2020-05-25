import java.sql.*; 
import java.io.*; 

import javax.servlet.*; 
import javax.servlet.http.*; 

public class insert extends HttpServlet{ 
    public void doPost( 
        HttpServletRequest req, 
        HttpServletResponse res ) 
        throws ServletException, IOException{ 
            
/** 
* ＤＢ：ＵＲＬ 
*/ 
final String URL = "jdbc:mysql://localhost/nhsxxxxxdb?useUnicode=true&characterEncodi ng=UTF-8"; 
/** 
* ＤＢ：ユーザ 
*/ 
final String USER = "root"; 
/** 
* ＤＢ：パスワード 
*/ 
final String PASSWORD = "root"; 
/** 
* ＤＢ：ドライバ 
*/ 
final String DRIVER = "org.gjt.mm.mysql.Driver"; 
Connection con = null; 
Statement stmt = null; 
String  home_tel,simei,seibetu,ketueki,umare,k_tel,info; 

PrintWriter out; 
req.setCharacterEncoding("UTF-8"); 
res.setContentType("text/html;charset=UTF-8"); 
out = res.getWriter(); 

//webブラウザのFormからパラメータを取得 
String kubunStr = req.getParameter( "KUBUN" ); 
String simeiStr = req.getParameter( "SIMEI" ); 
String seibetuStr = req.getParameter( "SEIBETU" ); 
String ketuekiStr = req.getParameter( "KETUEKI" ); 
String umareStr = req.getParameter( "UMARE" ); 
String home_telStr = req.getParameter( "HOME_TEL" ); 
String k_telStr = req.getParameter( "K_TEL" ); 
String infoStr = req.getParameter( "INFO" );
try { 
    //  MySQL Driver ローディング 
    Class.forName(DRIVER); 
    //  MySQL への接続 
    con = DriverManager.getConnection(URL,USER,PASSWORD); 
    //  SQL 格納 
    //stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet .CONCUR_READ_ONLY); 
    stmt = con.createStatement(); 
    //SQL 実行 顧客クエリー検索 
    StringBuffer query = new StringBuffer(); 
    query.append("SELECT * FROM meibo_table WHERE home_tel = '"); 
    query.append(home_telStr); 
    query.append("'"); 
    ResultSet rs = stmt.executeQuery(query.toString()); 
    
    //検索結果 表示 
    StringBuffer  sb = new StringBuffer(); 
    sb.append("<html>"); 
    sb.append("<head><title>名簿登録</title></head>"); 
    sb.append("<body bgcolor='#ffffff'>"); 
    sb.append("insert.java"); 
    sb.append("<center>"); 
    sb.append("<CAPTION><FONT SIZE='+3' COLOR='#0000FF'>"); 
    sb.append("<B>"); 
    sb.append("＜＜名簿登録 ＞＞"); 
    sb.append("</B></FONT></CAPTION>"); 
    sb.append("<BR><BR><BR>"); 
    if( rs.next() ) { 
        sb.append("<center>"); 
        sb.append("自宅電話番号 "); 
        sb.append("<font size='+3' color='deeppink'>"); 
        sb.append(home_telStr); 
        sb.append("</font>"); 
        sb.append( " はすでに登録済です。"); 
    }else{ 
        //SQL 実行 名簿テーブル追加 
        query = new StringBuffer(); 
        query.append("INSERT INTO meibo_table"); 
        query.append(" (kubun,home_tel,simei,seibetu,ketueki,umare,k_tel,info)"); 
        query.append(" VALUES('"); 
        query.append(kubunStr); 
        query.append("','"); 
        query.append(home_telStr); 
        query.append("','"); 
        query.append(simeiStr); 
        query.append("','");
        query.append(seibetuStr); 
        query.append("','"); 
        query.append(ketuekiStr); 
        query.append("','"); 
        query.append(umareStr); 
        query.append("','"); 
        query.append(k_telStr); 
        query.append("','"); 
        query.append(infoStr); 
        query.append("')"); 
        stmt.executeUpdate(query.toString()); 
        sb.append("<center><h1>"); 
        sb.append("名簿登録完了しました。"); 
        sb.append("</h1>"); 
    } 
    sb.append("</center><br><br>"); 
    sb.append("<HR><A HREF='/JV27/insert.html'>"); 
    sb.append("名簿登録に戻る "); 
    sb.append("</A>  "); 
    sb.append("<A HREF='/JV27/meibo.html'>"); 
    sb.append("ホームへ戻る"); 
    sb.append("</A>  "); 
    sb.append("</body>"); 
    sb.append("</html>"); 
    out.println(sb.toString()); 
    //切断 
    stmt.close(); 
    con.close(); 
} 
//例外処理 
catch (SQLException ex) { 
    out.println( " --- SQL Exception --" + "<BR>" ); 
    out.println( "Message   : " + "<BR>" ); 
    while(ex != null){ 
        out.println( ex.getMessage() + "<BR>" ); 
        ex = ex.getNextException(); 
    } 
} 
catch (Exception ex) { 
    ex.printStackTrace (out); 
} 
} 
}        