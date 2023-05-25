import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<Object,Text, Text, Text> {
    @Override
    protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        String str = value.toString();
        String[] strings = str.split(":");
        context.write(new Text(strings[0]),new Text(strings[1]+":"+strings[2]));
    }
}
