package ba.unsa.pmf.ws.service.cache.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unsa.pmf.ws.service.cache.Configurations;
import com.unsa.pmf.ws.service.cache.Filter;
import com.unsa.pmf.ws.service.cache.Row;
import com.unsa.pmf.ws.service.cache.Session;
import com.unsa.pmf.ws.service.cache.impl.CacheServiceImplService;
import com.unsa.pmf.ws.service.cache.impl.Exception;

public class Client {

	public static void main(String[] args) throws Exception {
		CacheServiceImplService service = new CacheServiceImplService();
		
		Configurations configuration = new Configurations();
		configuration.setName("simpleName");
		
		Session session = service.getCacheServiceImplPort().createCacheService(configuration);
		
		for (int i = 0; i < 70; i++){
			List<String> values = new ArrayList<String>();
			values.add("first" + i);
			values.add("second" + i);
			service.getCacheServiceImplPort().putValues(session, values);
		}
		ArrayList<String> values = new ArrayList<String>();
		values.add("first5");
		Filter filter = new Filter();
		filter.setSpecificData(values);
		Date date = new Date();
		System.out.println(date);
		List<Row> list = service.getCacheServiceImplPort().getValues(session, filter).getSpecificValues(); 
		for (Row row : list) {
			for (String string : row.getRowValues()){
				System.out.print(string + ", ");
			}
			System.out.println();
		}
		System.out.println(new Date());
		System.out.println(System.currentTimeMillis() - date.getTime());
	}
}
