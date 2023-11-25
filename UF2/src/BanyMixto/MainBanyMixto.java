package BanyMixto;

public class MainBanyMixto {
    public static void main(String[] args) {

        Bany bany = new Bany(3);
        Persona persona1 = new Persona("Juana", Persona.SEXO.CHICA, bany);
        Persona persona2 = new Persona("Rafael", Persona.SEXO.CHICO, bany);
        Persona persona3 = new Persona("Andrea", Persona.SEXO.CHICA, bany);
        Persona persona4 = new Persona("Maria", Persona.SEXO.CHICA, bany);
        Persona persona5 = new Persona("Jorge", Persona.SEXO.CHICO, bany);
        Persona persona6 = new Persona("Roberto", Persona.SEXO.CHICO, bany);

        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
        persona5.start();
        persona6.start();
    }


}
