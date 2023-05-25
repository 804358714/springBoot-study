import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MyReducer extends Reducer<Text, Text,Text, DoubleWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, DoubleWritable>.Context context) throws IOException, InterruptedException {
        HashMap<String,Double> set = new HashMap<>();
        for (Text value : values) {
            String[] strings = value.toString().split(":");
            int t = Integer.parseInt(strings[1]);
            if (t>=95) set.put(strings[0], 4.5);
            else if (t>=90) set.put(strings[0], 4.0);
            else if (t>=85) set.put(strings[0], 3.5);
            else if (t>=80) set.put(strings[0], 3.0);
            else if (t>=75) set.put(strings[0], 2.5);
            else if (t>=70) set.put(strings[0], 2.0);
            else if (t>=65) set.put(strings[0], 1.5);
            else if (t>=60) set.put(strings[0], 1.0);
            else set.put(strings[0], 0.0);
        }
        Collection<Double> floats = set.values();
        Double res = floats.stream().collect(Collectors.averagingDouble(value -> value));
        String format = new DecimalFormat("######0.00").format(res);
        double d = Double.parseDouble(format);
        context.write(key,new DoubleWritable(d));
    }
}
