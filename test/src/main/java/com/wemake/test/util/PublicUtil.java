package com.wemake.test.util;

import static com.wemake.test.exception.BaseResponseStatus.PARSE_ERROR;

import com.wemake.test.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PublicUtil {

    // Jsoup 라이브러리를 활용하여 파싱
    public String parseHtml(String url) throws Exception {
        try {
            Connection.Response response = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .execute();
            Document document = response.parse();
            log.debug("document = " + document);
            return document.html();

        } catch (Exception e) {
            throw new BaseException(PARSE_ERROR);
        }
    }

    // 영어 및 숫자만 출력
    public String replaceStr(String str) {
        String regex = "/^[a-zA-Z0-9]*$/";
        return str.replaceAll(regex, "");
    }

    // 오름차순 출력
    public String replaceAsc(String str) {
        String regex = "/^[a-zA-Z0-9]*$/";
        return str.replaceAll(regex, "");
    }

    // 태그 지우기
    public String replaceTag(String str){
        String regex = "<[^>]*>";
        return str.replaceAll(regex,"");
    }
}
