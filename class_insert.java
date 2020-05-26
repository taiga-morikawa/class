import java.sql.*; 
import java.io.*; 

import javax.servlet.*; 
import javax.servlet.http.*; 

public class class_insert extends HttpServlet{ 
    public void doPost( 
        HttpServletRequest req, 
        HttpServletResponse res ) 
        throws ServletException, IOException{ 
            
/** 
* ＤＢ：ＵＲＬ 
*/ 
final String URL = "jdbc:mysql://localhost/nhs90416db?useUnicode=true&characterEncodi ng=UTF-8"; 
/** 
* ＤＢ：ユーザ 
*/ 
final String USER = "root"; 
/** 
* ＤＢ：パスワード 
*/ 
final String PASSWORD = ""; 
/** 
* ＤＢ：ドライバ 
*/ 
final String DRIVER = "org.gjt.mm.mysql.Driver"; 
Connection con = null; 
Statement stmt = null; 
String  class_no,syusseki_no,gakuseki_no,simei_1,simei_2,kana_1,kana_2,umare; 

PrintWriter out; 
req.setCharacterEncoding("UTF-8"); 
res.setContentType("text/html;charset=UTF-8"); 
out = res.getWriter(); 

//webブラウザのFormからパラメータを取得 
String class_noStr = req.getParameter( "CLASS_NO" ); 
String syusseki_noStr = req.getParameter( "SYUSSEKI_NO" ); 
String gakuseki_noStr = req.getParameter( "GAKUSEKI_NO" ); 
String simei_1Str = req.getParameter( "SIMEI_1" ); 
String simei_2Str = req.getParameter( "SIMEI_2" ); 
String kana_1Str = req.getParameter( "KANA_1" ); 
String kana_2Str = req.getParameter( "KANA_2" ); 
String umareStr = req.getParameter( "UMARE" ); 
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
    query.append("SELECT * FROM class_table WHERE gakuseki_no = '"); 
    query.append(gakuseki_noStr); 
    query.append("'"); 
    ResultSet rs = stmt.executeQuery(query.toString()); 
    
    //検索結果 表示 
    StringBuffer  sb = new StringBuffer(); 
    sb.append("<html>"); 
    sb.append("<head><title>名簿登録</title></head>"); 
    sb.append("<body bgcolor='#ffffff'>"); 
    sb.append("class_insert.java"); 
    sb.append("<center>"); 
    sb.append("<CAPTION><FONT SIZE='+3' COLOR='#0000FF'>"); 
    sb.append("<B>"); 
    sb.append("＜＜名簿登録 ＞＞"); 
    sb.append("</B></FONT></CAPTION>"); 
    sb.append("<BR><BR><BR>"); 
    if( rs.next() ) { 
        sb.append("<center>"); 
        sb.append("学籍番号 "); 
        sb.append("<font size='+3' color='deeppink'>"); 
        sb.append(gakuseki_noStr); 
        sb.append("</font>"); 
        sb.append( " はすでに登録済です。"); 
    }else{ 
        //SQL 実行 クラステーブル追加 
        query = new StringBuffer(); 
        query.append("INSERT INTO class_table"); 
        query.append(" (class_no,syusseki_no,gakuseki_no,simei_1,simei_2,kana_1,kana_2,umare)"); 
        query.append(" VALUES('"); 
        query.append(class_noStr); 
        query.append("','"); 
        query.append(syusseki_noStr); 
        query.append("','"); 
        query.append(gakuseki_noStr); 
        query.append("','"); 
        query.append(simei_1Str); 
        query.append("','");
        query.append(simei_2Str); 
        query.append("','"); 
        query.append(kana_1Str); 
        query.append("','"); 
        query.append(kana_2Str); 
        query.append("','"); 
        query.append(umareStr); 
        query.append("')"); 
        stmt.executeUpdate(query.toString()); 
        sb.append("<center><h1>"); 
        sb.append("名簿登録完了しました。"); 
        sb.append("</h1>"); 
    } 
    sb.append("</center><br><br>"); 
    sb.append("<HR><A HREF='/JV27/class_insert.html'>"); 
    sb.append("名簿登録に戻る "); 
    sb.append("</A>  "); 
    sb.append("<A HREF='/JV27/class_index.html'>"); 
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