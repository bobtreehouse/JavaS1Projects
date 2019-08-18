select * from northwind.products where product_name like '%Dell%';
select * from northwind.orders where ship_state = 'Pennsylvania';
SELECT * from northwind.employees 
WHERE last_name LIKE 'W%';
select * from northwind.employees where last_name like 'W%';
select * from northwind.customers where postal_code like '55%';
select * from northwind.customers where postal_code like '%0';
select * from northwind.customers where email like '%.org';
select first_name, "First"
    last_name, "Last"
    email, "Email"
from northwind.customers where email like '%@%.org';
SELECT SUBSTRING(email, 1, LOCATE('@', email) - 1) AS localpart,
       SUBSTRING(email, LOCATE('@', email) + 1) AS domain
       from northwind.customers where email like '%@%.org';
select first_name, "First"
    last_name, "Last"
    email, "Email"
from northwind.customers where phone like '%202%'; 
select orders.id
from northwind.orders left outer join northwind.employees
on employees.employee_id = employees.id;
select orders.id "Order ID"  from orders
inner join customers on customers.id = orders.customer_id
where customers.first_name='George' and customers.last_name = 'Wilson';



