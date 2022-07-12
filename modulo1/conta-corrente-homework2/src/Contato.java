public class Contato {
    //atributos do contato
    private String descricao;
    private String telefone;
    private int tipo; //1 - residencial, 2 - comercial


    //construtor do contato
    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }


    //métodos do contato

    //método imprime contato
    void imprimirContato(){
        System.out.println(toString());
    }

    //getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    //toString
    @Override
    public String toString() {
        return "Contato{" +
                "descricao: " + descricao + '\'' +
                ", telefone: " + telefone + '\'' +
                ", tipo (1-residencial ou 2-comercial): " + tipo +
                '}';
    }
}