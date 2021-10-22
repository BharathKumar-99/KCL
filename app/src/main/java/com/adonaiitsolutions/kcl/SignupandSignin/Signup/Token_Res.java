package com.adonaiitsolutions.kcl.SignupandSignin.Signup;


import com.google.gson.annotations.SerializedName;

public class Token_Res {


    @SerializedName("head")
    private Head head;
    @SerializedName("body")
    private Body body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
    public class ResultInfo {

        @SerializedName("resultStatus")
        private String resultStatus;
        @SerializedName("resultCode")
        private String resultCode;
        @SerializedName("resultMsg")
        private String resultMsg;

        public String getResultStatus() {
            return resultStatus;
        }

        public void setResultStatus(String resultStatus) {
            this.resultStatus = resultStatus;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }

    }
    public class Head {

        @SerializedName("responseTimestamp")
        private String responseTimestamp;
        @SerializedName("version")
        private String version;
        @SerializedName("signature")
        private String signature;

        public String getResponseTimestamp() {
            return responseTimestamp;
        }

        public void setResponseTimestamp(String responseTimestamp) {
            this.responseTimestamp = responseTimestamp;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

    }

    public class Body {

        @SerializedName("resultInfo")
        private ResultInfo resultInfo;
        @SerializedName("txnToken")
        private String txnToken;
        @SerializedName("isPromoCodeValid")
        private boolean isPromoCodeValid;
        @SerializedName("authenticated")
        private boolean authenticated;

        public ResultInfo getResultInfo() {
            return resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo) {
            this.resultInfo = resultInfo;
        }

        public String getTxnToken() {
            return txnToken;
        }

        public void setTxnToken(String txnToken) {
            this.txnToken = txnToken;
        }

        public boolean isIsPromoCodeValid() {
            return isPromoCodeValid;
        }

        public void setIsPromoCodeValid(boolean isPromoCodeValid) {
            this.isPromoCodeValid = isPromoCodeValid;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

    }
}