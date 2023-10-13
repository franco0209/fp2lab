
//Autor: Franco Jesus Cahua Soto
//Lab08
import java.util.*;

public class Viedeojuego5v2 {
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
            HashMap<Integer, Soldado> soldados1 = new HashMap<Integer, Soldado>();
            HashMap<Integer, Soldado> soldados2 = new HashMap<Integer, Soldado>();
            HashMap<Integer, Soldado> soldados = new HashMap<Integer, Soldado>();
            completarArray(soldados, soldados1, soldados2);
            while (defecto(soldados)) {
                completarArray(soldados, soldados1, soldados2);
            }
            for (int i = 0; i < soldados.size(); i++) {
                tablero[soldados.get(i).getFila() - 1][(soldados.get(i).getColumna2()) - 1] = soldados.get(i);
                if (i < soldados1.size()) {
                    sumaVidas = sumaVidas + soldados.get(i).getVida();
                    if (soldados.get(i).getVida() > mayorVida) {
                        mayorVida = soldados.get(i).getVida();
                        posMayorVida = i;
                    }
                } else {
                    sumaVidas2 = sumaVidas2 + soldados.get(i).getVida();
                    if (soldados.get(i).getVida() > mayorVida2) {
                        mayorVida2 = soldados.get(i).getVida();
                        posMayorVida2 = i;
                    }
                }
            }
            System.out.println("Ejercito 1: ");
            mostrarLista(soldados1);
            System.out.println("El soldado con mayor nivel de vida: ");
            System.out.println(posMayorVida);
            mostrar(soldados, posMayorVida);
            System.out.println("Promedio de vida de los soldados: " + ((sumaVidas + 0.0) / (soldados1.size() + 0.0)));
            System.out.println("Ejercito 2: ");
            mostrarLista(soldados2);
            System.out.println("El soldado con mayor nivel de vida: ");
            System.out.println(posMayorVida2);
            mostrar(soldados, posMayorVida2);
            System.out.println("Promedio de vida de los soldados: " + ((sumaVidas2 + 0.0) / (soldados2.size() + 0.0)));
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

    public static void mostrar(HashMap<Integer, Soldado> ejercito, int j) {
        System.out.println("\t\tNombre:" + ejercito.get(j).getNombre() + "\t\tFila: " + ejercito.get(j).getFila() + "\t"
                + "\t\tColumna:" + ejercito.get(j).getColumna() + "\t\tVida:" + ejercito.get(j).getVida());
    }

    public static String letraNum(int n) {
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        return letras[n - 1];
    }

    public static boolean defecto(HashMap<Integer, Soldado> ejercito) {
        for (int i = 0; i < ejercito.size(); i++) {
            for (int j = i + 1; j < ejercito.size(); j++) {
                if ((ejercito.get(i).getFila() == ejercito.get(i).getFila())
                        && (ejercito.get(i).getColumna2() == ejercito.get(i).getColumna2())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void completarArray(HashMap<Integer, Soldado> soldados, HashMap<Integer, Soldado> soldados1,
            HashMap<Integer, Soldado> soldados2) {
        int numsold1 = (((int) (Math.random() * 10)) + 1);
        int numsold2 = (((int) (Math.random() * 10)) + 1);
        int numsold = numsold1 + numsold2;
        for (int i = 0; i < numsold; i++) {
            soldados.put(i, new Soldado());
            soldados.get(i).setVida((int) (Math.random() * 5) + 1);
            soldados.get(i).setFila((int) (Math.random() * 10) + 1);
            soldados.get(i).setColumna2((int) (Math.random() * 10) + 1);
            soldados.get(i).setColumna(letraNum(soldados.get(i).getColumna2()));
            if (i < numsold1) {
                soldados.get(i).setNombre("Soldado" + i + "X1");
                soldados.get(i).setEjercito(true);
                soldados1.put(i, soldados.get(i));
            } else {
                soldados.get(i).setNombre("Soldado" + (i - numsold1) + "X2");
                soldados.get(i).setEjercito(false);
                soldados2.put(i - numsold1, soldados.get(i));
            }
        }
    }

    public static void mostrarLista(HashMap<Integer, Soldado> soldados) {
        for (int i = 0; i < soldados.size(); i++) {
            mostrar(soldados, i);
        }
    }

    public static void ordenarBurbuja(HashMap<Integer, Soldado> soldados) {
        for (int i = 1; i < soldados.size(); i++) {
            for (int j = 0; j < soldados.size() - i; j++) {
                if ((soldados.get(j).getVida()) < (soldados.get(j + 1).getVida())) {
                    intercambiar(soldados, j, j + 1);
                }
            }
        }
    }

    public static void ordenarInserccion(HashMap<Integer, Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            int max = soldados.get(i).getVida();
            int maxpos = i;
            for (int j = i; j < soldados.size(); j++) {
                if (soldados.get(j).getVida() > max) {
                    max = soldados.get(j).getVida();
                    maxpos = j;
                }
            }
            intercambiar(soldados, i, maxpos);
        }
    }

    public static void intercambiar(HashMap<Integer, Soldado> a, int i, int j) {
        Soldado temp = new Soldado();
        temp = a.get(i);
        a.put(i, a.get(j));
        a.put(j, temp);
    }
}
