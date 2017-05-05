package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            /* 
            alteração do valor 1 anteriormente colocado no indice do array pelo valor i,
            permitindo assim que todas as posições do array seja percorrida
            
            codigo antigo: papelMoeda[1] == quantia
            codigo atual: papelMoeda[i] == quantia
            */
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        return null;
    }

    /*
        Nesse método foi encontrado o erro no qual não era debitado do saldo do cliente
    o valor do ticket, assim fazendo com que o cliente possa imprimir quantos bilhetes 
    desejar basntando colocar apenas uma nota que contemple o valor do bilhete.
    
    para consertar o metodo foi acrescentado a linha de codigo abaixo: 
    
    saldo -= valor;
    
    */
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        saldo -= valor;
        
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
