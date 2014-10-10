/*   GET 요청과   POST요청 구분하기!!!!   * *  *
- request.method 프로퍼티의 값을 확인해라
 */

var http = require('http');
//1.URL 모듈을 가져온다.
var url = require('url'); 
var qs = require('querystring');

http.createServer(function handler(req, res) {
	 
   
    
    if(req.method=='GET') {
    	console.log('get요청');
  
    }  //GET일경우/
	else {  //POST경우
		console.log('post요청');
			  
	}	
    res.end();
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

