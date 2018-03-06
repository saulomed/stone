/*
* Criação : 3 de mar de 2018
*/

package br.com.stone.autorizador;

import java.net.MalformedURLException;
import java.net.URL;
import javax.ejb.Singleton;
import br.com.stone.autorizador.transaction.wsclient.AutorizadorService;
import br.com.stone.autorizador.transaction.wsclient.AutorizadorServiceService;

/**
 * Classe responsavel pela comunicacao com o webservice
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
@Singleton
public class Comunicator
{

   public AutorizadorService getPort() throws MalformedURLException
   {

      AutorizadorServiceService proxy =
         new AutorizadorServiceService(new URL("http://127.0.0.1:8080/servidor-1.0.0-SNAPSHOT/AutorizadorService?wsdl"));
      return proxy.getAutorizadorServicePort();
   }

}
