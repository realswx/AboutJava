<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <table class="imgtable">
    <thead>
      <tr>
        <th>职位名称</th>
        <th>所属企业</th>
        <th>招聘数</th>
        <th>申请数</th>
        <th>结束日期</th>
        <th>招聘状态</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${jobList}" var="job" step="1">
    	<tr height="50px" align="center"><td>${job.j_name}</td>
			<td align="center">${job.company}</td>
			<td align="center">${job.hiringnum}</td>
			<td></td>
			<td align="center">${job.endtimeDate }</td>
			<td align="center">${job.state }</td>
     
        <td ><a href="#" class="tablelink">修改</a> &nbsp;&nbsp;
        <a href="#" class="tablelink"> 删除</a></td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  </body>
</html>
