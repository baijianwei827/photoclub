package com.photo.common.tools;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AliYunOssUtil {
    /**
     * 下面配置的文档说明：https://help.aliyun.com/document_detail/100624.html?spm=5176.10695662.1996646101.searchclickresult.25ae515a9PnWXS
     */
    /**
     * 阿里云STS地址
     */
    private static final String END_POINT = "sts.aliyuncs.com";
    /**
     * 子账号的accessKeyId 和 AK
     */
    private static final String ACCESS_KEY_ID = "LTAIAjrBBmcW5m9L";

    private static final String ACCESS_KEY_SECRET = "zWdrSBkLWKgQ1IIwpxfcwXa7hmxkfR";
    /**
     * 角色ID
     */
    private static final String ROLE_ARM = "acs:ram::1819823174914655:role/pamosstest";
    /**
     * 用来标识临时凭证的名称，建议使用不同的应用程序用户来区分   首字母不能为数字
     */
    private static final String ROLE_SESSION_NAME = "zhouwei";
    /**
     * 在扮演角色的时候额外添加的权限限制: 这里是操作oss的所有权限
     */
    private static final String POLICY = "{\n" +
            "    \"Version\": \"1\", \n" +
            "    \"Statement\": [\n" +
            "        {\n" +
            "            \"Action\": [\n" +
            "                \"oss:*\"\n" +
            "            ], \n" +
            "            \"Resource\": [\n" +
            "                \"acs:oss:*:*:*\" \n" +
            "            ], \n" +
            "            \"Effect\": \"Allow\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    /**
     * 设置凭证有效时间
     */
    private static final Long TIME = 1000L;

    private static Logger logger = LogManager.getLogger(AliYunOssUtil.class);
    /**
     * 获取STS的临时权限
     * @return
     */
    public static Map<String,String> getSTS(){
        Map<String,String> map = new HashMap<>();
        try {
            // 添加endpoint（直接使用STS endpoint，前一个参数留空，无需添加region ID）
            DefaultProfile.addEndpoint( "", "Sts", END_POINT);
            // 构造default profile（参数留空，无需添加region ID）
            IClientProfile profile = DefaultProfile.getProfile("", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            // 用profile构造client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(ROLE_ARM);
            request.setRoleSessionName(ROLE_SESSION_NAME);
            request.setPolicy(POLICY); // 若policy为空，则用户将获得该角色下所有权限
            request.setDurationSeconds(TIME); // 设置凭证有效时间
            final AssumeRoleResponse response = client.getAcsResponse(request);
            map.put("accessKeyId",response.getCredentials().getAccessKeyId());
            map.put("accessKeySecret",response.getCredentials().getAccessKeySecret());
            map.put("stsToken",response.getCredentials().getSecurityToken());
            map.put("requestId",response.getRequestId());
            logger.info("Expiration: " + response.getCredentials().getExpiration());
            logger.info("Access Key Id: " + response.getCredentials().getAccessKeyId());
            logger.info("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            logger.info("Security Token: " + response.getCredentials().getSecurityToken());
            logger.info("RequestId: " + response.getRequestId());
            return map;
        } catch (ClientException e) {
            logger.info(e.getErrCode());
            logger.info(e.getErrMsg());
            logger.info(e.getRequestId());
            logger.info(e.getMessage());
           return null;
        }
    }
}
