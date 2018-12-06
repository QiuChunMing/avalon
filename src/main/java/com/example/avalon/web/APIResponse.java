package com.example.avalon.web;

import lombok.Data;

@Data
public class APIResponse {

    private long count;

    private int status;

    private String success;

    private String message;

    private String type;

    public static APIResponse success() {
        APIResponse response = new APIResponse();
        response.setStatus(0);
        response.setType(Type.SUCCESS.getType());
        return response;
    }

    public static enum Type {
        //保存数据失败
        ERROR_IN_SAVE("ERROR_IN_SAVE"),
        //参数错误
        ERROR_PARAMS("ERROR_PARAMS"),
        //获取数据失败
        ERROR_DATA("ERROR_DATA"),
        //更新失败
        UPDATE_FAILED("UPDATE_FAILED"),
        //删除失败
        DELETE_FAILED("DELETE_FAILED"),
        //访问拒绝
        SC_FORBIDDEN("SC_FORBIDDEN"),
        //操作成功
        SUCCESS("SUCCESS");

        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
