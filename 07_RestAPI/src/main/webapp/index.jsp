<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>휴대전화 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>
			</tr>
		</thead>
		<tbody id="list">
		</tbody>
	</table>
	<h1>휴대전화 정보</h1>
	<form id="phoneFrm">
		모델번호 : <input type="text" name="num" id="num"><br>
		모델명 : <input type="text" name="model" id="model"><br>
		가격 : <input type="text" name="price" id="price"><br>
		제조사 : 
		<select id="vcode" name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select>
		<br>
		<input type="button" value="추가하기" id="insert">
		<input type="button" value="수정하기" id="update">
		<input type="button" value="삭제하기" id="delete">
	</form>
<script>
function list() {
    $.ajax({
        url: 'http://localhost:8080/api/phone', 
        type: 'get', // HTTP 요청 메서드 (GET 요청을 보냅니다)
        success: function(data) {
        	// AJAX 요청이 성공하면 실행되는 함수입니다.
            // 서버에서 받은 데이터(data)를 반복하여 휴대전화 목록을 생성하고 HTML 테이블에 추가합니다.
        	//console.log(data);
        	let html = '';
	        for (let phone of data) {
	        	html += '<tr>' +
		            '<td class="num">' + phone.num + '</td>' +
		            '<td>' + phone.model + '</td>' +
		            '<td>' + phone.price + '</td>' +
		            '<td>' + phone.company.vendor + '</td>' +
	            '</tr>';
        	 }
	        //$('#list').append(html);
               $('#list').html(html);
        },
        error: function() {
            console.log('시스템 상 에러 발생!');
        }
    });
}
//list() 함수를 호출하여 휴대전화 목록을 가져옵니다.
list();

// 상세 조회
$('#list').on('click', '.num', function() {
		
	    $.ajax({
	        url: 'http://localhost:8080/api/phone' + $(this).text(), 
	        type: 'get',
	        contentType: 'application/json',
	        success: function(data) {
	            $('#num').val(data.num); //$('#num').val 부분이 해당하는 부분으로가는거 val()안은 값을 넣는것
	            $('#model').val(data.model);
	            $('#price').val(data.price);
	            $('#vcode').val(data.vcode);
	        }
	    });
});

// 추가
$('#insert').on('click', function() {
	//JSON 방식으로 전달!
	let phone = {
		num: $('#num').val(),
		model: $('#model').val(),
		price: $('#price').val(),
		vcode: $('#vcode').val()
	};
    $.ajax({
        url: 'http://localhost:8080/api/phone', 
        type: 'post', 
        data: JSON.stringfly(phone),
        contentType: 'application/json',
        success: function() {
        	//$('#list').html(''); //$('#list').append(html);방식
        	list(); //$('#list').html(html);방식
        }
    });
});

//수정
$('#update').on('click', function() {
	let phone = {
			num: $('#num').val(),
			model: $('#model').val(),
			price: $('#price').val(),
			vcode: $('#vcode').val()
		};
	    $.ajax({
	        url: 'http://localhost:8080/api/phone', 
	        type: 'put', 
	        data: JSON.stringfly(phone),
	        contentType: 'application/json',
	        success: function() {
	        	//$('#list').html(''); //$('#list').append(html);방식
	        	list(); //$('#list').html(html);방식
	        }
	    });
	});

//삭제
$('#delete').on('click', function() {
	$.ajax({
        url: 'http://localhost:8080/api/phone' + $('num').val(), 
        type: 'delete',
        success: function(data) {
            list();
            $('#num').val("");
            $('#model').val("");
            $('#price').val("");
            $('#vcode').val("10");
        }
    });

</script>
	
</body>
</html>