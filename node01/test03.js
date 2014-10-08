var http = require('http');
http.createServer(function handler(req, res) {// mini server 고
    res.writeHead(200, 'ok',{'Content-Type': 'text/plain'});
    res.end('Hello World!!!\n');
	console.log('okokok'); // 클라이언트의 요청이들어올때!!!!
}).listen(1337, '192.168.0.125');
console.log('Server running at http://127.0.0.1:1337/');

/*
  1. HTTP 프로토콜 요청
  1)형식 ----------------------- 
  request-line(엔터) 
  헤더: 값(엔터) 
  헤더:값(엔터)
   ....
    (엔터) 
   서버에 보내는 데이터 본뮨 
   -----------------------
  
  2)예제 -------------------------
GET http://192.168.0.125:1337/ HTTP/1.1 
Host:  192.168.0.125:1337 
Connection: keep-alive 
Cache-Control: max-age=0 
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,
 /*;q=0.8
User-Agent: Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36
Accept-Encoding: gzip,deflate,sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
 ----------------------------------------
 -참고-
 헤더의 종류: 일반헤더, 요청헤더, 응답헤더, 본문헤더(entity header_
 
 
 2.HTTP 프로코톨-응답
 1)형식
 -------------------------
 상태라인(엔터)
 헤더:값(엔터)
 헤더:값(엔터)
 ...
 (엔터)
 브라우저가 출력할 본문 데이터
 ---------------------
 2)예제
 ---------------------
 HTTP/1.1 200 ok
 Content-Type: text/plain
Date: Wed, 08 Oct 2014 05:59:01 GMT
Connection: keep-alive
Content-Length: 15

Hello World!!!
 ----------------------------
 
 요청메서드
 1.GET
 1)GET 요청발생 
 -웹브라우저 주소창에 url입력후 엔터칠때 get발생
 -화면에서 링크 클릭할 
 -입력폼의 값을 기본 메서드로 전송할 때
 
 2)GET 요청에서 데이터 전송
 -요청라인 의 URL 에 포함한다.
 -예)
 
 3) 특징
 -전송 데이터의 크기가 제한된다.=>대용량 데이터 전송불가!!!
 MS IIS 웹서버 : 요청라인+헤더=16KB
 Apache 웹서버:  요청라인 + 헤더=8KB   max가..

- URL에 포함->(단점)외부에 노출됨...URL은 브라우저에서 기억해둔다..
                보안에 위협이!!!ㅠㅜ 그래서나온게 HTTP S(ecurity)
            ->(걍특징)전송할 수 있는 데이터는 문자열만 가능한다.
            ->(걍특징)이미지 음악 파일 등 바이너리 데이터 전송불가!
            :::: base-64와 같은 특별한 인코딩을 한다면
              바이너리 데이터 전송가능하다 굳이한다면!근디 비추!
  (cf)바이너리 데이터: text editor(memo)로 편집불가한것   
 - 간단한 데이터 전송할때 적합!!  예) 검색어, 게시물 조회 등
  URL에 데이터가 포함되기 때문에
     =>URL과 데이터를 함께 묶어서 다른사람에게 전달할수있다!
 4) 데이터 전송 방식
 GET url?이름=값&이름=값&이름=값... HTTP/1.1
 
 
 2.POST 요청
 1)POST요청 발생 예
  form의 값을 전송할 때 단, method 속성이 'post'로 지정되어야 한다.
 2)데이터 전송 방식
 POST http://192.168.0.125:1337/ HTTP/1.1
 HOST: 192. ....
 Connection: keep-alive
  ...
 (엔터)
 userid=ohora2&pwd=111222
 
 3)특징
 -대용량 데이터 전송 가능. 서버에서 크기를 제한하지 않는 한에선
 무제한으로 데이터를 전송할 수 있다.->ex게시물등록.로그인에쓰임多
 -데이터가 주소창에 보이지 않는다.->(장점)외부에 쉽게 노출 ㄴㄴ
            (단점) 즐겨찾기에 URL과함께 데이털 저장할 수 없다.
-멀티파트 인코딩 방식을 결합하면 바이너리 데이터 전송도 가능하다.            

 3.파일 업로드   web browser----[file]------>server
 -post방식으로 전송
 -<form>의 enctype='multipart/form-data' 이다!
 -전송 ㅇㅖ)
 POST http://192.168.0.32:1337/ HTTP/1.1
 HOST: ...
 Connection:...
 Content-Type: multipart/form-data; boundary=---WebLotFormBounda
 ...
 (엔터)
 ----WebKitFormBoundaryKQ#$#W$%
 
 
 WebKitFormBoundary는 랜덤한 값임ㅋㅋㅋㅋ알아서지정해줌
*/