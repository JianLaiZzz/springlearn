package webservice;

public class Cilent {

    public static void main(String[] args) {


        IpAddressSearchWebService searchWebServiceSoap = new IpAddressSearchWebService();
        IpAddressSearchWebServiceHttpGet get=searchWebServiceSoap.getIpAddressSearchWebServiceHttpGet();

        String s=get.getVersionTime();

        System.out.println(s);


    }
}
