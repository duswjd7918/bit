/* DISTINCT
 * 중복 데이터 제거
 */

/*1.모든 제품번호를 출력해*/
select PNO from PRODUCTS;

/*2.모든 주문제품의 번호를 출력하라*/
select PNO from ORDERS;

/*3.주문한 제품이 무엇이 있는지 목록을 출력하라.*/
/*중복제거 DISTINCT*/
select DISTINCT PNO FROM ORDERS; 

/*ORDER BY 절
  출력 결과를 정렬
 * 문법:
   ORDER BY /*ASC*/컬럼명, /*ASC*/컬럼명, ...
   ORDER BY DESC 컬럼명, /*ASC*/컬럼명, ...
  =>나열된 컬럼순서대로 정렬한다. 기본은 상향 정렬(ㄱ~ㅎ)! 
*정렬조건
ASC(ENDING) : 오름차순
DESC(ENDING) : 내림차순

*ORDERS BY 절 수행 후 -> SELECT가 비로소 실행 ㅋ.ㅋ

*/

/*1) 기본출력 */
select * from MEMBERS;

/*2) 이름을 오름차순으로 정렬하라.*/
select uid, uname, email from MEMBERS ORDER BY UNAME;

/*3)이름을 내림차순으로 정렬하라*/
select uid, uname, email from MEMBERS ORDER BY UNAME DESC;

/*4) 주문정보를 제품 번호의 오름차순으로 정렬하라.*/
select * from ORDERS ORDER BY PNO;

/*5) 주문정보를 제품 번호의 오름차순으로 정렬하고
   && 사용자 아이디로 오름차순으로 정렬하라..*/
select * from ORDERS ORDER BY PNO, UID;
/* 6)주문정보를 제품 번호의 오름차순으로 정렬하고
   && 사용자 아이디로 내차순으로 정렬하라*/
select * from ODRERS ORDER BY PNO, UID DESC;

/* 7) 정렬을 먼저 한 다음 select 실행.*/
select ONO, ODATE from ORDERS ORDER BY PNO, UID DESC;


/* 별명 붙이기!
 * 문법: 
 * SELECT 컬럼명 [as] 별명,...*/

select ONO AS NO, ODATE AS 'Order Date',
PNO 'Product No', UID id from ORDERS;

/*where 절
 * 문법: WHERE 조건1 (AND|OR) 조건2...
 * */


/*1) 더하기 연산자*/
select ono, qty, qty * 500000 AS TOTAL from ORDERS;

/*2)비교 연산자*/
select ONO, QTY from ORDERS
where QTY>2;

select ONO, QTY from ORDERS
where QTY=1;


select ONO, QTY from ORDERS
where QTY > 2 AND QTY <= 5;

/*3)문자열 비교*/
select UID, UNAME, EMAIL from MEMBERS
where UNAME = '홍길동';
 /*  %는  0개 이상의 글자*/
select UID, UNAME, EMAIL from MEMBERS
where UNAME LIKE '김%';
/* _는 1개의 글자를 갈킴^.^ */
select UID, UNAME, EMAIL from MEMBERS
where UNAME LIKE '김_진';


/*제품명에 '럭시'라는 글자를 포함한 모든 제품 선택하긔
 * 주의:  검색속도가 매우 느림... %를 남발하지*/
select PNO, PNAME from PRODUCTS
where PNAME LIKE '%럭시%';

/* IN 
 * 표현식 IN(값, 값, 값 ...)
 * =>표현식이  In에 들어있는 값과 일치하면  true
 */
/*문제:   삼성과 애플 제품을 출력해*/
select PNO, PNAME, MKNO from PRODUCTS
where MKNO=1 OR MKNO=2;

select PNO, PNAME, MKNO from PRODUCTS
where MKNO IN (1,2);

/*NULL 여부 검사하기*/
select * from PROD_PHOTS where PNO IS NOT NULL;


/*BETWEEN A AND B*/
select * from ORDERS WHERE QTY >= 1 and QTY<=3;

select * from ORDERS WHERE QTY BETWEEN 1 and 3;

/*UNION = > 결과의 결합*/
/* 두개의 결과를 합쳐서 하나로 다루고 싶을 때
 * 예) 제품ㅇㅣ름과 제조사이름을 알구싶당*/
select PNAME from PRODUCTS
UNION
select MKNAME from MAKERS;

/* 예) 2014년 7월 이후의 주문정보와 
  패블릿 및 패드 제품의 주문정보출력*/
select * from ORDERS WHERE ODATE >= '2014-07-01'
UNION 
select * from ORDERS WHERE PNO IN(1,2,3);

/*UNION ALL 두 결과 데이터를 중복에 상관없이 합친다.*/
select * from ORDERS WHERE ODATE >= '2014-07-01'
UNION ALL
select * from ORDERS WHERE PNO IN(1,2,3);

/*7월 이후 주문정보중에서 애플제품을 제외한 주문정보*/
/*MySQL은 MINUS가 없다. 다른 문법으로 대체해야한다.*/

select * from ORDERS WHERE ODATE >= '2014-07-01'
AND PNO NOT IN(1,2,3);



/* 서브 쿼리 */
/*1)주문제품의 주문 번호와 제품명을 출력하라!*/
select 
	ONO,
	PNO,
	(SELECT PNAME FROM PRODUCTS WHERE PNO=T1.PNO) AS NAME,
	QTY 
from ORDERS T1;


/*2)검색어와 일치하는 회사제품의 주문정보를 출력하세여*/
select * from ORDERS 
where PNO IN (select PNO from PRODUCTS where MKNO = 1);

/*3) '2014-07-01' 이후에 주문한 정보 중에서
 * u01, u05가 주문한 것!*/
select * from(select * from ORDERS where ODATE >= '2014-07-01') AS T1
where UID IN('u01','u05');