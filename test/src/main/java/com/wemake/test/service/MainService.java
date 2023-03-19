package com.wemake.test.service;

import com.wemake.test.dto.ResponseDto;
import com.wemake.test.util.PublicUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainService {

    @Autowired
    PublicUtil publicUtil;

    public ResponseDto mainService(String url, String type, int unit) throws Exception {
        String parseStr;
        // url parsing
        if (type.equals("TEXT")) {
            parseStr = publicUtil.parseHtml(url);
        } else {
            parseStr = publicUtil.replaceTag(publicUtil.parseHtml(url));
        }
        return CreateRes(parseStr, unit);
    }

    public ResponseDto CreateRes(String str, int unit) {
        ResponseDto responseDto = new ResponseDto();
        int strLen = str.length();
        String quotient = "";
        String remainder = "";


        if(strLen % unit == 0){
            quotient = str;
        } else {
            int remainLength = (strLen % unit);
            quotient = str.substring(0, strLen-remainLength);
            remainder = str.substring(strLen-remainLength, strLen);
        }

        responseDto.setRemainder(remainder);
        responseDto.setQuotient(quotient);

        return responseDto;
    }
}
