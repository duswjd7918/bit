<%@page import="java63.servlets.test05.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>   JSTL - Core tag사용!!!  </title>
</head>
<body>
cf)JSTL 은 JSP확장 태그이다.  별도의 라이브러리(두가지)를 추가해야한다!
<h1>Core tag 사용</h1>
<h2>c:out</h2>
<p>목적: 출력문을 만든다!</p>
<c:out value="오호라! 출력이당" /><br>
<c:out value="${null}" default ="기본값" /><br>
<c:out value="${null}">기본괎</c:out><br>

<p>   cf)
기존JSP로표현하자면 - 
차이점: 위에껀 순수태그 / 아래껀 자바코드
</p>

 <%= "오호라 출력" %><br>
<!-- --------------------------------------------------  --> 
 <h2>c:set         var/value/scope</h2>
 <p>변수를 생성하거나 변수의 값을 설정할 때 사용</p>
 <c:set var="name1" value="홍길동" scope="page" />
 <c:set var="name2" scope="page">이순신</c:set>
 
 <%
 String name3="임꺽정";
 pageContext.setAttribute("name3", name3);
 %>
requestScope.name1 = ${requestScope.name1} <br>
pageScope.name1 = ${pageScope.name1} <br>
pageScope.name2 = ${pageScope.name2} <br>
pageScope.name3 = ${pageScope.name3} <br>


<h2>객체의 프로퍼티 값 설정하긔</h2>
<%
Product product = new Product();
product.setNo(10);
product.setName("아이폰");
product.setQuantity(200);
product.setMakerNo(1);
pageContext.setAttribute("product", product);
%>
${product.name} <br>

<!-- setter삘  c:set로 target지정하규: 특정객체 set ㅇㅋ -->
<c:set target="${product}" property="name" value="오호라폰" />
${product.name} <br>

<h2> ♥ c:remove</h2>
<p>보관소에 저장된 객체ㅈ ㅔ 거 하 기</p>
${pageScope.name1}<br>
<c:remove var="name1" scope="page" />
<%pageContext.removeAttribute("name2"); %>
제거한 후 name1은?  ${pageScope.name1}  ______(제거돼서 출력안댕안댕~~)<br>
제거한 후 name2은?  ${pageScope.name2}  ______(제거돼서 출력안댕안댕~~)<br>
</body>
</html>



