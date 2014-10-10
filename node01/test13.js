/*   GET 요청과   POST요청 구분하기!!!!   * *  *
- request.method 프로퍼티의 값을 확인해라
 */

var http = require('http');
var url= require('url');///test/okok?v1=4&op=plus&v2=2

http.createServer(function handler(req, res) {
	 
   
    
    if(req.method=='GET') {
    	console.log('get요청-------------------------');
    	
    	//parse를 이용하여 url의 정보를 분석하자 
    	//=>특히  query string(url中 물음표다음에 오는데이타)은 분해해서 객체로 만들앙!
    	var obj=url.parse(req.url,true);
    	//쿼리 객체에서 요청 값을 꺼낸다.
    	var v1= parseInt(obj.query.v1,10);
    	var v2= parseInt(obj.query.v2,10);//10진수로 바꿔줭!!
    	var op= obj.query.op;
    	
    	var result= v1+v2;
    	console.log(op,result);
    
    
    }  
	else {  
		console.log('post요청');
			  
	}	
    res.end();
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

