<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html>
	<head><title>class_update.jsp</title></head>
	<body bgcolor="#ffffff">
		class_update.jsp
		<center>
			<caption>
				<font size="+3" color="#0000ff">
					<b>＜＜名簿更新＞＞</b>
				</font>
			</caption><br>
			<form method="POST" name="frm" action="./class_update3">
				<input type="hidden" name="GAKUSEKI_NO" value=<%= request.getAttribute("gakuseki_no").toString()%>>
				<font size="+1" color="#0000ff">
					名簿情報を変更してください。
				</font>
				<p>
					<hr size="5" width="80%">
					<table border="1" bordercolor="darkblue">
						<tr>
							<td bgcolor="darkblue"><font color="white">クラス</font></td>
							<td>
								<select name="CLASS_NO" size="1">
									<option value="AT11A192">AT11A192</option>
									<option value="AT11B203">AT11B203</option>
									<option value="CG11A172">CG11A172</option>
									<option value="IT11A172">IT11A172</option>
									<option value="AT12A165">AT12A165</option>
									<option value="AT12B165">AT12B165</option>
									<option value="IH12A101">IH12A101</option>
									<option value="IW12A185">IW12A185</option>
									<option value="AT13A181">AT13A181</option>
									<option value="AP13A223">AP13A223</option>
									<option value="IH13A181">IH13A181</option>
									<option value="IW13A187">IW13A187</option>
									<option value="CD13A166">CD13A166</option>
									<option value="AP14A226">AP14A226</option>
									<option value="AT14A226">AT14A226</option>
									<option value="IH14A223">IH14A223</option>
									<option value="CT14A187">CT14A187</option>
									<option value="IW14A187">IW14A187</option>
									<option value="xx14Axxx">xx14Axxx</option>
								</select>
<%
								int i = 0;
								if(request.getAttribute("class_no").toString().equals("AT11A192"))
								{
									i = 0;
								}
								else if(request.getAttribute("class_no").toString().equals("AT11B203"))
								{
									i = 1;
								}
								else if(request.getAttribute("class_no").toString().equals("CG11A172"))
								{
									i = 2;
								}
								else if(request.getAttribute("class_no").toString().equals("IT11A172"))
								{
									i = 3;
								}
								else if(request.getAttribute("class_no").toString().equals("AT12A165"))
								{
									i = 4;
								}
								else if(request.getAttribute("class_no").toString().equals("AT12B165"))
								{
									i = 5;
								}
								else if(request.getAttribute("class_no").toString().equals("IH12A101"))
								{
									i = 6;
								}
								else if(request.getAttribute("class_no").toString().equals("IW12A185"))
								{
									i = 7;
								}
								else if(request.getAttribute("class_no").toString().equals("AT13A181"))
								{
									i = 8;
								}
								else if(request.getAttribute("class_no").toString().equals("AP13A223"))
								{
									i = 9;
								}
								else if(request.getAttribute("class_no").toString().equals("IH13A181"))
								{
									i = 10;
								}
								else if(request.getAttribute("class_no").toString().equals("IW13A187"))
								{
									i = 11;
								}
								else if(request.getAttribute("class_no").toString().equals("CD13A166"))
								{
									i = 12;
								}
								else if(request.getAttribute("class_no").toString().equals("AP14A226"))
								{
									i = 13;
								}
								else if(request.getAttribute("class_no").toString().equals("AT14A226"))
								{
									i = 14;
								}
								else if(request.getAttribute("class_no").toString().equals("IH14A223"))
								{
									i = 15;
								}
								else if(request.getAttribute("class_no").toString().equals("CT14A187"))
								{
									i = 16;
								}
								else if(request.getAttribute("class_no").toString().equals("IW14A187"))
								{
									i = 17;
								}
								else if(request.getAttribute("class_no").toString().equals("xx14Axxx"))
								{
									i = 18;
								}
%>
								<script language="JavaScript">
									document.frm.CLASS_NO.options[<%= i %>].selected = true;
								</script>
							</td>
						</tr>
						<tr>
							<td bgcolor="darkblue"><font color="white">出席</font></td>
							<td><input type="text" name="SYUSSEKI_NO" size="20" value=<%=request.getAttribute("syusseki_no")%>></td>
						</tr>
						<tr>
							<td bgcolor="darkblue"><font color="white">学籍</font></td>
							<td><input type="text" name="GAKUSEKI_NO" size="20" value=<%=request.getAttribute("gakuseki_no")%> readonly></td>
						<tr>
							<td bgcolor="darkblue"><font color="white">氏名(姓)</font></td>
							<td><input type="text" name="SIMEI_1" size="20" value=<%=request.getAttribute("simei_1")%>></td>
						</tr>
						<tr>
							<td bgcolor="darkblue"><font color="white">氏名(名)</font></td>
							<td><input type="text" name="SIMEI_2" size="20" value=<%=request.getAttribute("simei_2")%>></td>
						</tr>
						<tr>
							<td bgcolor="darkblue"><font color="white">カナ(姓)</font></td>
							<td><input type="text" name="KANA_1" size="20" value=<%=request.getAttribute("kana_1")%>></td>
						</tr>
						<tr>
							<td bgcolor="darkblue"><font color="white">カナ(名)</font></td>
							<td><input type="text" name="KANA_2" size="20" value=<%=request.getAttribute("kana_2")%>></td>
						</tr>
						<tr>
							<td bgcolor="darkblue"><font color="white">生年月日</font></td>
							<td><input type="text" name="UMARE" size="20" value=<%=request.getAttribute("umare")%>></td>
						</tr>
					</table>
				</p>
				<hr size="5" width="80%">
				<br>
				<input type="submit" value="名簿更新">
				<input type="reset" value="入力クリア">
				<br><br>
			</form>
			<hr>
			<a href="../class_update.html">名簿選択へ戻る</a>　
			<a href="../class_index.html">メニューへ戻る</a>
			<br>
		</center>
	</body>
</html>
			