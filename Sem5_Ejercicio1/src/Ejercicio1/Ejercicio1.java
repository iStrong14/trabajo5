package Ejercicio1;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        ListProducto listaproducto = new ListProducto();
            
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Agregar");
        System.out.println("2. Eliminar");
        System.out.println("3. Mostrar");
        System.out.println("4. Reponer");
        System.out.println("5. Venta");
        System.out.println("6. Salir");
        
        while(true){
        System.out.println("Ingresa una opcion (1-6): ");
        int opcion = scanner.nextInt();
        
        if(opcion == 1){            
        System.out.println("Ingrese codigo");  
        int codigo = scanner.nextInt();
        
        if(listaproducto.existe(codigo)) //Llamarás el método propio de la clase ArrayList y lo concatenas con el nuevo objeto listaproducto
            System.out.println("El codigo ya existe");
        else{
        
            
        System.out.println("Ingrese nombre");
        String nombre = scanner.next();
        System.out.println("Ingrese precio");  
        double precio = scanner.nextDouble();
        System.out.println("Ingrese Stock"); 
        int stock = scanner.nextInt();
        
        Producto producto = new Producto(codigo,nombre,precio,stock);
        listaproducto.agregar(producto);
        }
        }
 
        else if(opcion == 2){
        System.out.println("Ingrese codigo");
        int codigo = scanner.nextInt();      
        listaproducto.eliminar(codigo);

        }
        else if(opcion == 3){
        System.out.println("PRODUCTOS");
        listaproducto.mostrar();
        
        }
        else if(opcion == 4){
            System.out.println("ingrese codigo");
            int codigo = scanner.nextInt();
            System.out.println("Ingrese cantidad");
            int cantidad = scanner.nextInt();
            
            listaproducto.reponer(codigo, cantidad);
            
        }
        else if (opcion==5){
            listaproducto.venta();
        }
        else
            break;
     }    
   }    
}
