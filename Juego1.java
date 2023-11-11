//Autor: Franco Jesus Cahua Soto
//Laboratorio 14
import java.util.*;

public class Juego1 {

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
    
    //fila
    public static int fila() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la fila:");
        return scan.nextInt();
    }
    
    //columna
    public static int columna() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la columna:");
        return convertir(scan.next());
    }
    
    //turno batalla ejercitos
    
    public static void turnoBatalla(Ejercito[][] tablero, boolean ejercito) {
        int turno;
        int enemigo;
        if (ejercito) {
            turno = 1;
            enemigo = 2;
        } else {
            turno = 2;
            enemigo = 1;
        }
        System.out.println("Turno del jugador " + turno + ":");
        System.out.println("Eliga la posición del soldado que utilizará: ");
        int filaSol1 = fila();
        int colSol1 = columna();
        while (true) {
            if (filaSol1 > 10 || filaSol1 < 1 || colSol1 == -1) {
                System.out.println("Soldado inválido, fuera de los límites.");
                System.out.println("Eliga la posición del soldado que utilizará: ");
                filaSol1 = fila();
                colSol1 = columna();
            } else {
                if (tablero[filaSol1 ][colSol1 ] == null) {
                    System.out.println("Soldado inválido, casilla vacía. ");
                    System.out.println("Eliga la posición del soldado que utilizará: ");
                    filaSol1 = fila();
                    colSol1 = columna();
                } else {
                    if ((!(tablero[filaSol1 ][colSol1 ].getReino()) || (ejercito))
                            && (!(ejercito) || (tablero[filaSol1 ][colSol1 ].getReino()))) {
                        System.out.println("Soldado válido.");
                        System.out.println("Fila: " + filaSol1);
                        System.out.println("Columna: " + convertir(colSol1));
                        break;
                    } else {
                        System.out.println("Soldado inválido, soldado enemigo. ");
                        System.out.println("Eliga la posición del soldado que utilizará: ");
                        filaSol1 = fila();
                        colSol1 = columna();
                    }
                }
            }
        }
        System.out.println("Eliga la posición para realizar el movimiento: ");
        int filaMov1 = fila();
        int colMov1 = columna();
        while (true) {
            if (filaMov1 > 10 || filaMov1 < 1 || colMov1 == -1) {
                System.out.println("Movimiento inválido, fuera de los límites.");
                System.out.println("Eliga la posición para realizar el movimiento: ");
                filaMov1 = fila();
                colMov1 = columna();
            } else {
                if (tablero[filaMov1 ][colMov1 ] == null) {
                    System.out.println("Movimiento válido: ");
                    System.out.println("Fila: " + filaMov1);
                    System.out.println("Columna: " + convertir(colMov1));
                    tablero[filaMov1 ][colMov1 ] = new Ejercito();
                    tablero[filaMov1 ][colMov1 ] = tablero[filaSol1 ][colSol1 ];
                    tablero[filaSol1 ][colSol1 ] = null;
                    break;
                } else {
                    if ((!(tablero[filaMov1 ][colMov1 ].getReino()) || (ejercito))
                            && (!(ejercito) || (tablero[filaMov1 ][colMov1 ].getReino()))) {
                        System.out.println("Movimiento inválido, ya hay un aliado en esa posición.");
                        System.out.println("Eliga la posición para realizar el movimiento: ");
                        filaMov1 = fila();
                        colMov1 = columna();
                    } else {
                        System.out.println("Movimiento válido: ");
                        System.out.println("Fila: " + filaMov1);
                        System.out.println("Columna: " + convertir(colMov1));
                        System.out.println(" ¡EMPIEZA UNA BATALLA!");
                        String []opciones={"Batalla automática", "Batalla manual"};
                        int menOpciones;
                        menOpciones=elegirOpcion(opciones);
                        if(menOpciones==1){
                            if (batalla(tablero,filaSol1,colSol1,filaMov1,colMov1)) {
                            System.out.println("Gana el jugador: " + turno);
                            tablero[filaMov1 ][colMov1 ] = tablero[filaSol1 ][colSol1 ];
                            tablero[filaSol1 ][colSol1 ] = null;
                            if (ejercito) {
                                Ejercito.totalEjercitos2--;
                            } else {
                                Ejercito.totalEjercitos1--;
                            }
                            } else {
                                System.out.println("Gana el jugador: " + enemigo);
                                tablero[filaSol1 ][colSol1 ] = null;
                                if (ejercito) {
                                    Ejercito.totalEjercitos1--;
                                } else {
                                    Ejercito.totalEjercitos2--;
                                }
                            }
                        }
                        else{
                            if (batalla2(tablero,filaSol1,colSol1,filaMov1,colMov1)) {
                            System.out.println("Gana el jugador: " + turno);
                            tablero[filaMov1 ][colMov1 ] = tablero[filaSol1 ][colSol1 ];
                            tablero[filaSol1 ][colSol1 ] = null;
                            if (ejercito) {
                                Ejercito.totalEjercitos2--;
                            } else {
                                Ejercito.totalEjercitos1--;
                            }
                            } else {
                                System.out.println("Gana el jugador: " + enemigo);
                                tablero[filaSol1 ][colSol1 ] = null;
                                if (ejercito) {
                                    Ejercito.totalEjercitos1--;
                                } else {
                                    Ejercito.totalEjercitos2--;
                                }
                            }
                            
                        }
                        break;
                    }
                }
            }
        }
    }
    //batalla2
    public static boolean batalla2(Ejercito[][]tableroEj, int posFila, int posColumna, int movFila, int movColumna){
        int soldadosTurno=(tableroEj[posFila][posColumna]).getNumSoldados();
        int soldadosEnemigo=(tableroEj[movFila][movColumna]).getNumSoldados();

        int sumavida1=0;
        int sumavida2=0;
        for(int i=0;i<soldadosTurno;i++){
            sumavida1=sumavida1+((int) (Math.random() * 5) + 1);
        }
        for(int j=0;j<soldadosEnemigo;j++){
            sumavida2=sumavida1+((int) (Math.random() * 5) + 1);
        }

        if(sumavida1>sumavida2){
            System.out.println("Gana, la suma de vidas de sus soldados es: "+sumavida1+" la del rival: "+sumavida2);
            return true;
        }
        else{
            System.out.println("Pierde, la suma de vidas de sus soldados es: "+sumavida1+" la del rival: "+sumavida2);
            return false;
        }
    }
    //batalla 1
    public static boolean batalla(Ejercito[][]tableroEj, int posFila, int posColumna, int movFila, int movColumna){
        int soldadosTurno=(tableroEj[posFila][posColumna]).getNumSoldados();
        int soldadosEnemigo=(tableroEj[movFila][movColumna]).getNumSoldados();
        Soldado.total1=soldadosTurno;
        Soldado.total2=soldadosEnemigo;
        Soldado[]soldados=new Soldado[soldadosEnemigo+soldadosTurno];
        Soldado[]soldados1=new Soldado[soldadosTurno];
        Soldado[]soldados2=new Soldado[soldadosEnemigo];
        Soldado[][] tablero=new Soldado[11][11];
        for (int i = 0; i < soldados.length; i++) {
            if (i < soldadosTurno) {
                soldados[i] = new Soldado();
                soldados[i].setVida((int) (Math.random() * 5) + 1);
                soldados[i].setFila((int) (Math.random() * 10) + 1);
                soldados[i].setColumna2((int) (Math.random() * 10) + 1);
                soldados[i].setColumna(convertir((soldados[i].getColumna2())));
                soldados[i].setNombre("Soldado" + i + "X1");
                soldados[i].setEjercito(true);
                soldados1[i] = new Soldado();
                soldados1[i] = soldados[i];
            }
            else if(i>=soldados1.length){
                soldados[i] = new Soldado();
                soldados[i].setVida((int) (Math.random() * 5) + 1);
                soldados[i].setFila((int) (Math.random() * 10) + 1);
                soldados[i].setColumna2((int) (Math.random() * 10) + 1);
                soldados[i].setColumna(convertir((soldados[i].getColumna2())));
                soldados[i].setNombre("Soldado" + (i-soldados1.length) + "X2");
                soldados[i].setEjercito(false);
                soldados2[i-soldados1.length] = new Soldado();
                soldados2[i-soldados1.length] = soldados[i];
            }
            if(soldados[i]!=null){
                int j = 0;
                while (j < i) {
                    if(soldados[j]!=null){
                        if ((soldados[j].getFila() == soldados[i].getFila())&& (soldados[j].getColumna2() == soldados[i].getColumna2())) {
                            soldados[i].setFila((int) (Math.random() * 10) + 1);
                            soldados[i].setColumna2((int) (Math.random() * 10) + 1);
                            soldados[i].setColumna(convertir((soldados[i].getColumna2())));
                            j = 0;
                        } 
                        else {
                            j++;
                        }
                    }
                    j++;
                }
            }
        }
        int i=0;
        while(i<soldados.length){
            if(soldados[i]!=null){
                tablero[soldados[i].getFila()][soldados[i].getColumna2()] = soldados[i];
            }
            i++;
        }
        imprimirTablero(tablero);
        System.out.println("INICIA LA BATALLA REAL!");
        System.out.println("Ejercito 1: X");
        System.out.println("Ejercito 2: O");
        while ((Soldado.total1 != 0) && (Soldado.total2 != 0)) {
            System.out.println("Soldados activos del ejercito 1: " + Soldado.total1);
            System.out.println("Soldados activos del ejercito 2: " + Soldado.total2);
            turnoBatalla(tablero, true);
            imprimirTablero(tablero);
            if((Soldado.total1 == 0) || (Soldado.total2 == 0)){
                break;
            }
            turnoBatalla(tablero, false);
            imprimirTablero(tablero);
        }
        if (Soldado.total1== 0) {
            System.out.println("Gana el jugador 2. El ejercito 1 ha sido eliminado");
            return false;
        } else {
            System.out.println("Gana el jugador 1. El ejercito 2 ha sido eliminado");
            return true;
        }
    }

    //turno batalla soldados
    public static void turnoBatalla(Soldado[][] tablero, boolean ejercito) {
        int turno;
        int enemigo;
        if (ejercito) {
            turno = 1;
            enemigo = 2;
        } else {
            turno = 2;
            enemigo = 1;
        }
        System.out.println("Turno del jugador " + turno + ":");
        System.out.println("Eliga la posición del soldado que utilizará: ");
        int filaSol1 = fila();
        int colSol1 = columna();
        while (true) {
            if (filaSol1 > 10 || filaSol1 < 1 || colSol1 == -1) {
                System.out.println("Soldado inválido, fuera de los límites.");
                System.out.println("Eliga la posición del soldado que utilizará: ");
                filaSol1 = fila();
                colSol1 = columna();
            } else {
                if (tablero[filaSol1 ][colSol1 ] == null) {
                    System.out.println("Soldado inválido, casilla vacía. ");
                    System.out.println("Eliga la posición del soldado que utilizará: ");
                    filaSol1 = fila();
                    colSol1 = columna();
                } else {
                    if ((!(tablero[filaSol1 ][colSol1 ].getEjercito()) || (ejercito))
                            && (!(ejercito) || (tablero[filaSol1 ][colSol1 ].getEjercito()))) {
                        System.out.println("Soldado válido.");
                        System.out.println("Fila: " + filaSol1);
                        System.out.println("Columna: " + convertir(colSol1));
                        break;
                    } else {
                        System.out.println("Soldado inválido, soldado enemigo. ");
                        System.out.println("Eliga la posición del soldado que utilizará: ");
                        filaSol1 = fila();
                        colSol1 = columna();
                    }
                }
            }
        }
        System.out.println("Eliga la posición para realizar el movimiento: ");
        int filaMov1 = fila();
        int colMov1 = columna();
        while (true) {
            if (filaMov1 > 10 || filaMov1 < 1 || colMov1 == -1) {
                System.out.println("Movimiento inválido, fuera de los límites.");
                System.out.println("Eliga la posición para realizar el movimiento: ");
                filaMov1 = fila();
                colMov1 = columna();
            } else {
                if (tablero[filaMov1 ][colMov1 ] == null) {
                    System.out.println("Movimiento válido: ");
                    System.out.println("Fila: " + filaMov1);
                    System.out.println("Columna: " + convertir(colMov1));
                    tablero[filaMov1 ][colMov1 ] = new Soldado();
                    tablero[filaMov1 ][colMov1 ] = tablero[filaSol1 ][colSol1 ];
                    tablero[filaSol1 ][colSol1 ] = null;
                    break;
                } else {
                    if ((!(tablero[filaMov1 ][colMov1 ].getEjercito()) || (ejercito))
                            && (!(ejercito) || (tablero[filaMov1 ][colMov1 ].getEjercito()))) {
                        System.out.println("Movimiento inválido, ya hay un aliado en esa posición.");
                        System.out.println("Eliga la posición para realizar el movimiento: ");
                        filaMov1 = fila();
                        colMov1 = columna();
                    } else {
                        System.out.println("Movimiento válido: ");
                        System.out.println("Fila: " + filaMov1);
                        System.out.println("Columna: " + convertir(colMov1));
                        System.out.println(" ¡EMPIEZA UNA BATALLA!");
                        int vida1 = tablero[filaSol1 ][colSol1 ].getVida();
                        int vida2 = tablero[filaMov1 ][colMov1 ].getVida();
                        int suma = vida1 + vida2;
                        int random = (int) ((Math.random() * suma) + 1);
                        System.out.println("Posibilidades de ganar : 1-" + vida1 + "  " + (vida1 * 100 / suma) + "%");
                        System.out.println("Posibilidades de ganar del enemigo : " + (vida1 + 1) + "-" + suma + "  "
                                + (vida2 * 100 / suma) + "%");
                        System.out.println("Random:" + random);
                        if (random <= vida1) {
                            System.out.println("Gana el jugador: " + turno);
                            tablero[filaMov1 ][colMov1 ] = tablero[filaSol1 ][colSol1 ];
                            tablero[filaMov1 ][colMov1 ]
                                    .setVida((tablero[filaMov1 ][colMov1 ].getVida()) + 1);
                            tablero[filaSol1 ][colSol1 ] = null;
                            if (ejercito) {
                                Soldado.total2--;
                            } else {
                                Soldado.total1--;
                            }
                        } else {
                            System.out.println("Gana el jugador: " + enemigo);
                            tablero[filaSol1 ][colSol1 ] = null;
                            tablero[filaMov1 ][colMov1 ]
                                    .setVida((tablero[filaMov1 ][colMov1 ].getVida()) + 1);
                            if (ejercito) {
                                Soldado.total1--;
                            } else {
                                Soldado.total2--;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    //imprimir tablero de soldados
    public static void imprimirTablero(Soldado[][] tablero) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if ((tablero[fila][columna] != null)) {
                        if (tablero[fila][columna].getEjercito()) {
                            System.out.print("|X");
                        }
                        else {
                            System.out.print("|O");
                        }
                }
                else {
                    if(fila==0){
                        if(columna==0){
                           System.out.print(" "+"\t "); 
                        }
                        else{
                            System.out.print(convertir(columna)+" ");
                        }
                    }
                    else if(columna==0){
                        System.out.print(fila+"\t");
                    }
                    else{
                        System.out.print("|_");
                    }
                }
            }
            if(fila!=0){
                System.out.println("|");
            }
            else{
                System.out.println("");
            }
        }
    }
    //imprimir tablero de ejercitos
    public static void imprimirTablero(Ejercito[][] tablero) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if ((tablero[fila][columna] != null)) {
                        if (tablero[fila][columna].getReino()) {
                            System.out.print("|X");
                        }
                        else {
                            System.out.print("|O");
                        }
                }
                else {
                    if(fila==0){
                        if(columna==0){
                           System.out.print(" "+"\t "); 
                        }
                        else{
                            System.out.print(convertir(columna)+" ");
                        }
                    }
                    else if(columna==0){
                        System.out.print(fila+"\t");
                    }
                    else{
                        System.out.print("|_");
                    }
                }
            }
            if(fila!=0){
                System.out.println("|");
            }
            else{
                System.out.println("");
            }
        }
    }

    //mostrar los datos de un ejercito
    public static void mostrar(Ejercito[] ejercito, int j) {
        if(ejercito[j].getReino()){

        }
        System.out.println((j+1)+".\tFila: " + ejercito[j].getFila() + "\t"+ "Columna:" + ejercito[j].getColumna()+ "\t"+ "Reino:" + ejercito[j].getReino2()+ "\t"+ "Número de soldados:" + ejercito[j].getNumSoldados());
    }
    //mostrar un arreglo de ejercitos
    public static void mostrarEjercitos(Ejercito[]ejercitos){
        for (int i=0;i<ejercitos.length;i++){
            if(ejercitos[i]!=null){
                mostrar(ejercitos, i);
            }
        }
    }

    public static void main(String[]args){
        //eleccion del reino
        String[]reinos={"Inglaterra", "Francia", "Sacro Imperio Romano Germánico",  "Castilla Aragón", "Moros"};
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

        //Creación de los ejércitos
        Ejercito[][]tableroEjercitos=new Ejercito[11][11];
        Ejercito[]ejercitos=new Ejercito[2*Ejercito.maxEjercitos];
        Ejercito[]ejercito1=new Ejercito[Ejercito.maxEjercitos];
        Ejercito[]ejercito2=new Ejercito[Ejercito.maxEjercitos];
        Ejercito.totalEjercitos1 = ((int) (Math.random() * 10)) + 1;
        Ejercito.totalEjercitos2 = ((int) (Math.random() * 10)) + 1;
        Ejercito.totalEjercitos=Ejercito.totalEjercitos1+Ejercito.totalEjercitos2;
        for(int i=0;i<ejercitos.length;i++){
            if(i<Ejercito.totalEjercitos1){
                ejercitos[i]=new Ejercito();
                ejercitos[i].setNumSoldados((int) (Math.random() * 10) + 1);
                ejercitos[i].setFila((int) (Math.random() * 10) + 1);
                ejercitos[i].setColumna2((int) (Math.random() * 10) + 1);
                ejercitos[i].setColumna(convertir(ejercitos[i].getColumna2()));
                ejercitos[i].setReino(true);
                ejercitos[i].setReino2(reino1);
                ejercito1[i]=new Ejercito();
                ejercito1[i]=ejercitos[i];
            }
            if(i>=Ejercito.maxEjercitos&&i<(Ejercito.maxEjercitos+Ejercito.totalEjercitos2)){
                ejercitos[i]=new Ejercito();
                ejercitos[i].setNumSoldados((int) (Math.random() * 10) + 1);
                ejercitos[i].setFila((int) (Math.random() * 10) + 1);
                ejercitos[i].setColumna2((int) (Math.random() * 10) + 1);
                ejercitos[i].setColumna(convertir(ejercitos[i].getColumna2()));
                ejercitos[i].setReino(false);
                ejercitos[i].setReino2(reino2);
                ejercito2[i-Ejercito.maxEjercitos]=new Ejercito();
                ejercito2[i-Ejercito.maxEjercitos]=ejercitos[i];
            }
            if(ejercitos[i]!=null){
                int j=0;
                while (j<i) {
                    if(ejercitos[j]!=null){
                        if(ejercitos[j].getFila()==ejercitos[i].getFila()&&ejercitos[j].getColumna2()==ejercitos[i].getColumna2()){
                            if(ejercitos[j].getFila()==ejercitos[i].getFila()){
                                ejercitos[i].setFila((int) (Math.random() * 10) + 1);
                            }
                            else{
                                ejercitos[i].setColumna2((int) (Math.random() * 10) + 1);
                                ejercitos[i].setColumna(convertir((ejercitos[i].getColumna2())));
                            }
                            if(ejercitos[i].getReino()){
                                ejercito1[i]=ejercitos[i];
                            }
                            else{
                                ejercito2[i-Ejercito.maxEjercitos]=ejercitos[i];
                            }
                            j=0;
                        }
                        else{
                            j++;
                        }
                    }
                    else{
                        j++;
                    }
                }
            }
        }
        //fin creacion ejercitos
        //rellenar el tablero bidimensional
        int i=0;
        while(i<ejercitos.length){
            if(ejercitos[i]!=null){
                tableroEjercitos[ejercitos[i].getFila()][ejercitos[i].getColumna2()] = ejercitos[i];
            }
            i++;
        }
        //fin relleno tablero
        //iniciar batalla
        System.out.println("Reino de "+reino1+ " con "+Ejercito.totalEjercitos1+" ejercitos.");
        mostrarEjercitos(ejercito1);
        System.out.println("Reino de "+reino2+ " con "+Ejercito.totalEjercitos2+" ejercitos.");
        mostrarEjercitos(ejercito2);
        imprimirTablero(tableroEjercitos);
        System.out.println("INICIA LA BATALLA REAL!");
        while ((Ejercito.totalEjercitos1 != 0) && (Ejercito.totalEjercitos2 != 0)) {
            System.out.println("Soldados activos del ejercito 1: " + Ejercito.totalEjercitos1);
            System.out.println("Soldados activos del ejercito 2: " + Ejercito.totalEjercitos2);
            turnoBatalla(tableroEjercitos, true);
            imprimirTablero(tableroEjercitos);
            if((Ejercito.totalEjercitos1 == 0) || (Ejercito.totalEjercitos2 == 0)){
                break;
            }
            turnoBatalla(tableroEjercitos, false);
            imprimirTablero(tableroEjercitos);
        }
        if (Ejercito.totalEjercitos2== 0) {
            System.out.println("Gana el jugador 2. El ejercito 1 ha sido eliminado");
        } else {
            System.out.println("Gana el jugador 1. El ejercito 2 ha sido eliminado");
        }
        //finbatalla
        
    }
}
