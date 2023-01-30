<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 가입</title>
		<link rel="stylesheet" href="regi.css">
	</head>
	<body>
		<!--  -->
		<!--  -->
		<form action="joinAction.jsp" method="POST">
		<h3>회원가입</h3>
		<hr>
		<table>
			<tr>
				<td>
					<label for="lblUid">ID</label>
				</td>
				<td>
					<input type="text" id="lblUid" name="id">
				</td>
			</tr>
			
			<tr>
				<td>
					<label for="lblName">이름</label>
				</td>
				<td>
					<input type="text" id="lblName" name="name">
				</td>
			</tr>
			
			<tr>
				<td>
				<label for="lblPassword">패스워드</label>
				</td>
				<td>
					<input type="password" id="lblPassword" name="password">
				</td>
			</tr>

			<tr>
				<td>
					<label for="lblEmail">이메일</label>
				</td>
				<td>
					<input type="text" id="lblEmail" name="email">
				</td>
			</tr>

			<tr>
				<td>
					<label for="lblAge">나이</label>
				</td>
				<td>
					<input type="number" id="lblAge" name="age">
				</td>
			</tr>

			<tr>
				<td>
					<label>성별</label>
				</td>
				<td>
					<!-- radio 버튼은 여러개 중 단일 선택. name 속성값으로 그룹화 -->
					<input type="radio" name="gender" id="lblMale" value="male">
					<label for="lblMale">남성</label>
					<input type="radio" name="gender" id="lblFemale" value="female">
					<label for="lblFemale">여성</label>
					<input type="radio" name="gender" id="lblUnkown" value="unknown" checked="checked">
					<label for="lblUnkown">모름</label>
				</td>
			</tr>

			<tr>
				<td>
					<label>취미</label>
				</td>
				<td>
					<!-- checkbox는 다중 선택. toggle 동작 -->
					<input type="checkbox" id="lblSoccer" name="hobby" value="축구">
					<label for="lblSoccer">축구</label>
					<input type="checkbox" id="lblBasketball" checked="checked" name="hobby" value="야구">
					<label for="lblBasketball">농구</label>
					<input type="checkbox" id="lblRun" name="hobby" value="달리기">
					<label for="lblRun">달리기</label>
					<input type="checkbox" id="lblSwim" name="hobby" value="수영">
					<label for="lblSwim">수영</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>가입하기</button>		
					<!-- form tag안에 있을 시 type="submit" 생략됨 -->
					<button type="reset">다시쓰기</button>
					<button type="button" onclick="location.href='/jsp'">HOME</button>
					<!-- onclick은 자바스크립트 코드를 작성 -->
				</td>
			</tr>
		</table>
		<hr>
		</form>
	</body>
</html>