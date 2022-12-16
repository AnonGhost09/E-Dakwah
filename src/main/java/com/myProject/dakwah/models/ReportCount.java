package com.myProject.dakwah.models;

public class ReportCount {
    private Long totalMosque;
    private Long totalKajian;
    private Long totalPreacher;
    private Long totalUser;
    private Long totalUserKajian;

    public Long getTotalMosque() {
        return totalMosque;
    }

    public void setTotalMosque(Long totalMosque) {
        this.totalMosque = totalMosque;
    }

    public Long getTotalKajian() {
        return totalKajian;
    }

    public void setTotalKajian(Long totalKajian) {
        this.totalKajian = totalKajian;
    }

    public Long getTotalPreacher() {
        return totalPreacher;
    }

    public void setTotalPreacher(Long totalPreacher) {
        this.totalPreacher = totalPreacher;
    }

    public Long getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(Long totalUser) {
        this.totalUser = totalUser;
    }

    public Long getTotalUserKajian() {
        return totalUserKajian;
    }

    public void setTotalUserKajian(Long totalUserKajian) {
        this.totalUserKajian = totalUserKajian;
    }

    @Override
    public String toString() {
        return "totalMosque=" + totalMosque +
                ", totalKajian=" + totalKajian +
                ", totalPreacher=" + totalPreacher +
                ", totalUser=" + totalUser +
                ", totalUserKajian=" + totalUserKajian+"\n";
    }
}
