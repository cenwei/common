package org.bclove.common.utils.text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.bclove.common.utils.ResourceUtils;

public class PinyinUtils {
	private final Properties properties;

	public PinyinUtils() {
		InputStream istream = null;
		String resource = "unicode_pinyin_mapping.properties";
		try {
			istream = ResourceUtils.getResourceAsStream(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (istream == null) {
			throw new RuntimeException("Could not find code table: " + resource);
		}

		properties = new Properties();
		try {
			properties.load(istream);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public String getPinyinFromCharacter(char ch) {
		String key = Integer.toHexString((int) ch).toUpperCase();
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		PinyinUtils pinyin = new PinyinUtils();
		String content = "网页の吙煋呅转换器 吥螚过藘炏猩炆の过藘喺綂没囿噫锶 筷啦倒紦，朕の溱都亡ㄋ，说这些冇什么甪" ;
	 
		for(char c :content.toCharArray()){
			String str = pinyin.getPinyinFromCharacter(c);
			System.out.print(str +" ");
		}
		
	}
}
