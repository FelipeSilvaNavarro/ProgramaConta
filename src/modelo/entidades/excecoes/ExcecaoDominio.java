package modelo.entidades.excecoes;

public class ExcecaoDominio extends RuntimeException {
    /**
     * @param mensagem <p>Construtor para receber a mensagem da excecao</p>
     */
    public ExcecaoDominio(String mensagem) {
        super(mensagem);
    }
}
