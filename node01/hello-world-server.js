var http = require('http');
http.createServer(function handler(req, res) {//mini server 고
    res.writeHead(200, 'ok',{'Content-Type': 'text/plain'});
    res.end('Hello World!!!\n');
	console.log('okokok'); //클라이언트의 요청이들어올때!!!!
}).listen(1337, '192.168.0.125');
console.log('Server running at http://127.0.0.1:1337/');
