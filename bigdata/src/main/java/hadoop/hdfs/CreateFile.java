package hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CreateFile {

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        //设置hdfs和yarn地址
        conf.set("fs.defaultFS", "hdfs://hadoop01:9000");
        conf.set("yarn.resourcemanager.hostname","hadoop01");

        FileSystem hdfs = FileSystem.get(conf);

        byte[] buff = "hello hadoop world!\n".getBytes();

        Path dfs = new Path("/test");

        FSDataOutputStream outputStream = hdfs.create(dfs);

        outputStream.write(buff, 0, buff.length);

    }

}