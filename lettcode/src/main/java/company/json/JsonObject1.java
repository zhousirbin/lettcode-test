package company.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonObject1 {

    public static void main(String[] args){

        String temp="{'data':{'a':[{'b1':'bb1','c1':'cc1'},{'b2':'bb2','c2':'cc2'}]}}";

        JSONObject jodat =JSONObject.parseObject(temp);

        String data = jodat.getString("data");  //获取data的值
        System.out.println("data="+data);

        JSONObject jodata =JSONObject.parseObject(data); //获取data值



        String temp1 = jodata.getString("a");  //获取a里的值

        JSONArray ja=JSONArray.parseArray(temp1);

        System.out.println(ja);
        for(int i=0;i<ja.size();i++){

            JSONObject o=ja.getJSONObject(i);

            if(o.get("b1")!=null){

                System.out.println(o.get("b1"));

            }

            if(o.get("c1")!=null){

                System.out.println(o.get("c1"));

            }

            if(o.get("b2")!=null){

                System.out.println(o.get("b2"));

            }

            if(o.get("c2")!=null){

                System.out.println(o.get("c2"));

            }

        }

    }
}
