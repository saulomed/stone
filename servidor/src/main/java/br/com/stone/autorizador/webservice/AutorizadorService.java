/*
* Criação : 12 de fev de 2018
*/
package br.com.stone.autorizador.webservice;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesResposta;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesSolicitacao;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;
import br.com.stone.autorizador.webservice.ejb.AutorizerTransactionServiceLocal;
import br.com.stone.autorizador.webservice.ejb.ConsultaTransacoesServiceLocal;

/**
 * WebService para autorização de transações
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@WebService
@Stateless
@Local(AutorizadorServiceLocal.class)
@Remote(AutorizadorServiceRemote.class)
@XmlSeeAlso({
   ConsultaTransacoesSolicitacao.class,
   ConsultaTransacoesResposta.class

})
public class AutorizadorService implements Serializable, AutorizadorServiceRemote, AutorizadorServiceLocal
{

   @EJB
   private ConsultaTransacoesServiceLocal consultaTransacoesService;

   @EJB
   private AutorizerTransactionServiceLocal autorizerService;

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = -130192946510977681L;

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.webservice.AutorizadorServiceRemote#consultaTransacoes(br.com.stone.autorizador.webservice.dto.ConsultaTransacoesSolicitacao)
    */
   @WebMethod
   public ConsultaTransacoesResposta consultaTransacoes(ConsultaTransacoesSolicitacao solicitacao)
   {

      return consultaTransacoesService.execute(solicitacao);
   }


   public TransactionResponse transactionRequest(TransactionDTORequest request) throws IOException
   {
      return autorizerService.execute(request);
   }
}
