package com.ping.thread.utils;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * @Author:xgchen
 * @Date:2015-02-25 18:03
 * @Version: V0.0.1
 */
public class PropertyUtil {

    private static String separator = File.separator;

    private static Properties properties = new Properties();

    public static void init(Properties props) {
        properties = props;
    }

    public static String getPropertyByName(String name) {
    	String result = properties.getProperty(name);
        return result == null ? "" : result.trim();
    }
    /**
     * 读取properties文件
     *
     * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties
     * @return key对应的值
     */
    public static void readData(String filePath) {
        String path = getFilePath(filePath);
        File file = new File(path);
        load(file, properties);
    }

    public static Properties readDataR(String filePath) {
        Properties pro = new Properties();
        String path = getFilePath(filePath);
        File file = new File(path);
        load(file, pro);
        return pro;
    }

    private static void load(File file,Properties pro) {
        try {
            InputStream stream = new BufferedInputStream(new FileInputStream(file));
            pro.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改或添加键值对 如果key存在，修改, 反之，添加。
     *
     * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties
     * @param key      键
     * @param value    键对应的值
     */
    public static void writeData(String filePath, String key, String value) {
        String path = getFilePath(filePath);
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            Properties props = new Properties();
            InputStream fis = new FileInputStream(file);
            props.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            OutputStream fos = new FileOutputStream(file);
            props.setProperty(key, value);
            //保存，并加入注释
            props.store(fos, "Update '" + key + "' value");
            fos.close();
        } catch (IOException e) {
            System.err.println("Visit " + filePath + " for updating " + value + " value error");
        }
    }

    /**
     * 拼装出文件所在的路径
     *
     * @param filePath
     * @return
     */
    private static String getFilePath(String filePath) {
        String osName = System.getProperty("os.name");
        String path = filePath;
        if (osName.contains("Windows")) {
            path = getWindowsFilePath(filePath);
        }

        return path;
    }

    private static String getWindowsFilePath(String filePath) {
        URL url = PropertyUtil.class.getClassLoader().getResource("");
        String[] filepath = url.getPath().split("/");
        String filePrefix = filepath[1];
        return separator + filePrefix + separator + filePath;
    }

    public static void main(String[] args) {
        String file = "/web/profile/usercenter/center/usercenter_conf.properties";
        PropertyUtil.readData(file);
        System.out.println(PropertyUtil.getPropertyByName("sms_username"));
        PropertyUtil.readData(file);
        writeData(file, "sms_username", "1234");
        PropertyUtil.readData(file);
        System.out.println(PropertyUtil.getPropertyByName("sms_username"));
    }
}
