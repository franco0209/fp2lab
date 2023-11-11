    import java.util.*;

    public class Juego3 {
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
        //conversiones
        //letra a número
        public static int convertir(String letra){
            String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
            for (int i = 0; i < letras.length; i++) {
                if (letra.equals(letras[i])) {
                    return (i + 1);
                }
            }
            return -1;
        }
        //número a letra
        public static String convertir(int numero){
            String[] letras = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
            return letras[numero];
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
            //eleccion territorio
            String[]territorios={"Bosque", "Campo abierto", "Montaña","Desierto", "Playa"};
            System.out.println("Elegir a continuación el territorio en el que se desee jugar.");
            int territorioNum=elegirOpcion(territorios);   
            String territorio=territorios[territorioNum];  
            System.out.println("Se ha elegido jugar en "+territorio); 
            Mapa mapa=new Mapa(territorio, reino1, reino2);
            System.out.println("El reino "+reino1+ " cuenta con "+mapa.getNumEjercitos1()+" ejércitos."); 
            System.out.println("El reino "+reino2+ " cuenta con "+mapa.getNumEjercitos2()+" ejércitos."); 
            System.out.println("Se mostrará el tablero "+territorio+ ", cada recuadro tendra el formato (Inicial del reino- numero de soldados en ese ejército- suma de vidas de esos soldados.)"); 
            mapa.imprimirTablero();
            if(mapa.getSumaVidasE1()>mapa.getSumaVidasE2()){
                System.out.println("Al sumar mas puntos de vida ("+mapa.getSumaVidasE1()+"), la guerra la gana "+reino1);
            }
            else if(mapa.getSumaVidasE2()>mapa.getSumaVidasE1()){
                System.out.println("Al sumar mas puntos de vida ("+mapa.getSumaVidasE2()+"), la guerra la gana "+reino2);
            }
            else{
                System.out.println("La guerra resulta en un empate");
            }
        }
    }