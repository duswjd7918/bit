/*  URL 알아내기
 *  -request.url    =>  URL 정보 추출
 *  ㅇㅖ) GET /status?name=ryan HTTP/1.1\r\n
 *    리턴값           =>   /status?name=ryan
 */

var http = require('http');  //http 객체 가져오기
var url = require('url');    //url 객체 가져오
http.createServer(function handler(req, res) {// 서버에서 UI생성=dynamic resource동적자원
	console.log(req.url);
	
	//url로부터 경로 정보와 데이터 정보를 분리하여 추출!
	 var urlInfoMap=url.parse(req.url);
	 console.log('URL전체 내용:',urlInfoMap);
	 console.log('경로:',urlInfoMap.pathname);
	 console.log('데이터:',urlInfoMap.search);
	 console.log('query string:',urlInfoMap.query);
    res.writeHead(200, 'ok',{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>test05</title></head>')
    res.write('<body>');
    res.write('<h1>오호라 이거은 노드 제이에스임</h1>');
    res.write('<p>자바 스크립트만 제대로 배워도 서버측 애플리케이션을 개발할 수 있당</p>');
    res.write('</body></html>');
    res.end('Hello World!!!\n');
	console.log('okokok'); // 클라이언트의 요청이들어올때!!!!
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
