//package xulinfeng.util;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 最简单的 HttpClient 封装
// *
// * @author xujiahong
// * @date 2018/6/27
// */
//public class HttpUtils {
//
//    public static String doGet(String url) {
//
//        String result = "";
//        //创建一个httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        //创建一个GET对象
//        HttpGet get = new HttpGet(url);
//        //执行请求
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(get);
//            //取响应的结果
////            int statusCode = response.getStatusLine().getStatusCode();
////            System.out.println(statusCode);
//
//            HttpEntity entity = response.getEntity();
//            result = EntityUtils.toString(entity, "utf-8");
////            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            close(response, httpClient);
//        }
//        return result;
//    }
//
//
//    public static String doPost(String url, Map<String, String> paramsHashMap) throws Exception {
//
//        String result = "";
//        //创建一个httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        //执行请求
//        CloseableHttpResponse response = null;
//        List<NameValuePair> kvList = new ArrayList<NameValuePair>();
//        // 将传过来的参数添加到List<NameValuePair>中
//        if (paramsHashMap != null && !paramsHashMap.isEmpty()) {
//            //遍历map
//            for (Map.Entry<String, String> entry : paramsHashMap.entrySet()) {
//                kvList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//            }
//        }
//        //包装成一个Entity对象
//        StringEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");
//
//        //创建一个POST对象
//        HttpPost post = new HttpPost(url);
//        post.setEntity(entity);
//        try {
//            response = httpClient.execute(post);
//            result = EntityUtils.toString(response.getEntity());
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            close(response, httpClient);
//        }
//        return result;
//
//    }
//
//
//    /**
//     * 关闭httpclient
//     *
//     * @param response
//     * @param httpClient
//     */
//    private static void close(CloseableHttpResponse response, CloseableHttpClient httpClient) {
//        try {
//            if (response != null) {
//                response.close();
//            }
//            if (httpClient != null) {
//                httpClient.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}