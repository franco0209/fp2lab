
//Autor: Franco Jesus Cahua Soto
//Lab07
import java.util.*;

public class Videojuego4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Soldado[][] tablero = new Soldado[10][10];
        System.out.println("Ingrese el número de soldados del ejercito 1: ");
        int cap1 = scan.nextInt();
        System.out.println("Ingrese el número de soldados del ejercito 2: ");
        int cap2 = scan.nextInt();
        while ((cap1 + cap2) > (tablero.length * tablero[0].length)) {
            System.out.println("Capacidad del tablero excedida.");
            System.out.println("Ingrese el número de soldados del ejercito 1: ");
            cap1 = scan.nextInt();
            System.out.println("Ingrese el número de soldados del ejercito 2: ");
            cap2 = scan.nextInt();
        }
        Soldado[] soldados = new Soldado[cap1 + cap2];
        Soldado[] soldados1 = new Soldado[cap1];
        Soldado[] soldados2 = new Soldado[cap2];
        int mayorVida = 0;
        int posMayorVida = 0;
        int sumaVidas = 0;
        int mayorVida2 = 0;
        int posMayorVida2 = 0;
        int sumaVidas2 = 0;
        completarArray(soldados, soldados1, soldados2);
        while (defecto(soldados)) {
            completarArray(soldados, soldados1, soldados2);
        }
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
        mostrar(soldados, posMayorVida);
        System.out.println("Promedio de vida de los soldados: " + ((sumaVidas + 0.0) / (soldados1.length + 0.0)));
        System.out.println("Ejercito 2: ");
        mostrarLista(soldados2);
        System.out.println("El soldado con mayor nivel de vida: ");
        mostrar(soldados, posMayorVida2);
        System.out.println("Promedio de vida de los soldados: " + ((sumaVidas2 + 0.0) / (soldados2.length + 0.0)));
        imprimirTablero(tablero);
        System.out.println("Ordenamiento ejercito 1 (burbuja): ");
        ordenarBurbuja(soldados1);
        mostrarLista(soldados1);
        System.out.println("Ordenamiento ejercito 2 (insercción): ");
        ordenarInserccion(soldados2);
        mostrarLista(soldados2);
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
    }

    public static void imprimirTablero(Soldado[][] tablero) {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (tablero[fila][columna] != null) {
                    if (tablero[fila][columna].getEjercito()) {
                        System.out.print("|X");
                    } else {
                        System.out.print("|O");
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

    public static boolean defecto(Soldado[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            for (int j = i + 1; j < ejercito.length; j++) {
                if ((ejercito[i].getFila() == ejercito[j].getFila())
                        && (ejercito[i].getColumna2() == ejercito[j].getColumna2())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void completarArray(Soldado[] soldados, Soldado[] soldados1, Soldado[] soldados2) {
        int alfa = 0;
        int beta = 0;
        for (int i = 0; i < soldados.length; i++) {
            soldados[i] = new Soldado();
            soldados[i].setVida((int) (Math.random() * 5) + 1);
            soldados[i].setFila((int) (Math.random() * 10) + 1);
            soldados[i].setColumna2((int) (Math.random() * 10) + 1);
            soldados[i].setColumna(letraNum((soldados[i].getColumna2())));
            if (i < soldados1.length) {
                soldados[i].setNombre("Soldado" + i + "X1");
                soldados[i].setEjercito(true);
                soldados1[alfa] = new Soldado();
                soldados1[alfa] = soldados[i];
                alfa++;
            } else {
                soldados[i].setNombre("Soldado" + (i - soldados1.length) + "X2");
                soldados[i].setEjercito(false);
                soldados2[beta] = new Soldado();
                soldados2[beta] = soldados[i];
                beta++;
            }
        }
    }

    public static void mostrarLista(Soldado[] soldados) {
        for (int i = 0; i < soldados.length; i++) {
            mostrar(soldados, i);
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
