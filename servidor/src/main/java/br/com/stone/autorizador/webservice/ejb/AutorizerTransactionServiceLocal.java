/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.webservice.ejb;

import java.io.IOException;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;

/**
 * Inteface local responsavel pela autorizacao de uma trasacao
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public interface AutorizerTransactionServiceLocal
{

   TransactionResponse execute(TransactionDTORequest request) throws IOException;

}
