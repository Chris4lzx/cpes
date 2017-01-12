package jUnitTest;

import org.junit.Test;

import com.atguigu.crowdfunding.util.MD5Util;

public class UtilTest {

	@Test
	public void test() {
		String digest = MD5Util.digest("123456");
		System.out.println(digest);
	}

}
