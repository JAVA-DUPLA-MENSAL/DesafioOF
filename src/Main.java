import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                List<Pessoa> pessoas = new ArrayList<>();

                System.out.println("Qunatas pessoas você quer cadastrar?");
                int numPessoas = scanner.nextInt();

                for(int i = 0; i < numPessoas; i++){
                    System.out.println("Nome: ");
                    String nome = scanner.next();
                    System.out.println("Idade: ");
                    int idade = scanner.nextInt();

                    System.out.println("Quantos endereços essa pessoa tem?");
                    int numEnd = scanner.nextInt();

                    Endereco[] enderecos = new Endereco[numEnd];
                    for (int j = 0; j < numEnd; j++){
                        System.out.println("Rua: ");
                        String rua = scanner.next();
                        System.out.println("Cidade: ");
                        String cidade = scanner.next();
                        System.out.println("CEP: ");
                        String cep = scanner.next();
                        enderecos[j] = new Endereco(rua, cidade, cep);
                    }
                    pessoas.add(new Pessoa(nome, idade, enderecos));
                }
                System.out.print("Digite o nome da pessoa que deseja buscar: ");
                String nomeBusca = scanner.nextLine();

                for (Pessoa pessoa : pessoas) {
                    if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
                        pessoa.imprimirDados();
                        break;
                    }
                }

            }
}
