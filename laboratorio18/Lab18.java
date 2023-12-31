import java.util.*;

public class Lab18 {
    public static void batalla(Ejercito elEjercito1,Ejercito elEjercito2){
        int suma1 =elEjercito1.getSumaVidas();
        int suma2 =elEjercito2.getSumaVidas();
        if(suma1>suma2){
            System.out.println(Atajos.BLUE+"Gana el ejército 1, con "+suma1+" puntos de vida."+Atajos.RESET);
        }
        else if(suma2>suma1){
            System.out.println(Atajos.RED+"Gana el ejército 2, con "+suma2+" puntos de vida."+Atajos.RESET);
        }
        else{
            System.out.println(Atajos.RED+"RESULTADO: "+Atajos.BLUE+" EMPATE."+Atajos.RESET);
        }
    }    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("Empieza la batalla entre el "+Atajos.BLUE+"Ejercito 1"+Atajos.RESET+" y el "+Atajos.RED+"Ejercito 2"+Atajos.RESET);
            //Datos generales
            Ejercito.totalSoldados1=(((int) (Math.random() * 10)) + 1);
            Ejercito.totalSoldados2=(((int) (Math.random() * 10)) + 1);
            Ejercito.totalSoldados=Ejercito.totalSoldados1+Ejercito.totalSoldados2;
            //Creación de los ejercitos
            Ejercito ejercito1=new Ejercito(true);
            Ejercito ejercito2=new Ejercito(false);
            ArrayList<Soldado> actual1=ejercito1.arregloAuxiliar();
            ArrayList<Soldado> actual2=ejercito2.arregloAuxiliar();
            //Ordenamiento en el tablero bidimensional
            ArrayList<Soldado>ejercitos=actual1;
            for(int i=0;i<actual2.size();i++){
                ejercitos.add(actual2.get(i));
            }
            for(int i=0;i<ejercitos.size();i++){
                    ejercitos.get(i).setFila((int) (Math.random() * 10) + 1);
                    ejercitos.get(i).setColumna2((int) (Math.random() * 10) + 1);
                    ejercitos.get(i).setColumna(Atajos.convertir(ejercitos.get(i).getColumna2()));
                    int j=0;
                    while (j<i) {
                        if(ejercitos.get(j).getFila()==ejercitos.get(i).getFila()&&ejercitos.get(j).getColumna2()==ejercitos.get(i).getColumna2()){
                            if(ejercitos.get(j).getFila()==ejercitos.get(i).getFila()){
                                ejercitos.get(i).setFila((int) (Math.random() * 10) + 1);
                            }
                            else{
                                ejercitos.get(i).setColumna2((int) (Math.random() * 10) + 1);
                                ejercitos.get(i).setColumna(Atajos.convertir((ejercitos.get(i).getColumna2())));
                            }
                            j=0;
                        }
                        else{
                            j++;
                        }
                    }
            }
            ejercito1.ordenarEjercito();
            ejercito2.ordenarEjercito();
            System.out.println("Ejercito 1 (ordenado)");
            ejercito1.mostrarDatos();
            System.out.println("Ejercito 2 (ordenado)");
            ejercito2.mostrarDatos();
            //rellenar el tablero bidimensional
            Soldado tableroSoldados[][]=new Soldado[11][11];
            int varTablero=0;
            while(varTablero<ejercitos.size()){
                tableroSoldados[ejercitos.get(varTablero).getFila()][ejercitos.get(varTablero).getColumna2()] = ejercitos.get(varTablero);
                varTablero++;
            }
            //fin relleno tablero
            Soldado.imprimirTablero(tableroSoldados);
            batalla(ejercito1, ejercito2);
            //Secuencia de control
            System.out.println("¿ Desea generar otra batalla ? (s/n)");
            String control=(scan.next()).toLowerCase();
            if(control.equals("n")){
                break;
            }

        }
    }        
}