Evaluación semana 3 construcción de una aplicación de despacho.

Objetivos:

- Construir una aplicación que permita calcular el valor de despacho según los requerimientos solicitado por el cliente utilizando JAVA
  y que estos puedan ser visualizado posteriormente por el usuario.
- Compilar el programa creado.
- Poder ejecutarse desde la terminal.


Requerimientos funcionales:

- Según la documentación del caso presentado en la evaluación se requiere de un programa que solicite al usuario los siguiente:

1.- Datos iniciales de: Nombre, edad y email.

2.- Datos del vehículo: Marca, modelo, cilindrada, tipo de combustible, capacidad de pasajeros.

3.- Datos que permitan calcular el valor final de la compra: Distancia del despacho y valor de la compra.

- Con estos últimos datos el programa debe ser capaz de calcular los valores de despacho, donde el tope máximo para realizar un despacho es de 20km, por lo que el programa debe
  ser capaz de advertir al usuario de esta limitación.

- Para la realización del cálculo se debe regir por las siguientes reglas:

1.- Despacho con un valor superior a 50.000 el cobro por envío es gratis.

2.- Despacho con un valor dentro del rango de 25.000 hasta 49.999, el valor de envío equivale a 150 por km recorrido.

3.- Despacho por un valor dentro del rango de 1 a 24.999, el valor del envío equivale a 300 por km recorrido.

  
Requerimientos no funcionales:

- Elaboración de documentación necesaria para su posterior revisión.

- Código comentado para su posterior revisión y análisis.


Historia de usuarios:

- Usuario debe ser capaz ejecutar el programa desde la terminal del sistema.
- Usuario debe ser capaz de ingresar datos requeridos desde el teclado físico de su equipo.
- Usuario debe ser capaz de ver los resultados obtenidos según los valores asignados por el mismo.

Pasos realizados para la concreción del proyecto:

1.- Se declara el uso de scanner en el código para poder permitir el uso del teclado como input válido para la ejecución del programa.

2.- Se declaran las variables que serán usadas por el sistema durante el funcionamiento del programa.

3.- Se definen las operaciones matemáticas que permitirán obtener los resultados y los requerimientos para esto son:
    
    Para valores > o = a 50.000: Total = Valor digitado.
    Para valores entre el rango de 25.000 a 49.999: Total = Valor + (Distancia * 150).
    Para valores entre el rango de 1 a 24.999: Total = Valor + (Distancia * 300).


4.- Se define la primera condición, si la distancia de despacho es superior a 20Km, no se puede realizar despacho.

5.- Si la distancia está dentro de los rangos establecidos el sistema se codifico de tal forma que este entre los inputs solicitados
    según los requerimientos, más el total final de la compra.

6.- Se realizaron los comentarios a las partes del código.

7.- Se procedió a realizar la compilación.

8.- Se probó y documento los resultados del trabajo.

9.- Se genero informe final.

    


  
  

