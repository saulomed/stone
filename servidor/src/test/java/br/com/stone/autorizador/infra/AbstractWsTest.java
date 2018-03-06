/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.infra;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.Assert;
import br.com.stone.autorizador.webservice.AutorizadorServiceLocal;
import br.com.stone.autorizador.wsclient.AutorizadorService;

/**
 * Classe abstrata para testes do webservice
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class AbstractWsTest extends AbstractTest
{

   protected AutorizadorService getPort() throws MalformedURLException
   {
      URL url = new URL("http://127.0.0.1:8080/servidor-1.0.0-SNAPSHOT/AutorizadorService?wsdl");
      QName qName = new QName("http://superbiz.org/wsdl", "CalculatorWsService");
      Service service = Service.create(url, qName);
      Assert.assertNotNull(service);
      return (AutorizadorService) service.getPort(AutorizadorServiceLocal.class);

      // AutorizadorServiceService proxy =
      // new AutorizadorServiceService(new URL("http://localhost:4204/AutorizadorService?wsdl"));
      // return proxy.getAutorizadorServicePort();
   }
}
