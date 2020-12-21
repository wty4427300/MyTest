package com.ftest.flinkTest;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.BatchTableEnvironment;

public class WordCountTable {

	// *************************************************************************
	//     PROGRAM
	// *************************************************************************

	public static void main(String[] args) throws Exception {
		ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		BatchTableEnvironment tEnv = BatchTableEnvironment.create(env);

		DataSet<WC> input = env.fromElements(
				new WC("Hello", 1),
				new WC("Ciao", 1),
				new WC("Hello", 1),
				new WC("Hello", 1),
				new WC("Hello", 1),
				new WC("word",1));

		Table table = tEnv.fromDataSet(input);
		Table rs =table.addColumns("concat (word,'shabi') as desc");


		Table filtered = table
				//根据代词分组
				.groupBy("word")
				//计数
				.select("word, frequency.sum as frequency")
				//过滤出filter=4的
				.filter("frequency = 4");

		DataSet<WC> result = tEnv.toDataSet(filtered, WC.class);
		DataSet<WC> result1 = tEnv.toDataSet(rs, WC.class);

		result.print();
		result1.print();
	}

	public static class WC {
		public String word;
		public long frequency;

		// public constructor to make it a Flink POJO
		public WC() {}

		public WC(String word, long frequency) {
			this.word = word;
			this.frequency = frequency;
		}

		@Override
		public String toString() {
			return "WC " + word + " " + frequency;
		}
	}
}