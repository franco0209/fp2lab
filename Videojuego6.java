
//Autor: Franco Jesus Cahua Soto
//Lab9
import java.util.*;

public class Videojuego6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Soldado[][] tablero = new Soldado[10][10];
        int mayorEsta, posMayorEsta, sumaEsta, mayorEsta2, posMayorEsta2, sumaEsta2, sumaVidas, sumaVidas2;
        String c = "n";
        do {
            mayorEsta = 0;
            posMayorEsta = 0;
            sumaEsta = 0;
            mayorEsta2 = 0;
            posMayorEsta2 = 0;
            sumaEsta2 = 0;
            sumaVidas = 0;
            sumaVidas2 = 0;
            Soldado[] soldados1 = new Soldado[((int) (Math.random() * 10)) + 1];
            Soldado[] soldados2 = new Soldado[((int) (Math.random() * 10)) + 1];
            Soldado[] soldados = new Soldado[soldados1.length + soldados2.length];
            completarArray(soldados, soldados1, soldados2);
            while (defecto(soldados)) {
                completarArray(soldados, soldados1, soldados2);
            }
            for (int i = 0; i < soldados.length; i++) {
                tablero[soldados[i].getFila() - 1][(soldados[i].getColumna2()) - 1] = soldados[i];
                if (i < soldados1.length) {
                    sumaEsta = sumaEsta
                            + (soldados[i].getVida() * soldados[i].getNivelDefensa() + soldados[i].getNivelAtaque());
                    sumaVidas = sumaVidas + soldados[i].getVida();
                    if ((soldados[i].getVida() * soldados[i].getNivelDefensa()
                            + soldados[i].getNivelAtaque()) > mayorEsta) {
                        mayorEsta = (soldados[i].getVida() * soldados[i].getNivelDefensa()
                                + soldados[i].getNivelAtaque());
                        posMayorEsta = i;
                    }
                } else {
                    sumaEsta2 = sumaEsta2
                            + (soldados[i].getVida() * soldados[i].getNivelDefensa() + soldados[i].getNivelAtaque());
                    sumaVidas2 = sumaVidas2 + soldados[i].getVida();
                    if ((soldados[i].getVida() * soldados[i].getNivelDefensa()
                            + soldados[i].getNivelAtaque()) > mayorEsta2) {
                        mayorEsta2 = (soldados[i].getVida() * soldados[i].getNivelDefensa()
                                + soldados[i].getNivelAtaque());
                        posMayorEsta2 = i;
                    }
                }
            }
            System.out.println("Ejercito 1: ");
            mostrarLista(soldados1);
            System.out.println("El soldado con mayor nivel de vida: ");
            mostrar(soldados, posMayorEsta);
            System.out.println("Promedio de vida de los soldados: " + ((sumaVidas + 0.0) / (soldados1.length + 0.0)));
            System.out.println("Ejercito 2: ");
            mostrarLista(soldados2);
            System.out.println("El soldado con mayor nivel de vida: ");
            mostrar(soldados, posMayorEsta2);
            System.out.println("Promedio de vida de los soldados: " + ((sumaVidas2 + 0.0) / (soldados2.length + 0.0)));
            imprimirTablero(tablero);
            System.out.println("Ordenamiento ejercito 1 (burbuja): ");
            ordenarBurbuja(soldados1);
            mostrarLista(soldados1);
            System.out.println("Ordenamiento ejercito 2 (insercción): ");
            ordenarInserccion(soldados2);
            mostrarLista(soldados2);
            if (sumaEsta > sumaEsta2) {
                System.out.println(
                        "Gana el ejercito 1, sus soldados tienen como estadisticas generales un puntaje de  " + sumaEsta
                                + " , mientras el adversario suma " + sumaEsta2);
            } else if (sumaEsta < sumaEsta2) {
                System.out.println(
                        "Gana el ejercito 2, sus soldados tienen como estadisticas generales un puntaje de " + sumaEsta2
                                + " , mientras el adversario suma " + sumaEsta);
            } else {
                System.out
                        .println("Empate, los soldados del ejercito 1 tienen como estadisticas generales un puntaje de "
                                + sumaEsta
                                + " , mientras el adversario suma " + sumaEsta2);

            }
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
                + "\t\tColumna:" + ejercito[j].getColumna() + "\t\tVida:" + ejercito[j].getVida() + "\n\t\tAtaque:"
                + ejercito[j].getNivelAtaque() + "\t\tDefensa:" + ejercito[j].getNivelDefensa());
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
        for (int i = 0; i < soldados.length; i++) {
            soldados[i] = new Soldado();
            soldados[i].setVida((int) (Math.random() * 5) + 1);
            soldados[i].setNivelAtaque((int) (Math.random() * 5) + 1);
            soldados[i].setNivelDefensa((int) (Math.random() * 5) + 1);
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
