package com.sora.temp.mapper;

import com.github.pagehelper.Page;
import com.sora.temp.annotation.AutoFill;
import com.sora.temp.dto.MessageDTO;
import com.sora.temp.enumeration.OperationType;
import com.sora.temp.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MessageMapper {


    @Select("select * from temp.t_message where status = 1 and create_time > #{after} and create_time < #{before}")
    Page<MessageVO> pageQuery(MessageDTO messageDTO);

    @Select("select * from temp.t_message where id = #{id} and status = 1")
    MessageVO getById(Long id);

    @Update("update temp.t_message set status = #{i} where id = #{id}")
    void updateStatus(Long id, int i);


    @AutoFill(OperationType.INSERT)
    Long saveMessage(MessageDTO messageDTO);
}
