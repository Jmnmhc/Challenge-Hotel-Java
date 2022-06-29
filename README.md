# Challenge ONE | Java | Back-end | Hotel Alura

<p align = "center-"> El sistema de manejo de habitaciones desarrollado para Hotel Alura parte de la siguiente base de datos realizada en MYSQL
NOMBRE: Hotel_alura

tablas:

EMPLEADO                                              
user (varchar 25) pk.                
pass (varchar 25)                           
                                         
HUESPEDES                                     
id (int) auto_increment pk                                       
nombre (varchar 45)                                    
apellido (varchar 45)                              
fecha_nacimiento (date)
nacionalidad (varchar 45)
telefono (varchar 20)
id_reserva (varchar 50) fk

RESERVAS
id (varchar 50) pk (se genera por codigo con uuid)
fecha_entrada (date)
fecha_salida (date)
valor (int)
forma_pago(varchar 50)
</p>

Por el momento, el registro de nuevos empleados lo debe realizar alguien del área de Sistemas "manualmente" usando una consulta de mySql.

El programa funciona de la siguiente manera:
en la pantalla principal nos encontramos con el boton login, el que nos abre una ventana en la que deberá ingresarse el usuario y la contraseña previamente asignadas.


La siguiente pantalla nos deja realizar una nueva reserva o buscar entre los usuarios y reservas previamente realizadas.

En el caso de realizar una nueva reserva nos va a pedir la fecha de ingreso, la de egreso, nos va a dar el valor total de la reserva hay que elegir la forma de pago (por defecto es tarjeta de crédito) y luego hay que presionar el boton continuar.

En la siguiente ventana nos pide los datos del huesped (nombre, apellido, fecha de nacimiento, nacionalidad (por si hay que efectuar recargos/descuentos dependiendo su origen), fecha de nacimiento, numero de telefono) y nos da el numero de reserva que deberá ser informado al huesped.

En la ventana d busqueda nos va a dejar modificar los datos del huesped (no de la reserva) y eliminarlo (eliminandose tambien la reserva). Se podrá buscar huespedes por nombre y reservas por numero de reserva




