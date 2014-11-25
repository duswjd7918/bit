<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>   JSTL   </title>
</head>
<body>
gradle에 이미 라이브러리 추가 되어있어야 해쎠쎠
<h1> JSTL 사용 </h1>

<p>JSTL 은 JSP확장 태그이다.  별도의 라이브러리(두가지)를 추가해야한다!</p>
<h2> 1. 라이브러리 추가</h2>
<ul>
  <li> JSTL API=> JSTL 관련 class와 interface정의되어있는 라이브러뤼  </li>
  <li> JSTL API 구현체 => JSTL 규약에 따라 만든 클래스들</li>
</ul>

<h2> 2. JSP 페이지에 사용할 태그를 임포트!</h2>
<p>
라이브러리명 :약자: 태그 라이브러리 URL                      <br>
Core     : c    :http://java.sun.com/jsp/jstl/core     <br>
XML      : x    :http://java.sun.com/jsp/jstl/xml      <br>
I18N     : fmt  :http://java.sun.com/jsp/jstl/fmt      <br>Internationalization I18N 국제화
Database : sql  :http://java.sun.com/jsp/jstl/sql      <br>
Functions: fn   :http://java.sun.com/jsp/jstl/functions<br>
</p>
<p>
&lt;%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
</p>
</body>
</html>