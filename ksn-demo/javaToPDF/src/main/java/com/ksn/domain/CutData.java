package com.ksn.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/21 10:14
 * @description: 切割的数据
 */
public class CutData implements Serializable {


    private Integer totalLength;
    private Integer serialNum;
    private Integer redundant;

    private List<CutPlan> cutPlans;

    public Integer getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(Integer totalLength) {
        this.totalLength = totalLength;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getRedundant() {
        return redundant;
    }

    public void setRedundant(Integer redundant) {
        this.redundant = redundant;
    }

    public List<CutPlan> getCutPlans() {
        return cutPlans;
    }

    public void setCutPlans(List<CutPlan> cutPlans) {
        this.cutPlans = cutPlans;
    }

    public static class CutPlan {
        private Integer cutLength;
        private Integer cutNum;

        public Integer getCutNum() {
            return cutNum;
        }

        public void setCutNum(Integer cutNum) {
            this.cutNum = cutNum;
        }

        public Integer getCutLength() {
            return cutLength;
        }

        public void setCutLength(Integer cutLength) {
            this.cutLength = cutLength;
        }
    }
}
