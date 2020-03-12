<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%
  //文字コードの指定
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  
  //入力データ受信
  String syou_nameStr  = request.getParameter("syouhin_name");
  String syou_preStr = request.getParameter("syouhin_pre");
  String syou_msgStr = request.getParameter("syouhin_msg");
  String syou_iconStr = request.getParameter("syouhin_icon");

  //データベースに接続するために使用する変数宣言
  Connection con = null;
  Statement stmt = null;
  StringBuffer SQL = null;
  ResultSet rs = null;

  //ローカルのMySQLに接続する設定
  // String USER ="root";
  // String PASSWORD = "";
  // String URL ="jdbc:mysql://localhost/nhs90416db";
  // String DRIVER ="com.mysql.jdbc.Driver";

  // サーバーのMySQLに接続する設定
   String USER = "nhs90416";
   String PASSWORD = "b19960228";
   String URL ="jdbc:mysql://192.168.121.16/nhs90416db";

     String DRIVER = "com.mysql.jdbc.Driver";

  //確認メッセージ
  StringBuffer ERMSG = null;
  
  //ヒットフラグ
  int hit_flag = 0;
  
  //追加件数
  int ins_count=0;
   
  try{  // ロードに失敗したときのための例外処理
    // JDBCドライバのロード
    Class.forName(DRIVER).newInstance();

    // Connectionオブジェクトの作成
    con = DriverManager.getConnection(URL,USER,PASSWORD);

    //Statementオブジェクトの作成
    stmt = con.createStatement();

    //SQLステートメントの作成（選択クエリ）
    //SQL = new StringBuffer();

    //SQL文の構築（DB検索）
    //SQL.append("select * from syou_tbl where syou_name = '");
    //SQL.append(syou_nameStr);
   // SQL.append("' and cus_pas = '");
    //SQL.append(cus_pasStr);
    //SQL.append("'");
      //System.out.println(SQL.toString());

    //SQL文の実行（選択DB検索）
    //rs = stmt.executeQuery(SQL.toString());

    //入力したデータがデータベースに存在するか調べる
    //if(rs.next()){  //存在する(追加NG)
      //ヒットフラグON
      //hit_flag = 1;
      
    //}else{  //存在しない(追加OK)
      //ヒットフラグOFF
      //hit_flag = 0;
      //SQLステートメントの作成(選択クエリ)
      SQL=new StringBuffer();

      //SQL分の構築(DB追加)
      SQL.append("insert into syou_tbl(syou_name,syou_pre,syou_msg,syou_icon)");
      SQL.append("values('");
      SQL.append(syou_nameStr);
      SQL.append("','");
      SQL.append(syou_preStr);
      SQL.append("','");
      SQL.append(syou_msgStr);
      SQL.append("','");
      SQL.append(syou_iconStr);
      SQL.append("')");
      //System.out.println(SQL.toString());
      //SQL文の実行(DB追加)
      ins_count = stmt.executeUpdate(SQL.toString());
    //}

  } //tryブロック終了
  catch(ClassNotFoundException e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
  }
  catch(SQLException e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
  }
  catch(Exception e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
  }

  finally{
    //各種オブジェクトクローズ
      try{
        if(rs != null){
          rs.close();
        }
        if(stmt != null){
          stmt.close();
      }
        if(con != null){
          con.close();
      }
      }
    catch(SQLException e){
    ERMSG = new StringBuffer();
    ERMSG.append(e.getMessage());
    }
  }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>『顧客テーブルを読み、ログイン認証するプログラム』</title>
</head>
<body>
<%
  if(hit_flag == 1){  //追加NG
%>
  追加NG<br>
  <%="入力された商品名は既に存在します"%>
<%
  }else if(ins_count == 0){//追加処理失敗
%>
  追加NG<br>
<%="登録処理が失敗しました"%>
<%
  }else{//認証OK
%>
  追加OK<br>
  <%=ins_count + "件 商品登録が完了しました"%>
<%
  }
%>
<br><br>
<% if(ERMSG != null){ %>
予期せぬエラーが発生しました<br />
<%= ERMSG %>
<% }else{ %>
<FORM  METHOD="POST" ACTION="syouhin_main.jsp">
  <input type="submit" value="商品一覧に戻る">
</FORM><br/>
<% } %>

</body>
</html>
