# Challenge ONE | Java | Back-end | Hotel Alura

<p align = "center-"> El sistema de manejo de habitaciones desarrollado para Hotel Alura parte de la siguiente base de datos realizada en MYSQL
NOMBRE: Hotel_alura

tablas:

EMPLEADO                      HUESPEDES                          RESERVAS
user (varchar 25) pk.         id (int) auto_increment pk       --id (varchar 50) pk (se genera por codigo con uuid)
pass (varchar 25)             nombre (varchar 45)            /   fecha_entrada (date)
                              apellido (varchar 45)         /    fecha_salida (date)
                              fecha_nacimiento (date)      /     valor (int)
                              nacionalidad (varchar 45)   /      forma_pago(varchar 50)
                              telefono (varchar 20)      /
                              id_reserva (varchar 50) fk/

</p>
