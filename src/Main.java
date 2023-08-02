import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> cliente = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        int opc;

        do{
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Realizar um pedido");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Encerrar pedidos");
            System.out.println("5 - Pedidos");
            System.out.println("0 - Encerrar");
            opc = scanner.nextInt();
            switch (opc){

                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.next();
                    System.out.println("Telefone: ");
                    String telefone = scanner.next();
                    System.out.println("Endereço: ");
                    String endereco = scanner.next();
                    cliente.add(new Cliente(nome, telefone, endereco));
                    break;
                case 2:
                    System.out.println("Deseja cadastrar um pedido? 1 - Sim/ 2 - Não");
                    int op = scanner.nextInt();
                    if(op != 1){
                        break;
                    }else{
                        System.out.println("Nome do pedido: ");
                        String pedido = scanner.next();
                        System.out.println("Para qual cliente deseja vincular o produto?");
                        String nomeCliente = scanner.next();
                        for(int i = 0; i < cliente.size(); i++){
                            if(cliente.get(i).getNome().equals(nomeCliente)){
                                pedidos.add(new Pedido(cliente.get(i), pedido));
                                System.out.println("Pedido: " + pedido + "\nAdcionado ao cliente: " + nomeCliente);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Qual cliente deseja ver?");
                    String nomeCliente2 = scanner.next();
                    for(Cliente clientes: cliente){
                        if(clientes.getNome().equals(nomeCliente2)){
                            clientes.imprimirClientes();
                            for (Pedido pedido : pedidos) {
                                if (pedido.getCliente().getNome().equals(nomeCliente2)) {
                                    System.out.println("Pedido associado: " + pedido.getPedido());
                                }
                            }
                        }else{
                            System.out.println("Cliente não encontrado!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Qual cliente deseja encerrar o pedido?");
                    String encerrarNome = scanner.next();
                    for (Pedido pedido : pedidos) {
                        if (pedido.getCliente().getNome().equals(encerrarNome)) {
                            System.out.println("Cliente encontrado: " + pedido.getCliente().getNome());
                            System.out.println("Deseja encerrar pedido do cliente? 1 - Sim/ 2 - Não");
                            int encerrarPedido = scanner.nextInt();
                            if (encerrarPedido == 1) {
                                pedido.setEncerrado(true); // Atualiza o status do pedido para encerrado
                                System.out.println("Cliente com pedido encerrado!");

                                try {
                                    String recibo = "Entrega_" + pedido.getCliente().getNome() + ".txt";
                                    FileWriter writer = new FileWriter(recibo);
                                    writer.write("Nome do cliente: " + pedido.getCliente().getNome() + "\n");
                                    writer.write("Endereço de entrega: " + pedido.getCliente().getEndereco() + "\n");
                                    writer.close();
                                    System.out.println("Arquivo de entrega criado: " + recibo);
                                } catch (IOException e) {
                                    System.out.println("Erro ao criar o arquivo de entrega.");
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    int emAndamento = 0;
                    int encerrados = 0;
                    for (Pedido pedido : pedidos) {
                        System.out.println("Pedido: " + pedido.getPedido());
                        if (pedido.isEncerrado()) {
                            System.out.println("Status: Encerrado");
                            encerrados++;
                        } else {
                            System.out.println("Status: Em andamento");
                            emAndamento++;
                        }
                        System.out.println("Cliente: " + pedido.getCliente().getNome());
                        System.out.println("------------------------");
                    }
                    System.out.println("Total de pedidos em andamento: " + emAndamento);
                    System.out.println("Total de pedidos encerrados: " + encerrados);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opc != 0);
    }
}
