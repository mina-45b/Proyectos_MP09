package BanyMixto;

public class Persona extends Thread {
    public enum SEXO {
        CHICO, CHICA;
    }
    SEXO sexo;
    Bany bany;

    public Persona(String nombre, SEXO sexo, Bany bany) {
        super(nombre);
        this.sexo = sexo;
        this.bany = bany;
    }

    @Override
    public void run() {
        for (;;){
            irBany();
        }
    }

    private void irBany() {
            bany.entrar(this);
        try {
            Thread.sleep((long) (Math.random() * 250) + 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        bany.salir(this);

        try {
            Thread.sleep((long) (Math.random() * 700) + 250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
    }
}
