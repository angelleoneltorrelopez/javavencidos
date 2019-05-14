/*crear base de datos*/
create database VENCIMIENTO;
use VENCIMIENTO;

/*creando tabla*/
create table ingreso(Id int not null auto_increment, Nombre varchar(255), 
Casa varchar(50), Mes int, Año int, Proveedor varchar (100), 
Politica int, Caducidad date, Meses varchar(50), PRIMARY KEY (Id));

/*creando usuario*/
create user VENCIDOS identified by "";
drop user vencimiento;
GRANT ALL PRIVILEGES ON VENCIMIENTO.*  TO 'VENCIDOS'@'%' identified by "";
flush privileges;


/*insertando archivo excel guardado como .csv*/
load data LOCAL infile "C:/Users/BODEGA2/Desktop/PRODUCTOS.csv" into table productos
fields terminated by ';'
lines terminated by '\n';

/*actualizar*/
update ingreso set Mes=01, Meses='ENERO' where Mes=1;
update ingreso set Mes=02, Meses='FEBRERO' where Mes=2;
update ingreso set Mes=03, Meses='MARZO' where Mes=3;
update ingreso set Mes=04, Meses='ABRIL' where Mes=4;
update ingreso set Mes=05, Meses='MAYO' where Mes=5;
update ingreso set Mes=06, Meses='JUNIO' where Mes=6;
update ingreso set Mes=07, Meses='JULIO' where Mes=7;
update ingreso set Mes=08, Meses='AGOSTO' where Mes=8;
update ingreso set Mes=09, Meses='SEPTIEMBRE' where Mes=9;
update ingreso set Mes=10, Meses='OCTUBRE' where Mes=10;
update ingreso set Mes=11, Meses='NOVIEMBRE' where Mes=11;
update ingreso set Mes=12, Meses='DICIEMBRE' where Mes=12;

update ingreso set Estado=0;

update ingreso set Estado=1 where Caducidad='2018-09-01' and Politica='0';
update ingreso set Estado=1 where Caducidad='2018-10-01' and Politica='1';
update ingreso set Estado=1 where Caducidad='2018-11-01' and Politica='2';
update ingreso set Estado=1 where Caducidad='2018-12-01' and Politica='3';
update ingreso set Estado=1 where Caducidad='2019-01-01' and Politica='4';

update ingreso set Estado=1 where Caducidad='2019-01-01' and Politica='5';
update ingreso set Estado=1 where Caducidad='2019-01-01' and Politica='6';

update ingreso set Estado=1 where Caducidad='2018-01-01';
update ingreso set Estado=1 where Caducidad='2018-02-01';
update ingreso set Estado=1 where Caducidad='2018-03-01';
update ingreso set Estado=1 where Caducidad='2018-04-01';
update ingreso set Estado=1 where Caducidad='2018-05-01';
update ingreso set Estado=1 where Caducidad='2018-06-01';



update ingreso set Estado=1 where Caducidad='2017-07-01';
update ingreso set Estado=1 where Caducidad='2017-08-01';
update ingreso set Estado=1 where Caducidad='2017-09-01';
update ingreso set Estado=1 where Caducidad='2017-10-01';
update ingreso set Estado=1 where Caducidad='2017-11-01';
update ingreso set Estado=1 where Caducidad='2017-12-01';




update ingreso set Proveedor='LANQUETIN' where Proveedor='LANQUETAN';

update ingreso set Nombre='ACEITE J J BABY 200 ML' where Nombre='ACEITE JHONSON 200 ML';



update ingreso set Casa='MERCK CENTROAMERICANA' where Casa='MERCK';



update ingreso set Casa='BDF DIVISION COSMETICOS' where Nombre Like '%nivea%';


update ingreso set Politica=1 where Proveedor='BODEGA' AND Casa='UNIPHARM / PHARMANOVA';

commit;

/*comandos de control*/
select User from mysql.user;
show tables;
drop database vencimiento;
drop table casa;
select * from ingreso;
describe ingreso;
select count(*) from ingreso;

SHOW VARIABLES LIKE "secure_file_priv";
SELECT @@GLOBAL.secure_file_priv;