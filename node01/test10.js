/*   GET 요청과   POST요청 구분하기!!!!   * *  *
- request.method 프로퍼티의 값을 확인해라
 */

var http = require('http');
//1.URL 모듈을 가져온다.
var url = require('url'); 
var qs = require('querystring');

http.createServer(function handler(req, res) {
	 
    var v1, v2,op;
    
    if(req.method=='GET') {
			
    	var urlInfoMap=url.parse(req.url, true);
    	var name=urlInfoMap.query.name;
    	v1=urlInfoMap.query.v1;
    	op=urlInfoMap.query.op;
    	v2=urlInfoMap.query.v2;
	
    	displayResult(req,res,v1,v2,op);
    }  //GET일경우/
	else {  //POST경우
			var messageBody='';
			//data 이벤트는 클라이언트에서 데이터를 읽을 때 마다 
			//일정 시간 or 일정 크기 단위로  발생한다.
			//data 이벤트가 발생할 때 마다 등록된 함수를 호출한다.
			//따라서 개발자는 client가 보낸 데이터를 받고싶으믄
			//data 이벤트에 리스너를 등록하고 리스너가 호출될 때
			//넘어오는 파라미터 값을 보관하면 된다.
			   req.on('data',function(chunk){ //이함수는 cli가 요청하는 만큼 호출됨
				messageBody+= chunk;
				});
			   req.on('end',function(chunk){//cli가 보낸 data 다 읽음/
				   console.log(messageBody);
				   var paramMap = qs.parse(messageBody);
				  /* console.log('v1=', paramMap.v1);
				   console.log('op=', paramMap.op);
				   console.log('v2=', paramMap.v2);*/
				   v1= paramMap.v1;
				   op= paramMap.op;
				   v2= paramMap.v2;
				
				   displayResult(req,res,v1,v2,op);
			   });
		

		
			  
		}	
  
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

function displayResult(req,res, v1, v2, op){
	res.writeHead(200, 'ok',{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>test10</title></head>')
    res.write('<body>');
    var result=0;

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
    
    res.write('</body></html>');
	res.end();

	
}
