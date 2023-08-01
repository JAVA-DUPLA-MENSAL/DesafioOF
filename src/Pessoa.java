


    public class Pessoa {

        public String nome;
        public int idade;

        public Endereco[] enderecos;

        public Pessoa(String nome, int idade, Endereco[] enderecos) {
            this.nome = nome;
            this.idade = idade;
            this.enderecos = enderecos;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public Endereco[] getEnderecos() {
            return enderecos;
        }

        public void setEnderecos(Endereco[] enderecos) {
            this.enderecos = enderecos;
        }

        public void imprimirDados(){
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Endereços: ");
            for(Endereco endereco: enderecos){
                System.out.println(endereco);
            }
            System.out.println("-----------------------------------");
        }
    }


