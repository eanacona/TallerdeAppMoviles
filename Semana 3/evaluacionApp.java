

import java.util.Scanner;// Código que permite usar el teclado

public class evaluacionApp {// Clase en la cual se construye nuestro programa.

    public static void main(String[] args) {
       
        Scanner teclado = new Scanner(System.in); // Código que permite usar el teclado cuando sea llamado.
        
        //Declaración de variables a utilizar
        String nombre; //Datos solicitado por los requerimientos
        int edad; //Datos solicitado por los requerimientos
        String email; //Datos solicitado por los requerimientos
        String marca; //Datos solicitado por los requerimientos
        String modelo; //Datos solicitado por los requerimientos
        int cilindrada; //Datos solicitado por los requerimientos
        String combustible; //Datos solicitado por los requerimientos
        int pasajero; //Datos solicitado por los requerimientos
        int distancia; //Datos solicitado por los requerimientos
        int valor; //Datos solicitado por los requerimientos
        int total1; //Declaración de variable para ser utilizados por la calculadora
        int total2; //Declaración de variable para ser utilizados por la calculadora
        int total3; //Declaración de variable para ser utilizados por la calculadora
                
        // Código de bienvenida al programa
        System.out.println("-------------------------------");
        System.out.println("Bienvendio");
        System.out.println("-------------------------------");
        System.out.println();// Código para dejar un salto
        
        //Datos iniciales solicitado de nombre, edad, y email según los requerimientos.
        System.out.println("Ingrese su nombre:");
        nombre = teclado.nextLine(); //Linea de código que nos permite ingresar un string
        System.out.println("Ingrese su edad:");
        edad = teclado.nextInt(); //Línea de código que nos permite ingresar datos de tipo numérico
        teclado.nextLine(); //Permite finalizar bucle del ciclo nextInt, esto permite ingresar el siguiente dato. 
        System.out.println("Ingrese su email:");
        email = teclado.nextLine();
        System.out.println(); 
        
        //Sección de ingreso de datos según los requerimientos se requieren para mostrar como datos de salida
        System.out.println("-------------------------------");
        System.out.println("Ingrese la marca del auto:");
        marca = teclado.nextLine();
        System.out.println("Ingrese el modelo del auto:");
        modelo = teclado.nextLine();
        System.out.println("Ingrese cilindrada del auto:");
        cilindrada = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el tipo de combustible del auto:");
        combustible = teclado.nextLine();
        System.out.println("Ingrese la capacidad de pasajeros del auto:");
        pasajero = teclado.nextInt();
        teclado.nextLine();
        
        //Sección de datos solicitados para calcular el valor final de la comprar que se mostran en los datos de salida
        System.out.println("Ingrese la distancia de reparto:");
        distancia = teclado.nextInt();
        System.out.println("Ingrese el valor de su compra:");
        valor = teclado.nextInt();
        
        //Operaciones matemáticas que se ejecutarán según sus respectivas condciones. 
        total1 = valor; //Operación para compras igual o superior a 50000
        total2 = valor + (distancia * 150);//Operación para compras entre 25000 a 49999 con un valor por km de 150
        total3 = valor + (distancia * 300);//Operación para compras entre 1 a 24999 con un valor por km de 300
        
        
        /* 
           Ciclo if else que se ejecuta segun el cumplimiento de las condiciones: 
           (0) Distancia mayor a 20km, no hay reparto, generando la salida de una alerta.
           (1) Con un valor mayor a 50000 no hay cobro, dentro del radio de los 20km.
           (2) Con un valor entre los rango de 25000 a 49999, se cobran 150 por km dentro del radio de los 20km.
           (3) Con un valor entre los rango de 1 a 24999, se cobran 300 por km dentro del radio de los 20km.
           El cumplimiento de estas condiciones crean los datos de salida solicitados según los requerimientos
           construido con los datos ingresados por el usuario más el valor final que tendra el despacho de la compra.
        */
        
        if (distancia > 20){ //Condición (0) 
            System.out.println("-------------------------------");
            System.out.println("La distancia de reparto ingresada no es valida ");
            System.out.println("-------------------------------");
                
        }else if (valor >= 50000){ // Condición (1)
            System.out.println("-------------------------------");
            System.out.println("La marca que ha ingresado es: " + marca);
            System.out.println("El modelo que ha ingresado es: " + modelo);
            System.out.println("La cilindrada que ha ingresado es: " + cilindrada);
            System.out.println("El tipo de combustible es: " + combustible);
            System.out.println("Tiene una capacidad de: " + pasajero + " pasajeros");
            System.out.println("El valor final de su compra es de: " + total1); //Utilización de la operación matemática creada
            System.out.println("-------------------------------");
          
        }else if (valor >= 25000 && valor <= 49999){ //Condición (2)
            System.out.println("-------------------------------");
            System.out.println("La marca que ha ingresado es: " + marca);
            System.out.println("El modelo que ha ingresado es: " + modelo);
            System.out.println("La cilindrada que ha ingresado es: " + cilindrada);
            System.out.println("El tipo de combustible es: " + combustible);
            System.out.println("Tiene una capacidad de: " + pasajero + " pasajeros");
            System.out.println("El valor final de su compra es de: " + total2); //Utilización de la operación matemática creada
            System.out.println("-------------------------------");
            
        }else if (valor >= 1 && valor <= 24999){ //Condición (3)
            System.out.println("-------------------------------");
            System.out.println("La marca que ha ingresado es: " + marca);
            System.out.println("El modelo que ha ingresado es: " + modelo);
            System.out.println("La cilindrada que ha ingresado es: " + cilindrada);
            System.out.println("El tipo de combustible es: " + combustible);
            System.out.println("Tiene una capacidad de: " + pasajero + " pasajeros");
            System.out.println("El valor final de su compra es de: " + total3); //Utilización de la operación matemática creada
            System.out.println("-------------------------------");
            
        }
    }
}
