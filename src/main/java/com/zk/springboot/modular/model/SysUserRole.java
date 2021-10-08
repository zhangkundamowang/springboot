package com.zk.springboot.modular.model;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户和角色关联表
    * </p>
*
* @author zk
* @since 2021-10-08
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

            /**
            * 用户ID
            */
            @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

            /**
            * 角色ID
            */
    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
