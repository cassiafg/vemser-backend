public class Contato {
    //atributos do contato
    String descricao;
    String telefone;
    int tipo; //1 - residencial, 2 - comercial

    //métodos do contato
    //método imprime contato
    void imprimirContato(){
        System.out.println("----------Contato----------");
        System.out.println("Descrição: "+descricao);
        System.out.println("Telefone: "+telefone);
        System.out.println("Tipo(1-residencial ou 2-comercial: "+tipo);
    }

    //método toString
    public String toString(){
        return telefone;
    }
}
