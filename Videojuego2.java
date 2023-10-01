import java.util.*;
public class Videojuego2 {
    public static void main(String[]args){
            Scanner scan=new Scanner(System.in);
            Soldado [] soldados=new Soldado[10];
            Soldado[][] tablero=new Soldado[10][10];
            int mayorVida=0;
            int posMayorVida=0;
            int sumaVidas=0;
            completarArray(soldados);
            while(defecto(soldados)){
                completarArray(soldados);
            }
            for(int i=0;i<soldados.length;i++){
                mostrar(soldados, i);
                tablero[soldados[i].getFila()-1][(soldados[i].getColumna2())-1]=soldados[i];
                sumaVidas=sumaVidas+soldados[i].getVida();
                if (soldados[i].getVida()>mayorVida){
                    mayorVida=soldados[i].getVida();
                    posMayorVida=i;
                }
            }
            System.out.println("El soldado con mayor nivel de vida: ");
            mostrar(soldados,posMayorVida);
            System.out.println("Promedio de vida de los soldados: "+((sumaVidas+0.0)/(soldados.length+0.0)));
            imprimirTablero(tablero);
            ordenarBurbuja(soldados);
            mostrarLista(soldados);
            ordenarInserccion(soldados);
            mostrarLista(soldados);
        }
        public static void imprimirTablero(Soldado[][] tablero) {
            for (int fila = 0; fila < tablero.length; fila++) {
                for (int columna = 0; columna < tablero[fila].length; columna++) {
                    if (tablero[fila][columna] != null) {
                        System.out.print("|X");
                    } else {
                        System.out.print("|_");
                    }
                }
                System.out.println("|");
            }
        }
        public static void mostrar(Soldado[] ejercito, int j){
            System.out.println("\t\tNombre:"+ejercito[j].getNombre()+"\t\tFila: "+ejercito[j].getFila()+"\t"+"\t\tColumna:"+ejercito[j].getColumna()+"\t\tVida:"+ejercito[j].getVida());
        }
        public static String letraNum(int n){
            String[]letras= {"A","B","C","D","E","F","G","H","I","J"};
            return letras[n-1];
        }
        public static boolean defecto(Soldado[] ejercito) {
            for (int i = 0; i < ejercito.length; i++) {
                for (int j = i + 1; j < ejercito.length; j++) {
                    if ((ejercito[i].getFila() == ejercito[j].getFila()) && (ejercito[i].getColumna2() == ejercito[j].getColumna2())) {
                        return true; 
                    }
                }
            }
            return false;
        }
        public static void completarArray(Soldado[]soldados){
            for(int i=0; i<10; i++){
                soldados[i]=new Soldado();
                soldados[i].setNombre("soldado"+i);
                soldados[i].setVida((int)(Math.random()*5)+1);
                soldados[i].setFila((int)(Math.random()*10)+1);
                soldados[i].setColumna2((int)(Math.random()*10)+1);
                soldados[i].setColumna(letraNum((soldados[i].getColumna2())));
            }
        }
        public static void mostrarLista(Soldado[]soldados){
            for(int i=0;i<soldados.length;i++){
                mostrar(soldados, i);
            }
        }
        public static void ordenarBurbuja(Soldado[] soldados){
            for (int i=1;i<soldados.length;i++){
                for(int j=0; j<soldados.length-i;j++){
                    if((soldados[j].getVida())<(soldados[j+1].getVida())){
                        intercambiar(soldados, j, j+1);
                    }
                }
            }
        }
        public static void ordenarInserccion(Soldado[] soldados){
            for (int i=0;i<soldados.length-1;i++){
                int max=soldados[i].getVida();
                int maxpos=i;
                for(int j=i;j<soldados.length;j++){
                    if(soldados[j].getVida()>max){
                        max=soldados[j].getVida();
                        maxpos=j;
                    }
                }
                intercambiar(soldados, i, maxpos);
            }
            }
        
        public static void intercambiar(Soldado []a,int i, int j){
            Soldado temp=new Soldado();
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        public static int min(int a, int b){
            if(a<b){
                return a;
            }
            else{
                return b;
            }
        }
        
}
