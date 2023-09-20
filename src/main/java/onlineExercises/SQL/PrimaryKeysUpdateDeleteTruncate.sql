CREATE TABLE customers(
	customer_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(300) NOT NULL,
    PRIMARY KEY(customer_id)
    );
    

#2  
INSERT INTO customers(first_name, last_name, email,password)
	VALUES('Fidelis','Maiba','fidelismaiba@gmail.com','Welcome@123'),
		('Vincent', 'Kavishe','vincentkavishe@gmail.com','Welcome@123'),
        ('Antony','Meme','antonymeme@gmail.com','Welcome@123'),
        ('Christine','Monchari','christinemonchari@gmail.com','Welcome@123'),
        ('Angela', 'Mukiri','angelamukiri@gmail.com','Welcome@123');
  
  
  
#3
UPDATE customers
	SET last_name='Deborah'
    WHERE customer_id = 5;
   
UPDATE customers
	SET email = 'christine@gmail.com'
    WHERE customer_id = 4;
    
UPDATE customers
	SET  first_name = 'Silvester'
    WHERE customer_id = 2;
    
UPDATE customers
	SET password = 'WelcomeFidelis@123'
	WHERE customer_id = 1;
   
   
#4
DELETE FROM customers
	WHERE customer_id = 3;
    
DELETE FROM customers
	WHERE customer_id = 2;
    
    
#5
TRUNCATE customers;    

#6
/* customer_id  */

#7
/* product_name  */

#8
/* order_id  */

#9
/* order_id and  product_name as composite  */
    
   
   
