<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>企业列表</title>
<link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">企业列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="images/t01.png" /></span><a href="manage/companyAdd.jsp">添加</a></li>
      <li><span><img src="images/t03.png" /></span><a href="#">删除</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>企业名称</th>
        <th>企业所在地</th>
        <th>企业规模</th>
        <th>企业性质</th>
        <th>招聘状态</th>
        <th>显示排序</th>
        <th>浏览数</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${pagecompany.list }" var="company">
   		<tr height="50px">
    		<td ><input name="" type="checkbox" value=${company.c_id }></td>
      		<td >${company.c_name }</td>
        	<td>${company.c_area }</td>
        	<td>${company.c_size }</td>
        	<td>${company.c_type }</td>
        	<td>${company.c_state }</td>
        	<td>${company.c_sort }</td>
        	<td>${company.c_viewnum }
        	<td ><a href="UpdateServlet?action=companyupdate_echo&companyid=${company.c_id }" class="tablelink">修改</a> &nbsp;&nbsp;<a href="DeleteServlet?action=companydelete&companyID=${company.c_id} " class="tablelink"> 删除</a></td>
    	</tr>
    
    </c:forEach>
      
        
      
      
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">共<i class="blue">${pagecompany.totalDataCount }</i>条记录，当前显示第&nbsp;<i class="blue">${pagecompany.currentPageIndex }&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
      <c:forEach begin="1" end="${pagecompany.pagerow }" var="page">
      <li class="paginItem"><a href="CompanyServlet?currentpageindex=${page }">${page }</a></li>
      </c:forEach>
      <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
  </div>
</div>
</body>
</html>
