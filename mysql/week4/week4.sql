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
-- loop through the first 10 employees
create procedure firstTen()
begin
	
end//

call replaceEmployee(10001, 'Georgi', 'Facello', 'Tim');
call getTotalSalary();

drop procedure if exists replaceEmployee;
drop procedure if exists getTotalSalary;
