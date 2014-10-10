/*   GET 요청과   POST요청 구분하기!!!!   * *  *
- request.method 프로퍼티의 값을 확인해라
 */

var http = require('http');
//1.URL 모듈을 가져온다.
var url = require('url');  
http.createServer(function handler(req, res) {
	 res.writeHead(200, 'ok',{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>test08</title></head>')
    res.write('<body>');

    if(req.method=='GET') {
			
	var urlInfoMap=url.parse(req.url, true);
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
	
	
    res.write('<h1>계산기넹ㅎㅎ</h1>');
    res.write('<p>'+v1 + op + v2+'='+result+'</p>');
    }  //GET일경우까지
	else {  //POST경우
		res.write(req.method + '요청을 지원하지 않습니다.');
	}	
	
	res.write('</body></html>');
	res.end();

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
