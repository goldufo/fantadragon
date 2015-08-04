<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxName" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>
<style>
.back-ground {
	background: url("../images/background.png");	
}
</style>
</head>
<body class="back-ground">
   <main>
      <section>
         <h1>Intro</h1>
         
         <img src ="" alt="TRADIA"/>
      
      
         <form action="${ctxName}/j_spring_security_check" method="post">

            <legend>E-mail 입력</legend>
            <label>E-mail</label> <input name="j_username" type="text" name="id" />
         <br/>
            <legend>비밀번호입력</legend>
            <label>비밀번호</label> <input name="j_password" type="password" name = "pw"/>
               
         <nav>
            <h1>버튼 목록</h1>
            <p>
               <a href="../join/join">
                  
                     <legend>회원가입버튼</legend>
                     <label>회원가입</label> <input type="button" value="회원가입" />
                     
               </a> 
               <a href="">
                  
                     <legend>로그인버튼</legend>
                     <label>로그인</label> <input type="submit" value="로그인" />
                     
                  </a>
               </p>
            </nav>
   
         </form>         
      </section>

   </main>   
</body>
</html>