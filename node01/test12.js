/*   GET 요청과   POST요청 구분하기!!!!   * *  *
- request.method 프로퍼티의 값을 확인해라
 */

var http = require('http');
var url= require('url');///test/okok?v1=4&op=plus&v2=2

http.createServer(function handler(req, res) {
	 
   
    
    if(req.method=='GET') {
    	console.log('get요청');
    	
    	//parse를 이용하여 url의 정보를 분석하자 
    	//=>특히  query string(url中 물음표다음에 오는데이타)은 분해해서 객체로 만들앙!
    	var obj=url.parse(req.url,true);
    	console.log('URL:', obj.href);
    	console.log('경로:', obj.pathname);
    	console.log('경로 외:', obj.search);
    	console.log('쿼리 스트링을 객체로 변환 한 것:',obj.query);
    }  
	else {  
		console.log('post요청');
			  
	}	
    res.end();
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

