
    public class Endereco {
        public String rua;
        public String cidade;
        public String cep;

        public Endereco(String rua, String cidade, String cep) {
            this.rua = rua;
            this.cidade = cidade;
            this.cep = cep;
        }
        public String toString(){
            return "Rua: " + rua + " Cidade: " + cidade + " CEP: " + cep;
        }
    }


