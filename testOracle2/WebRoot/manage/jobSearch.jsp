<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>职位搜索</title>
<link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<ul class="seachform">
  <li>
    <div class="vocation">
     所属企业： <select class="select3" name="companyId" id="companyID">
     <c:forEach items="${companies }" var="company" step="1">
     	<option value="${company.c_id }">${company.c_name }</option>
     </c:forEach>
     	
      </select>
    </div>
  </li>
  <li>
    职位名称：<input type="text" class="scinput" name="jobName" id="jobname"/>
  </li>
  <li>
    <input name="" type="button" class="scbtn" value="查询" onclick="find()"/>
  </li>
</ul>
<script>
	function find(){
	alert(document.getElementById("companyID").value+document.getElementById("jobname").value);
		var myForm = document.createElement("form");
		myForm.method="post" ;
		myForm.target="_parent";
		myForm.action = "AllJobServlet?action=find&currentpageIndex=1";
		var myInput = document.createElement("input") ;
		myInput.setAttribute("name", "company") ;
		myInput.setAttribute("value", document.getElementById("companyID").value);
		myForm.appendChild(myInput) ;
		var myInput1 = document.createElement("input") ;
		myInput1.setAttribute("name", "jobname") ;
		myInput1.setAttribute("value", document.getElementById("jobname").value);
		myForm.appendChild(myInput1) ;
		document.body.appendChild(myForm) ;
		myForm.submit() ;
		document.body.removeChild(myForm) ;
	
	}


</script>
</body>
</html>
