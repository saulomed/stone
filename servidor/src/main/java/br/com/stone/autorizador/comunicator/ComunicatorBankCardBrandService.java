/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.comunicator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.apache.commons.lang3.math.NumberUtils;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;
import br.com.stone.autorizador.webservice.enums.ResponseCode;

/**
 * Classe comunicadora
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(ComunicatorBankCardBrandServiceLocal.class)
public class ComunicatorBankCardBrandService implements ComunicatorBankCardBrandServiceLocal
{

   private static final String CARD_CATALOG = "config/CardCatalog.properties";
   Properties prop = new Properties();
   InputStream input = null;

   public TransactionResponse validate(TransactionDTORequest resquest) throws IOException
   {
      TransactionResponse response = createResponse(resquest, getResponse(resquest));

      return response;
      
   }

   private ResponseCode getResponse(TransactionDTORequest resquest) throws IOException
   {
      loadCatalog();
      Integer codeResponse = NumberUtils.createInteger(prop.getProperty(resquest.getCardNumber()));
      return ResponseCode.get(codeResponse);
   }

   private void loadCatalog() throws IOException
   {
      input = getClass().getClassLoader().getResourceAsStream(CARD_CATALOG);// new FileInputStream(CARD_CATALOG);
      prop.load(input);

   }

   /**
    * Cria resposta com o codido de resposta passado por parametro
    * 
    * @param request
    * @param valorInvalido
    */
   protected TransactionResponse createResponse(TransactionDTORequest request, ResponseCode responseCode)
   {
      TransactionResponse response = new TransactionResponse();
      response.setCardNumber(request.getCardNumber());
      response.setMerchantId(request.getMerchantId());
      response.setAmount(request.getAmount());
      response.setPassword(request.getPassword());
      response.setTransactionType(request.getTransactionType());
      response.setParcelNumber(request.getParcelNumber());
      response.setReponseCode(responseCode.ordinal());
      return response;
   }

}
