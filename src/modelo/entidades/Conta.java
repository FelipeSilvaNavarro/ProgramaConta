package modelo.entidades;

import modelo.entidades.excecoes.ExcecaoDominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta {
    private Integer numero;
    private String dono;
    private Double saldo;
    private Double saqueLimite;

    private Date data;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Conta() {
    }

    public Conta(Integer numero, String dono, Date data, Double saldo, Double saqueLimite) {
        if (data.after(new Date())) {
            throw new ExcecaoDominio("A data de criação da conta não pode ser uma data futura");
        }
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.saqueLimite = saqueLimite;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaqueLimite() {
        return saqueLimite;
    }

    public void setSaqueLimite(Double saqueLimite) {
        this.saqueLimite = saqueLimite;
    }

    /**
     * @param valorDeposito
     * @throws ExcecaoDominio
     * <p>Adiciona o valor passado como parametro na variavel <b>saldo</b></p>
     */
    public void deposito(Double valorDeposito) throws ExcecaoDominio {
        saldo += valorDeposito;
    }

    /**
     * @param valorSaque
     * @throws ExcecaoDominio
     * <p>Retira o valor passado como paramentro na variavel <b>saldo</b></p>
     * <p>REGRAS: </p>
     * <p> - Um saque não pode ocorrer se não houver saldo na conta
     * <p> - Se o valor do saque for superior ao limite de saque da conta </p>
     */
    public void saque(Double valorSaque) throws ExcecaoDominio {
        if (valorSaque > saldo) {
            throw new ExcecaoDominio("Saldo insuficiente!");
        }
        if (valorSaque > saqueLimite) {
            throw new ExcecaoDominio("O valor excede o limite de saque");
        } else {
            saldo -= valorSaque;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numero);
        sb.append(", ");
        sb.append(dono);
        sb.append(", Novo saldo: ");
        sb.append(saldo);


        return sb.toString();
    }
}
