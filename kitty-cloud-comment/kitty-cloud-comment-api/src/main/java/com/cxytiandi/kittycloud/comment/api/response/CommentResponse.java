package com.cxytiandi.kittycloud.comment.api.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 评论Response
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
public class CommentResponse implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论业务用户ID
     */
    private Long commentBizUserId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 回复数量
     */
    private int replyCount;

}