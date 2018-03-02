package com.lucius.common.support.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 *  model类 所有类均继承于此类
 * @author Lucius
 * create by 2018/2/28
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Data
@MappedSuperclass
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler","modelName","clazzName"})
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -2693221461836848144L;
    /**
     * 记录主键
     */
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(length = 32, nullable = false, unique = true, columnDefinition = "int(11) comment '记录主键'")
    private Long id;


    /**
     * 创建记录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",columnDefinition = "datetime comment '创建记录时间'", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createdAt;

    /**
     * 更新记录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at",columnDefinition = "datetime comment '更新记录时间'", updatable = false)
    @org.hibernate.annotations.UpdateTimestamp
    private Date updatedAt;

    /**
     * 删除记录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at",columnDefinition = "datetime comment '删除时间'", updatable = false)
    private Date deletedAt;

    /**
     * 创建人
     */
    @Column(name = "created_by",columnDefinition = "int(11) comment '创建人'")
    private Long createdBy;

    /**
     * 更新人
     */
    @Column(name = "updated_by",columnDefinition = "int(11) comment '更新人'")
    private Long updatedBy;

    /**
     * 删除人
     */
    @Column(name = "deleted_by",columnDefinition = "int(11) comment '删除人'")
    private Long deletedBy;


    /**
     * 版本号
     */
    @Column(name = "version",columnDefinition = "int(11) comment '版本号' default '0'")
    private Long version;

    /**
     * 是否被删除 0未删除 1已删除
     */
    @Column(name = "is_delete",columnDefinition = "int(1) comment '是否被删除' default '0'")
    private Long isDelete;

    /**
     * 快速将实体输出成字符串
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
