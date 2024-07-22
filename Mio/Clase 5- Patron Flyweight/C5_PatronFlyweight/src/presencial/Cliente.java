package presencial;

public class Cliente {
    public static void main(String[] args) {
        ArbolFactory fabricaArboles = new ArbolFactory();
        for (int i = 0; i < 500000; i++){
            fabricaArboles.getArbol(200, 400, "verde");
        }
        for (int i = 0; i < 500000; i++){
            fabricaArboles.getArbol(500, 300, "rojo");
        }
        /*
        for (int i = 0; i < 500000; i++){
            fabricaArboles.getArbolMod(500, 300, "rojo");
        }
        for (int i = 0; i < 500000; i++){
            fabricaArboles.getArbolMod(200, 400, "verde");
        }
        */
        fabricaArboles.cantidadArboles();
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() -
                runtime.freeMemory()) / (1024 * 1024));


    }
}
