/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.comunicator;

import java.io.IOException;
import javax.ejb.Local;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;

/**
 * Interface local para a classe comunicadora
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface ComunicatorBankCardBrandServiceLocal
{

   /**
    * Valida transacao com terceiro
    * 
    * @param resquest
    * @return
    * @throws IOException
    */
   TransactionResponse validate(TransactionDTORequest resquest) throws IOException;

}
