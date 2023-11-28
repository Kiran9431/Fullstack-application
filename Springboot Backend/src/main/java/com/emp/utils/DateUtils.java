package com.emp.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	public class DateUtils {

		protected final static Log logger = LogFactory.getLog(DateUtils.class);

		public static Date getDateFromStringDate(String scheduleDate) throws ParseException {
			DateFormat formatter = null;
			Date convertedDate = null;
			formatter = new SimpleDateFormat("dd-MM-yyyy");
			convertedDate = (Date) formatter.parse(scheduleDate);
			logger.info("Date from dd-MM-yyyy String in Java : " + convertedDate);
			return convertedDate;
		}

	}


