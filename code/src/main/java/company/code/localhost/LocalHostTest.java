package company.code.localhost;

import org.apache.commons.lang3.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

public class LocalHostTest {


    public static void main(String[] args){

        String a = getLocalAddressHost();
        InetAddress inetAddress = null;
        InetAddress[] inetAddresses = null;

        try {
             inetAddress = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inetAddress);
        System.out.println(a);
        String b = getIDC();
    }
    private static String getLocalAddressHost() {
        ArrayList hostNames = new ArrayList();

        try {
            Enumeration ifaces = NetworkInterface.getNetworkInterfaces();

            while(ifaces.hasMoreElements()) {
                NetworkInterface iface = (NetworkInterface)ifaces.nextElement();
                Enumeration addresses = iface.getInetAddresses();

                while(addresses.hasMoreElements()) {
                    InetAddress addr = (InetAddress)addresses.nextElement();
                    if (addr instanceof Inet4Address && !addr.isLoopbackAddress() && StringUtils.isNotEmpty(addr.getHostName()) && !"localhost".equals(addr.getHostName().toLowerCase().trim())) {
                        hostNames.add(addr.getHostName());
                    }
                }
            }
        } catch (Exception var5) {

        }

        String host = null;
        if (!hostNames.isEmpty()) {
            host = (String)hostNames.get(0);

            for(int i = 1; i < hostNames.size(); ++i) {
                if (((String)hostNames.get(i)).toLowerCase().contains(".diditaxi.com")) {
                    host = (String)hostNames.get(i);
                    break;
                }
            }
        }

        return host;
    }

    public static String getIDC() {
        try {
            String host = getLocalAddressHost();

            if (StringUtils.isEmpty(host)) {
                return null;
            } else {
                String[] arr = host.split("\\.");
                if (arr == null) {
                    return null;
                } else if (!host.contains(".diditaxi.com")) {
                    return arr[arr.length - 1];
                } else {
                    return arr.length < 4 ? null : arr[arr.length - 3];
                }
            }
        } catch (Exception var2) {

            return null;
        }
    }
}
