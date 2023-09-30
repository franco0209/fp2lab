import java.util.*;
public class DemoBatalla {
public static void main(String [] args){
 Nave [] misNaves = new Nave[3];
 Nave [] misNaves2 =new Nave[misNaves.length];
 Scanner sc = new Scanner(System.in);
 String nomb, col;
 int fil, punt, mayor;
 mayor=0; 
 int posmayor=0;
 boolean est;
 for (int i = 0; i < misNaves.length; i++) {
 System.out.println("Nave " + (i+1));
 System.out.print("Nombre: ");
 nomb = sc.next();
 System.out.println("Fila ");
 fil = sc.nextInt();
 System.out.print("Columna: ");
 col = sc.next();
 System.out.print("Estado: ");
 est = sc.nextBoolean();
 System.out.print("Puntos: ");
 punt = sc.nextInt();
 if(punt>mayor){
    mayor=punt;
    posmayor=i;
 }
 misNaves[i] = new Nave(); 
 misNaves[i].setNombre(nomb);
 misNaves[i].setFila(fil);
 misNaves[i].setColumna(col);
 misNaves[i].setEstado(est);
 misNaves[i].setPuntos(punt);
}
 System.out.println("\nNaves creadas:");
 mostrarNaves(misNaves);
 mostrarPorNombre(misNaves);
 mostrarPorPuntos(misNaves);
 System.out.println("\nNave con mayor número de puntos: ");
 mostrarDatos(misNaves, posmayor);
System.out.println("\nNaves desordenadas: ");
 aleatorNaves(misNaves, misNaves2);
 mostrarNaves(misNaves2);
 System.out.println("\nNaves ordenadas por puntos: ");
 ordenarPorPuntosBurbuja(misNaves);
 mostrarNaves(misNaves);
  System.out.println("\nNaves ordenadas por nombre: ");
 ordenarPorNombreBurbuja(misNaves);
 mostrarNaves(misNaves);
System.out.println("\nIngresar nombre para realizar busqueda binaria: ");
String noooom=sc.next();
System.out.println("\nCoincidencia detectada en la nave "+(busquedaBinariaNombre(misNaves, noooom)+1));
}
public static void mostrarNaves(Nave [] flota){
    for(int j=0;j<flota.length;j++){
        mostrarDatos(flota, j);    
        }
 }
public static void mostrarPorNombre(Nave [] flota){
    Scanner scan=new Scanner(System.in);
    System.out.println("Ingrese el nombre de la nave para hacer la búsqueda: ");
    String nombre=scan.next();
    int c=0;
        for(int j=0;j<flota.length;j++){
            if(flota[j].getNombre().equals(nombre)){
                System.out.println("Coincidencia encontrada:");
                mostrarDatos(flota, j);   
                c++; 
            }
        }
        if(c==0){
            System.out.println("No se encontraron resultados.");
        }
}
public static void mostrarPorPuntos(Nave [] flota){
    Scanner scan=new Scanner(System.in);
    int c=0;
    System.out.println("Ingrese el número de puntos para hacer la búsqueda (se retornarán naves con el mismo o menor número de puntos): ");
    int puntos=scan.nextInt();
        for(int j=0;j<flota.length;j++){
            if((flota[j].getPuntos())<=puntos){
                System.out.println("Coincidencia encontrada:");
                mostrarDatos(flota, j);  
                c++;  
            }
        }
        if(c==0){
            System.out.println("No se encontraron resultados.");
        }
}
public static void mostrarDatos(Nave [] flota, int j){
        String estado="";   
        if(flota[j].getEstado()==true){
            estado="activa";
        }
        else{
            estado="caída";
        }
        System.out.println("\t\tNombre: "+flota[j].getNombre()+"\t\tFila: "+flota[j].getFila()+"\t\tColumna: "+flota[j].getColumna()+"\t\tEstado: "+ (estado) +"\t\tPuntos: "+flota[j].getPuntos());
}
public static void aleatorNaves(Nave [] flota, Nave [] flota2){
    int c=flota.length;
    int i=0;
    int n;
    int[]comprobar=new int[c];
    n=(int)(Math.random()*c);
    flota2[0]=new Nave();
    flota2[0].setColumna(flota[n].getColumna());
    flota2[0].setEstado(flota[n].getEstado());
    flota2[0].setFila(flota[n].getFila());
    flota2[0].setNombre(flota[n].getNombre());
    flota2[0].setPuntos(flota[n].getPuntos());
    comprobar[n]++;
    while(i<(c-1)){
        n=(int)(Math.random()*c);
        if(comprobar[n]==0){
            comprobar[n]++;
            flota2[i+1]=new Nave();
            flota2[i+1].setColumna(flota[n].getColumna());
            flota2[i+1].setEstado(flota[n].getEstado());
            flota2[i+1].setFila(flota[n].getFila());
            flota2[i+1].setNombre(flota[n].getNombre());
            flota2[i+1].setPuntos(flota[n].getPuntos());            
            i++;
        }
    }
 }
 //Método para buscar la primera nave con un nombre que se pidió por teclado
 public static int busquedaLinealNombre(Nave[] flota, String s){
    int c=0;
        for(int j=0;j<flota.length;j++){
            if(flota[j].getNombre().equals(s)){
                System.out.println("Coincidencia encontrada:");
                c++;
                return j;   
            }
        }
        if(c==0){
            System.out.println("No se encontraron resultados.");
            return -1;
        }
        return -1;
 }
//Método que ordena por número de puntos de menor a mayor
public static void ordenarPorPuntosBurbuja(Nave[] flota){
    for (int i=1;i<flota.length;i++){
        for(int j=0; j<flota.length-i;j++){
            if((flota[j].getPuntos())>(flota[j+1].getPuntos())){
                intercambiar(flota, j, j+1);
            }
        }
    }
}
//Método que ordena por nombre de A a Z
public static void ordenarPorNombreBurbuja(Nave[] flota){
        for (int i=1;i<flota.length;i++){
        for(int j=0; j<flota.length-i;j++){
            if((letraNum((flota[j].getNombre()).substring(0,1)))>(letraNum((flota[j+1].getNombre()).substring(0,1)))){
                intercambiar(flota, j, j+1);
            }
        }
    }

}
//Método para buscar la primera nave con un nombre que se pidió por teclado
public static int busquedaBinariaNombre(Nave[] flota, String s){
    int alta, baja, media;
    baja=0;
    alta=flota.length-1;
    while(baja<=alta){
        media=(alta+baja)/2;
        if((flota[media].getNombre()).equals(s)){
            return media;
        }
        else if((letraNum(s.substring(0)))<(letraNum((flota[media].getNombre()).substring(0)))){
            alta=media-1;
        }
        else{
            baja=media+1;
        }
    }
    return -1;
}
//Método que ordena por número de puntos de menor a mayor
public static void ordenarPorPuntosSeleccion(Nave[] flota) {
    for (int i = 0; i < flota.length - 1; i++) {
        int minIndex = i;
        
        for (int j = i + 1; j < flota.length; j++) {
            if (flota[j].getPuntos() < flota[minIndex].getPuntos()) {
                minIndex = j;
            }
        }
        
        intercambiar(flota, i, minIndex);
    }
}
//Método que ordena por nombre de A a Z
public static void ordenarPorNombreSeleccion(Nave[] flota){

}
//Método que muestra las naves ordenadas por número de puntos de mayor a menor
public static void ordenarPorPuntosInsercion(Nave[] flota){

}
//Método que muestra las naves ordenadas por nombre de Z a A
public static void ordenarPorNombreInsercion(Nave[] flota){

}
public static void intercambiar(Nave []a,int i, int j){
    Nave temp=new Nave();
    temp=a[i];
    a[i]=a[j];
    a[j]=temp;
}
public static int letraNum(String lt){
    String[] abc = new String[26];
    char letra = 'a';
for (int i = 0; i < 26; i++) {
    abc[i] = String.valueOf(letra); 
    letra++;
}
for(int i=0;i<abc.length;i++){
    if(abc[i].equals(lt.toLowerCase())){
        return i;
    }
}
return -1;
}
}
