package com.yanghui.study.cmdcline;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CmdlineTest {

	public static void main(String[] args) throws ParseException {
		Options options = new Options();
		options.addOption("t", true, "display current time");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("t")) {
			System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
			System.out.println(cmd.getOptionValue("t"));
		} else {
			System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		}

	}
}
