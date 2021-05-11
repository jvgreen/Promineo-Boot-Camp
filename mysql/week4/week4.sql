delimiter //
-- replace employee first name
create procedure replaceEmployee(in employeeNumber int, in firstName varchar(30), in LastName varchar(30), in newFirstName varchar(30))
begin
	update employees
    set first_name = newFirstName
    where first_name = firstName
    and   last_name  = lastName;
    
    -- display updated rows
end //
delimiter ;
delimiter //
-- Get the total salary and place it in a variable
create procedure getTotalSalary()
begin
	declare totalSalary bigint default 0;
    
    select sum(salary) 
    into totalSalary
    from salaries;
    
    select totalSalary;
end//
delimiter ;
delimiter //

delimiter //
-- Determine if an employee gets high medium or low pay
create procedure getPayLevel()
begin    
    select s.salary,
	case
		when s.salary > 80000 then "High Salary"
        when s.salary > 50000 and s.salary < 80000 then "Medium Salary"
        else "Low Salary"
	end as 'Pay level'
    from salaries s
    inner join employees e
    on s.emp_no = e.emp_no;
end//
delimiter ;

delimiter //
-- Repeat employee name 
create procedure repeatName(in empNum int, in repeatNum int)
begin 
	select repeat(first_name, repeatNum)
    from employees
    where emp_no = empNum;
end//
delimiter ;

delimiter //
	-- return an employees full name
    create procedure fullName(in empNum int, out fullName varchar(50))
    begin
		select concat(first_name, ' ' , last_name)
        into fullName
        from employees
        where emp_no = empNum;
    end//
delimiter ;

call replaceEmployee(10001, 'Georgi', 'Facello', 'Tim');
call getTotalSalary();
call getPayLevel();
call repeatName(10001, 4);
call fullName(10001, @out_value);
select @out_value;
