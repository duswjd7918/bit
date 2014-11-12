/*join  :   두 테이블을 연결해서 정보추출*/
/* 1) CROSS 조인           무. 식. 해.
  => 두개의 테이블 데이터를  M:N로 조인한다.
*/
select ONO, PNO, QTY from ORDERS;
select PNO, PNAME from PRODUCTS;
     
select ONO, T1.PNO, T1.QTY, PNAME from ORDERS T1, PRODUCTS T2;

/* 2) NATURAL 조인
 * => 두개의 테이블의 '공통' 컬럼을 기준으로 조인한다.
 *    "외부키"를 기준으로 조인을 수행한다.
 */

select ONO, T1.PNO, T1.QTY, PNAME 
from ORDERS T1, PRODUCTS T2
where T1.PNO = T2.PNO;

/* NATURAL 조인 中.... T1 JOIN T2 USING(컬럼명, 컬럼명...)
단, 조인할 때 기준이 되는 컬럼명이 일치하야한다.*/

select ONO, T1.PNO, T1.QTY, PNAME 
from ORDERS T1 JOIN PRODUCTS T2 USING(PNO);

/* NATURAL 조인 中.... T1 JOING T2 ON 조인조건1...
 *  => 조인의 기준이 되는 컬럼명이 다를 때 사용 !   */

select ONO, T1.PNO, T1.QTY, PNAME 
from ORDERS T1 JOIN PRODUCTS T2 ON T1.PNO = T2.PNO;

/*   3) OUTER JOIN  */
/* 모든 제품정보와 사진정보를 출력하라.*/
/*다음 질의문은 조인 가능한 결과만 출력한다.*/
/*
select T1.PNO, T1.PNAME, T2.URL 
from PRODUCTS T1 JOIN PROD_PHOTS T2 ON T1.PNO = T2.PNO;
*/

/* 조인 불가능하더라도 조인할 데이터가 상대테이블에 없더라도
 * 반드시 기준이 되는 테이블의 데이터를 모두 출력하고 싶다면 
 * OUTER 조인을 사용하라.
 * 문법: 왼쪽 T1테이블을 기준으로 T2테이블과 조인하라!
 *     T1 LEFT OUTER JOIN T2 ON 조인조건1
 *     기준 테이블인 T1의 테이터는 모두 출력될꺼야 ~
 */

select T1.PNO, T1.PNAME, T2.URL
from PRODUCTS T1 LEFT OUTER JOIN PROD_PHOTS T2 
ON T1.PNO = T2.PNO;

/* 사진 테이블을 기준으로 조인을 하고 싶다면,*/
select T1.PNO, T1.PNAME, T2.URL
from PRODUCTS T1 RIGHT OUTER JOIN PROD_PHOTS T2 
ON T1.PNO = T2.PNO;

/*문제: 다음 결과를 출력하세여 ~~~~~~~~~~~~ 4개 쪼이 실무에서 쉽.가장.
* 주문번호T1.ONO, 주문수량T1.QTY  / 제품명T2.PNAME, 잔여수량T1.QTY,  
  ORDERS    T1.                 PRODUCTS  T2.   
  
  *제조사명T3.MKNAME,  /   고객명T4.UNAME, 고객이메일T4.EMAIL
  MAKERS     T3.                MEMBERS      T4.
*/

select T1.ONO, T2.PNAME, T3.MKNAME,T1.QTY, T2.QTY,
T4.UNAME,T4.EMAIL
from ORDERS T1 
LEFT OUTER JOIN PRODUCTS T2 on T1.PNO = T2.PNO 
LEFT OUTER JOIN MAKERS on T1.MKNO = T3.MKNO 
LEFT OUTER JOIN MEMBERS on T1.UID = T4.UID;








