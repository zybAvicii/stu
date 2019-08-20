<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>

</head>
<body>
	<table id="table1" border="1px" width="65%" align="center">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>
		
	</table>
	<table id="table2" border="1px" width="65%" align="center">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>
		
	</table>
</body>
<!-- 1.导入js函数类库
	 2.让页面加载完成后执行js
	 3.发起异步请求 
	 $.load(url)从远程获取html代码在指定的元素中展现
	 $.get(url,data,callback,type)
	 $.post(url,data,callback,type)
	 $.getJSON(url,data,callback)
	 $.ajax({
	 	type: "get/post",
			url : "请求路径",
			data:  {key:value,key2:value2....},
			dataType: 服务器返回数据格式 text/json
			success : function(data){....
				编辑回调函数
				}
	 });
	 -->
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$.getJSON("http://localhost:8090/ajaxUserList",function(result){
			var trs=null;
			$.each(result,function(index,user){
				var id=user.id;
				var name=user.name;
				var age=user.age;
				var sex=user.sex;
trs += "<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>"
				$("#table1").append(trs);	
		})
			
		})

	$(function(){
		alert("开始调用")
		$.ajax({
			type: "get",
			url:  "http://localhost:8090/ajaxUserList",
			dataType: "json",
			//result表示后台服务器返回的json数据    List<User>
			success: function(result){
				
				//1.循环变量返回值
				//参数1.表示需要遍历的数据
				//参数2.表示每次遍历的元素的处理方式
				$.each(result,function(index,user){
					var id = user.id;
					var name = user.name;
					var age = user.age;
					var sex = user.sex;
					//需要将数据封装到table中
					var tr = "<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>"

					$("#table2").append(tr);
				})
			}
		});
	});
</script>
</html>