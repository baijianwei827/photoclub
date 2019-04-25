package com.photo.api.aliyunoss;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AliyunOSSUtil {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    private OSSClient ossClient;

    public  OSSClient initOss(){
        String endpoint=ConstantProperties.END_POINT;
        String accessKeyId=ConstantProperties.ACCESS_KEY_ID;
        String accessKeySecret=ConstantProperties.ACCESS_KEY_SECRET;
         ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        return ossClient;
    }

    public  String uploadOne(File file){
        logger.info("=========>OSS文件上传开始："+file.getName());
        String bucketName=ConstantProperties.BUCKET_NAME;
        String fileHost=ConstantProperties.FILE_HOST;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        if(file == null){
            return null;
        }
        try {
            //容器不存在，就创建
            if(! ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost+"/"+(dateStr + "/" + UUID.randomUUID().toString().replace("-","")+"-"+file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
            if(null != result){
                logger.info("==========>OSS文件上传成功,OSS地址："+fileUrl);
               String img = getImgUrl(fileUrl);
                return img;
            }
        }catch (OSSException oe){
            logger.error(oe.getMessage());
        }catch (ClientException ce){
            logger.error(ce.getMessage());
        }finally {
            closeOssClient();
        }
        return null;
    }

    public List<String> uploadList(File[] files){
        List<String> urlList = new ArrayList<>();
        for(File file:files){
            urlList.add(uploadOne(file));
        }
        return urlList;
    }
    public  void  closeOssClient() {
        ossClient.shutdown();
    }


    public static  String getImgUrl(String url){
        String img = "https://"+ConstantProperties.BUCKET_NAME+"."+ConstantProperties.END_POINT+url;
        return img;
    }
}
