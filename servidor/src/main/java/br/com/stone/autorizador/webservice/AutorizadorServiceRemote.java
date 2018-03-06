/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.webservice;

import java.io.IOException;
import javax.ejb.Remote;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesResposta;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesSolicitacao;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;

/**
 * Interface Remota para o webservice
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Remote
public interface AutorizadorServiceRemote
{

   /**
    * Realiza consulta de transacoes, podendo considerar a data de referencia da transacao
    * 
    * @param solicitacao
    * @return
    */
   ConsultaTransacoesResposta consultaTransacoes(ConsultaTransacoesSolicitacao solicitacao);

   /**
    * Relaiza requisicao de transacao
    * 
    * @param request
    * @return
    * @throws IOException
    */
   TransactionResponse transactionRequest(TransactionDTORequest request) throws IOException;

}
