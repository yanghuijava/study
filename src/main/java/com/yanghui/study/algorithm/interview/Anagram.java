package com.yanghui.study.algorithm.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * @author think
 *
 */
public class Anagram {
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}
	
	public static boolean isAnagram(String s, String t) {
		if(s == null || t == null || s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map1 = new HashMap<>();
		for(Character c : s.toCharArray()) {
			if(map1.containsKey(c)) {
				map1.put(c, map1.get(c) + 1);
			}else {
				map1.put(c, 1);
			}
		}
		Map<Character, Integer> map2 = new HashMap<>();
		for(Character c : t.toCharArray()) {
			if(map2.containsKey(c)) {
				map2.put(c, map2.get(c) + 1);
			}else {
				map2.put(c, 1);
			}
		}
		return map1.equals(map2);
	}
}
