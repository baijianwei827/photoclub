package com.photo.api.aliyunoss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class TestOss {
    public static void main(String[] args) {
//        String endpoint = "sts.aliyuncs.com";
//        String accessKeyId = "LTAIAjrBBmcW5m9L";
//        String accessKeySecret = "zWdrSBkLWKgQ1IIwpxfcwXa7hmxkfR";
//        String roleArn = "acs:ram::1819823174914655:role/pamosstest";
//        String roleSessionName = "zhouwei";
//        String policy = "{\n" +
//                "    \"Version\": \"1\", \n" +
//                "    \"Statement\": [\n" +
//                "        {\n" +
//                "            \"Action\": [\n" +
//                "                \"oss:*\"\n" +
//                "            ], \n" +
//                "            \"Resource\": [\n" +
//                "                \"acs:oss:*:*:*\" \n" +
//                "            ], \n" +
//                "            \"Effect\": \"Allow\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint1 = null;
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId1 = null;
//        String accessKeySecret1 = null;
//        String securityToken1 = null;
//        try {
//            // 添加endpoint（直接使用STS endpoint，前两个参数留空，无需添加region ID）
//            DefaultProfile.addEndpoint( "", "Sts", endpoint);
//            // 构造default profile（参数留空，无需添加region ID）
//            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
//            // 用profile构造client
//            DefaultAcsClient client = new DefaultAcsClient(profile);
//            final AssumeRoleRequest request = new AssumeRoleRequest();
//            request.setMethod(MethodType.POST);
//            request.setRoleArn(roleArn);
//            request.setRoleSessionName(roleSessionName);
//            request.setPolicy(policy); // 若policy为空，则用户将获得该角色下所有权限
//            request.setDurationSeconds(1000L); // 设置凭证有效时间
//            final AssumeRoleResponse response = client.getAcsResponse(request);
//            System.out.println("Expiration: " + response.getCredentials().getExpiration());
//            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
//            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
//            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
//            System.out.println("RequestId: " + response.getRequestId());
//            endpoint1 = "http://oss-cn-shanghai.aliyuncs.com";
//            accessKeyId1 = response.getCredentials().getAccessKeyId();
//            accessKeySecret1 = response.getCredentials().getAccessKeySecret();
//            securityToken1 = response.getCredentials().getSecurityToken();
//        } catch (ClientException e) {
//            System.out.println("Failed：");
//            System.out.println("Error code: " + e.getErrCode());
//            System.out.println("Error message: " + e.getErrMsg());
//            System.out.println("RequestId: " + e.getRequestId());
//        }
//        Resource resource = new ClassPathResource("image/one.jpg");
//        File file = null;
//        try {
//            file = resource.getFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String bucketName = ConstantProperties.BUCKET_NAME;
//        //创建文件路径
//       String fileUrl = ConstantProperties.FILE_HOST+"/"+(UUID.randomUUID().toString().replace("-","")+"-"+file.getName());
//// 用户拿到STS临时凭证后，通过其中的安全令牌（SecurityToken）和临时访问密钥（AccessKeyId和AccessKeySecret）生成OSSClient。
//// 创建OSSClient实例。注意，这里使用到了上一步生成的STS凭证
//        OSSClient ossClient = new OSSClient(endpoint1, accessKeyId1, accessKeySecret1, securityToken1);
//        //上传文件
//        PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
//        //设置权限 这里是公开读
//        ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
//// OSS操作。
//
//// 关闭OSSClient。
//        ossClient.shutdown();
    }
}
