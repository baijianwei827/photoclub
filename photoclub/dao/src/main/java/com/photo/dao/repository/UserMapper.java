package com.photo.dao.repository;

import com.photo.dao.domain.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String u_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    User selectByPrimaryKey(String u_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeyWithBLOBs(User record);

    /**
     * 用户ID
     * @param u_id
     * @return
     */
    User selectUserByU_id(@Param("u_id")String u_id);
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过手机号查找用户
     * @param account
     * @return
     */
    User selectUserByAccount(String account);

    /**
     * 首页推荐用户
     * @return
     */
    List<User> selectUserIsRecommend(@Param("is_Top") Integer is_Top);

    /**
     * 通过用户昵称查找
     * @param u_nickName
     * @return
     */
    List<Map> selectUserByLikeNickName(@Param("u_nickName") String u_nickName,
                                        @Param("isDesc") Integer isDesc,
                                        @Param(value = "pageNum") Integer pageNum,
                                        @Param(value = "pageSize")Integer pageSize);
    /**
     * 通过用户昵称查找总个数
     * @param u_nickName
     * @return
     */
    int selectUserByLikeNickNameCount(@Param("u_nickName") String u_nickName,
                                      @Param("isDesc") Integer isDesc);

    /**
     * 关注个数的加减
     * @param number
     * @return
     */
    @Update("UPDATE t_user set attention_number = attention_number + #{number} WHERE u_id = #{u_id}")
    int UpdateUserAttention(@Param(value = "number") Integer number,
                            @Param(value = "u_id")String u_id);

    /**
     * 粉丝个数的加减
     * @param number
     * @return
     */
    @Update("UPDATE t_user set fans_number = fans_number + #{number} WHERE u_id = #{u_id}")
    int UpdateUserBean(@Param(value = "number") Integer number,@Param(value = "u_id")String u_id);

    /**
     * 修改密码
     * @param u_password
     * @return
     */
    @Update("UPDATE t_user SET  u_password  = #{u_password} WHERE u_account = #{u_account}")
    int UpdateUserPassword(@Param(value = "u_password") String u_password ,@Param(value = "u_account") String u_account);

    @Select("SELECT * FROM t_users")
    Map selelctAllUser();
}