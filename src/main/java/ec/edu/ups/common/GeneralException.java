package ec.edu.ups.common;

public class GeneralException extends Exception {

    private int codigo;

    public GeneralException(String mensaje){
        super(mensaje);
    }

    public GeneralException(int codigo, String mensaje){
        super(mensaje);
        this.codigo = codigo;
    }
}
