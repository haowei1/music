package com.hao.music.server;

import com.hao.music.utils.HttpClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

/**
 * @author m760384371
 * @date 2019/9/28
 */
@Service
public class MusicServer {

    private final String HOST = "https://c.y.qq.com";

    /**
     * 搜索音乐
     * @param songName
     * @return
     */
    public String searchMusic(String songName) {
        String url = HOST + "/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&format=json&flag_qc=0&p=1&n=15&w=" + songName;
        HttpMethod method = HttpMethod.GET;
        LinkedMultiValueMap body=new LinkedMultiValueMap();
        HttpHeaders headers = new HttpHeaders();
        return HttpClient.sendGetRequest(url, method, body, headers);
    }

    /**
     * 获取歌曲信息
     * @param songMid
     * @return
     */
    public String getMusicInfo(String songMid) {
        String url = HOST + "/base/fcgi-bin/fcg_music_express_mobile3.fcg?format=json205361747&platform=yqq&cid=205361747" +
                "&songmid=" + songMid + "&filename=C400" + songMid + ".m4a&guid=126548448&loginUin=2012313298";
        HttpMethod method = HttpMethod.GET;
        LinkedMultiValueMap body=new LinkedMultiValueMap();
        HttpHeaders headers = new HttpHeaders();
        return HttpClient.sendGetRequest(url, method, body, headers);
    }

    /**
     * 获取歌曲歌词
     * @param musicId
     * @return
     */
    public String getMusicLrc(String musicId) {
        String url = HOST + "/lyric/fcgi-bin/fcg_query_lyric_yqq.fcg?nobase64=1&musicid=" + musicId +
                "&-=jsonp1&g_tk=5381&loginUin=2278395159&hostUin=0&format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0";
        HttpMethod method = HttpMethod.GET;
        LinkedMultiValueMap body = new LinkedMultiValueMap();
        HttpHeaders headers = new HttpHeaders();
        headers.add("referer", "https://y.qq.com");
        return HttpClient.sendGetRequest(url, method, body, headers);
    }
}
