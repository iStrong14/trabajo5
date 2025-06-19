package Ejercicio1; //Nos dice en que carpeta o paquete está el archivo.

import java.util.ArrayList;
import java.util.Scanner;


public class ListProducto {
    ArrayList<Producto> p; //Se declara una lista dinámica de productos.
    
    
    public ListProducto(){ //Constructor de la lista.
        p = new ArrayList<>(); //Se crea la lista vacia de productos.
    }
    
    public void agregar(Producto producto){
        p.add(producto); //Agrega el nuevo producto al ArrayList median un .add.

    }
    
    public boolean existe(int codigo){ //Busca si ya hay un producto mediante el código.
        for(int i = 0; i < p.size();i++) //Esto recorre toda la lista
            if(p.get(i).getCodigo() == codigo) // Acá compara códigos. //.get(i) accede al elemento en la posición i. y .size() devuelve la cantidad de elementos en el ArrayList.
            return true;
        return false;           
    }
    
    public void eliminar(int codigo){ //Función para eliminar un producto mediante el código.
        for(int i = 0;i < p.size();i++)
            if(p.get(i).getCodigo() == codigo){ //Compara códigos sin son iguales.
                p.remove(i); //Elimina el producto si lo encuentra. .remove(i) elimina el producto en la posición i.
                System.out.println("Producto eliminado"); //Imprimirá que fue eliminado
                return;
            }
        System.out.println("Producto no encontrado"); //Si no lo encuentra botará esto.          
    }
    
    public void mostrar(){ //Muestro los atributos o productos.
        
        for(int i = 0;i < p.size();i++) //Igualmente, mismo código, solo recorre la lista o todos los productos.
        System.out.println(p.get(i).getCodigo()+","+p.get(i).getNombre()+","+p.get(i).getPrecio()+","+p.get(i).getStock()); //Imprime todo los datos agregados de la lista en pantalla o consola.             
               
    }
    
    public void reponer(int codigo, int cantidad){ //Repone los productos mediante la búsqueda del código y agregamos la cantidad del stock para reponer.
        for(int i = 0;i < p.size();i++)//Recorre la lista.
            if(p.get(i).getCodigo() == codigo) { //Compara códigos si son iguales.
                p.get(i).setStock(p.get(i).getStock() + cantidad); //Suma stock actual.
                System.out.println("Stock Actualizado");
                return;
            }
        
        System.out.println("Producto no encontrado");
    }           

    public void venta() { //Función para vender productos.
    
    Scanner scanner = new Scanner(System.in); //Lo mismo que en el main, importas libreraría para el programa lea lo que escribe el usuario.
    
    System.out.println("Ingrese el codigo del producto que desea vender:");
    int codigo = scanner.nextInt();
    System.out.println("Ingrese la cantidad que desea vender:");
    int cantidad = scanner.nextInt();

    for (int i = 0; i < p.size(); i++) { //Recorre la lista.
        if (p.get(i).getCodigo() == codigo) { //Compara códigos si son iguales.
            if (p.get(i).getStock() >= cantidad) { //Lo que hace acá es verificar si hay suficiente stock para vender.
                p.get(i).setStock(p.get(i).getStock() - cantidad); //Resta la cantidad vencidad del stock actul. Ejemplo: 5 stock, se vendio 2 productos, ahora hay 3 de stock. 5 - 2 = 3 stock actual.
                double totalVenta = cantidad * p.get(i).getPrecio(); //Multiplica la cantidad vendida del stock por el precio que pusimos.
                System.out.println("Venta realizada: " + cantidad + " unidades de " + p.get(i).getNombre() + " por un total de: " + totalVenta); //Te dice lo que vendiste y el precio.
                System.out.println("Stock restante: " + p.get(i).getStock()); //Te mostrará el stock actual luego de la venta.
                return;
            } else {
                System.out.println("No hay suficiente stock para realizar la venta."); //En caso que el usuario quiera comprar por ejemplo 8 productos y tu solo tienes 5 de stock te dirá esto.
                return;
            }
        }
    }
    System.out.println("Producto no encontrado."); //y en caso introduscas código de un producto que no agregaste a la lista te botará esto.
    }
}