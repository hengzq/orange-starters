package cn.hengzq.orange.common.dto;

import cn.hengzq.orange.common.constant.PageConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;


/**
 * 分页数据
 *
 * @author hengzq
 */
@Data
@NoArgsConstructor
public class PageDTO<T> {


    @Schema(description = "列表总数")
    private Integer total;

    @Schema(description = "每页数量")
    private Integer pageSize;

    @Schema(description = "页码")
    private Integer pageNo;

    @Schema(description = "列表数据")
    private List<T> records;


    public PageDTO(Integer pageNo, Integer pageSize, Integer total, List<T> records) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.records = records;
    }

    public static <T> PageDTO<T> of(Integer pageNo, Integer pageSize) {
        return new PageDTO<>(pageNo, pageSize, 0, Collections.emptyList());
    }

    public static <T> PageDTO<T> of(Integer pageNo, Integer pageSize, Integer total, List<T> records) {
        return new PageDTO<>(pageNo, pageSize, total, records);
    }

    public List<T> getRecords() {
        return records == null ? Collections.emptyList() : records;
    }

    public Integer getTotal() {
        return total == null ? PageConstant.TOTAL : total;
    }

    public Integer getPageSize() {
        return pageSize == null ? PageConstant.PAGE_SIZE : pageSize;
    }

    public Integer getPageNo() {
        return pageNo == null ? PageConstant.PAGE_NO : pageNo;
    }

}
