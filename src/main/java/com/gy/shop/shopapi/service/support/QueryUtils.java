package com.gy.shop.shopapi.service.support;

import com.gy.shop.shopapi.exception.ArgumentsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author gy
 * @Date: Create in 2018/3/31 19:12
 * @Description
 * @Modified By:
 */
public class QueryUtils<T> {


    /**
     * 通用分页查询
     *
     * @param repository
     * @param currentPage
     * @param pageSize
     * @param sortField
     * @param orderType
     * @return
     */
    public PageQuery<T> query(JpaRepository repository, Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {

        OrderType var1 = orderType;
        Sort sort = null;
        if (var1 == null || var1 == orderType.ASC) {
            sort = new Sort(Sort.Direction.ASC, sortField);
        } else if (var1 == var1.DESC) {
            sort = new Sort(Sort.Direction.DESC, sortField);
        } else {
            throw new ArgumentsException("排序参数错误");
        }

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, sort);

        long count = repository.count();

        Page<T> items = repository.findAll(pageable);

        PageQuery<T> query = new PageQuery();
        query.setCurrentPage(currentPage);
        query.setPageSize(pageSize);
        query.setCount(count);
        query.setItems(items.getContent());


        return query;

    }

}
