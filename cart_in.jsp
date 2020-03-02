<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% 
  //文字コードの指定
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピングカート</title>
</head>
<body>
<h1>商品一覧</h1>
<form method="post" action="cart_out.jsp">
<table border="1">
  <tr>
    <td rowspan="4">
      <img src="./image/bung1.png" height="64px" width="64px"/>
    </td>
  </tr>
  <tr>
    <td>
      商品No.
    </td>
    <td width="100">
      1
    </td>
  </tr>
  <tr>
    <td>
      商品名
    </td>
    <td width="100">
      はさみ
    </td>
  </tr>
  <tr>
    <td>
      数量
    </td>
    <td width="100">
      <select size="1" name="syouhin1">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
    </td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="カートに入れる">
    </td>
  </tr>
</table>
</form>
<br/>

<form method="post" action="cart_out.jsp">
<table border="1">
  <tr>
    <td rowspan="4">
      <img src="./image/bung2.png" height="64px" width="64px"/>
    </td>
  </tr>
  <tr>
    <td>
      商品No.
    </td>
    <td width="100">
      2
    </td>
  </tr>
  <tr>
    <td>
      商品名
    </td>
    <td width="100">
      えんぴつ
    </td>
  </tr>
  <tr>
    <td>
      数量
    </td>
    <td width="100">
      <select size="1" name="syouhin2">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
    </td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="カートに入れる">
    </td>
  </tr>
</table>
</form>
<br/>

<form method="post" action="cart_out.jsp">
<table border="1">
  <tr>
    <td rowspan="4">
      <img src="./image/bung3.png" height="64px" width="64px"/>
    </td>
  </tr>
  <tr>
    <td>
      商品No.
    </td>
    <td width="100">
      3
    </td>
  </tr>
  <tr>
    <td>
      商品名
    </td>
    <td width="100">
      ノート
    </td>
  </tr>
  <tr>
    <td>
      数量
    </td>
    <td width="100">
      <select size="1" name="syouhin3">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
    </td>
  </tr>
  <tr>
    <td>
      <input type="submit" value="カートに入れる">
    </td>
  </tr>
</table>
</form>
<br/>

<form method="post" action="cart_out.jsp">
  <input type="submit" value="カートの中を見る">
</form>
</body>
</html>