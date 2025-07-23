package loongly.lsdc.api.system;

import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.HashMap;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class RefMap<K,V>
{
    public Map<K,V> map = new HashMap<K,V>();

    public boolean containsKey(String key)
    {
        return map.containsKey(key);
    }

    public V get(String key)
    {
        return map.get(key);
    }

    /*Tool Func*/
    /*Map*/

    static public void initMapWithPathAndURL(String jsonFilePath, String jsonURL,RefMap refMap )
    {
        try (InputStream inputStream = RefMap.class.getResourceAsStream(jsonFilePath)) {
            if (inputStream == null) {
                System.err.println("JSON 文件未找到: " + jsonFilePath);
                //return;
            }
            else
            {
                byte[] bytes = new byte[0];
                bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                String jsStr = new String(bytes);

                //json对象转Map
                refMap.map = convertJsonToMap(jsStr);
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String jsonStr = doGet(jsonURL);
        if(jsonStr != null)
        {
            try
            {
                refMap.map = convertJsonToMap(jsonStr);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    static public Map convertJsonToMap(String jsonString)
    {
        Map<String, Object> map = new HashMap<>();
        if (jsonString == null || jsonString.isEmpty())
        {
            return map;
        }

        // 去掉首尾的花括号
        jsonString = jsonString.trim();
        if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
            throw new IllegalArgumentException("Invalid JSON string");
        }
        jsonString = jsonString.substring(1, jsonString.length() - 1).trim();

        // 按逗号分隔键值对
        String[] pairs = jsonString.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.trim().split(":");
            if (keyValue.length != 2) {
                throw new IllegalArgumentException("Invalid key-value pair: " + pair);
            }

            String key = parseString(keyValue[0].trim());
            Object value = parseValue(keyValue[1].trim());
            map.put(key, value);
        }

        return map;
    }

    /**
     * 解析字符串类型的值（去掉引号）
     *
     * @param str 字符串
     * @return 去掉引号后的字符串
     */
    static private String parseString(String str)
    {
        if (str.startsWith("\"") && str.endsWith("\""))
        {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    /**
     * 解析JSON中的值
     *
     * @param valueStr 值的字符串表示
     * @return 解析后的值
     */
    static private Object parseValue(String valueStr)
    {
        if (valueStr.equalsIgnoreCase("true") || valueStr.equalsIgnoreCase("false"))
        {
            return Boolean.parseBoolean(valueStr);
        }
        else if (valueStr.matches("-?\\d+"))
        { // 整数
            return Integer.parseInt(valueStr);
        }
        else if (valueStr.matches("-?\\d*\\.\\d+"))
        { // 浮点数
            return Double.parseDouble(valueStr);
        }
        else if (valueStr.startsWith("\"") && valueStr.endsWith("\""))
        { // 字符串
            return parseString(valueStr);
        }
        else if (valueStr.equalsIgnoreCase("null"))
        {
            return null;
        }
        else
        {
            throw new IllegalArgumentException("Unsupported value type: " + valueStr);
        }
    }

    static private String doGet(String httpurl)
    {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try
        {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(3000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(6000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200)
            {
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null)
                {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭资源
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        return result;
    }
}
