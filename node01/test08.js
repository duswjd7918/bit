/*    요청 파라미터의 값 꺼내기
 - 클라이언트가 보낸 데이터(요청파라미터)
 */

var http = require('http');
//1.URL 모듈을 가져온다.
var url = require('url');  
http.createServer(function handler(req, res) {
	//클라이언트가 보낸 name 파라미터 값을 변수에 저장하라!
	//2.URL정보 parsing(해석, 분해 분석)한다.
	var urlInfoMap=url.parse(req.url, true);///true
	//3.query객체에서 파라미터 값을 추출한다.
	var name=urlInfoMap.query.name;
	var v1=urlInfoMap.query.v1;
	var op=urlInfoMap.query.op;
	var result=0;
	var v2=urlInfoMap.query.v2;
	
    if(op=='plus'){
    	op='+';
    	result=Number(v1)+Number(v2);
    } else if(op=='minus'){
    	op='-';
    	result=Number(v1)-Number(v2);
    } else if(op=='multiple'){
    	op='*';
    	result=Number(v1)*Number(v2);
    }	else if(op=='divide'){
    	op='/';
    	result=Number(v1)/Number(v2);
    } else {
    	op='?';
    	result='error'};
	
	res.writeHead(200, 'ok',{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>test08</title></head>')
    res.write('<body>');
    res.write('<h1>계산기넹ㅎㅎ</h1>');
    res.write('<p>'+v1 + op + v2+'='+result+'</p>');
    res.write('</body></html>');
    res.end();
	console.log('cli의 request가 들어왓구만?ㅋㅋㅋokok'); // 클라이언트의 요청이들어올때!!!!
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
