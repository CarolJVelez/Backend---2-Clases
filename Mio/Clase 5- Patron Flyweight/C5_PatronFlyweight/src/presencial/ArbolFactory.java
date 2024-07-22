package presencial;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {

    private Map<String, Arbol> arbolMap;
    private int contadorOrnamentables = 0;
    private int contadorFrutales = 0;
    private int contadorFlorales =0;

    public ArbolFactory(){
        arbolMap = new HashMap<>();
    }

    public Arbol getArbol(int alto, int ancho, String color){

        String clave="K: "+alto+ "-" + ancho + "-"+ color;
        if(!arbolMap.containsKey(clave)){
            arbolMap.put(clave,new Arbol(alto,ancho,color));
            System.out.println("Arbol creado con exito"+clave);
        }
        if(clave == "K: 200-400-verde"){
            contadorOrnamentables++;
        }else if(clave == "K: 500-300-rojo"){
            contadorFrutales++;
        }else if(clave == "K: 100-200-celeste"){
            contadorFlorales++;
        }
        return arbolMap.get(clave);
    }

    public void cantidadArboles(){
        System.out.println("Ornamentales: "+contadorOrnamentables);
        System.out.println("Florales: "+contadorFlorales);
        System.out.println("Frutales: "+contadorFrutales);
    }

    /*
    public Arbol getArbolMod(int alto, int ancho, String color){
        String clave = "K: " + alto + "-" + ancho + "-" + color;
            arbolMap.put(clave, new Arbol(alto, ancho, color));
        if (clave.equals("K: 200-400-verde")){
            contadorOrnamentales++;
        } else if (clave.equals("K: 500-300-rojo")) {
            contadorFrutales++;
        } else if (clave.equals("K: 100-200-celeste")){
            contadorFlorales++;
        }
        System.out.println(arbolMap.size());
        return arbolMap.get(clave);
    }

     */
}
