import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMotoca {
    
    @Test
    public void testInicializacao(){
        Motoca motoca = new Motoca(5);
        assertNull(motoca.getPessoa(),
            "Ao criar uma motocicleta ela deve vir sem nenhuma pessoa [null].");
        assertEquals(0, motoca.getTempo(),
            "Ao criar uma motocicleta ela deve vir com tempo 0.");
        assertEquals(5, motoca.getPotencia(),
            "Ao criar uma motocicleta ela deve vir com a potência exata ao que foi passado na inicialização");
    }

    @Test
    public void testSubida(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa("João", 5);
        assertTrue(motoca.subir(pessoa),
            "Se não haver nenhuma pessoa na motocicleta, então era poderá embarcar.");   
    }

    @Test
    public void testSubidaMotocaCheia(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa("João", 5);
        motoca.subir(pessoa);
        assertFalse(motoca.subir(new Pessoa("Maria", 3)),
            "Não deve ser possível uma pessoa embarca se já tiver alguém embarcado.");
    }

    @Test
    public void testDescerMotocaVazia(){
        Motoca motoca = new Motoca(5);
        assertFalse(motoca.descer(),
            "Não deve ser possível desembarcar se não houver ninguem na motocicleta.");
    }

    @Test
    public void testDescerDaMotoca(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa("Laura", 8);
        motoca.subir(pessoa);
        assertTrue(motoca.descer(),
            "Deve ser possível desembarcar se houver uma pessoa na motocicleta");
    }

    @Test
    public void testDirgirSemPiloto(){
        Motoca motoca = new Motoca(5);
        assertFalse(motoca.dirigir(5),
            "Não deve ser possível dirigir se não houver ninguem na motocicleta.");
    }

    @Test
    public void testDirigirSemTempo(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa( "Davi", 3);
        motoca.subir(pessoa);
        assertFalse(motoca.dirigir(5),
            "Não deve ser possível dirigir se não houver comprado tempo.");
    }

    @Test
    public void testDirigirSemPermissao(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa("João", 11);
        motoca.subir(pessoa);
        motoca.colocarTempo(10);
        assertFalse(motoca.dirigir(5),
            "Não deve ser possível dirigir se não tiver a idade recomendada.");
    }

    @Test
    public void testDirgirComTempoSobrando(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa("Leo", 7);
        motoca.subir(pessoa);
        motoca.colocarTempo(20);
        assertTrue(motoca.dirigir(10),
            "Ao comprar tempo deve ser possível dirigir na motocicleta");
        assertEquals(10, motoca.getTempo(),
            "Ao dirigir por um determinado tempo menor ao comprado deve restar a quantidade exata não usada.");
    }

    @Test
    public void testDirigirAteAcabarTempo(){
        Motoca motoca = new Motoca(5);
        Pessoa pessoa = new Pessoa("João", 5);
        motoca.subir(pessoa);
        motoca.colocarTempo(20);
        motoca.dirigir(25);
        assertEquals(0, motoca.getTempo(),
            "Não deve ser possível andar mais do que o tempo comprado.");
    }

    @Test
    public void testBuzinar(){
        Motoca motoca = new Motoca(5);
        assertEquals("", motoca.buzinar(),
            "Não deve ser possível buzinar se não houver ninguem na motocicleta.");
        Pessoa pessoa = new Pessoa("Pedro", 5);
        motoca.subir(pessoa);
        assertEquals("Peeeeem", motoca.buzinar(),
            "Ao buzinar deve ser possível ver uma string com a quantidade de e equivalente ao número da potencia");
    }
}
