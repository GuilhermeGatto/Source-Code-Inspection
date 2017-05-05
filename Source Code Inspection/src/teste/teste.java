/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;
import br.calebe.ticketmachine.core.*;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
/**
 *
 * @author guilhermegatto
 */
public class teste {
    
    public static void main(String[] args) throws PapelMoedaInvalidaException, SaldoInsuficienteException {
       
        
        TicketMachine tm = new TicketMachine(2);
        
        System.out.println(tm.getSaldo());
        
        tm.inserir(20);
        
        System.out.println(tm.getSaldo());
        
        System.out.println(tm.imprimir());
        
        System.out.println(tm.getSaldo());

        
        
    }
    
}
