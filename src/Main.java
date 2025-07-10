public class Main {
    public static void main(String[] args) {
        int[][] matriz ={
                {0,300,302,303,304,305,0,296,298,299,299,299,0,289,293,290,289,293,0},
                {0,325,321,320,430,410,0,415,409,399,440,420,0,412,422,421,412,422,0},
                {0,435,425,425,420,420,0,410,414,414,415,421,0,410,420,420,430,430,0},
        };
        final int MAXFILA = 3;
        final int MAXCOLUMNA = 19;
        eliminarRepeticiones(matriz,MAXFILA,MAXCOLUMNA);
    }
    public static void eliminarRepeticiones (int[][] matriz, final int MAXFILA, final int MAXCOLUMNA){
        int[] diasAlzaMesX ={0,0,0};
      for (int i = 0; i<MAXFILA; i++){
          int inicioSecuencia = 0;
          int finSecuencia = -1;
          int finSecuenciaDiaAnterior=0;
          int contadorDiasEnAlza=0;
          int tamano;
          int tato = 0;
          while (inicioSecuencia<MAXCOLUMNA){
              inicioSecuencia=buscarInicio(MAXCOLUMNA,matriz[i],finSecuencia+1);
              if (inicioSecuencia<MAXCOLUMNA){
                  finSecuencia=buscarFin(MAXCOLUMNA,matriz[i],inicioSecuencia);
              }
              if (tato==0){
                  if (matriz[i][inicioSecuencia]<matriz[i][finSecuencia]) {
                   contadorDiasEnAlza++;
                   finSecuenciaDiaAnterior=finSecuencia;
                  }
                  tato++;
              }else if (finSecuenciaDiaAnterior<finSecuencia){
                  finSecuenciaDiaAnterior=finSecuencia;
                  contadorDiasEnAlza++;
              }else {finSecuenciaDiaAnterior=finSecuencia;}
              tamano=(finSecuencia-inicioSecuencia+1);
              eliminarRepetidos(inicioSecuencia,finSecuencia,matriz[i],tamano);
          }
          diasAlzaMesX[i]=contadorDiasEnAlza;
      }
      for (int r = 0; r<=2;r++){
          System.out.println("Mes: "+(r+1)+" cantidad de dias al alza: "+diasAlzaMesX[r]);
      }
    }
    public static void eliminarRepetidos (int inicio,int fin, int[] array, int tamano) {
        int numeroAnterior = 0;
        while (inicio<=fin){
            if (array[inicio]==array[inicio-1] || numeroAnterior==array[inicio] ){
                numeroAnterior=array[inicio];
                array[inicio]=0;
            }
            inicio++;
        }
    }
    public static int buscarInicio (final int MAXCOLUMNA, int[]array, int fin) {
        int inicio = fin;
        while (inicio<MAXCOLUMNA && array[inicio]==0){
            inicio++;
        }
        return inicio;
    }
    public static int buscarFin (final int MAXCOLUMNA, int[]array, int inicio) {
        while (inicio<MAXCOLUMNA && array[inicio]!=0){
            inicio++;
        }
        return inicio-1;
    }
}