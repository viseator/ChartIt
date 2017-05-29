package com.viseator.chartit.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

@Entity
public class ChartDataEntity {
    @Id(autoincrement = true)
    private Long id;

    private String mainValue;
    private String mapValue;
    //Type: 0 for float , 1 for String
    private int type;
    private Long time;

    @Generated(hash = 190162712)
    public ChartDataEntity(Long id, String mainValue, String mapValue, Long time) {
        this.id = id;
        this.mainValue = mainValue;
        this.mapValue = mapValue;
        this.time = time;
    }

    @Generated(hash = 812315989)
    public ChartDataEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainValue() {
        return this.mainValue;
    }

    public void setMainValue(String mainValue) {
        this.mainValue = mainValue;
    }

    public String getMapValue() {
        return this.mapValue;
    }

    public void setMapValue(String mapValue) {
        this.mapValue = mapValue;
    }

    @Override
    public String toString() {
        return String.valueOf(id)+" - " +mainValue + " : " + mapValue;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
