<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>

<%
  String namaeStr = request.getParameter("namae");
  String yuubinStr = request.getParameter("yuubin");
  String jyuusyoStr = request.getParameter("jyuusyo");
  String telStr = request.getParameter("tel");
  String seibetuStr = request.getParameter("seibetu");
  String nenStr = request.getParameter("nen");
  String tukiStr = request.getParameter("tuki");
  String hiStr = request.getParameter("hi");

  int seibetuInt = Integer.parseInt(seibetuStr);
  int bnen = Integer.parseInt(nenStr);
  int btuki = Integer.parseInt(tukiStr);
  int bhi = Integer.parseInt(hiStr);

    if(seibetuInt == 0){
      seibetuStr = "男";
    }else{
      seibetuStr = "女";
    }

    Date today = new Date();//現在日付取得

Calendar cal = Calendar.getInstance();

cal.setTime(today);

//年の取得
    int yy = cal.get(Calendar.YEAR);
    int mm = cal.get(Calendar.MONTH) + 1;
    int dd = cal.get(Calendar.DATE);

    int nenrei;

    nenrei = yy - bnen;
    
    if(mm < btuki)
    {
      nenrei = nenrei - 1;
    }
    else if(mm == btuki)
    {
      if(dd < bhi)
      {
        nenrei = nenrei - 1;
      }
    
    }
%>

<html>
<head>
  <title>JSPへデータ送信</title>
</head>

<body>
  <h1>入力確認画面</h1>
    <table border="1">
      <tr>
        <th>項目名</th><th>内容</th>
      </tr>
      <tr>
        <td>お名前</td>
        <td><%=namaeStr%></td>
      </tr>
      <tr>
        <td>郵便番号</td>
        <td><%=yuubinStr%></td>
      </tr>
      <tr>
        <td>住所</td>
        <td><%=jyuusyoStr%></td>
      </tr>
      <tr>
        <td>電話番号</td>
        <td><%=telStr%></td>
      </tr>
      <tr>
        <td>性別</td>
        <td><%=seibetuStr%></td>
      </tr>
      <tr>
        <td>生年月日</td>
        <td>
          <%=nenStr + "年"%>
          <%=tukiStr + "月"%>
          <%=hiStr + "日"%>
        </td>
      </tr>
      <tr>
        <td>年齢</td>
        <td>
          <%=nenrei + "才"%>

        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <a href="./question1.jsp">戻る</a>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>