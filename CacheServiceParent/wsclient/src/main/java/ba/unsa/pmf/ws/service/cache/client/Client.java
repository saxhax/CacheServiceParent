package ba.unsa.pmf.ws.service.cache.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unsa.pmf.ws.service.cache.Configurations;
import com.unsa.pmf.ws.service.cache.Filter;
import com.unsa.pmf.ws.service.cache.Row;
import com.unsa.pmf.ws.service.cache.Session;
import com.unsa.pmf.ws.service.cache.Field;
import com.unsa.pmf.ws.service.cache.impl.CacheServiceImplService;
import com.unsa.pmf.ws.service.cache.impl.Exception;

public class Client extends Filter{

	public static void main(String[] args) throws Exception {
		CacheServiceImplService service = new CacheServiceImplService();
		
		Session session = service.getCacheServiceImplPort().getCacheServiceSession("soap");
		
		for (int i = 0; i < 7000; i++){
			ArrayList<Field> values = new ArrayList<Field>(); 
			Field set = new Field();
			set.setKey("key");
			set.setValue("value" + i);
			values.add(set);
			service.getCacheServiceImplPort().putValues(session, values);
		}
		ArrayList<Field> values = new ArrayList<Field>(); 
		Field set = new Field();
		set.setKey("key");
		set.setValue("value55");
		values.add(set);
		Client filter = new Client();
		filter.findFields = values;
		Date date = new Date();
		System.out.println(date);
		List<Row> list = service.getCacheServiceImplPort().getValues(session, filter).getFoundRows(); 
		for (Row row : list) {
			for (Field setOfData : row.getFields()){
				System.out.print(setOfData.getKey() + ", " + setOfData.getValue());
			}
			System.out.println();
		}
		System.out.println(new Date());
		System.out.println(System.currentTimeMillis() - date.getTime());
	}
}
