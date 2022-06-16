# Challenge-Hotel-Java
este es el último Challenge del programa ONE
tengo que armar la logica para un hotel (reservas, listados, usuarios) para el que me dieron la parte grafica
y un TELLO sobre las funcionalidades a implementar

En principio la base de datos es simple:
HUESPEDES:
id INT AUTO_INCREMENT, (PRIMARY KEY)
nombre VARCHAR (45),
apellido VARCHAR (45) NOT NULL, (Lo pongo obligatorio al apellido para tener un dato seguro con el cual referirme al huesped en caso de tener que hacerlo, podria haber                                     agregado un campo (obligatorio tambien) de como desea ser llamado (Sr. Sra. Dr. Dra. etc.).
fecha_nacimiento DATE NOT NULL, (not null por politicas comerciales, si existe edad minima para reservar o descuentos en distitnas franjas etarias).
telefono VARCHAR (15) NOT NULL, (necesito poder comunicarme con el huesped en caso de cancelaciones/modificaciones, tambie podria haber agregado campo mail)
id_reserva (FOREING KEY de la tabla RESERVAS)

RESERVAS:
id INT AUTO_INCREMENT, (PRIMARY KEY)
fecha_entrada DATE NOT NULL
fecha_salidaDATE NOT NULL
valor INT NOT NULL
forma_pago VARCHAR 45 NOT NULL
