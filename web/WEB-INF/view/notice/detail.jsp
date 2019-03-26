<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告详情 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>公告详情</h3>
		<form action="<c:url value="/notice/add" />" method="post">
			<table class="form-table">
				<tr>
					<td class="label">发布时间</td>
					<td class="detail">
						${requestScope.notice.pub_time}
					</td>
					<td class="label">截止时间</td>
					<td class="detail">
						${requestScope.notice.expire_time}
					</td>
				</tr>
				<tr>
					<td class="label">主题</td>
					<td class="detail">
						${ requestScope.notice.subject }
					</td>
					<td class="label">通知范围</td>
					<td class="detail">
						<c:if test="${ requestScope.notice.receive_id==0 }">
							全部
						</c:if>
						<c:if test="${ requestScope.notice.receive_id==1 }">
							部门1
						</c:if>
						<c:if test="${ requestScope.notice.receive_id==2 }">
							部门2
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="label">内容</td>
					<td colspan="3" class="detail">
						${ requestScope.notice.text }
					</td>
				</tr>
			</table>
			<div class="buttons">
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>