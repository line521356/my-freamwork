package com.lucius.business.model.guojia;

/**
 * <br>
 *
 * @author sunzhongshuai
 */
public class AddPwdResponse extends BaseResponse{



    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String pwd_text;
        private String lock_no;
        private Integer pwd_no;
        private String business_id;

        public String getPwd_text() {
            return pwd_text;
        }

        public void setPwd_text(String pwd_text) {
            this.pwd_text = pwd_text;
        }

        public String getLock_no() {
            return lock_no;
        }

        public void setLock_no(String lock_no) {
            this.lock_no = lock_no;
        }

        public Integer getPwd_no() {
            return pwd_no;
        }

        public void setPwd_no(Integer pwd_no) {
            this.pwd_no = pwd_no;
        }

        public String getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(String business_id) {
            this.business_id = business_id;
        }
    }
}
