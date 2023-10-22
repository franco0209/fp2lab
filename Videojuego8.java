
//Autor: Franco Jesus Cahua Soto
//Lab08
import java.util.*;

public class Videojuego8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Soldado[][] tablero = new Soldado[10][10];
        int mayorVida, posMayorVida, sumaVidas, mayorVida2, posMayorVida2, sumaVidas2;
        String c = "n";
        do {
            mayorVida = 0;
            posMayorVida = 0;
            sumaVidas = 0;
            mayorVida2 = 0;
            posMayorVida2 = 0;
            sumaVidas2 = 0;
            Soldado[] soldados1 = new Soldado[((int) (Math.random() * 10)) + 1];
            Soldado[] soldados2 = new Soldado[((int) (Math.random() * 10)) + 1];
            Soldado[] soldados = new Soldado[soldados1.length + soldados2.length];
            completarArray(soldados, soldados1, soldados2);
            for (int i = 0; i < soldados.length; i++) {
                tablero[soldados[i].getFila() - 1][(soldados[i].getColumna2()) - 1] = soldados[i];
                if (i < soldados1.length) {
                    sumaVidas = sumaVidas + soldados[i].getVida();
                    if (soldados[i].getVida() > mayorVida) {
                        mayorVida = soldados[i].getVida();
                        posMayorVida = i;
                    }
                } else {
                    sumaVidas2 = sumaVidas2 + soldados[i].getVida();
                    if (soldados[i].getVida() > mayorVida2) {
                        mayorVida2 = soldados[i].getVida();
                        posMayorVida2 = i;
                    }
                }
            }
            System.out.println("Ejercito 1: ");
            mostrarLista(soldados1);
            System.out.println("El soldado con mayor nivel de vida: ");
            System.out.println(posMayorVida);
            mostrar(soldados, posMayorVida);
            System.out.println("Promedio de vida de los soldados: " + ((sumaVidas + 0.0) / (soldados1.length + 0.0)));
            System.out.println("Ejercito 2: ");
            mostrarLista(soldados2);
            System.out.println("El soldado con mayor nivel de vida: ");
            System.out.println(posMayorVida2);
            mostrar(soldados, posMayorVida2);
            System.out.println("Promedio de vida de los soldados: " + ((sumaVidas2 + 0.0) / (soldados2.length + 0.0)));
            imprimirTablero(tablero);
            System.out.println("Ordenamiento ejercito 1 (burbuja): ");
            ordenarBurbuja(soldados1);
            mostrarLista(soldados1);
            System.out.println("Ordenamiento ejercito 2 (insercción): ");
            ordenarInserccion(soldados2);
            mostrarLista(soldados2);
            System.out.println("Iniciando simulación virtual: ");
            if (sumaVidas > sumaVidas2) {
                System.out.println("Gana el ejercito 1, sus soldados suman " + sumaVidas
                        + " puntos de vida, mientras el adversario suma " + sumaVidas2);
            } else if (sumaVidas < sumaVidas2) {
                System.out.println("Gana el ejercito 2, sus soldados suman " + sumaVidas2
                        + " puntos de vida, mientras el adversario suma " + sumaVidas);
            } else {
                System.out.println("Empate, los soldados del ejercito 1 suman " + sumaVidas
                        + " puntos de vida, mientras el adversario suma " + sumaVidas2);

            }
            // batalla
            System.out.println("INICIA LA BATALLA REAL!");
            System.out.println("Ejercito 1: X");
            System.out.println("Ejercito 2: O");
            int vidas[] = { soldados1.length, soldados2.length };
            while ((vidas[0] != 0) && (vidas[1] != 0)) {
                System.out.println("Soldados activos del ejercito 1: " + vidas[0]);
                System.out.println("Soldados activos del ejercito 2: " + vidas[1]);
                turnoBatalla(tablero, true, vidas);
                imprimirTablero(tablero);
                System.out.println("¿ Desea recordar las estadísticas iniciales de los ejercitos? (s/n)");
                String pregunta = scan.next();
                if (pregunta.equals("s")) {
                    System.out.println("Ejercito 1: ");
                    mostrarLista(soldados1);
                    System.out.println("Ejercito 2: ");
                    mostrarLista(soldados2);
                }
                turnoBatalla(tablero, false, vidas);
                imprimirTablero(tablero);
            }
            if (vidas[0] == 0) {
                System.out.println("Gana el jugador 2. El ejercito 1 ha sido eliminado");
            } else {
                System.out.println("Gana el jugador 1. El ejercito 2 ha sido eliminado");
            }
            // finbatalla

            System.out.println("¿Desea generar otro tablero? (s/n)");
            c = scan.next();
            while (!(c.equals("s")) && !(c.equals("n"))) {
                System.out.println("Carácter inválido, solo se reconoce: (s/n). Intente nuevamente:");
                c = scan.next();
            }
        } while (c.equals("s"));
    }

    public static void imprimirTablero(Soldado[][] tablero) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if ((tablero[fila][columna] != null)) {
                    if (tablero[fila][columna].getVida() != -1) {
                        if (tablero[fila][columna].getEjercito()) {
                            System.out.print("|X");
                        } else {
                            System.out.print("|O");
                        }
                    }
                } else {
                    System.out.print("|_");
                }
            }
            System.out.println("|");
        }
    }

    public static void mostrar(Soldado[] ejercito, int j) {
        System.out.println("\t\tNombre:" + ejercito[j].getNombre() + "\t\tFila: " + ejercito[j].getFila() + "\t"
                + "\t\tColumna:" + ejercito[j].getColumna() + "\t\tVida:" + ejercito[j].getVida());
    }

    public static String letraNum(int n) {
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        return letras[n - 1];
    }

    public static void completarArray(Soldado[] soldados, Soldado[] soldados1, Soldado[] soldados2) {

        for (int i = 0; i < soldados.length; i++) {
            soldados[i] = new Soldado();
            soldados[i].setVida((int) (Math.random() * 5) + 1);
            soldados[i].setFila((int) (Math.random() * 10) + 1);
            soldados[i].setColumna2((int) (Math.random() * 10) + 1);
            soldados[i].setColumna(letraNum((soldados[i].getColumna2())));
            if (i < soldados1.length) {
                soldados[i].setNombre("Soldado" + i + "X1");
                soldados[i].setEjercito(true);
                soldados1[i] = new Soldado();
                soldados1[i] = soldados[i];
            } else {
                soldados[i].setNombre("Soldado" + (i - soldados1.length) + "X2");
                soldados[i].setEjercito(false);
                soldados2[i - soldados1.length] = new Soldado();
                soldados2[i - soldados1.length] = soldados[i];
            }
            int j = 0;
            while (j < i) {
                if ((soldados[j].getFila() == soldados[i].getFila())
                        && (soldados[j].getColumna2() == soldados[i].getColumna2())) {
                    soldados[i].setFila((int) (Math.random() * 10) + 1);
                    soldados[i].setColumna2((int) (Math.random() * 10) + 1);
                    soldados[i].setColumna(letraNum((soldados[i].getColumna2())));
                    j = 0;
                } else {
                    j++;
                }
            }
        }
    }

    public static void mostrarLista(Soldado[] soldados) {
        for (int i = 0; i < soldados.length; i++) {
            mostrar(soldados, i);
        }
    }

    public static int toNum(String s) {
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        for (int i = 0; i < letras.length; i++) {
            if (s.equals(letras[i])) {
                return (i + 1);
            }
        }
        return -1;
    }

    public static int fila() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la fila:");
        return scan.nextInt();
    }

    public static int columna() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la columna:");
        return toNum(scan.next());
    }

    public static void turnoBatalla(Soldado[][] tablero, boolean ejercito, int[] vidas) {
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
                if (tablero[filaSol1 - 1][colSol1 - 1] == null) {
                    System.out.println("Soldado inválido, casilla vacía. ");
                    System.out.println("Eliga la posición del soldado que utilizará: ");
                    filaSol1 = fila();
                    colSol1 = columna();
                } else {
                    if ((!(tablero[filaSol1 - 1][colSol1 - 1].getEjercito()) || (ejercito))
                            && (!(ejercito) || (tablero[filaSol1 - 1][colSol1 - 1].getEjercito()))) {
                        System.out.println("Soldado válido.");
                        System.out.println("Fila: " + filaSol1);
                        System.out.println("Columna: " + letraNum(colSol1));
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
                if (tablero[filaMov1 - 1][colMov1 - 1] == null) {
                    System.out.println("Movimiento válido: ");
                    System.out.println("Fila: " + filaMov1);
                    System.out.println("Columna: " + letraNum(colMov1));
                    tablero[filaMov1 - 1][colMov1 - 1] = new Soldado();
                    tablero[filaMov1 - 1][colMov1 - 1] = tablero[filaSol1 - 1][colSol1 - 1];
                    tablero[filaSol1 - 1][colSol1 - 1] = null;
                    break;
                } else {
                    if ((!(tablero[filaMov1 - 1][colMov1 - 1].getEjercito()) || (ejercito))
                            && (!(ejercito) || (tablero[filaMov1 - 1][colMov1 - 1].getEjercito()))) {
                        System.out.println("Movimiento inválido, ya hay un aliado en esa posición.");
                        System.out.println("Eliga la posición para realizar el movimiento: ");
                        filaMov1 = fila();
                        colMov1 = columna();
                    } else {
                        System.out.println("Movimiento válido: ");
                        System.out.println("Fila: " + filaMov1);
                        System.out.println("Columna: " + letraNum(colMov1));
                        System.out.println("Batalla: ");
                        int vida1 = tablero[filaSol1 - 1][colSol1 - 1].getVida();
                        int vida2 = tablero[filaMov1 - 1][colMov1 - 1].getVida();
                        int suma = vida1 + vida2;
                        int random = (int) ((Math.random() * suma) + 1);
                        System.out.println("Posibilidades de ganar : 1-" + vida1);
                        System.out.println("Posibilidades de ganar del enemigo : " + (vida1 + 1) + "-" + suma);
                        System.out.println("Random:" + random);
                        if (random <= vida1) {
                            System.out.println("Gana el jugador: " + turno);
                            tablero[filaMov1 - 1][colMov1 - 1] = tablero[filaSol1 - 1][colSol1 - 1];
                            tablero[filaMov1 - 1][colMov1 - 1]
                                    .setVida((tablero[filaMov1 - 1][colMov1 - 1].getVida()) + 1);
                            tablero[filaSol1 - 1][colSol1 - 1] = null;
                            if (ejercito) {
                                vidas[1]--;
                            } else {
                                vidas[0]--;
                            }
                        } else {
                            System.out.println("Gana el jugador: " + enemigo);
                            tablero[filaSol1 - 1][colSol1 - 1] = null;
                            tablero[filaMov1 - 1][colMov1 - 1]
                                    .setVida((tablero[filaMov1 - 1][colMov1 - 1].getVida()) + 1);
                            if (ejercito) {
                                vidas[0]--;
                            } else {
                                vidas[1]--;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void ordenarBurbuja(Soldado[] soldados) {
        for (int i = 1; i < soldados.length; i++) {
            for (int j = 0; j < soldados.length - i; j++) {
                if ((soldados[j].getVida()) < (soldados[j + 1].getVida())) {
                    intercambiar(soldados, j, j + 1);
                }
            }
        }
    }

    public static void ordenarInserccion(Soldado[] soldados) {
        for (int i = 0; i < soldados.length - 1; i++) {
            int max = soldados[i].getVida();
            int maxpos = i;
            for (int j = i; j < soldados.length; j++) {
                if (soldados[j].getVida() > max) {
                    max = soldados[j].getVida();
                    maxpos = j;
                }
            }
            intercambiar(soldados, i, maxpos);
        }
    }

    public static void intercambiar(Soldado[] a, int i, int j) {
        Soldado temp = new Soldado();
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
