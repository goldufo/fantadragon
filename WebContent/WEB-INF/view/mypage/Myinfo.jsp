
<%@page import="com.fantastic.web.vo.Member"%>
<%@page import="com.fantastic.web.dao.mybatis.MybatisMemberDao"%>
<%@page import="com.fantastic.web.dao.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../resource/css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>
<style>
#back-ground {
	background: url("../../resource/images/background.png");
}

.quick-menu {
	height: 65px;
	width: 100%;
	position: fixed;
	/* left: ?; */
	top: 0px;
	background: white;
}

.content-wrapper {
	width: 960px;
	height: 100%;
	/* height: inherit; */
	margin-left: auto;
	margin-right: auto;
	/* background: yellow;	
	opacity: 0.3; */
}

#main-menu {
	height: 65px;
}

#footer {
	height: inherit;
	
}

#information {
	height: inherit;
}

#aside {
	height: inherit;
	width: 80px;
	/* 	background: blue; */
	float: left;
	margin-top: 65px;
	min-height: 450px;
}

/* #body {
	height: 300px;
	background: beige;
} */
#profile {
	width: 880px;
	background: #50b4ff;
	float: left;
	margin-top: 65px;
	min-height: 300px;
}

#my-info {
	height: inherit;
	width: 140px;
	float: left;
	min-height: 300px;
	margin: 10px;
}

#normal-info {
	height: inherit;
	width: 700px;
	float: left;
	min-height: 300px;
	background: white;
	margin: 10px;
	font-family: SeoulNamsan;
	font-size: 15px;
	font-weight: bold;
}

#normal-info-title {
	margin: 20px;
	font-size: 20px;
}

#normal-info input[type="text"] {
	background: grey;
	width: 200px;
	height: 25px;
	border: 1px solid #50b4ff;
}

.first-info {
	margin-left: 150px;
}

.gender-margin {
	margin-left: 50px;
}
#normal-info dt, dd {
	margin:20px;
}

#profile-image {
	position: absolute;
	width: 150px;
	height: 150px;
	margin-left: 10px;
	margin-top: 150px;
	background: url("../../resource/images/profile-pic.png") no-repeat center;
}

#button {
	margin-top: 10px;
	margin-bottom: 20px;
	margin-left: 283px;
	width: 134px;
	height: 48px;
	border: 0px;
	background: url("../../resource/images/btn_modify.png");
	text-indent: -999px;
}

.hidden {
	display: none !important;
}
</style>
</head>
<body id="back-ground">
	<header>
		<div class="quick-menu">
			<div id="main-menu">
				<h1>
					<a href="" alt="Tradia">Tradia</a>
				</h1>
				<%-- <section>
					<h1>메인 메뉴</h1>
					<section>
						<h1>여행기 검색 폼</h1>
						<form method="post">
							<legend>통합검색</legend>
							<label>검색</label> <input type="text" value="가고싶은 여행지를 검색하세요" />
							<input type="submit" value="검색" />
							<li>${m.id}</li>
							<fieldset>
								<li><img src="../../resource/images/icon.png" alt="icon" />-클릭</li>
							</fieldset>
							<ul class="sub">
								<li><a href="mypage">MyPage</a></li>
								<li><a href="myinfo">내정보</a></li>
								<li><a href="scrapinfo">스크랩목록</a></li>
								<li><a href="">도움말</a></li>
								<li><a href="">로그아웃</a></li>
								<li><a href="">+작성하기</a></li>
							</ul>
							</li>
						</form>
					</section>
				</section> --%>
			</div>
		</div>
	</header>
	<div class="content-wrapper">
		<aside id="aside">
			<h1>SelectPreferLocation</h1>

			<section>
				<h1>PreferLocationButton</h1>
				<form>
					<legend>지역선택</legend>
					<label class="지역선택" for="location">지역선택</label> <input type="radio"
						name="location">전국 <input type="radio" name="location">서울
					<input type="radio" name="location">경기 <input type="radio"
						name="location">인천 <input type="radio" name="location">강원
					<input type="radio" name="location">충청 <input type="radio"
						name="location">대전 <input type="radio" name="location">전라
					<input type="radio" name="location">광주 <input type="radio"
						name="location">경상 <input type="radio" name="location">대구
					<input type="radio" name="location">울산 <input type="radio"
						name="location">부산 <input type="radio" name="location">제주
				</form>
			</section>
		</aside>
		<main>

		<nav id="profile">
			<h1 class="hidden">프로필</h1>
			<form method="post">
				<ul>
					<li id="profile-image"/>
					<dl class="article-detail-row">
						<dt class="article-detail-title hidden">사진수정</dt>
						<dd class="article-detail-data">
							&nbsp;<input type="file" id="txtFile" name="file" />
						</dd>
						<input type="submit" value="수정" />
					</dl>
				</ul>
			</form>
		</nav>
		<section id="information">
			<section id="my-info">
				<div>
					<dd class="hidden">내 소개</dd>
					<textarea id="txtContent" rows="15" cols="16" class="txtContent"
						name="content"></textarea>
				</div>
				<div>
					<dd>
						<a href="mypage">My Page</a>
					</dd>
				</div>
				<div>
					<dd>
						<a href="myinfo">내 정보</a>
					</dd>
				</div>
				<div>
					<dd>
						<a href="scrapinfo">스크랩 목록</a>
					</dd>
				</div>
			</section>
			<section>
				<section id="normal-info">
				<h1 class="hidden">기본정보</h1>

					<form method="post">
					<h1 id="normal-info-title">프로필정보</h1>
						<dl>
							<dt>ID</dt>
							<dd class="first-info">${m.id}</dd>
							<dt>비밀번호</dt>
							<dd class="first-info">${m.password}</dd>

							<label class="hidden">새 비밀번호</label>
							<input class="first-info" type="text" value="새 비밀번호" name="password">
							<label class="hidden">새 비밀번호 확인</label>
							<input type="text" value="새 비밀번호 확인" name="password2">

							<dt>생년월일</dt>
							<dd class="first-info">${m.birthday}</dd>

							<label class="hidden">생년월일 입력</label>
							<input class="first-info" type="date" name="birthday">

							<dt>성별</dt>

							<c:if test="${m.gender == 0}">
								<dd class="first-info">남</dd>
							</c:if>
							<c:if test="${m.gender == 1}">
								<dd class="first-info">여</dd>
							</c:if>

							<label class="hidden" for="gender">성별선택</label>

							<!-- <label>성별</label>
						<input type="text" name="gender"> -->

							<c:if test="${m.gender == 0}">
								<input class="first-info" type="radio" name="gender" checked="checked" value="man">남
						<input class="gender-margin" type="radio" name="gender" value="1">녀
						</c:if>
							<c:if test="${m.gender == 1}">
								<input class="first-info" type="radio" name="gender" value="0">남
						<input class="gender-margin" type="radio" name="gender" checked="checked" value="woman">녀
						</c:if>
							<c:if test="${m.gender == null}">
								<input class="first-info" type="radio" name="gender" value="0">남
						<input class="gender-margin" type="radio" name="gender" value="1">녀
						</c:if>
						</dl>
						<label class="hidden">수정</label>
						<input id="button" type="submit" value="수정" />
					</form>

				</section>
			</section>
			<!-- <section>
			<fieldset>
				<h1>선호지역</h1>
				<p>지역사진</p>
				<form method="post">
					<legend>지역선택</legend>
					<label class="지역선택" for="preferLocation">지역선택</label> <input
						type="radio" name="preferLocation" value="0">전국 <input
						type="radio" name="preferLocation" value="1">서울 <input
						type="radio" name="preferLocation" value="2">경기 <input
						type="radio" name="preferLocation" value="3">인천 <input
						type="radio" name="preferLocation" value="4">강원 <input
						type="radio" name="preferLocation" value="5">충청 <input
						type="radio" name="preferLocation" value="6">대전 <input
						type="radio" name="preferLocation" value="7">전라 <input
						type="radio" name="preferLocation" value="8">광주 <input
						type="radio" name="preferLocation" value="9">경상 <input
						type="radio" name="preferLocation" value="10">대구 <input
						type="radio" name="preferLocation" value="11">울산 <input
						type="radio" name="preferLocation" value="12">부산 <input
						type="radio" name="preferLocation" value="13">제주
				</form>
			</fieldset>
		</section> -->
		</main>
		<footer id="footer">
			<section>
				<h1>Tradia</h1>

				<section>
					<h1>사이트 하이퍼 링크</h1>
					<ul class="article-detail-data">
						<li><a href="" alt="메인">메인</a></li>
						<li><a href="" alt="공지사항">공지사항</a></li>
						<li><a href="" alt="도움말">도움말</a></li>

					</ul>

				</section>
				<section>
					<h1>관리자 정보</h1>
					<dl>
						<dt>주소:</dt>
						<dd>서울특별시 마포구</dd>
						<dt>관리자메일:</dt>
						<dd>pjh5263@naver.com</dd>
						<dt>전화:</dt>
						<dd>010-0000-0000</dd>
						<dt>대표:</dt>
						<dd>박종하</dd>
						<dt>관리자:</dt>
						<dd>
							이민우, <a href="download?f=mys-release.apk" alt="yong-game-down">김용</a>,
							조수나, 윤세리, 권한
						</dd>
					</dl>
				</section>
				<section>
					<h1>저작권 정보</h1>
					<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
						pjh5263@tradia.com</p>
				</section>
			</section>
		</footer>
	</div>
</body>
</html>