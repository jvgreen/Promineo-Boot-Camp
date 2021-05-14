create database cars;

use cars;

create table car (
	carId int not null auto_increment primary key,
    make varchar(50),
    model varchar(50)
    );
    
delimiter //
-- Select all cars in the car table
create procedure getCars()
begin
	select * from car;
end//
delimiter ;

delimiter //
-- Select all cars in the car table
create procedure addCar(in make varchar(50), in model varchar(50))
begin
	insert into car (make, model)
    values(make, model);
end//
delimiter ;

delimiter //
-- Select all cars in the car table
create procedure updateCar(in id int, in make varchar(50), in model varchar(50))
begin
	update car
    set make = make,
		model = model
    where carId = id;
end//
delimiter ;

delimiter //
-- Select all cars in the car table
create procedure deleteCar(in id int)
begin
	delete from car
    where carId = id;
end//
delimiter ;


