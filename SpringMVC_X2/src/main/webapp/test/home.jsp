<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>




<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/webapp/css/home.css" type="text/css">


<style>





* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}


.menu{

	float:right;

}


/* Style the top navigation bar */
.topnav {
    padding-left:0;
  overflow: hidden;
  background-color: #333;
}








/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create three unequal columns that floats next to each other */
.column {
  float: left;
  padding: 10px;
}

/* Left and right column */
.column.side {

padding-top: 15%;

background-color: ghostwhite;
     width: 10%;
     height:100%;
}

.column.side a{

font-size:1rem;
text-align: center;
padding-left: 45px;


}

/* Middle column */
.column.middle {
width: 70%;
 height:100%;
}






/* Clear floats after the columns 
.row:after {
  content: "";
  display: table;
  clear: both;
}
*/

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column.side, .column.middle {
    width: 100%;
  }
}


</style>

</head>
<body>

<div class="header">
	<p>아아</p>

</div>


	<div class="topnav">

			<a href="/webapp/test/login.jsp">로그인</a>
			<a href="${rootPath}/dept/list">대상</a>
			<a href="${rootPath}/student/list">지역</a>
			<a href="${rootPath}/member/login">뉴스</a> 
			<a href="${rootPath}/member/join">정책자료실</a>

	</div>
   








  <div class="column side">
   
    	<p><a href="">사이드메뉴</a>
  	 	<p><a href="">사이드메뉴</a>
    	<p><a href="">사이드메뉴</a>
    	<p><a href="">사이드메뉴</a>
    	<p><a href="">사이드메뉴</a>
   
  </div>
  
  <div class="column middle">
    <h2>Main Content</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque ultricies, eget elementum magna tristique. Quisque vehicula, risus eget aliquam placerat, purus leo tincidunt eros, eget luctus quam orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
  </div>
  
  
  
 
  
</body>
</html>
