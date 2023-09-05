<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>접근제한</h1>
	<p><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></p>
	<!-- Spring Security에서 throw한 403 액세스 거부 예외와 관련된 오류 메시지를 검색하고 표시하려고 시도하는 JSTL(JavaServer Pages Standard Tag Library) 코드 조각 -->
</body>
</html>