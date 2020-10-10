package webservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import mobileCodeWS.MobileCodeWSSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Cilent {

    public static void main(String[] args) throws MalformedURLException {

//        WebServiceDemoService_Service service = new WebServiceDemoService_Service();
//
//        WebServiceDemoService webServiceDemoService = service.getWebServiceDemoServiceImplPort();
//
//        String result = webServiceDemoService.hello("zhw1111");
//        System.out.println(result);


//
//        //创建WSDL文件的URL
//        URL wsdlDocumentLocation=new URL("http://localhost:8080/webservice/webservice?wsdl");
//        //创建服务名称
//        //1.namespaceURI - 命名空间地址
//        //2.localPart - 服务视图名
//        QName serviceName=new QName("http://WebXml.com.cn/","MobileCodeWS");
//        Service service=Service.create(wsdlDocumentLocation, serviceName);
//
//        //获取服务实现类
//        WebServiceDemoService demoService= service.getPort(WebServiceDemoService.class);
//        //调用方法
//        String message=demoService.hello("zhw");
//        System.out.println(message);


        //创建WSDL文件的URL
        URL wsdlDocumentLocation = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
        //创建服务名称
        //1.namespaceURI - 命名空间地址
        //2.localPart - 服务视图名
        QName serviceName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
        Service service = Service.create(wsdlDocumentLocation, serviceName);

        //获取服务实现类
        MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
        //调用方法
        String message = mobileCodeWSSoap.getMobileCodeInfo("18779147214", null);
        System.out.println(message);

    }
}
