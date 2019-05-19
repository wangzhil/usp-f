package sinosoft.com.ribbon.clienta.config;

import com.alibaba.druid.filter.config.ConfigTools;

public class decrpt {

	public static void main(String[] args) {
		try {
			String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJLYfIiAITRS85W0ulTEeDZhUjisbB74aBYVdLUw1iPLPsxT9Eokfd10gEMEkhQFc6aZm488CdQ1lR0yIxXZuM0CAwEAAQ==";
			String password = "HLYGVV8zs+MLhg2uG+RuTcQFEHb0CnKXGAqrMd1jDn6ABXrZ7wDPkssk+BfwZJJnnfLO95r5yzjQaXqkkAt+cA==";
			String str = ConfigTools.decrypt(publickey,password);
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
