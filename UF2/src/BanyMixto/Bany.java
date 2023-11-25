package BanyMixto;

public class Bany {
    private final int cubiculos;
    private int cubiculosOcupados;

    private Persona.SEXO sexoPersonaDentro;

    public Bany(int nCubilos) {
        this.cubiculos = nCubilos;
        cubiculosOcupados = 0;
        sexoPersonaDentro = Persona.SEXO.CHICA;
    }

    public synchronized void entrar(Persona persona) {

        try {
            while (cubiculosOcupados == cubiculos  || !sexoPersonaDentro.equals(persona.sexo)) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(persona.getName() + " esta en el baño");
        cubiculosOcupados += 1;
        sexoPersonaDentro = persona.sexo;
        notifyAll();
    }

    public synchronized void salir(Persona persona) {
        cubiculosOcupados--;
        if (cubiculosOcupados == 0) {
            if (persona.sexo.equals(Persona.SEXO.CHICA)) {
                sexoPersonaDentro = Persona.SEXO.CHICO;
            } else if (persona.sexo.equals(Persona.SEXO.CHICO)) {
                sexoPersonaDentro = Persona.SEXO.CHICA;
            }
        }
        System.out.println(persona.getName() + " ha salido del baño");
        notifyAll(); //porque modifico variables
    }
}
