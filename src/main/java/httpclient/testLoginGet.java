package httpclient;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class testLoginGet {
    public static void main(String[] args) {
        // 请求接口地址
        String url = "https://gatewaypreprod.vevor.net/scp-procurement-service/controller-purchaseOrderService/front/getPurchaseOrderList?currentPage=1&pageSize=10&purchaseStatus=&orderType=&billSource=&freeze=&procurementSupplierId=&groupId=";
        // 请求参数
        String key = "Bearer 30bb8610-98f4-4ff9-80ee-e10ef59a5432";
        HttpClient httpclient = null;
        GetMethod get = null;
        try {
            // 创建连接
            httpclient = new HttpClient();
            get = new GetMethod(url);
            // 设置编码方式
            get.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            // 添加参数
            get.addRequestHeader("Authorization", key);
            // 执行请求
            httpclient.executeMethod(get);
            // 接口返回信息
            String info = new String(get.getResponseBody(), "UTF-8");
            System.out.printf("resultJSON:" + info);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接，释放资源
            assert get != null;
            get.releaseConnection();
        }
    }
}

