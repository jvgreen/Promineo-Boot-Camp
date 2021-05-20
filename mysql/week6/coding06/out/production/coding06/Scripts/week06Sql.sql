create database bank;

/**** Users *****/
create table users (
	userId int not null auto_increment primary key,
	username varchar(100),
	password varchar(100)
);

delimiter //
create procedure createUser(in username varchar(50), in password varchar(50))
begin
	insert into users (username, password)
    values(username, password);
end//
delimiter ;

delimiter //
create procedure getUsers()
begin
	select *
    from users;
end//
delimiter ;

delimiter //
create procedure getUserById(in id int)
begin
	select *
    from users
    where userId = id;
end//
delimiter ;

delimiter //
create procedure updateUser(in id int, in userName varchar(50), in pass_word varchar(50))
begin
	update users
    set username = userName,
		password = pass_word
    where userId = id;
end//
delimiter ;

delimiter //
create procedure deleteUser(in id int)
begin
	delete from users
    where userId = id;
end//
delimiter ;

/***** Accounts ******/
create table accounts (
    accountNumber int not null unique,
    accountAmount double,
    userId int not null,
    foreign key (userId) references users(userId)
);

delimiter //
create procedure createAccount(in accountNumber int, in accountAmount double, in UserId int)
begin
	insert into accounts (accountNumber, accountAmount, userId)
    values(accountNumber, accountAmount, UserId);
end//
delimiter ;

delimiter //
create procedure getAccounts()
begin
	select *
    from accounts;
end//
delimiter ;

delimiter //
create procedure getAccountById(in id int)
begin
	select *
    from accounts
    where accountNumber = id;
end//
delimiter ;

delimiter //
create procedure updateAccount(in id int, in accountAmount double, in UserId int)
begin
	update accounts
    set accountAmount = accountAmount,
        userId = UserId
    where accountNumber = id;
end//
delimiter ;

delimiter //
create procedure deleteAccount(in id int)
begin
	delete from accounts
    where accountNumber = id;
end//
delimiter ;


/****** Loans ******/
create table loans (
	loanId int not null auto_increment primary key,
    loanAmount double not null,
    userId int not null,
    foreign key (userId) references Users(userId)
);

delimiter //
create procedure createLoan(in LoanAmount double, in UserId int)
begin
	insert into loans (loanAmount, userId)
    values(LoanAmount, UserId);
end//
delimiter ;

delimiter //
create procedure getLoans()
begin
	select *
    from loans;
end//
delimiter ;

delimiter //
create procedure getLoanById(in id int)
begin
	select *
    from loans
    where loanId = id;
end//
delimiter ;

delimiter //
create procedure updateLoan(in id int, in LoanAmount double, in UserId int)
begin
	update loans
    set loanAmount = LoanAmount,
        userId = UserId
    where loanId = id;
end//
delimiter ;

delimiter //
create procedure deleteLoan(in id int)
begin
	delete from loans
    where loanId = id;
end//
delimiter ;




insert into users (username, password)
values ('John', 'Doe');

insert into accounts (accountNumber, accountAmount, userId)
values (123456, 1234.54, 1);

insert into loans (loanAmount, userId)
values (12345, 3);