import java.util.*;

public class Mapa {

    private String territorio;
    private ArrayList<Ejercito> reinos=new ArrayList<>();
    private ArrayList<Ejercito> reino1=new ArrayList<>();
    private ArrayList<Ejercito> reino2=new ArrayList<>();
    private Ejercito [][] tablero=new Ejercito[11][11];
    private int numEjercitos1=999;
    private int numEjercitos2=999;
    private int numEjercitos;
    private int sumaVida1;
    private int sumaVida2;
    public static Ejercito[][]tableroOn=new Ejercito[11][11];


    //Métodos modificadores
    public Mapa(String territorio, String nomReino1, String nomReino2){
        if(numEjercitos1==999){
            numEjercitos1=(int) (Math.random() * 10) + 1;
        }
        if(numEjercitos2==999){
            numEjercitos2=(int) (Math.random() * 10) + 1;
        }
        numEjercitos=numEjercitos1+numEjercitos2;
        for(int i=0;i<numEjercitos;i++){
            Ejercito parcial=new Ejercito(nomReino1,(int) (Math.random() * 10) + 1);
            parcial.generarSoldados();
            parcial.setFila((int) (Math.random() * 10) + 1);
            parcial.setColumna2((int) (Math.random() * 10) + 1);
            parcial.setColumna(convertir(parcial.getColumna2()));
            if(i<numEjercitos1){
                parcial.setReino(true);
                parcial.setReino2(nomReino1);
                reino1.add(parcial);
                reinos.add(parcial);
            }
            else{
                parcial.setReino(false);
                parcial.setReino2(nomReino2);
                reino2.add(parcial);
                reinos.add(parcial);
            }
            for(int j=0;j<i;j++){
                if((reinos.get(i).getFila()==reinos.get(j).getFila())&&(reinos.get(i).getColumna2()==reinos.get(j).getColumna2())){
                    if(reinos.get(i).getFila()==reinos.get(j).getFila()){
                        reinos.get(i).setFila((int) (Math.random() * 10) + 1);
                    }
                    else{
                        reinos.get(i).setColumna2((int) (Math.random() * 10) + 1);
                        reinos.get(i).setColumna(convertir( reinos.get(i).getColumna2()));
                    }
                    if(reinos.get(i).getReino()){
                        reino1.set(i, reinos.get(i));
                    }
                    else{
                        reino2.set(i-numEjercitos1, reinos.get(i));
                    }
                    j=0;                    
                }
                else{
                    j++;
                }
            }
        }
        if(beneficio(territorio, nomReino1)){
            for(int v=0;v<reino1.size();v++){
                reino1.get(v).plusTerritorio();
            }
        }
        if(beneficio(territorio, nomReino2)){
            for(int z=0;z<reino2.size();z++){
                reino2.get(z).plusTerritorio();
            }
        }
        
        //rellenar el tablero bidimensional
        int i=0;
        while(i<reinos.size()){
            tablero[reinos.get(i).getFila()][reinos.get(i).getColumna2()] = reinos.get(i);
            if(i<numEjercitos1){
                sumaVida1=sumaVida1+reinos.get(i).getSumaVidas();
            }
            else{
                sumaVida2=sumaVida2+reinos.get(i).getSumaVidas();
            }
            i++;
        }
        //fin relleno tablero

    }

    public void setNumEjercitos1(int n1){
        numEjercitos1=n1;
    }
    public void setNumEjercitos2(int n2){
        numEjercitos1=n2;
    }
    public void setTerritorio(String t){
        territorio=t;
    }
    public int getNumEjercitos1(){
        return numEjercitos1;
    }
    public int getNumEjercitos2(){
        return numEjercitos2;
    }
    public int getSumaVidasE1(){
        return sumaVida1;
    }
    public int getSumaVidasE2(){
        return sumaVida2;
    }

    // accesores
    public void actualizarTableroOn(){
        for(int i=0;i<tableroOn.length;i++){
            for(int j=0;j<tableroOn[i].length;j++){
                tableroOn[i][j]=tablero[i][j];
            }
        }
    }
    public void imprimirTablero(){
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if ((tablero[fila][columna] != null)) {
                    String numDeSoldados, numSumaVidas;
                    numDeSoldados=""+tablero[fila][columna].getNumSoldados();
                    if(tablero[fila][columna].getNumSoldados()<10){
                        numDeSoldados=0+""+tablero[fila][columna].getNumSoldados();
                    }
                    numSumaVidas=""+tablero[fila][columna].getSumaVidas();
                    if(tablero[fila][columna].getSumaVidas()<10){
                        numSumaVidas=0+""+tablero[fila][columna].getSumaVidas();
                    }
                    System.out.print("|"+(tablero[fila][columna].getReino2()).substring(0,1)+"-"+numDeSoldados+"-"+numSumaVidas);
                }
                else {
                    if(fila==0){
                        if(columna==0){
                           System.out.print("   "+"\t "); 
                        }
                        else{
                            System.out.print(convertir(columna)+"       ");
                        }
                    }
                    else if(columna==0){
                        System.out.print(fila+"\t");
                    }
                    else{
                        System.out.print("|_______");
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
    //beneficios
    public static boolean beneficio(String territorio, String reino){
        String[]reinos={"Inglaterra", "Francia", "Sacro Imperio Romano Germánico",  "Castilla Aragón ", "Moros"};
        String[]territorios={"Bosque", "Campo abierto", "Montaña","Desierto", "Playa"};
        if(territorio.equals(territorios[0])){
            if(reino.equals(reinos[0])||reino.equals(reinos[2])){
                System.out.println(reino+ " obtiene un beneficio de territorio.");
                return true;
            }
        }
        else if(territorio.equals(territorios[1])){
            if(reino.equals(reinos[1])||reino.equals(reinos[2])){
                System.out.println(reino+ "obtiene un beneficio de territorio.");
                return true;
            }
        }
        else if(territorio.equals(territorios[2])){
            if(reino.equals(reinos[3])){
                System.out.println(reino+ "obtiene un beneficio de territorio.");
                return true;
            }
        }
        else if(territorio.equals(territorios[3])){
            if(reino.equals(reinos[4])){
                System.out.println(reino+ "obtiene un beneficio de territorio.");
                return true;
            }
        }
        else if(territorio.equals(territorios[4])){
            if(reino.equals(reinos[2])){
                System.out.println(reino+ "obtiene un beneficio de territorio.");
                return true;
            }
        }
        return false;
    }
      
}
