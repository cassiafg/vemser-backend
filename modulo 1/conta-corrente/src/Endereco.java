public class Endereco {
    //atributos do endereço
    int tipo; //1-residencial, 2-comercial
    int numero;
    String logradouro, complemento, cep, cidade, estado, pais;

    //metodos do endereço
    //método imprime endereço
    void imprimirEndereco(){
        System.out.println("----------Endereço----------");
        System.out.println(logradouro+", n."+numero+", compl. "+complemento);
        System.out.println("CEP "+cep+" Cidade: "+cidade+" - "+estado+", "+pais);
        System.out.println("Tipo: (1-residencial ou 2-comercial): "+tipo);
    }

    //método toString
    public String toString(){
        return logradouro+", "+numero+" - "+cidade;
    }
}
