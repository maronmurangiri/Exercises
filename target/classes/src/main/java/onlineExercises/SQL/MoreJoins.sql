#USING customers and orders tables.
INSERT INTO customers(first_name,last_name,email,password)
    VALUES('Fidelis','Maiba','fidelismaiba@gmail.com','Welcome@123'),
     ('Vincent','Kavishe','vincentKavishe@gmail.com','Welcome@123'),
     ('Angela','Mukiri','angelamukiri@gmail.com','Welcome@123'),
     ('Christine','Monchari','christinemonchari@gmail.com','Welcome@123');
     
     
     
INSERT INTO orders(order_id,customer_id,order_date,order_total)
	VALUES(1,1,now(),200.00),
	(2,NULL,DATE_ADD(NOW(),INTERVAL 2 HOUR),300.30),
	(3,2,NOW(),100.00),
	(4,NULL,NOW(),250.50);
     
     
#INNER JOIN     
select C.first_name,C.email,O.order_id, O.order_total FROM customers C 
	INNER JOIN orders O ON C.customer_id=O.customer_id;


#LEFT JOIN
select C.first_name,C.email,O.order_id, O.order_total FROM customers C
	LEFT JOIN orders O ON C.customer_id=O.customer_id;


#LEFT JOIN WHERE RIGHT TABLE KEY IS NULL
select C.first_name,C.email,O.order_id, O.order_total FROM customers C
	LEFT JOIN orders O ON C.customer_id=O.customer_id 
    WHERE O.customer_id IS NULL;


#RIGHT JOIN
SELECT C.first_name,C.email,O.order_id, O.order_total FROM customers C
	RIGHT JOIN orders O ON C.customer_id=O.customer_id;     
    
    
#RIGHT JOIN WHERE LEFT TABLE KEY IS NULL
SELECT C.first_name,C.email,O.order_id, O.order_total FROM customers C
	RIGHT JOIN orders O ON C.customer_id=O.customer_id 
    WHERE C.customer_id IS NULL;


#FULL OUTER JOIN
SELECT C.first_name,C.email,O.order_id, O.order_total FROM customers C 
	RIGHT JOIN orders O ON C.customer_id=O.customer_id
		UNION
SELECT C.first_name, C.email, O.order_id, O.order_total FROM customers C 
	LEFT JOIN orders O ON C.customer_id=O.customer_id;
    
    
#FULL OUTER JOIN WHERE BOTH TABLE KEY IS NULL  
 select C.first_name,C.email,O.order_id, O.order_total FROM customers C
	RIGHT JOIN orders O ON C.customer_id=O.customer_id 
	WHERE C.customer_id IS NULL
		UNION 
SELECT C.first_name, C.email, O.order_id, O.order_total FROM customers C 
	LEFT JOIN orders O ON C.customer_id=O.customer_id 
    WHERE O.customer_id IS NULL;   