<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="utf-8">
<title>添加企业</title>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
 %>
<link href="../css/manageadmin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript">

function validate(){
	if(document.getElementById("companyName").value == ""){
		alert("企业名称不能为空！");
		document.getElementById("companyName").focus();
		return false;
	}
	if(document.getElementById("companyArea").value == ""){
		alert("企业所在地不能为空！");
		document.getElementById("companyArea").focus();
		return false;
	}
	if(document.getElementById("companySize").value == ""){
		alert("企业规模不能为空！");
		document.getElementById("companySize").focus();
		return false;
	}
	if(document.getElementById("companyType").value == ""){
		alert("企业性质不能为空！");
		document.getElementById("companyType").focus();
		return false;
	}
	if(document.getElementById("companyPic").value == ""){
		alert("请选择企业宣传图片！");
		document.getElementById("companyPic").focus();
		return false;
	}
	return true;
}

</script>
</head>
<body >
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">修改工作</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="usual">
  <form name="frm" action="../UpdateServlet?action=jobupdate&jobId=<%=request.getParameter("jobId") %>" method="post"  onsubmit="return validate();">
    <div class="tabson">
      <ul class="forminfo">
      	<li>
          <label>职位名称<b>*</b></label>
          <input name="jobName" type="text" id="companyName" class="dfinput" style="width:518px;" value=<%=new String(request.getParameter("jobname").getBytes("iso-8859-1"),"utf-8") %>  />
        </li>
        <li>
          <label>所属企业<b>*</b></label>
          <input name="company" type="text" id="company" class="dfinput" style="width:518px;" value=<%=new String(request.getParameter("company").getBytes("iso-8859-1"),"utf-8")%>>
        </li>
        <li>
          <label>招聘数<b>*</b></label>
          <input name="number" type="text" id="number" class="dfinput" style="width:518px;" value=<%=request.getParameter("number") %>>
        </li>
        <li>
          <label>结束日期<b>*</b></label>
          <input name="endtime" type="text" id="endtime" class="dfinput" style="width:518px;" value=<%=request.getParameter("endtime") %>>
        </li>
        <li>
          <label>招聘状态</label>
          <div class="vocation">
            <select name="jobState" class="select3">
              <option value="1">招聘中</option>
              <option value="2">已暂停</option>
              <option value="3">已结束</option>
            </select>
          </div>
        </li>
        
        <li>  <label>&nbsp;</label>
          <input name="" type="submit" class="btn" value="修改"/>
        </li>
      </ul>
    </div>
  </form>
  </div>
</div>
</body>
</html>
