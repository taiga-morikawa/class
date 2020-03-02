<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% 
  //文字コードの指定
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");

  //入力した数量を格納する配列
  String[] syouhin = new String[3];

  //sessionの数量を格納する配列
  String[] syouhin_count = new String[3];

  //カートを空にする
  String cart_crea = request.getParameter("crea");
  if(cart_crea!=null){
    //セッション変数を削除
    session.removeAttribute("syouhin1");
    session.removeAttribute("syouhin2");
    session.removeAttribute("syouhin3");
}

//商品ページより数量の取得
syouhin[0] = request.getParameter("syouhin1");
syouhin[1] = request.getParameter("syouhin2");
syouhin[2] = request.getParameter("syouhin3");

//sessionより数量の取得
syouhin_count[0] = (String)session.getAttribute("syouhin1");
syouhin_count[1] = (String)session.getAttribute("syouhin2");
syouhin_count[2] = (String)session.getAttribute("syouhin3");

//合計を加算
int goukei = 0;
for(int i = 0; i<3; i++){
  if(syouhin[i]!=null){
    if(syouhin_count[i]!=null){
      goukei = Integer.parseInt(syouhin_count[i]);
  }
    goukei = goukei + Integer.parseInt(syouhin[i]);
  }
}

//セッションにバインド
if(syouhin[0]!=null){
  session.setAttribute("syouhin1", new Integer(goukei).toString());
}else if(syouhin[1]!=null){
  session.setAttribute("syouhin2", new Integer(goukei).toString());
}else if(syouhin[2]!=null){
  session.setAttribute("syouhin3", new Integer(goukei).toString());
}

//有効期限
session.setMaxInactiveInterval(30);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>カートの中には以下の商品が入ってます</h2>
<%
String count1 = (String)session.getAttribute("syouhin1");
String count2 = (String)session.getAttribute("syouhin2");
String count3 = (String)session.getAttribute("syouhin3");
%>
<%
  if(count1!=null){
  %>
  <table border="1">
    <tr>
      <td rowspan="3">
        <img src="./image/bung1.png" height="32px" width="32px"/>
      </td>
    </tr>
    <tr>
      <td width="80">
        商品No.
      </td>
      <td width="80">
        商品名
      </td>
      <td width="80">
        数量
      </td>
    </tr>
    <tr>
      <td width="80">
        1
      </td>
      <td>
        はさみ
      </td>
      <td>
        <%= count1 %>
      </td>
    </tr>
  </table>
<%
}
%>
<br/>
<%
  if(count2!=null){
%>
<table border="1">
    <tr>
      <td rowspan="3">
        <img src="./image/bung2.png" height="32px" width="32px"/>
      </td>
    </tr>
    <tr>
      <td width="80">
        商品No.
      </td>
      <td width="80">
        商品名
      </td>
      <td width="80">
        数量
      </td>
    </tr>
    <tr>
      <td width="80">
        2
      </td>
      <td>
        えんぴつ
      </td>
      <td>
        <%= count2 %>
      </td>
    </tr>
  </table>
<%
}
%>
<br/>
<br/>
<%
  if(count3!=null){
%>
<table border="1">
    <tr>
      <td rowspan="3">
        <img src="./image/bung3.png" height="32px" width="32px"/>
      </td>
    </tr>
    <tr>
      <td width="80">
        商品No.
      </td>
      <td width="80">
        商品名
      </td>
      <td width="80">
        数量
      </td>
    </tr>
    <tr>
      <td width="80">
        3
      </td>
      <td>
        ノート
      </td>
      <td>
        <%= count3 %>
      </td>
    </tr>
  </table>
<%
}
%>
<%
  if(count1==null&&count2==null&&count3==null){
%>
カートの中はありません<br/>
<%
}
%>
<br/>
  <table border="0">
    <tr>
      <td>
        <form method="post" action="cart_in.jsp">
          <input type="submit" value="お買い物を続ける">
        </form>
      </td>
      <td>
        <form method="post" action="cart_out.jsp">
          <input type="hidden" name="crea" value="crea">
          <input type="submit" value="カートを空にする">
        </form>
      </td>
    </tr>
  </table>
</body>
</html>