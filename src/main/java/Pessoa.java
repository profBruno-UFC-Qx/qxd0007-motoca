public class Pessoa {
    
    public int idade;
    public String nome;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "[" 
                + this.nome
                + ":" 
                + this.idade
                + "]";
    }
}
