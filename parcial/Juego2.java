//Autor: Franco Jesus Cahua Soto
//Laboratorio 15
import java.util.*;

public class Juego2 {
    //elegir opciones menu
    public static int elegirOpcion(String[]listaOpciones){
        Scanner scan=new Scanner(System.in);
        int i;
        do{
            System.out.println("Eliga uno de los opciones a continuación, ingrese el número entre 1 y "+listaOpciones.length+" según corresponda:");
            for(int j=0;j<listaOpciones.length;j++){
                System.out.println((j+1)+". "+listaOpciones[j]);
            }
            i=scan.nextInt();
        }
        while(i<1||i>listaOpciones.length);
        return (i-1);
    }
    public static void main(String[] args) {
        //eleccion del reino
        String[]reinos={"Inglaterra", "Francia", "Sacro Imperio Romano Germánico",  "Castilla Aragón ", "Moros"};
        System.out.println("El juego empezará cuando los 2 juagadores eligan el reino que deseen usar:");
        System.out.println("Es turno de elegir del jugador 1.");
        int reinoJugador1=elegirOpcion(reinos);
        String reino1=reinos[reinoJugador1];
        System.out.println("El jugaro 1 ha elegido: "+reino1);
        System.out.println("Es turno de elegir del jugador 2, recuerde que no se puede usar el mismo ejercito.");
        int reinoJugador2;
        String reino2;
        do{
            reinoJugador2=elegirOpcion(reinos);
            reino2=reinos[reinoJugador2];
        }
        while(reinoJugador1==reinoJugador2);
        System.out.println("El jugador 2 ha elegido: "+reino2);
        //fin eleccion reino
        
    }
    
}
