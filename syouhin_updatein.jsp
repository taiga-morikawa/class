<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%
  //文字コードの指定
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");

    //入力データ受信
  String syou_noStr  = request.getParameter("syouhin_no");

  //データベースに接続するために使用する変数宣言
  Connection con = null;
  Statement stmt = null;
  StringBuffer SQL = null;
  ResultSet rs = null;

  //ローカルのMySQLに接続する設定
  String USER ="root";
  String PASSWORD = "";
  String URL ="jdbc:mysql://localhost/nhs90416db";

  String DRIVER = "com.mysql.jdbc.Driver";

  //確認メッセージ
  StringBuffer ERMSG = null;


  //ヒットフラグ
  int hit_flag = 0;

  //HashMap（1件分のデータを格納する連想配列）
  HashMap<String,String> map = null;

  //ArrayList（すべての件数を格納する配列）
  ArrayList<HashMap> list = null;
  list = new ArrayList<HashMap>();

  try{  // ロードに失敗したときのための例外処理
    // JDBCドライバのロード
    Class.forName(DRIVER).newInstance();

    // Connectionオブジェクトの作成
    con = DriverManager.getConnection(URL,USER,PASSWORD);

    //Statementオブジェクトの作成
    stmt = con.createStatement();

    //SQLステートメントの作成（選択クエリ）
    SQL = new StringBuffer();

    //SQL文の構築（選択クエリ）
    SQL.append("select * from syou_tbl where syou_no = ");
    SQL.append(syou_noStr);

    //SQL文の発行（選択クエリ）
    rs = stmt.executeQuery(SQL.toString());

        //入力したデータがデータベースに存在するか調べる
    if(rs.next()){  //存在する
      //ヒットフラグON
      hit_flag = 1;
      
        //検索データをHashMapへ格納する
        map = new HashMap<String,String>();
      map.put("syou_no",rs.getString("syou_no"));
      map.put("syou_name",rs.getString("syou_name"));
      map.put("pre_name",rs.getString("pre_name"));
      map.put("syou_msg",rs.getString("syou_msg"));
      map.put("syou_icon",rs.getString("syou_icon"));

      //1件分のデータ(HashMap)をArrayListへ追加
      list.add(map);
    }else{  //存在しない
      //ヒットフラグOFF
      hit_flag = 0;
    }
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
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>商品登録</TITLE>
<META HTTP-EQUIV="content-type"  CONTENT="text/html;charset=UTF-8">
</HEAD>
<BODY BGCOLOR="#FFFFFF">
<h1>商品登録</h1>
<FORM  METHOD="POST" ACTION="/JV16/syouhin_updateout.jsp">
  <table border="1">
  <tr>
    <th bgcolor="#99CC00">項目名</th><th bgcolor="#99CC00">内容</th>
  </tr>
  <tr>
    <td bgcolor="#99CC00">商品No</td>
    <td>
      <input type="text" name="syou_no" size="53" maxlength="20"
      value="<%= list.get(0).get("syou_no") %>">>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">商品名</td>
    <td>
      <input type="text" name="syou_name" size="53" maxlength="20">
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">生産地</td>
    <td>
      <select size=1 name="syou_pre">
            <option value="1">北海道</option>
        <option value="2">青森県</option>
        <option value="3">岩手県</option>
        <option value="4">宮城県</option>
        <option value="5">秋田県</option>
        <option value="6">山形県</option>
        <option value="7">福島県</option>
        <option value="8">茨城県</option>
        <option value="9">栃木県</option>
        <option value="10">群馬県</option>
        <option value="11">埼玉県</option>
        <option value="12">千葉県</option>
        <option value="13">東京都</option>
        <option value="14">神奈川県</option>
        <option value="15">新潟県</option>
        <option value="16">富山県</option>
        <option value="17">石川県</option>
        <option value="18">福井県</option>
        <option value="19">山梨県</option>
        <option value="20">長野県</option>
        <option value="21">岐阜県</option>
        <option value="22">静岡県</option>
        <option value="23">愛知県</option>
        <option value="24">三重県</option>
        <option value="25">滋賀県</option>
        <option value="26">京都府</option>
        <option value="27">大阪府</option>
        <option value="28">兵庫県</option>
        <option value="29">奈良県</option>
        <option value="30">和歌山県</option>
        <option value="31">鳥取県</option>
        <option value="32">島根県</option>
        <option value="33">岡山県</option>
        <option value="34">広島県</option>
        <option value="35">山口県</option>
        <option value="36">徳島県</option>
        <option value="37">香川県</option>
        <option value="38">愛媛県</option>
        <option value="39">高知県</option>
        <option value="40">福岡県</option>
        <option value="41">佐賀県</option>
        <option value="42">長崎県</option>
        <option value="43">熊本県</option>
        <option value="44">大分県</option>
        <option value="45">宮崎県</option>
        <option value="46">鹿児島県</option>
        <option value="47">沖縄県</option>
          </select>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">コメント</td>
    <td>
      <textarea name="syou_msg" rows="3" cols="40" ></textarea>
    </td>
  </tr>
  <tr>
    <td bgcolor="#99CC00">アイコン</td>
    <td>
      <select name="syou_icon">
        <option value="1">いちご</option>
        <option value="2">りんご</option>
        <option value="3">さくらんぼ</option>
        <option value="4">すいか</option>
        <option value="5">パイナップル</option>
        <option value="6">メロン</option>
        <option value="7">バナナ</option>
      </select>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="登録">
    </td>
  </tr>
  </table>
</form>
<br />
<FORM  METHOD="POST" ACTION="/JV16/syouhin_main.jsp">
  <input type="submit" value="商品一覧に戻る">
</FORM>
</body>
</html>