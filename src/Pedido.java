public class Pedido {

    Cliente cliente;

    public String pedido;

    public boolean encerrado;

    public Pedido(Cliente cliente, String pedido) {
        this.cliente = cliente;
        this.pedido = pedido;
        this.encerrado = false;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getPedido() {
        return pedido;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
