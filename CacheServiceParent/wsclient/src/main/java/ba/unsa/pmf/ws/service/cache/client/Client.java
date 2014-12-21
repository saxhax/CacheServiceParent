package ba.unsa.pmf.ws.service.cache.client;

import com.unsa.pmf.ws.service.cache.Configurations;
import com.unsa.pmf.ws.service.cache.impl.CacheServiceImplService;
import com.unsa.pmf.ws.service.cache.impl.Exception;

public class Client {

	public static void main(String[] args) throws Exception {
		CacheServiceImplService service = new CacheServiceImplService();
		Configurations configuration = new Configurations();
		configuration.setName("name3");
		configuration.setNumberOfFields(5);
		System.out.println(service.getCacheServiceImplPort().createCacheService(configuration).getSessionId());;
	}
}
