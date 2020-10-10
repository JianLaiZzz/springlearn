package webservice;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Cilent {

    public static void main(String[] args) {

        WebServiceDemoService_Service service = new WebServiceDemoService_Service();

        WebServiceDemoService webServiceDemoService = service.getWebServiceDemoServiceImplPort();

        String result = webServiceDemoService.hello("zhw1111");
        System.out.println(result);

    }
}
