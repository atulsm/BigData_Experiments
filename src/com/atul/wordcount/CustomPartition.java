package com.atul.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
/**
 * Name starting with same letter will go to same reducer
 * @author atul.soman
 *
 */
public class CustomPartition extends Partitioner<Text, IntWritable> {

	@Override
	public int getPartition(Text key, IntWritable value, int noofreducers) {
		char firstLetter = key.toString().trim().charAt(0);

		return (firstLetter - 'A') % noofreducers;

	}

}