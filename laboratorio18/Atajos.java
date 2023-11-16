import java.util.Scanner;

public class Atajos {
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
    
}
