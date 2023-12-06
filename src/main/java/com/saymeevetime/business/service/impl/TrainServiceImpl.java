package com.saymeevetime.business.service.impl;

import com.saymeevetime.business.entity.Train;
import com.saymeevetime.business.mapper.TrainMapper;
import com.saymeevetime.business.service.ITrainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车次 服务实现类
 * </p>
 *
 * @author ChesterZhao
 * @since 2023-12-06
 */
@Service
public class TrainServiceImpl extends ServiceImpl<TrainMapper, Train> implements ITrainService {

}
