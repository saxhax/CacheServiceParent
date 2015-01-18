package com.unsa.pmf.ws.service.cache.statistic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Condition;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.service.cache.exception.ParameterNotValidException;
import com.unsa.pmf.ws.service.cache.impl.CacheServiceImpl;

public class Statistic {

	public StatisticResponse createStatistic(StatisticParameter parameter){
		StatisticResponse response = new StatisticResponse();
		try {
			checkParameter(parameter);
			CacheServiceImpl service = new CacheServiceImpl();
			Date start = new Date();
			response.getInsert().add("Started at " + new Date());
			
			int maxRows = parameter.getLimitRow();
			int key = parameter.getLimitField()<parameter.getDiffKeys()?parameter.getLimitField():parameter.getDiffKeys();
			int value = parameter.getLimitField()<parameter.getDiffValues()?parameter.getLimitField():parameter.getDiffValues();
			for (int i = 1; i <= parameter.getLimitRow(); i++) {
				if (key<parameter.getDiffKeys() && (i % (maxRows/parameter.getDiffKeys())) == 0) {
					key++;
				}
				if (value<parameter.getDiffValues() && (i % (maxRows/parameter.getDiffValues())) == 0) {
					value++;
				}
				List<Field> values = new ArrayList<Field>();
				for (int j = 0; j < parameter.getLimitField(); j++) {
					Field field = new Field();
					field.setKey((j<parameter.getDiffKeys()?j:"0") + "key" + key);
					field.setValue((j<parameter.getDiffValues()?j:"0") + "value" + value);
					values.add(field);
				}
				service.putValues(parameter.getSession(), values);
				if (i % (parameter.getLimitRow() /10) == 0) {
					response.getInsert().add(i + ". rows inserted for " + (System.currentTimeMillis() - start.getTime()) + ". ms");
				}
			}
			response.getInsert().add("Finished at " + new Date() + "<br><br>");
			
			response.getPull().add("Test with cache: " + new java.sql.Time(System.currentTimeMillis()) + "");
			Filter filter = new Filter();
			Condition condition = new Condition();
			condition.setLimit(parameter.getLimitRow());
			condition.setUseCache(true);
			filter.setCondition(condition);
			Field field = new Field();
			field.setKey("0key" + key);
			field.setValue("0value" + value);
			List<Field> fields = new ArrayList<Field>();
			fields.add(field);
			filter.setFindFields(fields);
			Date first = new Date();
			int size = service.getValues(parameter.getSession(), filter).getFoundRows().size();
			response.getPull().add("Pulled " + size + ". rows at " + new java.sql.Time(System.currentTimeMillis()) + "<br>with duration of: " + (new Date().getTime()  - first.getTime()) + "ms.<br><br>");
			response.getPull().add("Test without cache: " + new java.sql.Time(System.currentTimeMillis()) + "");
			condition.setUseCache(false);
			first = new Date();
			size = service.getValues(parameter.getSession(), filter).getFoundRows().size();
			response.getPull().add("Pulled " + size + ". rows at " + new java.sql.Time(System.currentTimeMillis()) + "<br>with duration of: " + (new Date().getTime()  - first.getTime()) + "ms.<br><br>");
			response.setMessage("Test passed with:<br>" +
					" &nbsp;&nbsp;&nbsp;&nbsp - " + parameter.getLimitField() + " fields per row<br>" +
					" &nbsp;&nbsp;&nbsp;&nbsp - " + parameter.getLimitRow() + " rows<br>" +
					" &nbsp;&nbsp;&nbsp;&nbsp - " + parameter.getLimitRow()*parameter.getLimitField() + " fields<br>" +
					" &nbsp;&nbsp;&nbsp;&nbsp - " + key + " different keys, planed (" + parameter.getDiffKeys() + ")<br>" +
					" &nbsp;&nbsp;&nbsp;&nbsp - " + value + " different values, planed (" + parameter.getDiffValues() + ")<br>"
					);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

	private void checkParameter(StatisticParameter parameter) throws ParameterNotValidException {
		if (parameter.getLimitField() == null) {
			throw new ParameterNotValidException("Please set fields limit");
		}
		
		if (parameter.getLimitRow() == null) {
			throw new ParameterNotValidException("Please set rows limit");
		}
		
		if (parameter.getSession() == null) {
			throw new ParameterNotValidException("Please set session");
		}
	}
}
