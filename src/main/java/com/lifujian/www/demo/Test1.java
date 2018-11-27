package com.lifujian.www.demo;

public class Test1 {
	
	private static String[] s1 = {"","十","百","千","万","十","百","千","亿","十","百","千"};
	private static String[] s2 = {"","一","二","三","四","五","六","七","八","九"};
	
	
	private String get(int i) {
		if (i < 0) {
			return null;
		}
		String s = String.valueOf(i);
		int[] intArr = new int[s.length()];
		for (int j = 0; j < intArr.length; j++) {
			
		}
		return "";
	}
	public static void main(String[] args) {
		String s = "12345";
		String res = "";
		char[] charArr = s.toCharArray();
		int index = charArr.length - 1;
		for (Character c : charArr) {
			int i = Integer.valueOf(c.toString());
			System.out.println(s2[i]);
			System.out.println(s1[index]);
			res += s2[i];
			res += s1[index];
			index--;
		}
		System.out.println(res);
	}
}
