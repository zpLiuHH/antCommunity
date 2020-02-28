package life.zpliu.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zpliu
 * @date 2020/2/25 14:26
 */
@Data
public class PagenationDTO {
    private Integer offset;
    private Integer pageSize;
    private Integer totalSize;
    private Boolean showNext;
    private Boolean showPrevious;
    private Boolean showEndPage;
    private Boolean showFirstPage;
    private List<Integer> pageNums = new ArrayList<>();
    private List<QuestionDTO> questionList;

    public void setPagenation(Integer totalCount, Integer offset, Integer pageSize) {
        if (totalCount % pageSize == 0) {
            totalSize = totalCount / pageSize;
        } else {
            totalSize = totalCount / pageSize + 1;
        }
        if (offset < 1) {
            offset = 1;
        }
        if (offset > totalSize) {
            offset = totalSize;
        }
        this.offset = offset;
        pageNums.add(offset);
        //始终保留offset前3个页码显示
        for (int i = 1; i <= 3; i++) {
            if (offset - i > 0) {
                pageNums.add(0, offset - i);
            }
            if (offset + i <= totalSize) {
                pageNums.add(offset + i);
            }
        }
        //是否显示上一页
        if (offset == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否显示下一页
        if (offset == totalSize) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否显示第一页
        if (pageNums.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //是否显示最后一页
        if (pageNums.contains(totalSize)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }

 /*   public static void main(String[] args) {
        setPagenation(8,7,1);
    }*/

}
