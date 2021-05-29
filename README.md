# Motoca Infantil
![motoca](public/figura.jpg)


- [Requisitos](#requisitos)
- [Ajuda](#ajuda)
- [Diagrama](#diagrama)
- [Exemplo de execução](#exemplo-de-execução)
- [Relatório de Entrega](#relatório-de-entrega)


## Requisitos

- Você deverá implementar a classe `Pessoa` e a class `Moto`.
- Iniciar
    - A moto inicia com com uma potência inteira, sem minutos e sem ninguém.
- Subir
    - Só pode estar uma pessoa na moto por vez. Para subir, informe nome e idade de quem está subindo.
- Descer
    - Só pode descer se tiver alguém na moto.
- Comprar tempo
    - O tempo em minutos é comprado e enquanto houver tempo, qualquer pessoa pode dirigir.
- Dirigir tempo
    - Se houver uma pessoa com 10 anos ou menos e houver minutos, então ela pode passear de moto.
    - Se o tempo acabar no meio do passeio, informe o quanto a pessoa andou.
- Buzinar
    - Qualquer pessoa pode buzinar(honk)
    - O barulho da buzina é "Pem", porém o número de `e` é igual ao valor da potência.
    - Ex: se a potência for 5, buzinar deve gerar: Peeeeem

## Ajuda

- Lembre de inicializar o objeto `Pessoa` antes de chamar o método embarcar.
- Para buzinar, utilize o `for` gerando várias vezes o `e`. 


## Diagrama

## Exemplo de execução 
```java
public class Runner {
    
    public static void main(String[] args) {
        
        //Inicializando a motocicleta
        Motoca motocileta = new Motoca(5);
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = null}

        //Embarcando na motocicleta;
        motocileta.in(new Pessoa("João", 5));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [João:5]}

        if(motocileta.in(new Pessoa("Maria", 6)) == false){
            System.out.println("fail: moto ocupada"); //fail: moto ocupada
        }

        //Embarcando e buzinando
        motocileta = new Motoca(5);
        motocileta.in(new Pessoa("Ana", 4));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [Ana:4]}
        motocileta.honk(); // "Peeeeem";

        //Embarcando e desembarcando na motocicleta
        motocileta = new Motoca(5);
        motocileta.in(new Pessoa("Heitor", 3));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [Heitor:3]}
        motocileta.out();
        if(motocileta.out() == false){
            System.out.println("fail: moto desocupada"); //fail: moto desocupada
        }
        motocileta.in(new Pessoa("Alice", 8));
        System.out.println(motocileta); // Motocicleta{Potencia = 5, Tempo = 0,  Pessoa = [Alice:8]}

        //Passeando na motocicleta
        motocileta = new Motoca(7);
        motocileta.in(new Pessoa("Biatriz", 6));
        if(motocileta.drive(10) == false){
            System.out.println("fail: tempo zerado"); //fail: tempo zerado
        }
        motocileta.buyTime(40);
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 40,  Pessoa = [Biatriz:6]}
        motocileta.drive(20);
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 40,  Pessoa = [Biatriz:6]}

        //Passeando na motocicleta sem idade recomendada
        motocileta = new Motoca(7);
        motocileta.in(new Pessoa("Edu", 15));
        motocileta.buyTime(20);
        if(motocileta.drive(15) == false){
            System.out.println("fail: a pessoa está fora da idade recomanda para andar.");
        }
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 20,  Pessoa = [Edu:15]}

        //Passeando com tempo esgotado
        motocileta = new Motoca(7);
        motocileta.in(new Pessoa("Gustavo", 9));
        motocileta.buyTime(20);
        motocileta.drive(15);
        System.out.println(motocileta); // Motocicleta{Potencia = 7, Tempo = 5,  Pessoa = [Gustavo:9]}
        motocileta.drive(10); //warning: andou 5 min e acabou o tempo
    }
}
```
## Relatório de Entrega
Não esqueça de preencher o seguinte formulário [Link para formulário](https://forms.gle/kAHZonXVL4CfKwpA6) ao completar a atividade.
