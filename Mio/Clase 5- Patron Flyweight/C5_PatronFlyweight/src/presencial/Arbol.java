package presencial;

public class Arbol {
    private int alto;
    private int ancho;
    private String color;
    private static int contador = 0;

    public Arbol(int alto, int ancho, String color) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        contador++;
    }

    public void cantidadArboles(){
        System.out.println(contador);
    }

}
