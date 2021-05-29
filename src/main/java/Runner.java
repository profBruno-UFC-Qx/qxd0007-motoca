public class Runner {
    
    public static void main(String[] args) {
        
        //Inicializando a motocicleta
        Motoca motocileta = new Motoca(5);
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = null}

        //Embarcando na motocicleta;
        motocileta.subir(new Pessoa("João", 5));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [João:5]}

        if(motocileta.subir(new Pessoa("Maria", 6)) == false){
            System.out.println("fail: moto ocupada"); //fail: moto ocupada
        }

        //Embarcando e buzinando
        motocileta = new Motoca(5);
        motocileta.subir(new Pessoa("Ana", 4));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [Ana:4]}
        System.out.println(motocileta.buzinar()); // "Peeeeem";

        //Embarcando e desembarcando na motocicleta
        motocileta = new Motoca(5);
        motocileta.subir(new Pessoa("Heitor", 3));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [Heitor:3]}
        motocileta.descer();
        if(motocileta.descer() == false){
            System.out.println("fail: moto desocupada"); //fail: moto desocupada
        }
        motocileta.subir(new Pessoa("Alice", 8));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [Alice:8]}

        //Passeando na motocicleta
        motocileta = new Motoca(7);
        motocileta.subir(new Pessoa("Biatriz", 6));
        if(motocileta.dirigir(10) == false){
            System.out.println("fail: tempo zerado"); //fail: tempo zerado
        }
        motocileta.colocarTempo(40);
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 40,  Pessoa = [Biatriz:6]}
        motocileta.dirigir(20);
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 40,  Pessoa = [Biatriz:6]}

        //Passeando na motocicleta sem idade recomendada
        motocileta = new Motoca(7);
        motocileta.subir(new Pessoa("Edu", 15));
        motocileta.colocarTempo(20);
        if(motocileta.dirigir(15) == false){
            System.out.println("fail: a pessoa está fora da idade recomanda para andar.");
        }
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 20,  Pessoa = [Edu:15]}

        //Passeando com tempo esgotado
        motocileta = new Motoca(7);
        motocileta.subir(new Pessoa("Gustavo", 9));
        motocileta.colocarTempo(20);
        motocileta.dirigir(15);
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 5,  Pessoa = [Gustavo:9]}
        motocileta.dirigir(10); //warning: andou 5 min e acabou o tempo
    }
}
