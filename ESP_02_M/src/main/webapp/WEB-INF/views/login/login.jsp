<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>취업지원정보 - 로그인</title>
    <style>
    .login{
        width: 410px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
    .login h2{
        font-size: 30px;
        color: rgb(47,79,79);
        text-align: center;
        border-bottom: 2px solid rgb(47,79,79);;
        line-height: 1;
        padding: 0 0 10px;
    }
    .login li{
        padding: 0 0 12px;
    }
    .login li input{
        font-size: 15px;
        width: 100%;
        height: 45px;
        box-sizing: border-box;
        text-indent: 16px;
    }
    .login li input::-webkit-input-placeholder{
        font-size: 16px; 
        color: gray;
    }
    .login ul{
        padding: 0;
        list-style: none;
        
    }
    
    .login button{
        width: 100%;
        height: 50px;
        background-color: rgb(47,79,79);
        color: white;
        font-size: 18px;
    }
    .login div {
        padding: 0 18px 0;
        display: flex;
        justify-content: center;
    }
    .login div a{
        padding: 10px;
        position: relative;
        bottom: 1rem;
    }
    div a{
        text-decoration: none;
    }
    a:hover{
        font-weight: bold;
    }
    #lb:hover{
        font-weight: bold;
    }
    section.login{
        border-radius: 5px;
    }
    body{
        background-color: rgb(245,246,247);
    }
    
    
    </style>
</head>
<body>
    <section class="login">
            <h2>LOGIN</h2>
            <ul>
                <li><input type="text" placeholder="아이디" title="아이디입력"></li>
                <li><input type="password" placeholder="비밀번호" title="비밀번호입력"></li>
                <li><a href="${rootPath}/"><button id="lb">로그인</button></a></li>
            </ul>
            
            <div>
                <a href="${rootPath}/join/agree">회원가입</a>
                <a href="">아이디찾기</a>
                <a href="">비밀번호찾기</a>
            </div>
    </section>
</body>
</html>