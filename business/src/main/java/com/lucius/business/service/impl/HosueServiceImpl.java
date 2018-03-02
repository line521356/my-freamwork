package com.lucius.business.service.impl;



/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/26
 * @Emial Lucius.li@ixiaoshuidi.com
 */
//@Service
//public class HosueServiceImpl implements HouseService{
//    @Resource
//    HouseRepository houseRepository;
//    @Override
//    public void addHouse(House house) {
//        houseRepository.save(house);
//    }
//
//    @Override
//    public Page<House> findByModel(HouseCondition houseCondition,Pageable pageable) {
//        SimpleSpecificationBuilder simpleSpecificationBuilder = new SimpleSpecificationBuilder();
//        if (houseCondition.getId() != null) {
//            simpleSpecificationBuilder.add("id", "=", houseCondition.getId());
//        }
//        if(StringUtils.isNotBlank(houseCondition.getDoor())){
//            simpleSpecificationBuilder.add("door", ":", houseCondition.getDoor());
//        }
//        if(StringUtils.isNotBlank(houseCondition.getRemark())){
//            simpleSpecificationBuilder.add("remark", ":", houseCondition.getRemark());
//        }
//        Specification <House> specification = simpleSpecificationBuilder.generateSpecification();
//        Page <House> page = houseRepository.findAll(specification
//                ,SimplePageBuilder.generate(pageable.getPageNumber(),pageable.getPageSize()
//                        , SimpleSortBuilder.generateSort("id_d")));
//        return page;
//
//    }
//
//    @Override
//    public House findById(Long id) {
//        return houseRepository.getOne(id);
//    }


//}
