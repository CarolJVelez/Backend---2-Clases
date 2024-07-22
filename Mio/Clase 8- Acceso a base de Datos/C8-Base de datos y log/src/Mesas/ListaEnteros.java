package Mesas;

import org.apache.log4j.Logger;
import presencial.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaEnteros {


    private static final Logger logger = Logger.getLogger(Cliente.class);
    List<Integer> listaEnteros = new ArrayList<>();

        public ListaEnteros (List<Integer> listaEnteros) throws Exception{
            if(listaEnteros.isEmpty()){
                logger.info("La lista es igual a cero");
                throw new Exception("La lista es igual a cero");
            }

            this.listaEnteros = listaEnteros;
            if(listaEnteros.size() > 5){
                logger.info("La longitud de la lista es mayor a 5");
            }
            if(listaEnteros.size() > 10){
                logger.info("La longitud de la lista es mayor a 10");
            }

            //Determinar el promedio
            double promedio = listaEnteros.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            logger.info("El valor promedio de la lista es: "+promedio);

            //Determinar el maximo
            int maximo = listaEnteros.stream().mapToInt(Integer::intValue).max().orElse(0);
            logger.info("El valor promedio de la lista es: "+maximo);

            int minimo = listaEnteros.stream().mapToInt(Integer::intValue).min().orElse(0);
            logger.info("El valor promedio de la lista es: "+minimo);

        }

    public static void main(String[] args) {
        List<Integer> lista5 = Arrays.asList(1, 2, 3, 4, 5,8);
        List<Integer> lista10 = Arrays.asList(1, 2, 3, 4, 5,8,9,10,47,5,6,7,3,7);
        try{
            ListaEnteros lista2 = new ListaEnteros(lista5);
            ListaEnteros lista3 = new ListaEnteros(lista10);
        }catch (Exception e){
            System.out.println("La lista es igual a cero");
            e.printStackTrace();
        }
    }


}
