package httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    //日志
    private final Logger logger = Logger.getLogger(Demo.class);

    //@Test(enabled = false)
    //public void testLoginPost() {
    //    //准备url
    //    String url = "https://gatewaypreprod.vevor.net/scp-procurement-service/controller-purchaseOrderService/front/getPurchaseOrderList?currentPage=1&pageSize=10&purchaseStatus=&orderType=&billSource=&freeze=&procurementSupplierId=&groupId=";
    //    //选择请求方式
    //    HttpPost httppost = new HttpPost(url);
    //    //准备参数
    //    List<BasicNameValuePair> para = new ArrayList<BasicNameValuePair>();
    //    BasicNameValuePair mobliePhone = new BasicNameValuePair("mobilephone", "**********");
    //    BasicNameValuePair pwd = new BasicNameValuePair("password", "e10adc3949ba59abbe56e057f20f883e");
    //    BasicNameValuePair type = new BasicNameValuePair("type", "1");
    //    para.add(mobliePhone);
    //    para.add(pwd);
    //    para.add(type);
    //    try {//把参数封装到请求体里面
    //        httppost.setEntity(new UrlEncodedFormEntity(para, "UTF-8"));
    //        //准备客户端
    //        HttpClient httpclient = HttpClients.createDefault();
    //        //发送请求，接受响应信息
    //        HttpResponse respones = httpclient.execute(httppost);
    //        //取出接口响应数据,并转成字符串
    //        String result = EntityUtils.toString(respones.getEntity());
    //        System.out.println(result);
    //    } catch (Exception e) {
    //        // TODO Auto-generated catch block
    //        logger.error("post请求出问题啦");
    //    }
    //}

    @Test
    public void testLoginGet() {
        //准备url
        String url = "https://gatewaypreprod.vevor.net/scp-procurement-service/controller-purchaseOrderService/front/getPurchaseOrderList?currentPage=1&pageSize=10&purchaseStatus=&orderType=&billSource=&freeze=&procurementSupplierId=&groupId=";
        //选择请求方式
        HttpGet httpget = new HttpGet(url);
        //准备参数
        List<BasicNameValuePair> para = new ArrayList<BasicNameValuePair>();
        //BasicNameValuePair mobilePhone = new BasicNameValuePair("mobilise", "*****");
        //BasicNameValuePair pwd = new BasicNameValuePair("password", "e10adc3949ba59abbe56e057f20f883e");
        //BasicNameValuePair type = new BasicNameValuePair("Authorization", "Bearer 30bb8610-98f4-4ff9-80ee-e10ef59a5432");
        //para.add(mobilePhone);
        //para.add(pwd);
        //para.add(type);
        String parameter = URLEncodedUtils.format(para, "UTF-8");
        //将参数拼接在url上面
        url += ("?" + parameter);
        try {
            httpget.setURI(new URI(url));
            //准备客户端
            HttpClient httpclient = HttpClients.createDefault();
            //执行
            HttpResponse response = httpclient.execute(httpget);
            String result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("get请求出问题啦");
        }
    }

}
