<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<style>
#bg {
	background: url("../../resource/images/background.png") no-repeat;
}

.wrap-content {
	width: 1020px;
	min-height: inherit;
	margin-left: auto;
	margin-right: auto;

	/* opacity:0.1; /*투명도  */
	*/
}

#header {
	position: fixed;
	top: 0px;
	width: 100%;
	height: 65px;
	margin-left: auto;
	margin-right: auto;
	background: white;
	font-size: 25px;
	display: block;
}

.hidden {
	display: none;
	visibility: hidden;
}

#body {
	margin-top: 65px;
	width: 1160px;
	height: 800px;
	margin-left: auto;
	margin-right: auto;
}

#footer {
	width: 1020px;
	height: inherit;
	margin-left: auto;
	margin-right: auto;
	background-color: rgba(255, 255, 255, 0.7);
}

#aside {
	width: 70px;
	height: inherit;
	margin-left: auto;
	margin-right: auto;
	float: left;
	position: fixed;
	left: 50px;
	top: 50%;
}

#aside:hover {
	width: 500px;
	height: 700px
}

#main {
	width: 1020px;
	height: inherit;
	margin-left: auto;
	margin-right: auto;
	/* float: left; */
	background-color: rgba(255, 255, 255, 0.7);
}

.clearfix:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
}

#header li {
	float: left;
}
</style>
</head>
<body id="bg">
	<header id="header" class="wrap-content">
		<h1>
			<a href="" alt="Tradia"><img src="../resource/images/logo.png"></a>
		</h1>

		<section>
			<h1 class="hidden">메인 메뉴</h1>

			<section>
				<h1 class="hidden">여행기 검색 폼</h1>
				<form>
					<fieldset>
						<legend class="hidden">통합검색</legend>
						<label class="hidden">검색</label> <input type="text"
							value="가고싶은 여행지를 검색하세요" /> <input type="submit" value="검색" />
					</fieldset>
				</form>
			</section>
			<nav>
				<h1 class="hidden">프로필</h1>
				<ul>
					<li>ProfilePicture</li>
					<li>${m.id}</li>
					<li><a href=""> ButtonImage</a>
						<ul class="sub">
							<li><a href="">MyPage</a></li>
							<li><a href="">내정보</a></li>
							<li><a href="">스크랩목록</a></li>
							<li><a href="">도움말</a></li>
							<li><form method="post">
									<a href="../intro/intro"><input type="button" name="logout"
										value="로그아웃"></a>
								</form></li>
							<li><a href="">+작성하기</a></li>
						</ul>
				</ul>
			</nav>
		</section>
	</header>
	<div id="body" class="wrap-content clearfix">
		<aside id="aside">
			<h1 class="hidden">SelectPreferLocation</h1>

			<section>
				<h1 class="hidden">PreferLocationButton</h1>
				<form>
					<fieldset>
						<legend class="hidden">지역선택</legend>
						<label class="지역선택" for="location">지역선택</label> <input
							type="radio" name="location">전국 <input type="radio"
							name="location">서울 <input type="radio" name="location">경기
						<input type="radio" name="location">인천 <input type="radio"
							name="location">강원 <input type="radio" name="location">충청
						<input type="radio" name="location">대전 <input type="radio"
							name="location">전라 <input type="radio" name="location">광주
						<input type="radio" name="location">경상 <input type="radio"
							name="location">대구 <input type="radio" name="location">울산
						<input type="radio" name="location">부산 <input type="radio"
							name="location">제주 <input type="submit" value="선택하기">
					</fieldset>
				</form>
			</section>
		</aside>
		<main id="main">
		<div>
			<section id="section">
				<h1 class="hidden">기본정보</h1>
				<section>
					<article>안녕하세요! TRADIA에 오신것을 환영합니다. 메인페이지에 띄울 선호 지역을
						선택해주세요. (다중 선택 불가) ${m.id}</article>
				</section>
				<section>
					<h1 class="hidden">선호지역선택</h1>
					<section>
						<h1 class="hidden">선호지역</h1>
						<p class="hidden">지역사진</p>
						<img src="../resource/images/korea_map.png">
						<form method="post">
							<fieldset>
								<legend>지역선택</legend>
								<label class="지역선택" for="preferLocation">지역선택</label> <input
									type="radio" name="preferLocation" value="0" checked>전국
								<input type="radio" name="preferLocation" value="1">서울 <input
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
									type="radio" name="preferLocation" value="13">제주 <br />
								<input type="submit" value="선호지역 선택하기">
							</fieldset>
						</form>
					</section>
				</section>
			</section>
		</div>
		</main>
	</div>
	<footer id="footer" class="wrap-content">
		<section>
			<h1 class="hidden">Tradia</h1>

			<section>
				<h1 class="hidden">사이트 하이퍼 링크</h1>
				<ul>
					<li><a href="" alt="메인">메인</a></li>
					<li><a href="" alt="공지사항">공지사항</a></li>
					<li><a href="" alt="도움말">도움말</a></li>
				</ul>

			</section>
			<section>
				<h1 class="hidden">관리자 정보</h1>
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
					<dd>이민우, 김용, 조수나, 윤세리, 권한</dd>
				</dl>
			</section>
			<section>
				<h1 class="hidden">저작권 정보</h1>
				<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
					pjh5263@tradia.com</p>
			</section>
		</section>
	</footer>
</body>
</html>