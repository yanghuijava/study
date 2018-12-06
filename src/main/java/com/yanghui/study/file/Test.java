package com.yanghui.study.file;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ll");
		list.add("dd");
		list.add("ss");
		List<String> c = list.stream().filter(l -> l.contains("ll"))
				.collect(Collectors.toList());
		System.out.println(c);
	}

}
