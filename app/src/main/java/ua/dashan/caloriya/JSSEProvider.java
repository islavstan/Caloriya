package ua.dashan.caloriya;

import java.security.AccessController;
import java.security.Provider;


public final class JSSEProvider extends Provider {

    public JSSEProvider() {

//конструктор providerс указанным именем, номером версии и информацией
        super("HarmonyJSSE", 1.0, "Harmony JSSE Provider");
//Класс AccessController используется для операций контроля доступа и решения
// использовать метод doPrivileged, который принимает контекст
        AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {
            public Void run() {
                put("SSLContext.TLS", "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
                put("Alg.Alias.SSLContext.TLSv1", "TLS");
                put("KeyManagerFactory.X509", "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
                put("TrustManagerFactory.X509", "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");
                return null;
            }
        });
    }
}
