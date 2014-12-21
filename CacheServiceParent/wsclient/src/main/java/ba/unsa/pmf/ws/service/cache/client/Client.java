package ba.unsa.pmf.ws.service.cache.client;

import com.unsa.pmf.ws.service.cache.impl.CacheServiceImplService;
import com.unsa.pmf.ws.service.cache.impl.Exception;

public class Client {

	public static void main(String[] args) throws Exception {
		CacheServiceImplService service = new CacheServiceImplService();
		System.out.println(service.getCacheServiceImplPort().getCacheServiceSession("df").getSessionId());;
	}
}
