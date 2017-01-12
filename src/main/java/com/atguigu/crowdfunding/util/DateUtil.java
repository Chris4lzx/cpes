package com.atguigu.crowdfunding.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author evaima
 *
 */
public class DateUtil {

	/**
	 * 将指定的日期按照指定的格式转换为字符串
	 * @param d
	 * @param f
	 * @return
	 */
	public static String format( Date d, String f ) {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		return sdf.format(d);
	}
	
	public static String getSystemtime() {
		return format( new Date(), Const.DATE_FORMAT_ALL );
	}
}
