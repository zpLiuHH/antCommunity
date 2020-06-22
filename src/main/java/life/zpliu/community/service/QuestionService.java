package life.zpliu.community.service;

import life.zpliu.community.dto.PagenationDTO;
import life.zpliu.community.dto.QuestionDTO;
import life.zpliu.community.mapper.QuestionMapper;
import life.zpliu.community.mapper.UserMapper;
import life.zpliu.community.model.QuestionModel;
import life.zpliu.community.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zpliu
 * @date 2020/2/20 15:33
 */
@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<QuestionModel> questionModelList = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (QuestionModel questionModel : questionModelList) {
            UserModel userModel = userMapper.findbyId(questionModel.getCreator()).get(0);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(questionModel, questionDTO);
            questionDTO.setUser(userModel);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }

    public PagenationDTO listByPage(Integer offset, Integer pageSize) {

        Integer totalCount = questionMapper.queryCount();
        List<QuestionModel> questionModelList = questionMapper.listByPage(pageSize * (offset - 1), pageSize);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PagenationDTO pagenationDTO = new PagenationDTO();
        for (QuestionModel questionModel : questionModelList) {
            UserModel userModel = userMapper.findbyId(questionModel.getCreator()).get(0);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(questionModel, questionDTO);
            questionDTO.setUser(userModel);
            questionDTOList.add(questionDTO);
        }
        pagenationDTO.setPagenation(totalCount, offset, pageSize);
        pagenationDTO.setQuestionList(questionDTOList);
        return pagenationDTO;
    }

    public PagenationDTO listByUserId(String userId, Integer offset, Integer pageSize) {
        Integer totalCount = questionMapper.queryCountByUserId(userId);
        List<QuestionModel> questionModelList = questionMapper.listByUserId(userId, pageSize * (offset - 1), pageSize);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PagenationDTO pagenationDTO = new PagenationDTO();
        for (QuestionModel questionModel : questionModelList) {
            UserModel userModel = userMapper.findbyId(questionModel.getCreator()).get(0);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(questionModel, questionDTO);
            questionDTO.setUser(userModel);
            questionDTOList.add(questionDTO);
        }
        pagenationDTO.setPagenation(totalCount, offset, pageSize);
        pagenationDTO.setQuestionList(questionDTOList);
        return pagenationDTO;
    }

    public QuestionDTO getById(Integer id) {
        QuestionModel question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        UserModel userModel = userMapper.findbyId(question.getCreator()).get(0);
        questionDTO.setUser(userModel);
        return questionDTO;
    }
}
