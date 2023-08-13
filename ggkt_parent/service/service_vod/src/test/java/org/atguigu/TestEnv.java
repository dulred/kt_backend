package org.atguigu;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Objects;


public class TestEnv {

    public static void copyDir(File srcDir,File targetDir) throws IOException {
        //获取新目录对象
        targetDir = new File(targetDir,srcDir.getName());
        //如果新目录不存在，则创建
        if(!targetDir.exists()){
            targetDir.mkdirs();
        }
        File[] files = srcDir.listFiles();
        if(Objects.nonNull(files)){
            for (File file : files) {
                if(file.isDirectory()){
                    //目录递归拷贝
                    copyDir(file,targetDir);
                }else{
                    //执行文件拷贝
                    copyFile(file,targetDir);
                }
            }
        }
    }

    /**
     * 将一个源文件拷贝到一个目标目录中
     * @param src 源文件
     * @param targetDir 目标目录
     */
    public static void copyFile(File src, File targetDir) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            //获取源文件的输入流
            is = new FileInputStream(src);
            //获取目标文件的输出流（目标文件是由：目录+源文件名称构成）：文件输出流可以创建文件（前提：父目录必须存在）

            os = new FileOutputStream(new File(targetDir,src.getName()));
            //声明字节缓冲区(缓冲区越大，拷贝效率越高，但是带来空间损耗也越大)
            byte[] b = new byte[1024*1024];
            //临时变量表示实际读取的字节数
            int len = 0;
            System.out.println("开始拷贝...");
            while((len = is.read(b)) != -1){
                //写出读取的内容到输出流
                os.write(b,0,len);
            }
            System.out.println("拷贝完成！");
        }  finally{
            if(os != null){
                os.close();
            }
            if(is != null){
                is.close();
            }
        }

    }

    //测试
    public static void main(String[] args) throws IOException {
        //源文件
        File srcDir = new File("D:\\dulred\\testData");
        //目标目录
        File targetDir = new File("D:\\dulred\\testData2");
        //文件拷贝
        copyDir(srcDir,targetDir);
    }


}
