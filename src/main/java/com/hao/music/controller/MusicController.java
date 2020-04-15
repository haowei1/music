package com.hao.music.controller;

import com.hao.music.server.MusicServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author m760384371
 * @date 2019/9/25
 */
@CrossOrigin
@RestController
@RequestMapping("music")
public class MusicController {

    @Autowired
    private MusicServer musicServer;

    /**
     * 搜索音乐
     * @param map
     * @return
     */
    @RequestMapping("search")
    public String searchMusic(@RequestBody Map<String, String> map) {
        return musicServer.searchMusic(map.get("songName"));
    }

    /**
     * 获取歌曲信息
     * @param map
     * @return
     */
    @RequestMapping("info")
    public String getMusicInfo(@RequestBody Map<String, String> map) {
        return musicServer.getMusicInfo(map.get("songMid"));
    }

    /**
     * 获取歌词
     * @param map
     * @return
     */
    @RequestMapping("lrc")
    public String getMusicLrc(@RequestBody Map<String, String> map) {
        return musicServer.getMusicLrc(map.get("musicId"));
    }


    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }


}




//https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_yqq.fcg?nobase64=1&musicid=237224580&-=jsonp1&g_tk=5381&loginUin=2278395159&hostUin=0&format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0


//System.out.println("!1111111111111");
//请求路径
//String url = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&format=json&flag_qc=0&p=1&n=15&w=" + map.get("songName");
//String url = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp";
//String url = "https://www.baidu.com/s";
//String url = "https://c.y.qq.com/v8/fcg-bin/fcg_v8_toplist_cp.fcg";
//String url = "https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_yqq.fcg";
//使用Restemplate来发送HTTP请求
//RestTemplate restTemplate = new RestTemplate();
//json对象
//JSONObject jsonObject = new JSONObject();
//
//LinkedMultiValueMap 有点像JSON，用于传递post数据，网络上其他教程都使用
//MultiValueMpat<>来传递post数据
//但传递的数据类型有限，不能像这个这么灵活，可以传递多种不同数据类型的参数
//LinkedMultiValueMap body=new LinkedMultiValueMap();
//body.add("wd", "音乐");
//body.add("ct","24");
//body.add("qqmusic_ver","1298");
//body.add("new_json","1");
//body.add("remoteplace","txt.yqq.top");
//body.add("searchid","25220941374966416");
//body.add("t","0");
//body.add("aggr","1");
//body.add("cr","1");
//body.add("catZhida","1");
//body.add("lossless","1");
//body.add("flag_qc","0");
//body.add("p",1);
//body.add("n",10);
//body.add("w","小半");
//body.add("g_tk","5381");
//body.add("loginUin","0");
//body.add("hostUin","0");
//body.add("format","json");
//body.add("inCharset","utf8");
//body.add("outCharset","utf-8");
//body.add("platform","h5");
//body.add("needNewCode",1);
//
//body.add("uin", 0);
//body.add("tpl", 3);
//body.add("page", "detail");
//body.add("type", "27");
//body.add("topid", 27);
//body.add("_", "1519963122923");
//
//body.add("nobase64", 1);
//body.add("musicid", "237385006");
//body.add("g_tk", 5381);
//body.add("loginUin", 2012313298);
//body.add("hostUin", 0);
//body.add("format", "json");
//body.add("inCharset", "utf8");
//body.add("outCharset", "utf-8");
//body.add("notice", 0);
//body.add("platform", "yqq.json");
//body.add("needNewCode", 0);
//
//
//设置请求header 为 APPLICATION_FORM_URLENCODED
//HttpHeaders headers = new HttpHeaders();
//headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//headers.add("referer", "https://y.qq.com");
//请求体，包括请求数据 body 和 请求头 headers
//HttpEntity httpEntity = new HttpEntity(body, headers);
//
//
//try {
//使用 exchange 发送请求，以String的类型接收返回的数据
//ps，我请求的数据，其返回是一个json
//ResponseEntity<String> strbody = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
//解析返回的数据
//System.out.println(strbody.getBody());
//JSONObject jsTemp = JSONObject.parseObject(strbody.getBody());
//System.out.println(jsonObject.toJSONString());
//
//return strbody.getBody();
//
//}catch (Exception e){
//System.out.println(e);
//}
//return  null;
