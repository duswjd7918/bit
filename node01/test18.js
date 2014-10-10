/*   GET 요청과   POST요청 구분하기!!!!   * *  *
- request.method 프로퍼티의 값을 확인해라
 */

var http = require('http');
var url= require('url');///test/okok?v1=4&op=plus&v2=2

http.createServer(function handler(req, res) {
	 //오직 pathname이 /calc 일때만 실행하도록합시다ㅏㅏㅏㅏㅏㅏ
	var obj=url.parse(req.url,true);
	
	 //pathname이 calc가 아닌 /favicon.ico며 ㅃㅃ
	//클라이언트가 요청한 것을 걸러낸당ㅇ
	if(obj.pathname != '/calc'){ 
		res.end();
		return;		
	}
	 
    if(req.method=='GET') {
    	console.log('get요청-------------------------');
    	
    	//parse를 이용하여 url의 정보를 분석하자 
    	//=>특히  query string(url中 물음표다음에 오는데이타)은 분해해서 객체로 만들앙!
    	//쿼리 객체에서 요청 값을 꺼낸다.
    	var v1= parseInt(obj.query.v1,10);
    	var v2= parseInt(obj.query.v2,10);//10진수로 바꿔줭!!
    	var op= obj.query.op;
    	
    	//계산주렴 "함수"얌
    	var result=compute(v1,op,v2);
    	
    	displayResult(res,v1+' '+op+ ' ' +v2+' = '+result);
    }  
    
    
    
	else {  
		console.log('post요청--------------------------');
	}	
    
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

function compute(v1,op,v2){
	switch(op){
	case 'plus': return v1+v2;
	case 'minus': return v1-v2;// return 있응까   break; 필요음슴
	case 'multiple': return v1*v2;
	case 'divide': return v1/v2;
	default: console.log('해당 연산자를 지원하지 않습니다.');
	}
	return 0;
}

function displayResult(res,content){
	res.writeHead(200,'OK',{
		 'Content-Type':'text/html; char-set=UTF-8' 
	 });
   res.write('<html><head><title>계산결과</title></head>');
   res.write('<body>');
   res.write(content);//\\//\\//C  O   N   T   E   N   T//\\//\\//\\//
   res.write('</body></html>');
   res.end();
}