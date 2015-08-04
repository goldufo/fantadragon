<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>
<style>
.clearfix:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
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
	background: aqua;
}

#footer {
	height: inherit;
	background: orange;
}

#information {
	height: inherit;
}

#aside {
	height: inherit;
	width: 80px;
	background: blue;
	float: left;
	min-height: 450px;
}

/* #body {
	height: 300px;
	background: beige;
} */
#profile {
	width: 880px;
	background: green;
	float: left;
	min-height: 150px;
}

#my-info {
	height: inherit;
	width: 140px;
	background: maroon;
	float: left;
	min-height: 300px;
}

#normal-info {
	height: inherit;
	width: 740px;
	background: grey;
	float: left;
	min-height: 300px;
}
</style>
</head>
	<body class="content-wrapper clearfix:after">
		<header>
			<div id="main-menu">
			<h1>
				<a href="" alt="Tradia">Tradia</a>
			</h1>
				<section>
				<h1>메인 메뉴</h1>
					<section>
					<h1>여행기 검색 폼</h1>
						<form>
							<legend>통합검색</legend>
							<label>검색</label> 
							<input type="text" value="가고싶은 여행지를 검색하세요" /> 
							<input type="submit" value="검색" />
						</form>
						<form method="post">
							<li>MemberId</li>
							<li><a href=""> ButtonImage</a>
							<ul class="sub">
								<li><a href="">MyPage</a></li>
								<li><a href="myinfo">내정보</a></li>
								<li><a href="scrapinfo">스크랩목록</a></li>
								<li><a href="">도움말</a></li>
								<li><a href="">로그아웃</a></li>
								<li><a href="">+작성하기</a></li>
							</ul>
						</form>
					</section> 
				</section>
			</div>
		</header>
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
	</section> </section> </aside>
	<nav id="profile">
	<h1>프로필</h1>
	<form method="post">
		<ul>
			<li>프로필 사진</li>
			<dl class="article-detail-row">
				<dt class="article-detail-title">사진수정</dt>
				<dd class="article-detail-data">
					&nbsp;<input type="file" id="txtFile" name="file" />
				</dd>
				<input type="submit" value="수정" />
			</dl>
	</form>
	</nav>



	</div>
	<main class="clearfix:after">
		<section id="my-info">
			<div>
				<fieldset>
				<ul>
					<li>내 소개</li>
				</ul>
				</fieldset>
			</div>
			<div>
				<fieldset>
				<ul>
					<li><a href="mypage">My Page</a></li>
				</ul>
				</fieldset>
			</div>
			<div>
			<fieldset>
			<ul>
				<li><a href="myinfo">내 정보</a></li>
			</ul>
		</fieldset>
	</div>
	<div>
		<fieldset>
			<ul>
				<li><a href="scrapinfo">스크랩 목록</a></li>
			</ul>
		</fieldset>
	</div>
	</section> <section id="normal-info">
	<h1>스크랩 목록</h1>
	<section>
	<fieldset>
		<h1>스크랩 여행기1</h1>
		<ul>
			<li>스크랩 회원사진</li>
			<li>스크랩 회원닉네임</li>
			<li>여행기 제목</li>
			<li>좋아요</li>
			<li>여행기코스</li>
			<li>여행사진1</li>
			<li>여행사진2</li>
			<li>여행사진3</li>
			<li>여행사진4</li>
		</ul>
	</fieldset>
	</section> <section>
	<fieldset>
		<h1>스크랩 여행기2</h1>
		<ul>
			<li>스크랩 회원사진</li>
			<li>스크랩 회원닉네임</li>
			<li>여행기 제목</li>
			<li>좋아요</li>
			<li>여행기코스</li>
			<li>여행사진1</li>
			<li>여행사진2</li>
			<li>여행사진3</li>
			<li>여행사진4</li>
		</ul>
	</fieldset>
	</section> </section> </main>
	<footer id="footer"> <section>
	<h1>Tradia</h1>

	<section>
	<h1>사이트 하이퍼 링크</h1>
	<ul class="article-detail-data">
		<li><a href="" alt="메인">메인</a></li>
		<li><a href="" alt="공지사항">공지사항</a></li>
		<li><a href="" alt="도움말">도움말</a></li>

	</ul>

	</section> <section>
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
	</section> <section>
	<h1>저작권 정보</h1>
	<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
		pjh5263@tradia.com</p>
	</section> </section> </footer>
</body>
</html>