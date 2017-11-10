<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>职位列表</title>
<link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="index.html">首页</a></li>
    <li>职位列表</li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="images/t01.png" /></span>
      <a href="jobAdd.html">添加</a></li>
    </ul>
    
    <iframe src="CompanyServlet" scrolling="no" frameborder="0" width="630" height="42"></iframe>
  </div>
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
    <c:forEach items="${jobList}" var="job" >
    	<tr height="50px" align="center"><td>${job.j_name}</td>
			<td align="center">${job.company}</td>
			<td align="center">${job.hiringnum}</td>
			<td></td>
			<td align="center">${job.endtimeDate }</td>
			<td align="center">${job.state }</td>
     
        <td ><a href="manage/jobUpdate.jsp?jobId=${job.jobID }&jobname=${job.j_name}&company=${job.company}&number=${job.hiringnum}&endtime=${job.endtimeDate}&state=${job.state}" class="tablelink">修改</a> &nbsp;&nbsp;
        <a href="DeleteServlet?action=jobdelete&jobID=${job.jobID} " class="tablelink"> 删除</a></td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">共<i class="blue" >${page.pagerow }</i>页，当前显示第&nbsp;<i class="blue">${page.currentPageIndex }&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="AllJobServlet?action=${action }&currentpageIndex=1">首页</a></li>
      <li class="paginItem"><a href="javascript:lastpage()">上一页<span class="pagepre"></span></a></li>
      <li class="paginItem"><a href="javascript:nextpage()">下一页<span class="pagenxt"></span></a></li>
       <li class="paginItem"><a href="AllJobServlet?action=${action }&currentpageIndex=${page.pagerow}">尾页</a></li>
    </ul>
  </div>
</div>
<script type="text/javascript">
	function lastpage(){
		if(1==${page.currentPageIndex }){
			alert("当前是第一页");
		
		}else{
			window.location.href="AllJobServlet?action=${action }&currentpageIndex=${page.currentPageIndex-1}"
		}
	}
	function nextpage(){
		if(${page.pagerow }==${page.currentPageIndex }){
			alert("当前是最后一页");
		
		}else{
			window.location.href="AllJobServlet?action=${action }&currentpageIndex=${page.currentPageIndex+1}"
		}
	
	
	}


</script>
</body>
</html>
